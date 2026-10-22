package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP224K1Field {
    static final int[] P = null;
    private static final int P6 = -1;
    private static final int[] PExt = null;
    private static final int PExt13 = -1;
    private static final int[] PExtInv = null;
    private static final int PInv33 = 6803;

    static {
        P = new int[]{-6803, -2, -1, -1, -1, -1, -1};
        PExt = new int[]{46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};
    }

    public SecP224K1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat224.add(r100, r101, r102) == 0) goto L5;
    L8:
        Nat.add33To(7, PInv33, r102);
        return;
    L5:
        if (r102[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(14, r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(14, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[13] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(14, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(7, r100, r101) == 0) goto L5;
    L8:
        Nat.add33To(7, PInv33, r101);
        return;
    L5:
        if (r101[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r101, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat224.fromBigInteger(r100);
        if (r101[6] == (-1)) goto L5;
    L7:
        return r101;
    L5:
        if (Nat224.gte(r101, P) == false) goto L7;
        Nat.add33To(7, PInv33, r101);
        goto L7
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(7, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(7, r101, Nat224.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 7) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat224.createExt();
        Nat224.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat224.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(14, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[13] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(14, r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat224.sub(r102, r102, r101);
        return;
    L5:
        Nat224.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[28];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 7);
        if (Nat.lessThan(7, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        if (Nat224.mul33DWordAdd(PInv33, Nat224.mul33Add(PInv33, r100, 7, r100, 0, r101, 0), r101, 0) == 0) goto L5;
    L8:
        Nat.add33To(7, PInv33, r101);
        return;
    L5:
        if (r101[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r101, P) == true) goto L8;
    }

    public static void reduce32(int r100, int[] r101) {
        if (r100 == 0) goto L7;
        if (Nat224.mul33WordAdd(PInv33, r100, r101, 0) == 0) goto L7;
    L10:
        Nat.add33To(7, PInv33, r101);
        return;
    L7:
        if (r101[6] == (-1)) goto L9;
        return;
    L9:
        if (Nat224.gte(r101, P) == true) goto L10;
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat224.createExt();
        Nat224.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat224.createExt();
        Nat224.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat224.square(r102, r103);
        goto L3
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat224.sub(r100, r101, r102) == 0) goto L6;
        Nat.sub33From(7, PInv33, r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(14, r100, r101, r102) == 0) goto L8;
        int[] r103 = PExtInv;
        if (Nat.subFrom(r103.length, r103, r102) == 0) goto L9;
        Nat.decAt(14, r102, r103.length);
        return;
    L9:
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(7, r100, 0, r101) == 0) goto L5;
    L8:
        Nat.add33To(7, PInv33, r101);
        return;
    L5:
        if (r101[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r101, P) == true) goto L8;
    }
}
