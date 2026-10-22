package org.bouncycastle.util;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position;

        public Iterator(T[] r100) {
            this.position = 0;
            this.dataArray = r100;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.dataArray.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            int r100 = this.position;
            T[] r101 = this.dataArray;
            if (r100 == r101.length) goto L7;
            this.position = r100 + 1;
            return r101[r100];
        L7:
            throw new NoSuchElementException("Out of elements: " + this.position);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    private Arrays() {
    }

    public static byte[] append(byte[] r100, byte r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        byte[] r103 = new byte[r102 + 1];
        System.arraycopy(r100, 0, r103, 0, r102);
        r103[r102] = r101;
        return r103;
    L5:
        return new byte[]{r101};
    }

    public static int[] append(int[] r100, int r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        int[] r103 = new int[r102 + 1];
        System.arraycopy(r100, 0, r103, 0, r102);
        r103[r102] = r101;
        return r103;
    L5:
        return new int[]{r101};
    }

    public static String[] append(String[] r100, String r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        String[] r103 = new String[r102 + 1];
        System.arraycopy(r100, 0, r103, 0, r102);
        r103[r102] = r101;
        return r103;
    L5:
        return new String[]{r101};
    }

    public static short[] append(short[] r100, short r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        short[] r103 = new short[r102 + 1];
        System.arraycopy(r100, 0, r103, 0, r102);
        r103[r102] = r101;
        return r103;
    L5:
        return new short[]{r101};
    }

    public static boolean areAllZeroes(byte[] r100, int r101, int r102) {
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r104 = r104 | r100[r101 + r103];
        r103 = r103 + 1;
        goto L3
    L5:
        if (r104 != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean areEqual(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105) {
        int r106 = r102 - r101;
        if (r106 == (r105 - r104)) goto L5;
        return false;
    L5:
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L11;
        if (r100[r101 + r107] != r103[r104 + r107]) goto L9;
        r107 = r107 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean areEqual(byte[] r100, byte[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(char[] r100, char[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(int[] r100, int[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(long[] r100, long[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(Object[] r100, Object[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(short[] r100, short[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static boolean areEqual(boolean[] r100, boolean[] r101) {
        return java.util.Arrays.equals(r100, r101);
    }

    public static void clear(byte[] r100) {
        if (r100 == null) goto L5;
        java.util.Arrays.fill(r100, (byte) 0);
        return;
    }

    public static void clear(int[] r100) {
        if (r100 == null) goto L5;
        java.util.Arrays.fill(r100, 0);
        return;
    }

    public static byte[] clone(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (byte[]) r100.clone();
    }

    public static byte[] clone(byte[] r100, byte[] r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L12;
        if (r101.length != r100.length) goto L12;
        System.arraycopy(r100, 0, r101, 0, r101.length);
        return r101;
    L12:
        return clone(r100);
    }

    public static char[] clone(char[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (char[]) r100.clone();
    }

    public static int[] clone(int[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (int[]) r100.clone();
    }

    public static long[] clone(long[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (long[]) r100.clone();
    }

    public static long[] clone(long[] r100, long[] r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L12;
        if (r101.length != r100.length) goto L12;
        System.arraycopy(r100, 0, r101, 0, r101.length);
        return r101;
    L12:
        return clone(r100);
    }

    public static BigInteger[] clone(BigInteger[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (BigInteger[]) r100.clone();
    }

    public static short[] clone(short[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (short[]) r100.clone();
    }

    public static boolean[] clone(boolean[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (boolean[]) r100.clone();
    }

    public static byte[][] clone(byte[][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        byte[][] r102 = new byte[r101][];
        int r103 = 0;
    L6:
        if (r103 == r101) goto L8;
        r102[r103] = clone(r100[r103]);
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    public static byte[][][] clone(byte[][][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        byte[][][] r102 = new byte[r101][][];
        int r103 = 0;
    L6:
        if (r103 == r101) goto L8;
        r102[r103] = clone(r100[r103]);
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    public static int compareUnsigned(byte[] r100, byte[] r101) {
        if (r100 != r101) goto L6;
        return 0;
    L6:
        if (r100 != null) goto L9;
        return -1;
    L9:
        if (r101 != null) goto L11;
        return 1;
    L11:
        int r102 = Math.min(r100.length, r101.length);
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L20;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        int r105 = r101[r103] & UByte.MAX_VALUE;
        if (r104 < r105) goto L15;
        if (r104 > r105) goto L17;
        r103 = r103 + 1;
        goto L12
    L17:
        return 1;
    L15:
        return -1;
    L20:
        if (r100.length >= r101.length) goto L23;
        return -1;
    L23:
        if (r100.length <= r101.length) goto L25;
        return 1;
    L25:
        return 0;
    }

    public static byte[] concatenate(byte[] r100, byte[] r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    L7:
        return clone(r100);
    L4:
        return clone(r101);
    }

    public static byte[] concatenate(byte[] r100, byte[] r101, byte[] r102) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        if (r102 == null) goto L10;
        byte[] r103 = new byte[(r100.length + r101.length) + r102.length];
        System.arraycopy(r100, 0, r103, 0, r100.length);
        int r104 = r100.length + 0;
        System.arraycopy(r101, 0, r103, r104, r101.length);
        System.arraycopy(r102, 0, r103, r104 + r101.length, r102.length);
        return r103;
    L10:
        return concatenate(r100, r101);
    L7:
        return concatenate(r100, r102);
    L4:
        return concatenate(r101, r102);
    }

    public static byte[] concatenate(byte[] r100, byte[] r101, byte[] r102, byte[] r103) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        if (r102 == null) goto L10;
        if (r103 == null) goto L13;
        byte[] r104 = new byte[((r100.length + r101.length) + r102.length) + r103.length];
        System.arraycopy(r100, 0, r104, 0, r100.length);
        int r105 = r100.length + 0;
        System.arraycopy(r101, 0, r104, r105, r101.length);
        int r106 = r105 + r101.length;
        System.arraycopy(r102, 0, r104, r106, r102.length);
        System.arraycopy(r103, 0, r104, r106 + r102.length, r103.length);
        return r104;
    L13:
        return concatenate(r100, r101, r102);
    L10:
        return concatenate(r100, r101, r103);
    L7:
        return concatenate(r100, r102, r103);
    L4:
        return concatenate(r101, r102, r103);
    }

    public static byte[] concatenate(byte[][] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r102 = r102 + r100[r101].length;
        r101 = r101 + 1;
        goto L4
    L6:
        byte[] r103 = new byte[r102];
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 == r100.length) goto L10;
        byte[] r106 = r100[r104];
        System.arraycopy(r106, 0, r103, r105, r106.length);
        r105 = r105 + r100[r104].length;
        r104 = r104 + 1;
        goto L8
    L10:
        return r103;
    }

    public static int[] concatenate(int[] r100, int[] r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        int[] r102 = new int[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    L7:
        return clone(r100);
    L4:
        return clone(r101);
    }

    public static short[] concatenate(short[] r100, short[] r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        short[] r102 = new short[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    L7:
        return clone(r100);
    L4:
        return clone(r101);
    }

    public static boolean constantTimeAreEqual(int r100, byte[] r101, int r102, byte[] r103, int r104) {
        if (r101 == null) goto L24;
        if (r103 == null) goto L22;
        if (r100 < 0) goto L20;
        if (r102 > (r101.length - r100)) goto L18;
        if (r104 > (r103.length - r100)) goto L16;
        int r105 = 0;
        int r106 = 0;
    L10:
        if (r105 >= r100) goto L12;
        r106 = r106 | (r101[r102 + r105] ^ r103[r104 + r105]);
        r105 = r105 + 1;
        goto L10
    L12:
        if (r106 != 0) goto L26;
        return true;
    L26:
        return false;
    L16:
        throw new IndexOutOfBoundsException("'bOff' value invalid for specified length");
    L18:
        throw new IndexOutOfBoundsException("'aOff' value invalid for specified length");
    L20:
        throw new IllegalArgumentException("'len' cannot be negative");
    L22:
        throw new NullPointerException("'b' cannot be null");
    L24:
        throw new NullPointerException("'a' cannot be null");
    }

    public static boolean constantTimeAreEqual(byte[] r100, byte[] r101) {
        if (r100 == null) goto L24;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r100 != r101) goto L10;
        return true;
    L10:
        if (r100.length >= r101.length) goto L12;
        int r102 = r100.length;
    L13:
        int r103 = r100.length ^ r101.length;
        int r104 = 0;
    L14:
        if (r104 == r102) goto L17;
        r103 = r103 | (r100[r104] ^ r101[r104]);
        r104 = r104 + 1;
    L17:
        if (r102 >= r101.length) goto L19;
        byte r105 = r101[r102];
        r103 = r103 | (r105 ^ (~r105));
        r102 = r102 + 1;
        goto L17
    L19:
        if (r103 != 0) goto L25;
        return true;
    L25:
        return false;
    L12:
        r102 = r101.length;
        goto L13
    L24:
        return false;
    }

    public static boolean contains(byte[] r100, byte r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean contains(char[] r100, char r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean contains(int[] r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean contains(long[] r100, long r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean contains(short[] r100, short r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean contains(boolean[] r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] == r101) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static byte[] copyOf(byte[] r100, int r101) {
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static char[] copyOf(char[] r100, int r101) {
        char[] r102 = new char[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static int[] copyOf(int[] r100, int r101) {
        int[] r102 = new int[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static long[] copyOf(long[] r100, int r101) {
        long[] r102 = new long[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static BigInteger[] copyOf(BigInteger[] r100, int r101) {
        BigInteger[] r102 = new BigInteger[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static short[] copyOf(short[] r100, int r101) {
        short[] r102 = new short[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static boolean[] copyOf(boolean[] r100, int r101) {
        boolean[] r102 = new boolean[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    public static byte[] copyOfRange(byte[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        byte[] r104 = new byte[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static char[] copyOfRange(char[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        char[] r104 = new char[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static int[] copyOfRange(int[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        int[] r104 = new int[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static long[] copyOfRange(long[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        long[] r104 = new long[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static BigInteger[] copyOfRange(BigInteger[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        BigInteger[] r104 = new BigInteger[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static short[] copyOfRange(short[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        short[] r104 = new short[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static boolean[] copyOfRange(boolean[] r100, int r101, int r102) {
        int r103 = getLength(r101, r102);
        boolean[] r104 = new boolean[r103];
        System.arraycopy(r100, r101, r104, 0, Math.min(r100.length - r101, r103));
        return r104;
    }

    public static void fill(byte[] r100, byte r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(byte[] r100, int r101, byte r102) {
        fill(r100, r101, r100.length, r102);
    }

    public static void fill(byte[] r100, int r101, int r102, byte r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(char[] r100, char r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(char[] r100, int r101, int r102, char r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(int[] r100, int r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(int[] r100, int r101, int r102) {
        java.util.Arrays.fill(r100, r101, r100.length, r102);
    }

    public static void fill(int[] r100, int r101, int r102, int r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(long[] r100, int r101, int r102, long r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(long[] r100, int r101, long r102) {
        java.util.Arrays.fill(r100, r101, r100.length, r102);
    }

    public static void fill(long[] r100, long r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(Object[] r100, int r101, int r102, Object r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(Object[] r100, Object r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(short[] r100, int r101, int r102, short r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(short[] r100, int r101, short r102) {
        java.util.Arrays.fill(r100, r101, r100.length, r102);
    }

    public static void fill(short[] r100, short r101) {
        java.util.Arrays.fill(r100, r101);
    }

    public static void fill(boolean[] r100, int r101, int r102, boolean r103) {
        java.util.Arrays.fill(r100, r101, r102, r103);
    }

    public static void fill(boolean[] r100, boolean r101) {
        java.util.Arrays.fill(r100, r101);
    }

    private static int getLength(int r100, int r101) {
        int r102 = r101 - r100;
        if (r102 < 0) goto L5;
        return r102;
    L5:
        StringBuffer r103 = new StringBuffer(r100);
        r103.append(" > ");
        r103.append(r101);
        throw new IllegalArgumentException(r103.toString());
    }

    public static int hashCode(byte[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ r100[r101];
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r103 = r102 + 1;
    L6:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        r103 = (r103 * 257) ^ r100[r101 + r102];
        goto L6
    L9:
        return r103;
    }

    public static int hashCode(char[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ r100[r101];
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(int[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ r100[r101];
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(int[] r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r103 = r102 + 1;
    L6:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        r103 = (r103 * 257) ^ r100[r101 + r102];
        goto L6
    L9:
        return r103;
    }

    public static int hashCode(long[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        long r103 = r100[r101];
        r102 = (((r102 * 257) ^ ((int) r103)) * 257) ^ ((int) (r103 >>> 32));
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(long[] r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r103 = r102 + 1;
    L6:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        long r104 = r100[r101 + r102];
        r103 = (((r103 * 257) ^ ((int) r104)) * 257) ^ ((int) (r104 >>> 32));
        goto L6
    L9:
        return r103;
    }

    public static int hashCode(Object[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ Objects.hashCode(r100[r101]);
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(short[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ (r100[r101] & 255);
        goto L6
    L9:
        return r102;
    }

    public static int hashCode(int[][] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r102 = (r102 * 257) + hashCode(r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public static int hashCode(short[][] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r102 = (r102 * 257) + hashCode(r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public static int hashCode(short[][][] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r102 = (r102 * 257) + hashCode(r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public static boolean isNullOrContainsNull(Object[] r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (r100[r102] == null) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public static boolean isNullOrEmpty(byte[] r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length < 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isNullOrEmpty(int[] r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length < 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isNullOrEmpty(Object[] r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length < 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static byte[] prepend(byte[] r100, byte r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        byte[] r103 = new byte[r102 + 1];
        System.arraycopy(r100, 0, r103, 1, r102);
        r103[0] = r101;
        return r103;
    L5:
        return new byte[]{r101};
    }

    public static int[] prepend(int[] r100, int r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        int[] r103 = new int[r102 + 1];
        System.arraycopy(r100, 0, r103, 1, r102);
        r103[0] = r101;
        return r103;
    L5:
        return new int[]{r101};
    }

    public static short[] prepend(short[] r100, short r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
        short[] r103 = new short[r102 + 1];
        System.arraycopy(r100, 0, r103, 1, r102);
        r103[0] = r101;
        return r103;
    L5:
        return new short[]{r101};
    }

    public static byte[] reverse(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102[r101] = r100[r103];
        r103 = r103 + 1;
        goto L6
    L9:
        return r102;
    }

    public static int[] reverse(int[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        int[] r102 = new int[r101];
        int r103 = 0;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102[r101] = r100[r103];
        r103 = r103 + 1;
        goto L6
    L9:
        return r102;
    }
}
