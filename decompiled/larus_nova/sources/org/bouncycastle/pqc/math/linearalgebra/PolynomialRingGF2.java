package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public final class PolynomialRingGF2 {
    private PolynomialRingGF2() {
    }

    public static int add(int r100, int r101) {
        return r100 ^ r101;
    }

    public static int degree(int r100) {
        int r101 = -1;
    L3:
        if (r100 == 0) goto L5;
        r101 = r101 + 1;
        r100 = r100 >>> 1;
        goto L3
    L5:
        return r101;
    }

    public static int degree(long r100) {
        int r101 = 0;
    L4:
        if (r100 == 0) goto L7;
        r101 = r101 + 1;
        r100 = r100 >>> 1;
        goto L4
    L7:
        return r101 - 1;
    }

    public static int gcd(int r100, int r101) {
    L2:
        int r102 = r101;
        int r103 = r100;
        r100 = r102;
        if (r100 == 0) goto L5;
        r101 = remainder(r103, r100);
        goto L2
    L5:
        return r103;
    }

    public static int getIrreduciblePolynomial(int r100) {
        if (r100 >= 0) goto L8;
        PrintStream r101 = System.err;
        String r102 = "The Degree is negative";
    L5:
        r101.println(r102);
        return 0;
    L8:
        if (r100 <= 31) goto L11;
        r101 = System.err;
        r102 = "The Degree is more then 31";
        goto L5
    L11:
        if (r100 != 0) goto L13;
        return 1;
    L13:
        int r103 = (1 << r100) + 1;
        int r104 = 1 << (r100 + 1);
    L14:
        if (r103 >= r104) goto L19;
        if (isIrreducible(r103) == true) goto L17;
        r103 = r103 + 2;
        goto L14
    L17:
        return r103;
    L19:
        return 0;
    }

    public static boolean isIrreducible(int r100) {
        if (r100 != 0) goto L5;
        return false;
    L5:
        int r101 = degree(r100) >>> 1;
        int r102 = 2;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L11;
        r102 = modMultiply(r102, r102, r100);
        if (gcd(r102 ^ 2, r100) != 1) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static int modMultiply(int r100, int r101, int r102) {
        int r103 = remainder(r100, r102);
        int r104 = remainder(r101, r102);
        int r105 = 0;
        if (r104 == 0) goto L12;
        int r106 = 1 << degree(r102);
    L5:
        if (r103 == 0) goto L12;
        if (((byte) (r103 & 1)) != 1) goto L9;
        r105 = r105 ^ r104;
    L9:
        r103 = r103 >>> 1;
        r104 = r104 << 1;
        if (r104 < r106) goto L5;
        r104 = r104 ^ r102;
    L12:
        return r105;
    }

    public static long multiply(int r100, int r101) {
        long r102 = 0;
        if (r101 == 0) goto L10;
        long r103 = ((long) r101) & BodyPartID.bodyIdMax;
    L5:
        if (r100 == 0) goto L10;
        if (((byte) (r100 & 1)) != 1) goto L9;
        r102 = r102 ^ r103;
    L9:
        r100 = r100 >>> 1;
        r103 = r103 << 1;
    L10:
        return r102;
    }

    public static int remainder(int r100, int r101) {
        if (r101 != 0) goto L6;
        System.err.println("Error: to be divided by 0");
        return 0;
    L6:
        if (degree(r100) < degree(r101)) goto L8;
        r100 = r100 ^ (r101 << (degree(r100) - degree(r101)));
        goto L6
    L8:
        return r100;
    }

    public static int rest(long r100, int r101) {
        if (r101 != 0) goto L5;
        System.err.println("Error: to be divided by 0");
        return 0;
    L5:
        long r102 = ((long) r101) & BodyPartID.bodyIdMax;
    L7:
        if ((r100 >>> 32) == 0) goto L9;
        r100 = r100 ^ (r102 << (degree(r100) - degree(r102)));
        goto L7
    L9:
        int r103 = (int) (r100 & (-1));
    L11:
        if (degree(r103) < degree(r101)) goto L13;
        r103 = r103 ^ (r101 << (degree(r103) - degree(r101)));
        goto L11
    L13:
        return r103;
    }
}
