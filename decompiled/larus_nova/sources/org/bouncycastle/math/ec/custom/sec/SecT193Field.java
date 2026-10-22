package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes42.dex */
public class SecT193Field {
    private static final long M01 = 1;
    private static final long M49 = 562949953421311L;

    public SecT193Field() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        long r103 = r100[3];
        r102[3] = r101[3] ^ r103;
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
        r102[4] = r100[4] ^ r101[4];
        r102[5] = r100[5] ^ r101[5];
        long r103 = r100[6];
        r102[6] = r101[6] ^ r103;
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
    }

    private static void addTo(long[] r100, long[] r101) {
        r101[0] = r101[0] ^ r100[0];
        r101[1] = r101[1] ^ r100[1];
        r101[2] = r101[2] ^ r100[2];
        r101[3] = r101[3] ^ r100[3];
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(193, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat256.createExt64();
        Nat256.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 193) goto L6;
        implSquare(r101, r102);
        reduce(r102, r101);
        implSquare(r101, r102);
        reduce(r102, r101);
        addTo(r100, r101);
        r103 = r103 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r210) {
        long r100 = r210[0];
        long r101 = r210[1];
        long r102 = r210[2];
        long r110 = r210[3];
        long r111 = r210[4];
        long r112 = r210[5];
        long r113 = r210[6];
        long r211 = r210[7];
        r210[0] = r100 ^ (r101 << 49);
        r210[1] = (r101 >>> 15) ^ (r102 << 34);
        r210[2] = (r102 >>> 30) ^ (r110 << 19);
        r210[3] = ((r110 >>> 45) ^ (r111 << 4)) ^ (r112 << 53);
        r210[4] = ((r111 >>> 60) ^ (r113 << 38)) ^ (r112 >>> 11);
        r210[5] = (r113 >>> 26) ^ (r211 << 23);
        r210[6] = r211 >>> 41;
        r210[7] = 0;
    }

    public static void implExpand(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r110[2];
        long r112 = r110[3];
        r111[0] = r100 & M49;
        r111[1] = ((r100 >>> 49) ^ (r101 << 15)) & M49;
        r111[2] = ((r101 >>> 34) ^ (r102 << 30)) & M49;
        r111[3] = (r102 >>> 19) ^ (r112 << 45);
    }

    public static void implMultiply(long[] r210, long[] r211, long[] r212) {
        long[] r100 = new long[4];
        long[] r101 = new long[4];
        implExpand(r210, r100);
        implExpand(r211, r101);
        long[] r110 = new long[8];
        implMulwAcc(r110, r100[0], r101[0], r212, 0);
        implMulwAcc(r110, r100[1], r101[1], r212, 1);
        implMulwAcc(r110, r100[2], r101[2], r212, 2);
        implMulwAcc(r110, r100[3], r101[3], r212, 3);
        int r102 = 5;
    L3:
        if (r102 <= 0) goto L5;
        r212[r102] = r212[r102] ^ r212[r102 - 1];
        r102 = r102 - 1;
        goto L3
    L5:
        implMulwAcc(r110, r100[0] ^ r100[1], r101[0] ^ r101[1], r212, 1);
        implMulwAcc(r110, r100[2] ^ r100[3], r101[2] ^ r101[3], r212, 3);
        int r103 = 7;
    L6:
        if (r103 <= 1) goto L8;
        r212[r103] = r212[r103] ^ r212[r103 - 2];
        r103 = r103 - 1;
        goto L6
    L8:
        long r111 = r100[0] ^ r100[2];
        long r213 = r100[1] ^ r100[3];
        long r214 = r101[0] ^ r101[2];
        long r104 = r101[1] ^ r101[3];
        implMulwAcc(r110, r111 ^ r213, r214 ^ r104, r212, 3);
        long[] r105 = new long[3];
        implMulwAcc(r110, r111, r214, r105, 0);
        implMulwAcc(r110, r213, r104, r105, 1);
        long r106 = r105[0];
        long r107 = r105[1];
        long r108 = r105[2];
        r212[2] = r212[2] ^ r106;
        r212[3] = r212[3] ^ (r106 ^ r107);
        r212[4] = r212[4] ^ (r108 ^ r107);
        r212[5] = r212[5] ^ r108;
        implCompactExt(r212);
    }

    public static void implMulwAcc(long[] r110, long r111, long r210, long[] r211, int r212) {
        r110[1] = r210;
        long r100 = r210 << 1;
        r110[2] = r100;
        long r101 = r100 ^ r210;
        r110[3] = r101;
        long r102 = r100 << 1;
        r110[4] = r102;
        r110[5] = r102 ^ r210;
        long r103 = r101 << 1;
        r110[6] = r103;
        r110[7] = r103 ^ r210;
        int r104 = (int) r111;
        long r105 = (r110[(r104 >>> 3) & 7] << 3) ^ r110[r104 & 7];
        long r106 = 0;
        int r112 = 36;
    L3:
        int r113 = (int) (r111 >>> r112);
        long r114 = (r110[(r113 >>> 12) & 7] << 12) ^ (((r110[r113 & 7] ^ (r110[(r113 >>> 3) & 7] << 3)) ^ (r110[(r113 >>> 6) & 7] << 6)) ^ (r110[(r113 >>> 9) & 7] << 9));
        r105 = r105 ^ (r114 << r112);
        r106 = r106 ^ (r114 >>> (-r112));
        r112 = r112 - 15;
        if (r112 > 0) goto L3;
        r211[r212] = r211[r212] ^ (M49 & r105);
        int r107 = r212 + 1;
        r211[r107] = r211[r107] ^ ((r105 >>> 49) ^ (r106 << 15));
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 3, r101, 0);
        r101[6] = r100[3] & 1;
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat256.isZero64(r100) == true) goto L7;
        long[] r102 = Nat256.create64();
        long[] r103 = Nat256.create64();
        square(r100, r102);
        squareN(r102, 1, r103);
        multiply(r102, r103, r102);
        squareN(r103, 1, r103);
        multiply(r102, r103, r102);
        squareN(r102, 3, r103);
        multiply(r102, r103, r102);
        squareN(r102, 6, r103);
        multiply(r102, r103, r102);
        squareN(r102, 12, r103);
        multiply(r102, r103, r102);
        squareN(r102, 24, r103);
        multiply(r102, r103, r102);
        squareN(r102, 48, r103);
        multiply(r102, r103, r102);
        squareN(r102, 96, r103);
        multiply(r102, r103, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat256.createExt64();
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat256.createExt64();
        implMultiply(r100, r101, r103);
        addExt(r102, r103, r102);
    }

    public static void reduce(long[] r210, long[] r211) {
        long r100 = r210[0];
        long r101 = r210[1];
        long r102 = r210[2];
        long r110 = r210[3];
        long r111 = r210[4];
        long r112 = r210[5];
        long r113 = r210[6];
        long r103 = r102 ^ (r113 << 63);
        long r114 = r110 ^ ((r113 >>> 1) ^ (r113 << 14));
        long r115 = r111 ^ (r113 >>> 50);
        long r104 = r101 ^ (r112 << 63);
        long r105 = r103 ^ ((r112 >>> 1) ^ (r112 << 14));
        long r116 = r114 ^ (r112 >>> 50);
        long r106 = r100 ^ (r115 << 63);
        long r107 = r104 ^ ((r115 >>> 1) ^ (r115 << 14));
        long r108 = r105 ^ (r115 >>> 50);
        long r117 = r116 >>> 1;
        r211[0] = (r106 ^ r117) ^ (r117 << 15);
        r211[1] = (r117 >>> 49) ^ r107;
        r211[2] = r108;
        r211[3] = 1 & r116;
    }

    public static void reduce63(long[] r110, int r111) {
        int r100 = r111 + 3;
        long r101 = r110[r100];
        long r102 = r101 >>> 1;
        r110[r111] = r110[r111] ^ ((r102 << 15) ^ r102);
        int r112 = r111 + 1;
        long r103 = r102 >>> 49;
        r110[r112] = r103 ^ r110[r112];
        r110[r100] = r101 & 1;
    }

    public static void sqrt(long[] r110, long[] r111) {
        long r100 = Interleave.unshuffle(r110[0]);
        long r101 = Interleave.unshuffle(r110[1]);
        long r102 = (r100 & BodyPartID.bodyIdMax) | (r101 << 32);
        long r103 = (r100 >>> 32) | (r101 & (-4294967296L));
        long r112 = Interleave.unshuffle(r110[2]);
        long r104 = (r112 & BodyPartID.bodyIdMax) ^ (r110[3] << 32);
        long r113 = r112 >>> 32;
        r111[0] = r102 ^ (r103 << 8);
        r111[1] = ((r104 ^ (r113 << 8)) ^ (r103 >>> 56)) ^ (r103 << 33);
        long r105 = r103 >>> 31;
        r111[2] = r105 ^ ((r113 >>> 56) ^ (r113 << 33));
        r111[3] = r113 >>> 31;
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat256.createExt64();
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat256.createExt64();
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat256.createExt64();
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        return ((int) r100[0]) & 1;
    }
}
