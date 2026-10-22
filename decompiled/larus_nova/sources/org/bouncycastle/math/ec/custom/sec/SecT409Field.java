package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;

/* JADX INFO: loaded from: classes42.dex */
public class SecT409Field {
    private static final long M25 = 33554431;
    private static final long M59 = 576460752303423487L;

    public SecT409Field() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
        r102[4] = r100[4] ^ r101[4];
        r102[5] = r100[5] ^ r101[5];
        long r103 = r100[6];
        r102[6] = r101[6] ^ r103;
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 13) goto L6;
        r102[r103] = r100[r103] ^ r101[r103];
        r103 = r103 + 1;
        goto L4
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
        r101[4] = r100[4];
        r101[5] = r100[5];
        r101[6] = r100[6];
    }

    private static void addTo(long[] r100, long[] r101) {
        r101[0] = r101[0] ^ r100[0];
        r101[1] = r101[1] ^ r100[1];
        r101[2] = r101[2] ^ r100[2];
        r101[3] = r101[3] ^ r100[3];
        r101[4] = r101[4] ^ r100[4];
        r101[5] = r101[5] ^ r100[5];
        r101[6] = r101[6] ^ r100[6];
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(409, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(13);
        Nat448.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 409) goto L6;
        implSquare(r101, r102);
        reduce(r102, r101);
        implSquare(r101, r102);
        reduce(r102, r101);
        addTo(r100, r101);
        r103 = r103 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r410) {
        long r100 = r410[0];
        long r101 = r410[1];
        long r102 = r410[2];
        long r110 = r410[3];
        long r111 = r410[4];
        long r112 = r410[5];
        long r113 = r410[6];
        long r210 = r410[7];
        long r211 = r410[8];
        long r212 = r410[9];
        long r310 = r410[10];
        long r311 = r410[11];
        long r312 = r410[12];
        long r313 = r410[13];
        r410[0] = r100 ^ (r101 << 59);
        r410[1] = (r101 >>> 5) ^ (r102 << 54);
        r410[2] = (r102 >>> 10) ^ (r110 << 49);
        r410[3] = (r110 >>> 15) ^ (r111 << 44);
        r410[4] = (r111 >>> 20) ^ (r112 << 39);
        r410[5] = (r112 >>> 25) ^ (r113 << 34);
        r410[6] = (r113 >>> 30) ^ (r210 << 29);
        r410[7] = (r210 >>> 35) ^ (r211 << 24);
        r410[8] = (r211 >>> 40) ^ (r212 << 19);
        r410[9] = (r212 >>> 45) ^ (r310 << 14);
        r410[10] = (r310 >>> 50) ^ (r311 << 9);
        r410[11] = ((r311 >>> 55) ^ (r312 << 4)) ^ (r313 << 63);
        r410[12] = r313 >>> 1;
    }

    public static void implExpand(long[] r210, long[] r211) {
        long r100 = r210[0];
        long r101 = r210[1];
        long r102 = r210[2];
        long r110 = r210[3];
        long r111 = r210[4];
        long r112 = r210[5];
        long r113 = r210[6];
        r211[0] = r100 & M59;
        r211[1] = ((r100 >>> 59) ^ (r101 << 5)) & M59;
        r211[2] = ((r101 >>> 54) ^ (r102 << 10)) & M59;
        r211[3] = ((r102 >>> 49) ^ (r110 << 15)) & M59;
        r211[4] = ((r110 >>> 44) ^ (r111 << 20)) & M59;
        r211[5] = ((r111 >>> 39) ^ (r112 << 25)) & M59;
        r211[6] = (r112 >>> 34) ^ (r113 << 30);
    }

    public static void implMultiply(long[] r310, long[] r311, long[] r312) {
        long[] r100 = new long[7];
        long[] r101 = new long[7];
        implExpand(r310, r100);
        implExpand(r311, r101);
        long[] r110 = new long[8];
        int r111 = 0;
    L3:
        if (r111 >= 7) goto L5;
        implMulwAcc(r110, r100[r111], r101[r111], r312, r111 << 1);
        r111 = r111 + 1;
        goto L3
    L5:
        long r102 = r312[0];
        long r103 = r312[1];
        long r104 = r312[2] ^ r102;
        long r112 = r104 ^ r103;
        r312[1] = r112;
        long r105 = r103 ^ r312[3];
        long r106 = r104 ^ r312[4];
        long r113 = r106 ^ r105;
        r312[2] = r113;
        long r107 = r105 ^ r312[5];
        long r108 = r106 ^ r312[6];
        long r210 = r108 ^ r107;
        r312[3] = r210;
        long r109 = r107 ^ r312[7];
        long r114 = r108 ^ r312[8];
        long r211 = r114 ^ r109;
        r312[4] = r211;
        long r115 = r109 ^ r312[9];
        long r116 = r114 ^ r312[10];
        long r212 = r116 ^ r115;
        r312[5] = r212;
        long r117 = r115 ^ r312[11];
        long r118 = r116 ^ r312[12];
        long r313 = r118 ^ r117;
        r312[6] = r313;
        long r119 = (r117 ^ r312[13]) ^ r118;
        r312[7] = r102 ^ r119;
        r312[8] = r112 ^ r119;
        r312[9] = r113 ^ r119;
        r312[10] = r210 ^ r119;
        r312[11] = r211 ^ r119;
        r312[12] = r212 ^ r119;
        r312[13] = r313 ^ r119;
        implMulwAcc(r110, r100[0] ^ r100[1], r101[0] ^ r101[1], r312, 1);
        implMulwAcc(r110, r100[0] ^ r100[2], r101[0] ^ r101[2], r312, 2);
        implMulwAcc(r110, r100[0] ^ r100[3], r101[0] ^ r101[3], r312, 3);
        implMulwAcc(r110, r100[1] ^ r100[2], r101[1] ^ r101[2], r312, 3);
        implMulwAcc(r110, r100[0] ^ r100[4], r101[0] ^ r101[4], r312, 4);
        implMulwAcc(r110, r100[1] ^ r100[3], r101[1] ^ r101[3], r312, 4);
        implMulwAcc(r110, r100[0] ^ r100[5], r101[0] ^ r101[5], r312, 5);
        implMulwAcc(r110, r100[1] ^ r100[4], r101[1] ^ r101[4], r312, 5);
        implMulwAcc(r110, r100[2] ^ r100[3], r101[2] ^ r101[3], r312, 5);
        implMulwAcc(r110, r100[0] ^ r100[6], r101[0] ^ r101[6], r312, 6);
        implMulwAcc(r110, r100[1] ^ r100[5], r101[1] ^ r101[5], r312, 6);
        implMulwAcc(r110, r100[2] ^ r100[4], r101[2] ^ r101[4], r312, 6);
        implMulwAcc(r110, r100[1] ^ r100[6], r101[1] ^ r101[6], r312, 7);
        implMulwAcc(r110, r100[2] ^ r100[5], r101[2] ^ r101[5], r312, 7);
        implMulwAcc(r110, r100[3] ^ r100[4], r101[3] ^ r101[4], r312, 7);
        implMulwAcc(r110, r100[2] ^ r100[6], r101[2] ^ r101[6], r312, 8);
        implMulwAcc(r110, r100[3] ^ r100[5], r101[3] ^ r101[5], r312, 8);
        implMulwAcc(r110, r100[3] ^ r100[6], r101[3] ^ r101[6], r312, 9);
        implMulwAcc(r110, r100[4] ^ r100[5], r101[4] ^ r101[5], r312, 9);
        implMulwAcc(r110, r100[4] ^ r100[6], r101[4] ^ r101[6], r312, 10);
        implMulwAcc(r110, r100[5] ^ r100[6], r101[5] ^ r101[6], r312, 11);
        implCompactExt(r312);
    }

    public static void implMulwAcc(long[] r110, long r111, long r112, long[] r210, int r211) {
        r110[1] = r112;
        long r100 = r112 << 1;
        r110[2] = r100;
        long r101 = r100 ^ r112;
        r110[3] = r101;
        long r102 = r100 << 1;
        r110[4] = r102;
        r110[5] = r102 ^ r112;
        long r103 = r101 << 1;
        r110[6] = r103;
        r110[7] = r103 ^ r112;
        int r104 = (int) r111;
        long r105 = (r110[(r104 >>> 3) & 7] << 3) ^ r110[r104 & 7];
        long r106 = 0;
        int r107 = 54;
    L3:
        int r113 = (int) (r111 >>> r107);
        long r114 = (r110[(r113 >>> 3) & 7] << 3) ^ r110[r113 & 7];
        r105 = r105 ^ (r114 << r107);
        r106 = r106 ^ (r114 >>> (-r107));
        r107 = r107 - 6;
        if (r107 > 0) goto L3;
        r210[r211] = r210[r211] ^ (M59 & r105);
        int r108 = r211 + 1;
        r210[r108] = r210[r108] ^ ((r105 >>> 59) ^ (r106 << 5));
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 6, r101, 0);
        r101[12] = Interleave.expand32to64((int) r100[6]);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat448.isZero64(r100) == true) goto L7;
        long[] r102 = Nat448.create64();
        long[] r103 = Nat448.create64();
        long[] r104 = Nat448.create64();
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
        multiply(r102, r103, r104);
        squareN(r104, 24, r102);
        squareN(r102, 24, r103);
        multiply(r102, r103, r102);
        squareN(r102, 48, r103);
        multiply(r102, r103, r102);
        squareN(r102, 96, r103);
        multiply(r102, r103, r102);
        squareN(r102, 192, r103);
        multiply(r102, r103, r102);
        multiply(r102, r104, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat448.createExt64();
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat448.createExt64();
        implMultiply(r100, r101, r103);
        addExt(r102, r103, r102);
    }

    public static void reduce(long[] r310, long[] r311) {
        long r100 = r310[0];
        long r101 = r310[1];
        long r102 = r310[2];
        long r110 = r310[3];
        long r111 = r310[4];
        long r112 = r310[5];
        long r113 = r310[6];
        long r210 = r310[7];
        long r211 = r310[12];
        long r114 = r112 ^ (r211 << 39);
        long r115 = r113 ^ ((r211 >>> 25) ^ (r211 << 62));
        long r212 = r210 ^ (r211 >>> 2);
        long r213 = r310[11];
        long r116 = r111 ^ (r213 << 39);
        long r117 = r114 ^ ((r213 >>> 25) ^ (r213 << 62));
        long r118 = r115 ^ (r213 >>> 2);
        long r214 = r310[10];
        long r119 = r110 ^ (r214 << 39);
        long r120 = r116 ^ ((r214 >>> 25) ^ (r214 << 62));
        long r121 = r117 ^ (r214 >>> 2);
        long r215 = r310[9];
        long r103 = r102 ^ (r215 << 39);
        long r122 = r119 ^ ((r215 >>> 25) ^ (r215 << 62));
        long r123 = r120 ^ (r215 >>> 2);
        long r216 = r310[8];
        long r104 = r101 ^ (r216 << 39);
        long r105 = r103 ^ ((r216 >>> 25) ^ (r216 << 62));
        long r124 = r122 ^ (r216 >>> 2);
        long r106 = r100 ^ (r212 << 39);
        long r107 = r104 ^ ((r212 >>> 25) ^ (r212 << 62));
        long r108 = r105 ^ (r212 >>> 2);
        long r217 = r118 >>> 25;
        r311[0] = r106 ^ r217;
        r311[1] = (r217 << 23) ^ r107;
        r311[2] = r108;
        r311[3] = r124;
        r311[4] = r123;
        r311[5] = r121;
        r311[6] = r118 & M25;
    }

    public static void reduce39(long[] r100, int r101) {
        int r102 = r101 + 6;
        long r103 = r100[r102];
        long r104 = r103 >>> 25;
        r100[r101] = r100[r101] ^ r104;
        int r105 = r101 + 1;
        long r106 = r104 << 23;
        r100[r105] = r106 ^ r100[r105];
        r100[r102] = r103 & M25;
    }

    public static void sqrt(long[] r210, long[] r211) {
        long r100 = Interleave.unshuffle(r210[0]);
        long r101 = Interleave.unshuffle(r210[1]);
        long r102 = (r100 & BodyPartID.bodyIdMax) | (r101 << 32);
        long r103 = (r100 >>> 32) | (r101 & (-4294967296L));
        long r110 = Interleave.unshuffle(r210[2]);
        long r111 = Interleave.unshuffle(r210[3]);
        long r112 = (r110 & BodyPartID.bodyIdMax) | (r111 << 32);
        long r113 = (r110 >>> 32) | (r111 & (-4294967296L));
        long r114 = Interleave.unshuffle(r210[4]);
        long r212 = Interleave.unshuffle(r210[5]);
        long r213 = (r114 & BodyPartID.bodyIdMax) | (r212 << 32);
        long r115 = (r114 >>> 32) | (r212 & (-4294967296L));
        long r214 = Interleave.unshuffle(r210[6]);
        long r104 = r214 & BodyPartID.bodyIdMax;
        long r215 = r214 >>> 32;
        r211[0] = r102 ^ (r103 << 44);
        r211[1] = (r112 ^ (r113 << 44)) ^ (r103 >>> 20);
        r211[2] = (r213 ^ (r115 << 44)) ^ (r113 >>> 20);
        r211[3] = (((r215 << 44) ^ r104) ^ (r115 >>> 20)) ^ (r103 << 13);
        long r105 = r103 >>> 51;
        r211[4] = r105 ^ ((r215 >>> 20) ^ (r113 << 13));
        r211[5] = (r115 << 13) ^ (r113 >>> 51);
        r211[6] = (r215 << 13) ^ (r115 >>> 51);
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(13);
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(13);
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat.create64(13);
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
