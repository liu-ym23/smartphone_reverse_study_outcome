package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP128R1Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P3s1 = 2147483646;
    private static final int[] PExt = null;
    private static final int PExt7s1 = 2147483646;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, -1, -1, -3};
        PExt = new int[]{1, 0, 0, 4, -2, -1, 3, -4};
        PExtInv = new int[]{-1, -1, -1, -5, 1, 0, -4, 3};
    }

    public SecP128R1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat128.add(r100, r101, r102) == 0) goto L5;
    L8:
        addPInvTo(r102);
        return;
    L5:
        if ((r102[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat256.add(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        Nat.addTo(r103.length, r103, r102);
        return;
    L5:
        if ((r102[7] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat256.gte(r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(4, r100, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if ((r101[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r101, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r100) {
        long r101 = (((long) r100[0]) & 4294967295L) + 1;
        r100[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        long r103 = r102 + (((long) r100[1]) & 4294967295L);
        r100[1] = (int) r103;
        long r104 = (r103 >> 32) + (((long) r100[2]) & 4294967295L);
        r100[2] = (int) r104;
        r102 = r104 >> 32;
    L5:
        r100[3] = (int) (r102 + ((4294967295L & ((long) r100[3])) + 2));
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat128.fromBigInteger(r100);
        if ((r101[3] >>> 1) < 2147483646) goto L7;
        int[] r102 = P;
        if (Nat128.gte(r101, r102) == false) goto L7;
        Nat128.subFrom(r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(4, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(4, r101, Nat128.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 4) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat128.createExt();
        Nat128.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat128.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        Nat.addTo(r103.length, r103, r102);
        return;
    L5:
        if ((r102[7] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat256.gte(r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat128.sub(r102, r102, r101);
        return;
    L5:
        Nat128.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[16];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 4);
        if (Nat.lessThan(4, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r210, int[] r211) {
        long r100 = ((long) r210[0]) & 4294967295L;
        long r101 = ((long) r210[1]) & 4294967295L;
        long r110 = ((long) r210[2]) & 4294967295L;
        long r111 = ((long) r210[3]) & 4294967295L;
        long r102 = ((long) r210[4]) & 4294967295L;
        long r103 = ((long) r210[5]) & 4294967295L;
        long r104 = ((long) r210[6]) & 4294967295L;
        long r105 = ((long) r210[7]) & 4294967295L;
        long r112 = r111 + r105;
        long r106 = r104 + (r105 << 1);
        long r107 = r110 + r106;
        long r108 = r103 + (r106 << 1);
        long r109 = r101 + r108;
        long r113 = r102 + (r108 << 1);
        long r114 = r100 + r113;
        long r115 = r112 + (r113 << 1);
        r211[0] = (int) r114;
        long r116 = r109 + (r114 >>> 32);
        r211[1] = (int) r116;
        long r117 = r107 + (r116 >>> 32);
        r211[2] = (int) r117;
        long r118 = r115 + (r117 >>> 32);
        r211[3] = (int) r118;
        reduce32((int) (r118 >>> 32), r211);
    }

    public static void reduce32(int r110, int[] r111) {
    L3:
        if (r110 == 0) goto L9;
        long r100 = ((long) r110) & 4294967295L;
        long r101 = (((long) r111[0]) & 4294967295L) + r100;
        r111[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L7;
        long r103 = r102 + (((long) r111[1]) & 4294967295L);
        r111[1] = (int) r103;
        long r104 = (r103 >> 32) + (((long) r111[2]) & 4294967295L);
        r111[2] = (int) r104;
        r102 = r104 >> 32;
    L7:
        long r105 = r102 + ((4294967295L & ((long) r111[3])) + (r100 << 1));
        r111[3] = (int) r105;
        r110 = (int) (r105 >> 32);
        goto L3
    L9:
        if ((r111[3] >>> 1) >= 2147483646) goto L11;
        return;
    L11:
        if (Nat128.gte(r111, P) == false) goto L18;
        addPInvTo(r111);
        return;
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat128.createExt();
        Nat128.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat128.createExt();
        Nat128.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat128.square(r102, r103);
        goto L3
    }

    private static void subPInvFrom(int[] r100) {
        long r101 = (((long) r100[0]) & 4294967295L) - 1;
        r100[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        long r103 = r102 + (((long) r100[1]) & 4294967295L);
        r100[1] = (int) r103;
        long r104 = (r103 >> 32) + (((long) r100[2]) & 4294967295L);
        r100[2] = (int) r104;
        r102 = r104 >> 32;
    L5:
        r100[3] = (int) (r102 + ((4294967295L & ((long) r100[3])) - 2));
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat128.sub(r100, r101, r102) == 0) goto L6;
        subPInvFrom(r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(10, r100, r101, r102) == 0) goto L6;
        int[] r103 = PExtInv;
        Nat.subFrom(r103.length, r103, r102);
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(4, r100, 0, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if ((r101[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r101, P) == true) goto L8;
    }
}
