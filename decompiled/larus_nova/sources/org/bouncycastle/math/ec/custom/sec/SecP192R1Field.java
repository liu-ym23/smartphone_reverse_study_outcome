package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192R1Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P5 = -1;
    private static final int[] PExt = null;
    private static final int PExt11 = -1;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, -1, -2, -1, -1, -1};
        PExt = new int[]{1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
        PExtInv = new int[]{-1, -1, -3, -1, -2, -1, 1, 0, 2};
    }

    public SecP192R1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat192.add(r100, r101, r102) == 0) goto L5;
    L8:
        addPInvTo(r102);
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
        addPInvTo(r101);
        return;
    L5:
        if (r101[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r101, P) == true) goto L8;
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
        long r103 = r101 + ((4294967295L & ((long) r110[2])) + 1);
        r110[2] = (int) r103;
        if ((r103 >> 32) == 0) goto L9;
        Nat.incAt(6, r110, 3);
        return;
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

    public static void reduce(int[] r210, int[] r211) {
        long r100 = ((long) r210[6]) & 4294967295L;
        long r101 = ((long) r210[7]) & 4294967295L;
        long r102 = ((long) r210[8]) & 4294967295L;
        long r110 = ((long) r210[9]) & 4294967295L;
        long r111 = ((long) r210[10]) & 4294967295L;
        long r112 = r111 + r100;
        long r113 = (((long) r210[11]) & 4294967295L) + r101;
        long r103 = ((((long) r210[0]) & 4294967295L) + r112) + 0;
        int r104 = (int) r103;
        long r105 = (r103 >> 32) + ((((long) r210[1]) & 4294967295L) + r113);
        int r106 = (int) r105;
        r211[1] = r106;
        long r114 = r112 + r102;
        long r115 = r113 + r110;
        long r107 = (r105 >> 32) + ((((long) r210[2]) & 4294967295L) + r114);
        long r108 = r107 & 4294967295L;
        long r109 = (r107 >> 32) + ((((long) r210[3]) & 4294967295L) + r115);
        r211[3] = (int) r109;
        long r116 = r115 - r101;
        long r117 = ((long) r210[4]) & 4294967295L;
        long r118 = (r109 >> 32) + (r117 + (r114 - r100));
        r211[4] = (int) r118;
        long r119 = (r118 >> 32) + ((((long) r210[5]) & 4294967295L) + r116);
        r211[5] = (int) r119;
        long r120 = r119 >> 32;
        long r121 = r108 + r120;
        long r122 = r120 + (((long) r104) & 4294967295L);
        r211[0] = (int) r122;
        long r123 = r122 >> 32;
        if (r123 == 0) goto L5;
        long r124 = r123 + (4294967295L & ((long) r106));
        r211[1] = (int) r124;
        r121 = r121 + (r124 >> 32);
    L5:
        r211[2] = (int) r121;
        if ((r121 >> 32) == 0) goto L10;
        if (Nat.incAt(6, r211, 3) == 0) goto L10;
    L13:
        addPInvTo(r211);
        return;
    L10:
        if (r211[5] == (-1)) goto L12;
        return;
    L12:
        if (Nat192.gte(r211, P) == true) goto L13;
    }

    public static void reduce32(int r110, int[] r111) {
        if (r110 == 0) goto L8;
        long r100 = ((long) r110) & 4294967295L;
        long r101 = ((((long) r111[0]) & 4294967295L) + r100) + 0;
        r111[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L7;
        long r103 = r102 + (((long) r111[1]) & 4294967295L);
        r111[1] = (int) r103;
        r102 = r103 >> 32;
    L7:
        long r104 = r102 + ((4294967295L & ((long) r111[2])) + r100);
        r111[2] = (int) r104;
        long r105 = r104 >> 32;
    L10:
        if (r105 == 0) goto L14;
        if (Nat.incAt(6, r111, 3) == 0) goto L14;
    L17:
        addPInvTo(r111);
        return;
    L14:
        if (r111[5] == (-1)) goto L16;
        return;
    L16:
        if (Nat192.gte(r111, P) == true) goto L17;
        return;
    L8:
        r105 = 0;
        goto L10
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

    private static void subPInvFrom(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) - 1;
        r110[0] = (int) r100;
        long r101 = r100 >> 32;
        if (r101 == 0) goto L5;
        long r102 = r101 + (((long) r110[1]) & 4294967295L);
        r110[1] = (int) r102;
        r101 = r102 >> 32;
    L5:
        long r103 = r101 + ((4294967295L & ((long) r110[2])) - 1);
        r110[2] = (int) r103;
        if ((r103 >> 32) == 0) goto L9;
        Nat.decAt(6, r110, 3);
        return;
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat192.sub(r100, r101, r102) == 0) goto L6;
        subPInvFrom(r102);
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
        addPInvTo(r101);
        return;
    L5:
        if (r101[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r101, P) == true) goto L8;
    }
}
