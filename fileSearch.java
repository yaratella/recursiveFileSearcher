import java.util.ArrayList;

public class fileSearch {

    public static String dedupe(String in) {
        if (in == null || in.length() == 0) {
            return " ";
        }
        if(in.length() == 1) {
            return in.substring(0,1) + dedupe(in.substring(1));
        }
        if(in.charAt(0) == in.charAt(1)) {
            return dedupe(in.substring(1));
        }
        else {
            return in.substring(0,1) + dedupe(in.substring(1));
        }
        }
        public static boolean searchArray(Object[] arr, Object target) {
            if (arr == null || target == null || arr.length == 0) {
                return false;
            }
            return searchArrayHelper(arr, target, 0);
    }
    private static boolean searchArrayHelper(Object[] arr, Object target, int index){

        if(arr.length == 0 || arr.length <= index) {
            return false;
        }

        if(arr[index] == null){
            return searchArrayHelper(arr, target, index+1);
        }

        if(arr[index].equals(target)) {
            return true;
        }

        if(arr[index] instanceof Object[] newArr) {
            boolean save = searchArrayHelper(newArr, target, 0);

            if(save){
            return true;
            }
        }

        return searchArrayHelper(arr, target, index+1);
    }

    public static void main(String[] args) {
        System.out.println(dedupe("Book").equals("Bok")); //Bok
        System.out.println(dedupe(null).isEmpty());
        System.out.println(dedupe("").isEmpty());
        System.out.println(dedupe("a").equals("a"));
        System.out.println(dedupe("Book")); //Bok
        System.out.println(dedupe(null));
        System.out.println(dedupe(""));
        System.out.println(dedupe("a"));
        String target = "HelloWorld";
        Object[] arr = new Object[4];
        arr[0] = new ArrayList<String>();
        // arr[1] = null;
        arr[2] = target;
        arr[3] = "Steve";
        System.out.println(searchArray(arr, target));
        System.out.println(searchArray(arr, "BAD") == false);
        System.out.println(searchArray(null, target) == false);
        System.out.println(searchArray(arr, null) == false);
        System.out.println(searchArray(new Object[0], target) == false);
        System.out.println(searchArrayHelper(arr, target, 10) == false);
        System.out.println(searchArrayHelper(new Object[0], target, 0) ==
        false);
        Object[] nested = new Object[3];
        nested[1] = arr;
        nested[0] = new Object[2];
        ((Object[])nested[0])[0] = "Bob";
        ((Object[])nested[0])[1] = "Steve";
        nested[2] = "Window";
        System.out.println(searchArray(nested, target));
        System.out.println(searchArray(nested, "BAD") == false);
    }
}