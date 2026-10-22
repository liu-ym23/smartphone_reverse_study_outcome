package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192K1Field {
    static final int[] P = null;
    private static final int P5 = -1;
    private static final int[] PExt = null;
    private static final int PExt11 = -1;
    private static final int[] PExtInv = null;
    private static final int PInv33 = 4553;

    static {
        P = new int[]{-4553, -2, -1, -1, -1, -1};
        PExt = new int[]{20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};
        PExtInv = new int[]{-20729809, -9107, -2, -1, -1, -1, 9105, 2};
    }

    public SecP192K1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat192.add(r100, r101, r102) == 0) goto L5;
    L8:
        Nat.add33To(6, PInv33, r102);
        return;
    L5:
        if (r102[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(12, r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(12, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(6, r100, r101) == 0) goto L5;
    L8:
        Nat.add33To(6, PInv33, r101);
        return;
    L5:
        if (r101[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r101, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat192.fromBigInteger(r100);
        if (r101[5] != (-1)) goto L7;
        int[] r102 = P;
        if (Nat192.gte(r101, r102) == false) goto L7;
        Nat192.subFrom(r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(6, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(6, r101, Nat192.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 6) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat192.createExt();
        Nat192.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat192.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(12, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat192.sub(r102, r102, r101);
        return;
    L5:
        Nat192.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[24];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 6);
        if (Nat.lessThan(6, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        if (Nat192.mul33DWordAdd(PInv33, Nat192.mul33Add(PInv33, r100, 6, r100, 0, r101, 0), r101, 0) == 0) goto L5;
    L8:
        Nat.add33To(6, PInv33, r101);
        return;
    L5:
        if (r101[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r101, P) == true) goto L8;
    }

    public static void reduce32(int r100, int[] r101) {
        if (r100 == 0) goto L7;
        if (Nat192.mul33WordAdd(PInv33, r100, r101, 0) == 0) goto L7;
    L10:
        Nat.add33To(6, PInv33, r101);
        return;
    L7:
        if (r101[5] == (-1)) goto L9;
        return;
    L9:
        if (Nat192.gte(r101, P) == true) goto L10;
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat192.createExt();
        Nat192.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat192.createExt();
        Nat192.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat192.square(r102, r103);
        goto L3
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat192.sub(r100, r101, r102) == 0) goto L6;
        Nat.sub33From(6, PInv33, r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(12, r100, r101, r102) == 0) goto L8;
        int[] r103 = PExtInv;
        if (Nat.subFrom(r103.length, r103, r102) == 0) goto L9;
        Nat.decAt(12, r102, r103.length);
        return;
    L9:
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(6, r100, 0, r101) == 0) goto L5;
    L8:
        Nat.add33To(6, PInv33, r101);
        return;
    L5:
        if (r101[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r101, P) == true) goto L8;
    }
}
