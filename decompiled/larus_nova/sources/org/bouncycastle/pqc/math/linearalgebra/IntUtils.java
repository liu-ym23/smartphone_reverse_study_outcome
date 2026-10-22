package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public final class IntUtils {
    private IntUtils() {
    }

    public static int[] clone(int[] r100) {
        int[] r101 = new int[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static boolean equals(int[] r100, int[] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = r100.length - 1;
        boolean r103 = true;
    L6:
        if (r102 < 0) goto L12;
        if (r100[r102] != r101[r102]) goto L10;
        boolean r104 = true;
    L11:
        r103 = r103 & r104;
        r102 = r102 - 1;
        goto L6
    L10:
        r104 = false;
        goto L11
    L12:
        return r103;
    }

    public static void fill(int[] r100, int r101) {
        int r102 = r100.length - 1;
    L3:
        if (r102 < 0) goto L5;
        r100[r102] = r101;
        r102 = r102 - 1;
        goto L3
    }

    private static int partition(int[] r100, int r101, int r102, int r103) {
        int r104 = r100[r103];
        r100[r103] = r100[r102];
        r100[r102] = r104;
        int r105 = r101;
    L3:
        if (r101 >= r102) goto L8;
        int r106 = r100[r101];
        if (r106 > r104) goto L7;
        int r107 = r100[r105];
        r100[r105] = r106;
        r100[r101] = r107;
        r105 = r105 + 1;
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        int r108 = r100[r105];
        r100[r105] = r100[r102];
        r100[r102] = r108;
        return r105;
    }

    public static void quicksort(int[] r100) {
        quicksort(r100, 0, r100.length - 1);
    }

    public static void quicksort(int[] r100, int r101, int r102) {
        if (r102 <= r101) goto L5;
        int r103 = partition(r100, r101, r102, r102);
        quicksort(r100, r101, r103 - 1);
        quicksort(r100, r103 + 1, r102);
        return;
    }

    public static int[] subArray(int[] r100, int r101, int r102) {
        int r103 = r102 - r101;
        int[] r104 = new int[r103];
        System.arraycopy(r100, r101, r104, 0, r103);
        return r104;
    }

    public static String toHexString(int[] r100) {
        return ByteUtils.toHexString(BigEndianConversions.toByteArray(r100));
    }

    public static String toString(int[] r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101 = r101 + r100[r102] + " ";
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }
}
