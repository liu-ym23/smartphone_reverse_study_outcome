package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP160R2Field {
    static final int[] P = null;
    private static final int P4 = -1;
    private static final int[] PExt = null;
    private static final int PExt9 = -1;
    private static final int[] PExtInv = null;
    private static final int PInv33 = 21389;

    static {
        P = new int[]{-21389, -2, -1, -1, -1};
        PExt = new int[]{457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
        PExtInv = new int[]{-457489321, -42779, -2, -1, -1, 42777, 2};
    }

    public SecP160R2Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat160.add(r100, r101, r102) == 0) goto L5;
    L8:
        Nat.add33To(5, PInv33, r102);
        return;
    L5:
        if (r102[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(10, r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(10, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[9] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(10, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(5, r100, r101) == 0) goto L5;
    L8:
        Nat.add33To(5, PInv33, r101);
        return;
    L5:
        if (r101[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r101, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat160.fromBigInteger(r100);
        if (r101[4] != (-1)) goto L7;
        int[] r102 = P;
        if (Nat160.gte(r101, r102) == false) goto L7;
        Nat160.subFrom(r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(5, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(5, r101, Nat160.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 5) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat160.createExt();
        Nat160.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat160.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(10, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[9] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(10, r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat160.sub(r102, r102, r101);
        return;
    L5:
        Nat160.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[20];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 5);
        if (Nat.lessThan(5, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        if (Nat160.mul33DWordAdd(PInv33, Nat160.mul33Add(PInv33, r100, 5, r100, 0, r101, 0), r101, 0) == 0) goto L5;
    L8:
        Nat.add33To(5, PInv33, r101);
        return;
    L5:
        if (r101[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r101, P) == true) goto L8;
    }

    public static void reduce32(int r100, int[] r101) {
        if (r100 == 0) goto L7;
        if (Nat160.mul33WordAdd(PInv33, r100, r101, 0) == 0) goto L7;
    L10:
        Nat.add33To(5, PInv33, r101);
        return;
    L7:
        if (r101[4] == (-1)) goto L9;
        return;
    L9:
        if (Nat160.gte(r101, P) == true) goto L10;
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat160.createExt();
        Nat160.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat160.createExt();
        Nat160.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat160.square(r102, r103);
        goto L3
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat160.sub(r100, r101, r102) == 0) goto L6;
        Nat.sub33From(5, PInv33, r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(10, r100, r101, r102) == 0) goto L8;
        int[] r103 = PExtInv;
        if (Nat.subFrom(r103.length, r103, r102) == 0) goto L9;
        Nat.decAt(10, r102, r103.length);
        return;
    L9:
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(5, r100, 0, r101) == 0) goto L5;
    L8:
        Nat.add33To(5, PInv33, r101);
        return;
    L5:
        if (r101[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r101, P) == true) goto L8;
    }
}
