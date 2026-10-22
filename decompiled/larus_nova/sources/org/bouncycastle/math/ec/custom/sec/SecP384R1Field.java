package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP384R1Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P11 = -1;
    private static final int[] PExt = null;
    private static final int PExt23 = -1;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
        PExt = new int[]{1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};
    }

    public SecP384R1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(12, r100, r101, r102) == 0) goto L5;
    L8:
        addPInvTo(r102);
        return;
    L5:
        if (r102[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(24, r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(24, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[23] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(24, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(12, r100, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if (r101[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r101, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) + 1;
        r110[0] = (int) r100;
        long r101 = (r100 >> 32) + ((((long) r110[1]) & 4294967295L) - 1);
        r110[1] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        long r103 = r102 + (((long) r110[2]) & 4294967295L);
        r110[2] = (int) r103;
        r102 = r103 >> 32;
    L5:
        long r104 = r102 + ((((long) r110[3]) & 4294967295L) + 1);
        r110[3] = (int) r104;
        long r105 = (r104 >> 32) + ((4294967295L & ((long) r110[4])) + 1);
        r110[4] = (int) r105;
        if ((r105 >> 32) == 0) goto L9;
        Nat.incAt(12, r110, 5);
        return;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat.fromBigInteger(384, r100);
        if (r101[11] != (-1)) goto L7;
        int[] r102 = P;
        if (Nat.gte(12, r101, r102) == false) goto L7;
        Nat.subFrom(12, r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(12, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(12, r101, Nat.add(12, r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 12) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat.create(24);
        Nat384.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat.sub(12, r102, r102, r101);
        return;
    L5:
        Nat.sub(12, P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[48];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 12);
        if (Nat.lessThan(12, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r410, int[] r411) {
        long r100 = ((long) r410[16]) & 4294967295L;
        long r101 = ((long) r410[17]) & 4294967295L;
        long r102 = ((long) r410[18]) & 4294967295L;
        long r103 = ((long) r410[19]) & 4294967295L;
        long r110 = ((long) r410[20]) & 4294967295L;
        long r111 = ((long) r410[21]) & 4294967295L;
        long r104 = ((long) r410[22]) & 4294967295L;
        long r105 = ((long) r410[23]) & 4294967295L;
        long r106 = ((((long) r410[12]) & 4294967295L) + r110) - 1;
        long r112 = (((long) r410[13]) & 4294967295L) + r104;
        long r113 = ((((long) r410[14]) & 4294967295L) + r104) + r105;
        long r114 = (((long) r410[15]) & 4294967295L) + r105;
        long r310 = r101 + r111;
        long r311 = r111 - r105;
        long r107 = r104 - r105;
        long r312 = r106 + r311;
        long r108 = ((((long) r410[0]) & 4294967295L) + r312) + 0;
        r411[0] = (int) r108;
        long r109 = (r108 >> 32) + ((((((long) r410[1]) & 4294967295L) + r105) - r106) + r112);
        r411[1] = (int) r109;
        long r115 = (r109 >> 32) + ((((((long) r410[2]) & 4294967295L) - r111) - r112) + r113);
        r411[2] = (int) r115;
        long r116 = (r115 >> 32) + ((((((long) r410[3]) & 4294967295L) - r113) + r114) + r312);
        r411[3] = (int) r116;
        long r117 = (r116 >> 32) + ((((((((long) r410[4]) & 4294967295L) + r100) + r111) + r112) - r114) + r312);
        r411[4] = (int) r117;
        long r118 = (r117 >> 32) + (((((((long) r410[5]) & 4294967295L) - r100) + r112) + r113) + r310);
        r411[5] = (int) r118;
        long r119 = (r118 >> 32) + (((((((long) r410[6]) & 4294967295L) + r102) - r101) + r113) + r114);
        r411[6] = (int) r119;
        long r120 = (r119 >> 32) + (((((((long) r410[7]) & 4294967295L) + r100) + r103) - r102) + r114);
        r411[7] = (int) r120;
        long r121 = (r120 >> 32) + (((((((long) r410[8]) & 4294967295L) + r100) + r101) + r110) - r103);
        r411[8] = (int) r121;
        long r122 = (r121 >> 32) + ((((((long) r410[9]) & 4294967295L) + r102) - r110) + r310);
        r411[9] = (int) r122;
        long r123 = (r122 >> 32) + (((((((long) r410[10]) & 4294967295L) + r102) + r103) - r311) + r107);
        r411[10] = (int) r123;
        long r124 = (r123 >> 32) + ((((((long) r410[11]) & 4294967295L) + r103) + r110) - r107);
        r411[11] = (int) r124;
        reduce32((int) ((r124 >> 32) + 1), r411);
    }

    public static void reduce32(int r110, int[] r111) {
        if (r110 == 0) goto L8;
        long r100 = ((long) r110) & 4294967295L;
        long r101 = ((((long) r111[0]) & 4294967295L) + r100) + 0;
        r111[0] = (int) r101;
        long r102 = (r101 >> 32) + ((((long) r111[1]) & 4294967295L) - r100);
        r111[1] = (int) r102;
        long r103 = r102 >> 32;
        if (r103 == 0) goto L7;
        long r104 = r103 + (((long) r111[2]) & 4294967295L);
        r111[2] = (int) r104;
        r103 = r104 >> 32;
    L7:
        long r105 = r103 + ((((long) r111[3]) & 4294967295L) + r100);
        r111[3] = (int) r105;
        long r106 = (r105 >> 32) + ((4294967295L & ((long) r111[4])) + r100);
        r111[4] = (int) r106;
        long r107 = r106 >> 32;
    L10:
        if (r107 == 0) goto L14;
        if (Nat.incAt(12, r111, 5) == 0) goto L14;
    L17:
        addPInvTo(r111);
        return;
    L14:
        if (r111[11] == (-1)) goto L16;
        return;
    L16:
        if (Nat.gte(12, r111, P) == true) goto L17;
        return;
    L8:
        r107 = 0;
        goto L10
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat.create(24);
        Nat384.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat.create(24);
        Nat384.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat384.square(r102, r103);
        goto L3
    }

    private static void subPInvFrom(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) - 1;
        r110[0] = (int) r100;
        long r101 = (r100 >> 32) + ((((long) r110[1]) & 4294967295L) + 1);
        r110[1] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        long r103 = r102 + (((long) r110[2]) & 4294967295L);
        r110[2] = (int) r103;
        r102 = r103 >> 32;
    L5:
        long r104 = r102 + ((((long) r110[3]) & 4294967295L) - 1);
        r110[3] = (int) r104;
        long r105 = (r104 >> 32) + ((4294967295L & ((long) r110[4])) - 1);
        r110[4] = (int) r105;
        if ((r105 >> 32) == 0) goto L9;
        Nat.decAt(12, r110, 5);
        return;
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(12, r100, r101, r102) == 0) goto L6;
        subPInvFrom(r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(24, r100, r101, r102) == 0) goto L8;
        int[] r103 = PExtInv;
        if (Nat.subFrom(r103.length, r103, r102) == 0) goto L9;
        Nat.decAt(24, r102, r103.length);
        return;
    L9:
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(12, r100, 0, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if (r101[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r101, P) == true) goto L8;
    }
}
