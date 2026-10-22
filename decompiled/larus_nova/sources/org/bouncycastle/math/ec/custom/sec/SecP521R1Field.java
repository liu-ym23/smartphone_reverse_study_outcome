package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat512;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP521R1Field {
    static final int[] P = null;
    private static final int P16 = 511;

    static {
        P = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};
    }

    public SecP521R1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        int r103 = (Nat.add(16, r100, r101, r102) + r100[16]) + r101[16];
        if (r103 > 511) goto L7;
        if (r103 == 511) goto L6;
    L8:
        r102[16] = r103;
        return;
    L6:
        if (Nat.eq(16, r102, P) == false) goto L8;
    L7:
        r103 = (r103 + Nat.inc(16, r102)) & 511;
        goto L8
    }

    public static void addOne(int[] r100, int[] r101) {
        int r102 = Nat.inc(16, r100, r101) + r100[16];
        if (r102 > 511) goto L7;
        if (r102 == 511) goto L6;
    L8:
        r101[16] = r102;
        return;
    L6:
        if (Nat.eq(16, r101, P) == false) goto L8;
    L7:
        r102 = (r102 + Nat.inc(16, r101)) & 511;
        goto L8
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat.fromBigInteger(521, r100);
        if (Nat.eq(17, r101, P) == false) goto L5;
        Nat.zero(17, r101);
    L5:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        int r102 = r100[16];
        int r103 = Nat.shiftDownBit(16, r100, r102, r101);
        int r104 = r103 >>> 23;
        r101[16] = r104 | (r102 >>> 1);
    }

    public static void implMultiply(int[] r100, int[] r110, int[] r111) {
        Nat512.mul(r100, r110, r111);
        int r101 = r100[16];
        int r102 = r110[16];
        r111[32] = Nat.mul31BothAdd(16, r101, r110, r102, r100, r111, 16) + (r101 * r102);
    }

    public static void implSquare(int[] r100, int[] r101) {
        Nat512.square(r100, r101);
        int r102 = r100[16];
        r101[32] = Nat.mulWordAddTo(16, r102 << 1, r100, 0, r101, 16) + (r102 * r102);
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 17) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat.create(33);
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat.sub(17, r102, r102, r101);
        return;
    L5:
        Nat.sub(17, P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[68];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 17);
        r101[16] = r101[16] & 511;
        if (Nat.lessThan(17, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        int r102 = r100[32];
        int r103 = ((Nat.shiftDownBits(16, r100, 16, 9, r102, r101, 0) >>> 23) + (r102 >>> 9)) + Nat.addTo(16, r100, r101);
        if (r103 > 511) goto L7;
        if (r103 == 511) goto L6;
    L8:
        r101[16] = r103;
        return;
    L6:
        if (Nat.eq(16, r101, P) == false) goto L8;
    L7:
        r103 = (r103 + Nat.inc(16, r101)) & 511;
        goto L8
    }

    public static void reduce23(int[] r100) {
        int r101 = r100[16];
        int r102 = Nat.addWordTo(16, r101 >>> 9, r100) + (r101 & 511);
        if (r102 > 511) goto L7;
        if (r102 == 511) goto L6;
    L8:
        r100[16] = r102;
        return;
    L6:
        if (Nat.eq(16, r100, P) == false) goto L8;
    L7:
        r102 = (r102 + Nat.inc(16, r100)) & 511;
        goto L8
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat.create(33);
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat.create(33);
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        int r103 = (Nat.sub(16, r100, r101, r102) + r100[16]) - r101[16];
        if (r103 >= 0) goto L5;
        r103 = (r103 + Nat.dec(16, r102)) & 511;
    L5:
        r102[16] = r103;
    }

    public static void twice(int[] r100, int[] r101) {
        int r102 = r100[16];
        r101[16] = (Nat.shiftUpBit(16, r100, r102 << 23, r101) | (r102 << 1)) & 511;
    }
}
