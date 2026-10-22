package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public final class BigIntUtils {
    private BigIntUtils() {
    }

    public static boolean equals(BigInteger[] r100, BigInteger[] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r103 = r103 | r100[r102].compareTo(r101[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        if (r103 != 0) goto L13;
        return true;
    L13:
        return false;
    }

    public static void fill(BigInteger[] r100, BigInteger r101) {
        int r102 = r100.length - 1;
    L3:
        if (r102 < 0) goto L5;
        r100[r102] = r101;
        r102 = r102 - 1;
        goto L3
    }

    public static BigInteger[] subArray(BigInteger[] r100, int r101, int r102) {
        int r103 = r102 - r101;
        BigInteger[] r104 = new BigInteger[r103];
        System.arraycopy(r100, r101, r104, 0, r103);
        return r104;
    }

    public static int[] toIntArray(BigInteger[] r100) {
        int[] r101 = new int[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].intValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int[] toIntArrayModQ(int r100, BigInteger[] r101) {
        BigInteger r102 = BigInteger.valueOf(r100);
        int[] r103 = new int[r101.length];
        int r104 = 0;
    L4:
        if (r104 >= r101.length) goto L6;
        r103[r104] = r101[r104].mod(r102).intValue();
        r104 = r104 + 1;
        goto L4
    L6:
        return r103;
    }

    public static byte[] toMinimalByteArray(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (r101.length != 1) goto L5;
    L9:
        return r101;
    L5:
        if ((r100.bitLength() & 7) != 0) goto L9;
        int r102 = r100.bitLength() >> 3;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    }
}
