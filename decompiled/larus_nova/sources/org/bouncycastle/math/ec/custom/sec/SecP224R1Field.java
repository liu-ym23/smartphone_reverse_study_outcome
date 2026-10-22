package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP224R1Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P6 = -1;
    private static final int[] PExt = null;
    private static final int PExt13 = -1;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{1, 0, 0, -1, -1, -1, -1};
        PExt = new int[]{1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
        PExtInv = new int[]{-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};
    }

    public SecP224R1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat224.add(r100, r101, r102) == 0) goto L5;
    L8:
        addPInvTo(r102);
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
        addPInvTo(r101);
        return;
    L5:
        if (r101[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r101, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) - 1;
        r110[0] = (int) r100;
        long r101 = r100 >> 32;
        if (r101 == 0) goto L5;
        long r102 = r101 + (((long) r110[1]) & 4294967295L);
        r110[1] = (int) r102;
        long r103 = (r102 >> 32) + (((long) r110[2]) & 4294967295L);
        r110[2] = (int) r103;
        r101 = r103 >> 32;
    L5:
        long r104 = r101 + ((4294967295L & ((long) r110[3])) + 1);
        r110[3] = (int) r104;
        if ((r104 >> 32) == 0) goto L9;
        Nat.incAt(7, r110, 4);
        return;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat224.fromBigInteger(r100);
        if (r101[6] != (-1)) goto L7;
        int[] r102 = P;
        if (Nat224.gte(r101, r102) == false) goto L7;
        Nat224.subFrom(r102, r101);
    L7:
        return r101;
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

    public static void reduce(int[] r310, int[] r311) {
        long r100 = ((long) r310[10]) & 4294967295L;
        long r101 = ((long) r310[11]) & 4294967295L;
        long r102 = ((long) r310[12]) & 4294967295L;
        long r103 = ((long) r310[13]) & 4294967295L;
        long r110 = ((((long) r310[7]) & 4294967295L) + r101) - 1;
        long r111 = (((long) r310[8]) & 4294967295L) + r102;
        long r104 = (((long) r310[9]) & 4294967295L) + r103;
        long r105 = ((((long) r310[0]) & 4294967295L) - r110) + 0;
        long r210 = r105 & 4294967295L;
        long r106 = (r105 >> 32) + ((((long) r310[1]) & 4294967295L) - r111);
        int r107 = (int) r106;
        r311[1] = r107;
        long r108 = (r106 >> 32) + ((((long) r310[2]) & 4294967295L) - r104);
        int r112 = (int) r108;
        r311[2] = r112;
        long r109 = (r108 >> 32) + (((((long) r310[3]) & 4294967295L) + r110) - r100);
        long r113 = r109 & 4294967295L;
        long r114 = (r109 >> 32) + (((((long) r310[4]) & 4294967295L) + r111) - r101);
        r311[4] = (int) r114;
        long r115 = (r114 >> 32) + (((((long) r310[5]) & 4294967295L) + r104) - r102);
        r311[5] = (int) r115;
        long r116 = (r115 >> 32) + (((((long) r310[6]) & 4294967295L) + r100) - r103);
        r311[6] = (int) r116;
        long r117 = (r116 >> 32) + 1;
        long r118 = r113 + r117;
        long r119 = r210 - r117;
        r311[0] = (int) r119;
        long r120 = r119 >> 32;
        if (r120 == 0) goto L5;
        long r121 = r120 + (((long) r107) & 4294967295L);
        r311[1] = (int) r121;
        long r122 = (r121 >> 32) + (4294967295L & ((long) r112));
        r311[2] = (int) r122;
        r118 = r118 + (r122 >> 32);
    L5:
        r311[3] = (int) r118;
        if ((r118 >> 32) == 0) goto L10;
        if (Nat.incAt(7, r311, 4) == 0) goto L10;
    L13:
        addPInvTo(r311);
        return;
    L10:
        if (r311[6] == (-1)) goto L12;
        return;
    L12:
        if (Nat224.gte(r311, P) == true) goto L13;
    }

    public static void reduce32(int r110, int[] r111) {
        if (r110 == 0) goto L8;
        long r100 = ((long) r110) & 4294967295L;
        long r101 = ((((long) r111[0]) & 4294967295L) - r100) + 0;
        r111[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L7;
        long r103 = r102 + (((long) r111[1]) & 4294967295L);
        r111[1] = (int) r103;
        long r104 = (r103 >> 32) + (((long) r111[2]) & 4294967295L);
        r111[2] = (int) r104;
        r102 = r104 >> 32;
    L7:
        long r105 = r102 + ((4294967295L & ((long) r111[3])) + r100);
        r111[3] = (int) r105;
        long r106 = r105 >> 32;
    L10:
        if (r106 == 0) goto L14;
        if (Nat.incAt(7, r111, 4) == 0) goto L14;
    L17:
        addPInvTo(r111);
        return;
    L14:
        if (r111[6] == (-1)) goto L16;
        return;
    L16:
        if (Nat224.gte(r111, P) == true) goto L17;
        return;
    L8:
        r106 = 0;
        goto L10
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

    private static void subPInvFrom(int[] r110) {
        long r100 = (((long) r110[0]) & 4294967295L) + 1;
        r110[0] = (int) r100;
        long r101 = r100 >> 32;
        if (r101 == 0) goto L5;
        long r102 = r101 + (((long) r110[1]) & 4294967295L);
        r110[1] = (int) r102;
        long r103 = (r102 >> 32) + (((long) r110[2]) & 4294967295L);
        r110[2] = (int) r103;
        r101 = r103 >> 32;
    L5:
        long r104 = r101 + ((4294967295L & ((long) r110[3])) - 1);
        r110[3] = (int) r104;
        if ((r104 >> 32) == 0) goto L9;
        Nat.decAt(7, r110, 4);
        return;
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat224.sub(r100, r101, r102) == 0) goto L6;
        subPInvFrom(r102);
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
        addPInvTo(r101);
        return;
    L5:
        if (r101[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r101, P) == true) goto L8;
    }
}
