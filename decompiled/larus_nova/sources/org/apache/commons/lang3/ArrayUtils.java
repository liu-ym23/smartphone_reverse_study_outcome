package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = null;
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = null;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = null;
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = null;
    public static final char[] EMPTY_CHAR_ARRAY = null;
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    public static final double[] EMPTY_DOUBLE_ARRAY = null;
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = null;
    public static final float[] EMPTY_FLOAT_ARRAY = null;
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = null;
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = null;
    public static final int[] EMPTY_INT_ARRAY = null;
    public static final long[] EMPTY_LONG_ARRAY = null;
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = null;
    public static final Object[] EMPTY_OBJECT_ARRAY = null;
    public static final short[] EMPTY_SHORT_ARRAY = null;
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = null;
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_LONG_ARRAY = new long[0];
        EMPTY_LONG_OBJECT_ARRAY = new Long[0];
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
        EMPTY_SHORT_ARRAY = new short[0];
        EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
        EMPTY_DOUBLE_ARRAY = new double[0];
        EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
        EMPTY_FLOAT_ARRAY = new float[0];
        EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
        EMPTY_BOOLEAN_ARRAY = new boolean[0];
        EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
        EMPTY_CHAR_ARRAY = new char[0];
        EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    }

    public static byte[] clone(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (byte[]) r100.clone();
    }

    public static int getLength(Object r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Array.getLength(r100);
    }

    public static boolean isEmpty(char[] r100) {
        if (getLength(r100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNotEmpty(int[] r100) {
        return !isEmpty(r100);
    }

    public static Boolean[] toObject(boolean[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Boolean[] r101 = new Boolean[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L17;
        if (r100[r102] == false) goto L15;
        Boolean r103 = Boolean.TRUE;
    L16:
        r101[r102] = r103;
        r102 = r102 + 1;
        goto L11
    L15:
        r103 = Boolean.FALSE;
        goto L16
    L17:
        return r101;
    L8:
        return EMPTY_BOOLEAN_OBJECT_ARRAY;
    }

    public static char[] clone(char[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (char[]) r100.clone();
    }

    public static boolean isEmpty(int[] r100) {
        if (getLength(r100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Byte[] toObject(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Byte[] r101 = new Byte[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Byte.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_BYTE_OBJECT_ARRAY;
    }

    public static double[] clone(double[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (double[]) r100.clone();
    }

    public static Character[] toObject(char[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Character[] r101 = new Character[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Character.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_CHARACTER_OBJECT_ARRAY;
    }

    public static float[] clone(float[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (float[]) r100.clone();
    }

    public static Double[] toObject(double[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Double[] r101 = new Double[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Double.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_DOUBLE_OBJECT_ARRAY;
    }

    public static int[] clone(int[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (int[]) r100.clone();
    }

    public static Float[] toObject(float[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Float[] r101 = new Float[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Float.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_FLOAT_OBJECT_ARRAY;
    }

    public static long[] clone(long[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (long[]) r100.clone();
    }

    public static Integer[] toObject(int[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Integer[] r101 = new Integer[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Integer.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_INTEGER_OBJECT_ARRAY;
    }

    public static <T> T[] clone(T[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T[]) ((Object[]) r100.clone());
    }

    public static Long[] toObject(long[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Long[] r101 = new Long[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Long.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_LONG_OBJECT_ARRAY;
    }

    public static short[] clone(short[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (short[]) r100.clone();
    }

    public static Short[] toObject(short[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length == 0) goto L8;
        Short[] r101 = new Short[r100.length];
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L13;
        r101[r102] = Short.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return r101;
    L8:
        return EMPTY_SHORT_OBJECT_ARRAY;
    }

    public static boolean[] clone(boolean[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (boolean[]) r100.clone();
    }

    public static <T> T[] add(T[] r100, T r101) {
        if (r100 == null) goto L4;
        Class<?> r102 = r100.getClass().getComponentType();
    L6:
        T[] r103 = (T[]) ((Object[]) copyArrayGrow1(r100, r102));
        r103[r103.length - 1] = r101;
        return r103;
    L4:
        if (r101 == null) goto L9;
        r102 = r101.getClass();
        goto L6
    L9:
        throw new IllegalArgumentException("Arguments cannot both be null");
    }

    public static boolean contains(Object[] r100, Object r101) {
        if (indexOf(r100, r101) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static Object copyArrayGrow1(Object r100, Class<?> r101) {
        if (r100 == null) goto L6;
        int r102 = Array.getLength(r100);
        Object r103 = Array.newInstance(r100.getClass().getComponentType(), r102 + 1);
        System.arraycopy(r100, 0, r103, 0, r102);
        return r103;
    L6:
        return Array.newInstance(r101, 1);
    }

    public static int indexOf(Object[] r100, Object r101) {
        return indexOf(r100, r101, 0);
    }

    public static Object removeAll(Object r100, int... r101) {
        int r102 = getLength(r100);
        int[] r103 = clone(r101);
        Arrays.sort(r103);
        if (isNotEmpty(r103) == false) goto L15;
        int r104 = r103.length;
        int r105 = r102;
        int r106 = 0;
    L5:
        r104 = r104 - 1;
        if (r104 < 0) goto L16;
        int r107 = r103[r104];
        if (r107 < 0) goto L14;
        if (r107 >= r102) goto L14;
        if (r107 >= r105) goto L5;
        r106 = r106 + 1;
        r105 = r107;
    L14:
        throw new IndexOutOfBoundsException("Index: " + r107 + ", Length: " + r102);
    L16:
        int r108 = r102 - r106;
        Object r109 = Array.newInstance(r100.getClass().getComponentType(), r108);
        if (r106 >= r102) goto L26;
        int r110 = r103.length - 1;
    L19:
        if (r110 < 0) goto L24;
        int r111 = r103[r110];
        int r112 = r102 - r111;
        if (r112 <= 1) goto L23;
        int r113 = r112 - 1;
        r108 = r108 - r113;
        System.arraycopy(r100, r111 + 1, r109, r108, r113);
    L23:
        r110 = r110 - 1;
        r102 = r111;
        goto L19
    L24:
        if (r102 <= 0) goto L26;
        System.arraycopy(r100, 0, r109, 0, r102);
    L26:
        return r109;
    L15:
        r106 = 0;
        goto L16
    }

    public static int[] add(int[] r100, int r101) {
        int[] r102 = (int[]) copyArrayGrow1(r100, Integer.TYPE);
        r102[r102.length - 1] = r101;
        return r102;
    }

    public static <T> T[] removeAll(T[] r100, int... r101) {
        return (T[]) ((Object[]) removeAll(r100, r101));
    }

    public static int indexOf(Object[] r100, Object r101, int r102) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        if (r101 != null) goto L15;
    L9:
        if (r102 >= r100.length) goto L20;
        if (r100[r102] == null) goto L12;
        r102 = r102 + 1;
        goto L9
    L12:
        return r102;
    L20:
        return -1;
    L15:
        if (r102 >= r100.length) goto L20;
        if (r101.equals(r100[r102]) == true) goto L18;
        r102 = r102 + 1;
        goto L15
    L18:
        return r102;
    }

    @SafeVarargs
    public static <T> T[] insert(int r100, T[] r101, T... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        T[] r103 = (T[]) ((Object[]) Array.newInstance(r101.getClass().getComponentType(), r101.length + r102.length));
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return (T[]) clone(r101);
    }

    public static byte[] insert(int r100, byte[] r101, byte... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        byte[] r103 = new byte[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static char[] insert(int r100, char[] r101, char... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        char[] r103 = new char[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static double[] insert(int r100, double[] r101, double... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        double[] r103 = new double[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static float[] insert(int r100, float[] r101, float... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        float[] r103 = new float[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static int[] insert(int r100, int[] r101, int... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        int[] r103 = new int[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static long[] insert(int r100, long[] r101, long... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        long[] r103 = new long[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static short[] insert(int r100, short[] r101, short... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        short[] r103 = new short[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }

    public static boolean[] insert(int r100, boolean[] r101, boolean... r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L22;
        if (r102.length == 0) goto L22;
        if (r100 < 0) goto L20;
        if (r100 > r101.length) goto L20;
        boolean[] r103 = new boolean[r101.length + r102.length];
        System.arraycopy(r102, 0, r103, r100, r102.length);
        if (r100 <= 0) goto L16;
        System.arraycopy(r101, 0, r103, 0, r100);
    L16:
        if (r100 >= r101.length) goto L18;
        System.arraycopy(r101, r100, r103, r102.length + r100, r101.length - r100);
    L18:
        return r103;
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Length: " + r101.length);
    L22:
        return clone(r101);
    }
}
