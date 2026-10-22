package org.bouncycastle.math.ec.custom.gm;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SM2P256V1Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P7s1 = Integer.MAX_VALUE;
    private static final int[] PExt = null;
    private static final int PExt15s1 = Integer.MAX_VALUE;

    static {
        P = new int[]{-1, -1, 0, -1, -1, -1, -1, -2};
        PExt = new int[]{1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};
    }

    public SM2P256V1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat256.add(r100, r101, r102) == 0) goto L5;
    L8:
        addPInvTo(r102);
        return;
    L5:
        if ((r102[7] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat256.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(16, r100, r101, r102) == 0) goto L5;
    L8:
        Nat.subFrom(16, PExt, r102);
        return;
    L5:
        if ((r102[15] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat.gte(16, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(8, r100, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if ((r101[7] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat256.gte(r101, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) + 1;
        r110[0] = (int) r100;
        long r101 = r100 >> 32;
        if (r101 == 0) goto L5;
        long r102 = r101 + (((long) r110[1]) & 4294967295L);
        r110[1] = (int) r102;
        r101 = r102 >> 32;
    L5:
        long r103 = r101 + ((((long) r110[2]) & 4294967295L) - 1);
        r110[2] = (int) r103;
        long r104 = (r103 >> 32) + ((((long) r110[3]) & 4294967295L) + 1);
        r110[3] = (int) r104;
        long r105 = r104 >> 32;
        if (r105 == 0) goto L8;
        long r106 = r105 + (((long) r110[4]) & 4294967295L);
        r110[4] = (int) r106;
        long r107 = (r106 >> 32) + (((long) r110[5]) & 4294967295L);
        r110[5] = (int) r107;
        long r108 = (r107 >> 32) + (((long) r110[6]) & 4294967295L);
        r110[6] = (int) r108;
        r105 = r108 >> 32;
    L8:
        r110[7] = (int) (r105 + ((4294967295L & ((long) r110[7])) + 1));
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat256.fromBigInteger(r100);
        if ((r101[7] >>> 1) < Integer.MAX_VALUE) goto L7;
        int[] r102 = P;
        if (Nat256.gte(r101, r102) == false) goto L7;
        Nat256.subFrom(r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(8, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(8, r101, Nat256.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 8) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat256.createExt();
        Nat256.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat256.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        Nat.subFrom(16, PExt, r102);
        return;
    L5:
        if ((r102[15] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat.gte(16, r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat256.sub(r102, r102, r101);
        return;
    L5:
        Nat256.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[32];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 8);
        if (Nat.lessThan(8, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r310, int[] r311) {
        long r100 = ((long) r310[8]) & 4294967295L;
        long r101 = ((long) r310[9]) & 4294967295L;
        long r102 = ((long) r310[10]) & 4294967295L;
        long r103 = ((long) r310[11]) & 4294967295L;
        long r110 = ((long) r310[12]) & 4294967295L;
        long r111 = ((long) r310[13]) & 4294967295L;
        long r112 = ((long) r310[14]) & 4294967295L;
        long r113 = ((long) r310[15]) & 4294967295L;
        long r210 = r102 + r103;
        long r211 = r111 + r112;
        long r212 = r211 + (r113 << 1);
        long r213 = (r100 + r101) + r211;
        long r214 = (r210 + (r110 + r113)) + r213;
        long r114 = (((((((long) r310[0]) & 4294967295L) + r214) + r111) + r112) + r113) + 0;
        r311[0] = (int) r114;
        long r115 = (r114 >> 32) + (((((((long) r310[1]) & 4294967295L) + r214) - r100) + r112) + r113);
        r311[1] = (int) r115;
        long r116 = (r115 >> 32) + ((((long) r310[2]) & 4294967295L) - r213);
        r311[2] = (int) r116;
        long r117 = (r116 >> 32) + (((((((long) r310[3]) & 4294967295L) + r214) - r101) - r102) + r111);
        r311[3] = (int) r117;
        long r104 = (r117 >> 32) + (((((((long) r310[4]) & 4294967295L) + r214) - r210) - r100) + r112);
        r311[4] = (int) r104;
        long r105 = (r104 >> 32) + (((((long) r310[5]) & 4294967295L) + r212) + r102);
        r311[5] = (int) r105;
        long r106 = (r105 >> 32) + ((((((long) r310[6]) & 4294967295L) + r103) + r112) + r113);
        r311[6] = (int) r106;
        long r107 = (r106 >> 32) + ((((4294967295L & ((long) r310[7])) + r214) + r212) + r110);
        r311[7] = (int) r107;
        reduce32((int) (r107 >> 32), r311);
    }

    public static void reduce32(int r110, int[] r111) {
        if (r110 == 0) goto L11;
        long r100 = ((long) r110) & 4294967295L;
        long r101 = ((((long) r111[0]) & 4294967295L) + r100) + 0;
        r111[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L7;
        long r103 = r102 + (((long) r111[1]) & 4294967295L);
        r111[1] = (int) r103;
        r102 = r103 >> 32;
    L7:
        long r104 = r102 + ((((long) r111[2]) & 4294967295L) - r100);
        r111[2] = (int) r104;
        long r105 = (r104 >> 32) + ((((long) r111[3]) & 4294967295L) + r100);
        r111[3] = (int) r105;
        long r106 = r105 >> 32;
        if (r106 == 0) goto L10;
        long r107 = r106 + (((long) r111[4]) & 4294967295L);
        r111[4] = (int) r107;
        long r108 = (r107 >> 32) + (((long) r111[5]) & 4294967295L);
        r111[5] = (int) r108;
        long r109 = (r108 >> 32) + (((long) r111[6]) & 4294967295L);
        r111[6] = (int) r109;
        r106 = r109 >> 32;
    L10:
        long r112 = r106 + ((4294967295L & ((long) r111[7])) + r100);
        r111[7] = (int) r112;
        long r113 = r112 >> 32;
    L13:
        if (r113 == 0) goto L15;
    L18:
        addPInvTo(r111);
        return;
    L15:
        if ((r111[7] >>> 1) >= Integer.MAX_VALUE) goto L17;
        return;
    L17:
        if (Nat256.gte(r111, P) == true) goto L18;
        return;
    L11:
        r113 = 0;
        goto L13
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat256.createExt();
        Nat256.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat256.createExt();
        Nat256.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat256.square(r102, r103);
        goto L3
    }

    private static void subPInvFrom(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) - 1;
        r110[0] = (int) r100;
        long r101 = r100 >> 32;
        if (r101 == 0) goto L5;
        long r102 = r101 + (((long) r110[1]) & 4294967295L);
        r110[1] = (int) r102;
        r101 = r102 >> 32;
    L5:
        long r103 = r101 + ((((long) r110[2]) & 4294967295L) + 1);
        r110[2] = (int) r103;
        long r104 = (r103 >> 32) + ((((long) r110[3]) & 4294967295L) - 1);
        r110[3] = (int) r104;
        long r105 = r104 >> 32;
        if (r105 == 0) goto L8;
        long r106 = r105 + (((long) r110[4]) & 4294967295L);
        r110[4] = (int) r106;
        long r107 = (r106 >> 32) + (((long) r110[5]) & 4294967295L);
        r110[5] = (int) r107;
        long r108 = (r107 >> 32) + (((long) r110[6]) & 4294967295L);
        r110[6] = (int) r108;
        r105 = r108 >> 32;
    L8:
        r110[7] = (int) (r105 + ((4294967295L & ((long) r110[7])) - 1));
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat256.sub(r100, r101, r102) == 0) goto L6;
        subPInvFrom(r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(16, r100, r101, r102) == 0) goto L6;
        Nat.addTo(16, PExt, r102);
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(8, r100, 0, r101) == 0) goto L5;
    L8:
        addPInvTo(r101);
        return;
    L5:
        if ((r101[7] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat256.gte(r101, P) == true) goto L8;
    }
}
