package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.bouncycastle.pqc.math.linearalgebra.BigIntUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

/* JADX INFO: loaded from: classes42.dex */
final class Conversions {
    private static final BigInteger ONE = null;
    private static final BigInteger ZERO = null;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    private Conversions() {
    }

    public static byte[] decode(int r100, int r101, GF2Vector r102) {
        if (r102.getLength() != r100) goto L18;
        if (r102.getHammingWeight() != r101) goto L18;
        int[] r103 = r102.getVecArray();
        BigInteger r104 = IntegerFunctions.binomial(r100, r101);
        BigInteger r105 = ZERO;
        int r106 = 0;
        int r107 = r100;
    L7:
        if (r106 >= r100) goto L16;
        r104 = r104.multiply(BigInteger.valueOf(r107 - r101)).divide(BigInteger.valueOf(r107));
        r107 = r107 - 1;
        if ((r103[r106 >> 5] & (1 << (r106 & 31))) == 0) goto L14;
        r105 = r105.add(r104);
        r101 = r101 - 1;
        if (r107 != r101) goto L13;
        r104 = ONE;
        goto L14
    L13:
        r104 = r104.multiply(BigInteger.valueOf(r101 + 1)).divide(BigInteger.valueOf(r107 - r101));
    L14:
        r106 = r106 + 1;
        goto L7
    L16:
        return BigIntUtils.toMinimalByteArray(r105);
    L18:
        throw new IllegalArgumentException("vector has wrong length or hamming weight");
    }

    public static GF2Vector encode(int r100, int r101, byte[] r102) {
        if (r100 < r101) goto L18;
        BigInteger r103 = IntegerFunctions.binomial(r100, r101);
        BigInteger r104 = new BigInteger(1, r102);
        if (r104.compareTo(r103) >= 0) goto L16;
        GF2Vector r105 = new GF2Vector(r100);
        int r106 = 0;
        int r107 = r100;
    L6:
        if (r106 >= r100) goto L14;
        r103 = r103.multiply(BigInteger.valueOf(r107 - r101)).divide(BigInteger.valueOf(r107));
        r107 = r107 - 1;
        if (r103.compareTo(r104) > 0) goto L13;
        r105.setBit(r106);
        r104 = r104.subtract(r103);
        r101 = r101 - 1;
        if (r107 != r101) goto L12;
        r103 = ONE;
        goto L13
    L12:
        r103 = r103.multiply(BigInteger.valueOf(r101 + 1)).divide(BigInteger.valueOf(r107 - r101));
    L13:
        r106 = r106 + 1;
        goto L6
    L14:
        return r105;
    L16:
        throw new IllegalArgumentException("Encoded number too large.");
    L18:
        throw new IllegalArgumentException("n < t");
    }

    public static byte[] signConversion(int r110, int r111, byte[] r112) {
        if (r110 < r111) goto L33;
        BigInteger r100 = IntegerFunctions.binomial(r110, r111);
        int r101 = r100.bitLength() - 1;
        int r102 = r101 >> 3;
        int r103 = r101 & 7;
        int r104 = 8;
        if (r103 != 0) goto L6;
        r102 = r102 - 1;
        r103 = 8;
    L6:
        int r105 = r110 >> 3;
        int r106 = r110 & 7;
        if (r106 != 0) goto L9;
        r105 = r105 - 1;
    L10:
        int r107 = r105 + 1;
        byte[] r108 = new byte[r107];
        if (r112.length >= r107) goto L15;
        System.arraycopy(r112, 0, r108, 0, r112.length);
        int r113 = r112.length;
    L13:
        if (r113 >= r107) goto L16;
        r108[r113] = 0;
        r113 = r113 + 1;
    L16:
        BigInteger r114 = ZERO;
        int r109 = r110;
        int r115 = 0;
    L17:
        if (r115 >= r110) goto L25;
        r100 = r100.multiply(new BigInteger(Integer.toString(r109 - r111))).divide(new BigInteger(Integer.toString(r109)));
        r109 = r109 - 1;
        if (((byte) (r108[r115 >>> 3] & (1 << (r115 & 7)))) == 0) goto L24;
        r114 = r114.add(r100);
        r111 = r111 - 1;
        if (r109 != r111) goto L23;
        r100 = ONE;
        goto L24
    L23:
        r100 = r100.multiply(new BigInteger(Integer.toString(r111 + 1))).divide(new BigInteger(Integer.toString(r109 - r111)));
    L24:
        r115 = r115 + 1;
        goto L17
    L25:
        int r116 = r102 + 1;
        byte[] r117 = new byte[r116];
        byte[] r118 = r114.toByteArray();
        if (r118.length >= r116) goto L30;
        System.arraycopy(r118, 0, r117, 0, r118.length);
        int r119 = r118.length;
    L28:
        if (r119 >= r116) goto L31;
        r117[r119] = 0;
        r119 = r119 + 1;
    L31:
        return r117;
    L30:
        System.arraycopy(r118, 0, r117, 0, r102);
        r117[r102] = (byte) (((1 << r103) - 1) & r118[r102]);
        goto L31
    L15:
        System.arraycopy(r112, 0, r108, 0, r105);
        r108[r105] = (byte) (r112[r105] & ((1 << r104) - 1));
        goto L16
    L9:
        r104 = r106;
        goto L10
    L33:
        throw new IllegalArgumentException("n < t");
    }
}
