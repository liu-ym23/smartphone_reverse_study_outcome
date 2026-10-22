package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes42.dex */
public class SecT233Field {
    private static final long M41 = 2199023255551L;
    private static final long M59 = 576460752303423487L;

    public SecT233Field() {
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
        r102[6] = r100[6] ^ r101[6];
        long r103 = r100[7];
        r102[7] = r101[7] ^ r103;
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
        return Nat.fromBigInteger64(233, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat256.createExt64();
        Nat256.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 233) goto L6;
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
        r210[0] = r100 ^ (r101 << 59);
        r210[1] = (r101 >>> 5) ^ (r102 << 54);
        r210[2] = (r102 >>> 10) ^ (r110 << 49);
        r210[3] = (r110 >>> 15) ^ (r111 << 44);
        r210[4] = (r111 >>> 20) ^ (r112 << 39);
        r210[5] = (r112 >>> 25) ^ (r113 << 34);
        r210[6] = (r113 >>> 30) ^ (r211 << 29);
        r210[7] = r211 >>> 35;
    }

    public static void implExpand(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r110[2];
        long r112 = r110[3];
        r111[0] = r100 & M59;
        r111[1] = ((r100 >>> 59) ^ (r101 << 5)) & M59;
        r111[2] = ((r101 >>> 54) ^ (r102 << 10)) & M59;
        r111[3] = (r102 >>> 49) ^ (r112 << 15);
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
        Interleave.expand64To128(r100, 0, 4, r101, 0);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat256.isZero64(r100) == true) goto L7;
        long[] r102 = Nat256.create64();
        long[] r103 = Nat256.create64();
        square(r100, r102);
        multiply(r102, r100, r102);
        square(r102, r102);
        multiply(r102, r100, r102);
        squareN(r102, 3, r103);
        multiply(r103, r102, r103);
        square(r103, r103);
        multiply(r103, r100, r103);
        squareN(r103, 7, r102);
        multiply(r102, r103, r102);
        squareN(r102, 14, r103);
        multiply(r103, r102, r103);
        square(r103, r103);
        multiply(r103, r100, r103);
        squareN(r103, 29, r102);
        multiply(r102, r103, r102);
        squareN(r102, 58, r103);
        multiply(r103, r102, r103);
        squareN(r103, 116, r102);
        multiply(r102, r103, r102);
        square(r102, r101);
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
        long r114 = r210[7];
        long r115 = r110 ^ (r114 << 23);
        long r116 = r111 ^ ((r114 >>> 41) ^ (r114 << 33));
        long r117 = r112 ^ (r114 >>> 31);
        long r103 = r102 ^ (r113 << 23);
        long r118 = r115 ^ ((r113 >>> 41) ^ (r113 << 33));
        long r119 = r116 ^ (r113 >>> 31);
        long r104 = r101 ^ (r117 << 23);
        long r105 = r103 ^ ((r117 >>> 41) ^ (r117 << 33));
        long r120 = r118 ^ (r117 >>> 31);
        long r106 = r100 ^ (r119 << 23);
        long r107 = r104 ^ ((r119 >>> 41) ^ (r119 << 33));
        long r108 = r105 ^ (r119 >>> 31);
        long r121 = r120 >>> 41;
        r211[0] = r106 ^ r121;
        r211[1] = (r121 << 10) ^ r107;
        r211[2] = r108;
        r211[3] = M41 & r120;
    }

    public static void reduce23(long[] r100, int r101) {
        int r102 = r101 + 3;
        long r103 = r100[r102];
        long r104 = r103 >>> 41;
        r100[r101] = r100[r101] ^ r104;
        int r105 = r101 + 1;
        long r106 = r104 << 10;
        r100[r105] = r106 ^ r100[r105];
        r100[r102] = r103 & M41;
    }

    public static void sqrt(long[] r210, long[] r211) {
        long r100 = Interleave.unshuffle(r210[0]);
        long r101 = Interleave.unshuffle(r210[1]);
        long r102 = (r100 & BodyPartID.bodyIdMax) | (r101 << 32);
        long r103 = (r100 >>> 32) | (r101 & (-4294967296L));
        long r104 = Interleave.unshuffle(r210[2]);
        int r110 = 3;
        long r111 = Interleave.unshuffle(r210[3]);
        long r105 = (BodyPartID.bodyIdMax & r104) | (r111 << 32);
        long r106 = (r104 >>> 32) | (r111 & (-4294967296L));
        long r112 = r106 >>> 27;
        long r107 = r106 ^ ((r103 >>> 27) | (r106 << 37));
        long r108 = r103 ^ (r103 << 37);
        long[] r113 = Nat256.createExt64();
        int[] r114 = {32, 117, 191};
        int r109 = 0;
    L3:
        if (r109 >= r110) goto L5;
        int r115 = r114[r109];
        int r116 = r115 >>> 6;
        int r117 = r115 & 63;
        r113[r116] = r113[r116] ^ (r108 << r117);
        int r118 = r116 + 1;
        int r119 = -r117;
        r113[r118] = r113[r118] ^ ((r107 << r117) | (r108 >>> r119));
        int r120 = r116 + 2;
        r113[r120] = r113[r120] ^ ((r112 << r117) | (r107 >>> r119));
        int r121 = r116 + 3;
        r113[r121] = r113[r121] ^ (r112 >>> r119);
        r109 = r109 + 1;
        r110 = 3;
        goto L3
    L5:
        reduce(r113, r211);
        r211[0] = r211[0] ^ r102;
        r211[1] = r211[1] ^ r105;
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
        return ((int) (r100[0] ^ (r100[2] >>> 31))) & 1;
    }
}
