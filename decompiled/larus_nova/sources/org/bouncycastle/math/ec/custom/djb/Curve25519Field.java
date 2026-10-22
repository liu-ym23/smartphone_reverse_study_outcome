package org.bouncycastle.math.ec.custom.djb;

import com.larus.dora.impl.ota.g2.j0;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Curve25519Field {
    private static final long M = 4294967295L;
    static final int[] P = null;
    private static final int P7 = Integer.MAX_VALUE;
    private static final int[] PExt = null;
    private static final int PInv = 19;

    static {
        P = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        PExt = new int[]{361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};
    }

    public Curve25519Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        Nat256.add(r100, r101, r102);
        if (Nat256.gte(r102, P) == false) goto L6;
        subPFrom(r102);
        return;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        Nat.add(16, r100, r101, r102);
        if (Nat.gte(16, r102, PExt) == false) goto L6;
        subPExtFrom(r102);
        return;
    }

    public static void addOne(int[] r100, int[] r101) {
        Nat.inc(8, r100, r101);
        if (Nat256.gte(r101, P) == false) goto L6;
        subPFrom(r101);
        return;
    }

    private static int addPExtTo(int[] r110) {
        long r100 = ((long) r110[0]) & 4294967295L;
        int[] r101 = PExt;
        long r102 = r100 + (((long) r101[0]) & 4294967295L);
        r110[0] = (int) r102;
        long r103 = r102 >> 32;
        if (r103 == 0) goto L5;
        r103 = Nat.incAt(8, r110, 1);
    L5:
        long r104 = r103 + ((((long) r110[8]) & 4294967295L) - 19);
        r110[8] = (int) r104;
        long r105 = r104 >> 32;
        if (r105 == 0) goto L8;
        r105 = Nat.decAt(15, r110, 9);
    L8:
        long r106 = r105 + ((((long) r110[15]) & 4294967295L) + (4294967295L & ((long) (r101[15] + 1))));
        r110[15] = (int) r106;
        return (int) (r106 >> 32);
    }

    private static int addPTo(int[] r100) {
        long r101 = (((long) r100[0]) & 4294967295L) - 19;
        r100[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        r102 = Nat.decAt(7, r100, 1);
    L5:
        long r103 = r102 + ((4294967295L & ((long) r100[7])) + j0.G2_OTA_SPACE_RESERVE_BYTES);
        r100[7] = (int) r103;
        return (int) (r103 >> 32);
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat256.fromBigInteger(r100);
    L3:
        int[] r102 = P;
        if (Nat256.gte(r101, r102) == false) goto L6;
        Nat256.subFrom(r102, r101);
        goto L3
    L6:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(8, r100, 0, r101);
        return;
    L5:
        Nat256.add(r100, P, r101);
        Nat.shiftDownBit(8, r101, 0);
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
        Nat256.mulAddTo(r100, r101, r102);
        if (Nat.gte(16, r102, PExt) == false) goto L6;
        subPExtFrom(r102);
        return;
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
        r101[7] = r101[7] & Integer.MAX_VALUE;
        if (Nat.lessThan(8, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        int r102 = r100[7];
        Nat.shiftUpBit(8, r100, 8, r102, r101, 0);
        int r103 = Nat256.mulByWordAddTo(19, r100, r101) << 1;
        int r104 = r101[7];
        int r105 = r103 + ((r104 >>> 31) - (r102 >>> 31));
        r101[7] = (r104 & Integer.MAX_VALUE) + Nat.addWordTo(7, r105 * 19, r101);
        if (Nat256.gte(r101, P) == false) goto L6;
        subPFrom(r101);
        return;
    }

    public static void reduce27(int r100, int[] r101) {
        int r102 = r101[7];
        int r103 = (r100 << 1) | (r102 >>> 31);
        r101[7] = (r102 & Integer.MAX_VALUE) + Nat.addWordTo(7, r103 * 19, r101);
        if (Nat256.gte(r101, P) == false) goto L6;
        subPFrom(r101);
        return;
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

    private static int subPExtFrom(int[] r110) {
        long r100 = ((long) r110[0]) & 4294967295L;
        int[] r101 = PExt;
        long r102 = r100 - (((long) r101[0]) & 4294967295L);
        r110[0] = (int) r102;
        long r103 = r102 >> 32;
        if (r103 == 0) goto L5;
        r103 = Nat.decAt(8, r110, 1);
    L5:
        long r104 = r103 + ((((long) r110[8]) & 4294967295L) + 19);
        r110[8] = (int) r104;
        long r105 = r104 >> 32;
        if (r105 == 0) goto L8;
        r105 = Nat.incAt(15, r110, 9);
    L8:
        long r106 = r105 + ((((long) r110[15]) & 4294967295L) - (4294967295L & ((long) (r101[15] + 1))));
        r110[15] = (int) r106;
        return (int) (r106 >> 32);
    }

    private static int subPFrom(int[] r100) {
        long r101 = (((long) r100[0]) & 4294967295L) + 19;
        r100[0] = (int) r101;
        long r102 = r101 >> 32;
        if (r102 == 0) goto L5;
        r102 = Nat.incAt(7, r100, 1);
    L5:
        long r103 = r102 + ((4294967295L & ((long) r100[7])) - j0.G2_OTA_SPACE_RESERVE_BYTES);
        r100[7] = (int) r103;
        return (int) (r103 >> 32);
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat256.sub(r100, r101, r102) == 0) goto L6;
        addPTo(r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(16, r100, r101, r102) == 0) goto L6;
        addPExtTo(r102);
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        Nat.shiftUpBit(8, r100, 0, r101);
        if (Nat256.gte(r101, P) == false) goto L6;
        subPFrom(r101);
        return;
    }
}
