package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes42.dex */
public class SecT571Field {
    private static final long M59 = 576460752303423487L;
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};
    }

    public SecT571Field() {
    }

    private static void add(long[] r100, int r101, long[] r102, int r103, long[] r110, int r111) {
        int r104 = 0;
    L4:
        if (r104 >= 9) goto L6;
        r110[r111 + r104] = r100[r101 + r104] ^ r102[r103 + r104];
        r104 = r104 + 1;
        goto L4
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 9) goto L6;
        r102[r103] = r100[r103] ^ r101[r103];
        r103 = r103 + 1;
        goto L4
    }

    private static void addBothTo(long[] r100, int r101, long[] r110, int r111, long[] r112, int r113) {
        int r102 = 0;
    L4:
        if (r102 >= 9) goto L6;
        int r103 = r113 + r102;
        r112[r103] = r112[r103] ^ (r100[r101 + r102] ^ r110[r111 + r102]);
        r102 = r102 + 1;
        goto L4
    }

    public static void addBothTo(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 9) goto L6;
        r102[r103] = r102[r103] ^ (r100[r103] ^ r101[r103]);
        r103 = r103 + 1;
        goto L4
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 18) goto L6;
        r102[r103] = r100[r103] ^ r101[r103];
        r103 = r103 + 1;
        goto L4
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        int r102 = 1;
    L4:
        if (r102 >= 9) goto L6;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    }

    private static void addTo(long[] r100, long[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= 9) goto L6;
        r101[r102] = r101[r102] ^ r100[r102];
        r102 = r102 + 1;
        goto L4
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(571, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat576.createExt64();
        Nat576.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 571) goto L6;
        implSquare(r101, r102);
        reduce(r102, r101);
        implSquare(r101, r102);
        reduce(r102, r101);
        addTo(r100, r101);
        r103 = r103 + 2;
        goto L4
    }

    public static void implMultiply(long[] r410, long[] r411, long[] r412) {
        long[] r100 = new long[16];
        int r110 = 0;
    L4:
        if (r110 >= 9) goto L6;
        implMulwAcc(r100, r410[r110], r411[r110], r412, r110 << 1);
        r110 = r110 + 1;
        goto L4
    L6:
        long r101 = r412[0];
        long r102 = r412[1];
        long r103 = r412[2] ^ r101;
        long r111 = r103 ^ r102;
        r412[1] = r111;
        long r104 = r102 ^ r412[3];
        long r105 = r103 ^ r412[4];
        long r112 = r105 ^ r104;
        r412[2] = r112;
        long r106 = r104 ^ r412[5];
        long r107 = r105 ^ r412[6];
        long r210 = r107 ^ r106;
        r412[3] = r210;
        long r108 = r106 ^ r412[7];
        long r109 = r107 ^ r412[8];
        long r211 = r109 ^ r108;
        r412[4] = r211;
        long r113 = r108 ^ r412[9];
        long r114 = r109 ^ r412[10];
        long r212 = r114 ^ r113;
        r412[5] = r212;
        long r115 = r113 ^ r412[11];
        long r116 = r114 ^ r412[12];
        long r310 = r116 ^ r115;
        r412[6] = r310;
        long r117 = r115 ^ r412[13];
        long r118 = r116 ^ r412[14];
        long r311 = r118 ^ r117;
        r412[7] = r311;
        long r119 = r117 ^ r412[15];
        long r120 = r118 ^ r412[16];
        long r312 = r120 ^ r119;
        r412[8] = r312;
        long r121 = (r119 ^ r412[17]) ^ r120;
        r412[9] = r101 ^ r121;
        r412[10] = r111 ^ r121;
        r412[11] = r112 ^ r121;
        r412[12] = r210 ^ r121;
        r412[13] = r211 ^ r121;
        r412[14] = r212 ^ r121;
        r412[15] = r310 ^ r121;
        r412[16] = r311 ^ r121;
        r412[17] = r312 ^ r121;
        implMulwAcc(r100, r410[0] ^ r410[1], r411[0] ^ r411[1], r412, 1);
        implMulwAcc(r100, r410[0] ^ r410[2], r411[0] ^ r411[2], r412, 2);
        implMulwAcc(r100, r410[0] ^ r410[3], r411[0] ^ r411[3], r412, 3);
        implMulwAcc(r100, r410[1] ^ r410[2], r411[1] ^ r411[2], r412, 3);
        implMulwAcc(r100, r410[0] ^ r410[4], r411[0] ^ r411[4], r412, 4);
        implMulwAcc(r100, r410[1] ^ r410[3], r411[1] ^ r411[3], r412, 4);
        implMulwAcc(r100, r410[0] ^ r410[5], r411[0] ^ r411[5], r412, 5);
        implMulwAcc(r100, r410[1] ^ r410[4], r411[1] ^ r411[4], r412, 5);
        implMulwAcc(r100, r410[2] ^ r410[3], r411[2] ^ r411[3], r412, 5);
        implMulwAcc(r100, r410[0] ^ r410[6], r411[0] ^ r411[6], r412, 6);
        implMulwAcc(r100, r410[1] ^ r410[5], r411[1] ^ r411[5], r412, 6);
        implMulwAcc(r100, r410[2] ^ r410[4], r411[2] ^ r411[4], r412, 6);
        implMulwAcc(r100, r410[0] ^ r410[7], r411[0] ^ r411[7], r412, 7);
        implMulwAcc(r100, r410[1] ^ r410[6], r411[1] ^ r411[6], r412, 7);
        implMulwAcc(r100, r410[2] ^ r410[5], r411[2] ^ r411[5], r412, 7);
        implMulwAcc(r100, r410[3] ^ r410[4], r411[3] ^ r411[4], r412, 7);
        implMulwAcc(r100, r410[0] ^ r410[8], r411[0] ^ r411[8], r412, 8);
        implMulwAcc(r100, r410[1] ^ r410[7], r411[1] ^ r411[7], r412, 8);
        implMulwAcc(r100, r410[2] ^ r410[6], r411[2] ^ r411[6], r412, 8);
        implMulwAcc(r100, r410[3] ^ r410[5], r411[3] ^ r411[5], r412, 8);
        implMulwAcc(r100, r410[1] ^ r410[8], r411[1] ^ r411[8], r412, 9);
        implMulwAcc(r100, r410[2] ^ r410[7], r411[2] ^ r411[7], r412, 9);
        implMulwAcc(r100, r410[3] ^ r410[6], r411[3] ^ r411[6], r412, 9);
        implMulwAcc(r100, r410[4] ^ r410[5], r411[4] ^ r411[5], r412, 9);
        implMulwAcc(r100, r410[2] ^ r410[8], r411[2] ^ r411[8], r412, 10);
        implMulwAcc(r100, r410[3] ^ r410[7], r411[3] ^ r411[7], r412, 10);
        implMulwAcc(r100, r410[4] ^ r410[6], r411[4] ^ r411[6], r412, 10);
        implMulwAcc(r100, r410[3] ^ r410[8], r411[3] ^ r411[8], r412, 11);
        implMulwAcc(r100, r410[4] ^ r410[7], r411[4] ^ r411[7], r412, 11);
        implMulwAcc(r100, r410[5] ^ r410[6], r411[5] ^ r411[6], r412, 11);
        implMulwAcc(r100, r410[4] ^ r410[8], r411[4] ^ r411[8], r412, 12);
        implMulwAcc(r100, r410[5] ^ r410[7], r411[5] ^ r411[7], r412, 12);
        implMulwAcc(r100, r410[5] ^ r410[8], r411[5] ^ r411[8], r412, 13);
        implMulwAcc(r100, r410[6] ^ r410[7], r411[6] ^ r411[7], r412, 13);
        implMulwAcc(r100, r410[6] ^ r410[8], r411[6] ^ r411[8], r412, 14);
        implMulwAcc(r100, r410[7] ^ r410[8], r411[7] ^ r411[8], r412, 15);
    }

    public static void implMultiplyPrecomp(long[] r110, long[] r111, long[] r112) {
        int r100 = 56;
        int r101 = 56;
    L4:
        if (r101 < 0) goto L9;
        int r102 = 1;
    L6:
        if (r102 >= 9) goto L8;
        int r103 = (int) (r110[r102] >>> r101);
        addBothTo(r111, (r103 & 15) * 9, r111, (((r103 >>> 4) & 15) + 16) * 9, r112, r102 - 1);
        r102 = r102 + 2;
        goto L6
    L8:
        Nat.shiftUpBits64(16, r112, 0, 8, 0);
        r101 = r101 - 8;
    L9:
        if (r100 < 0) goto L16;
        int r104 = 0;
    L11:
        if (r104 >= 9) goto L13;
        int r105 = (int) (r110[r104] >>> r100);
        addBothTo(r111, (r105 & 15) * 9, r111, (((r105 >>> 4) & 15) + 16) * 9, r112, r104);
        r104 = r104 + 2;
        goto L11
    L13:
        if (r100 <= 0) goto L15;
        Nat.shiftUpBits64(18, r112, 0, 8, 0);
    L15:
        r100 = r100 - 8;
        goto L9
    }

    public static void implMulwAcc(long[] r110, long r111, long r112, long[] r113, int r114) {
        long r100 = r111;
        r110[1] = r112;
        int r101 = 2;
    L4:
        if (r101 >= 16) goto L6;
        long r102 = r110[r101 >>> 1] << 1;
        r110[r101] = r102;
        r110[r101 + 1] = r102 ^ r112;
        r101 = r101 + 2;
        goto L4
    L6:
        int r103 = (int) r100;
        long r104 = r110[r103 & 15] ^ (r110[(r103 >>> 4) & 15] << 4);
        long r105 = 0;
        int r106 = 56;
    L7:
        int r115 = (int) (r100 >>> r106);
        long r107 = (r110[(r115 >>> 4) & 15] << 4) ^ r110[r115 & 15];
        r104 = r104 ^ (r107 << r106);
        r105 = r105 ^ (r107 >>> (-r106));
        r106 = r106 - 8;
        if (r106 > 0) goto L7;
        int r108 = 0;
    L11:
        if (r108 >= 7) goto L13;
        r100 = (r100 & (-72340172838076674L)) >>> 1;
        r105 = r105 ^ (((r112 << r108) >> 63) & r100);
        r108 = r108 + 1;
        goto L11
    L13:
        r113[r114] = r113[r114] ^ r104;
        int r109 = r114 + 1;
        r113[r109] = r113[r109] ^ r105;
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 9, r101, 0);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat576.isZero64(r100) == true) goto L7;
        long[] r102 = Nat576.create64();
        long[] r103 = Nat576.create64();
        long[] r104 = Nat576.create64();
        square(r100, r104);
        square(r104, r102);
        square(r102, r103);
        multiply(r102, r103, r102);
        squareN(r102, 2, r103);
        multiply(r102, r103, r102);
        multiply(r102, r104, r102);
        squareN(r102, 5, r103);
        multiply(r102, r103, r102);
        squareN(r103, 5, r103);
        multiply(r102, r103, r102);
        squareN(r102, 15, r103);
        multiply(r102, r103, r104);
        squareN(r104, 30, r102);
        squareN(r102, 30, r103);
        multiply(r102, r103, r102);
        squareN(r102, 60, r103);
        multiply(r102, r103, r102);
        squareN(r103, 60, r103);
        multiply(r102, r103, r102);
        squareN(r102, 180, r103);
        multiply(r102, r103, r102);
        squareN(r103, 180, r103);
        multiply(r102, r103, r102);
        multiply(r102, r104, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat576.createExt64();
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat576.createExt64();
        implMultiply(r100, r101, r103);
        addExt(r102, r103, r102);
    }

    public static void multiplyPrecomp(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat576.createExt64();
        implMultiplyPrecomp(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyPrecompAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat576.createExt64();
        implMultiplyPrecomp(r100, r101, r103);
        addExt(r102, r103, r102);
    }

    public static long[] precompMultiplicand(long[] r100) {
        long[] r101 = new long[288];
        int r102 = 0;
        System.arraycopy(r100, 0, r101, 9, 9);
        int r103 = 7;
    L3:
        if (r103 <= 0) goto L5;
        int r104 = r102 + 18;
        Nat.shiftUpBit64(9, r101, r104 >>> 1, 0, r101, r104);
        reduce5(r101, r104);
        add(r101, 9, r101, r104, r101, r104 + 9);
        r103 = r103 - 1;
        r102 = r104;
        goto L3
    L5:
        Nat.shiftUpBits64(144, r101, 0, 4, 0, r101, 144);
        return r101;
    }

    public static void reduce(long[] r110, long[] r210) {
        long r100 = r110[9];
        long r101 = r110[17];
        long r102 = (((r100 ^ (r101 >>> 59)) ^ (r101 >>> 57)) ^ (r101 >>> 54)) ^ (r101 >>> 49);
        long r103 = (r101 << 15) ^ (((r110[8] ^ (r101 << 5)) ^ (r101 << 7)) ^ (r101 << 10));
        int r104 = 16;
    L3:
        if (r104 < 10) goto L5;
        long r111 = r110[r104];
        r210[r104 - 8] = (((r103 ^ (r111 >>> 59)) ^ (r111 >>> 57)) ^ (r111 >>> 54)) ^ (r111 >>> 49);
        r103 = (((r110[r104 - 9] ^ (r111 << 5)) ^ (r111 << 7)) ^ (r111 << 10)) ^ (r111 << 15);
        r104 = r104 - 1;
        goto L3
    L5:
        r210[1] = (((r103 ^ (r102 >>> 59)) ^ (r102 >>> 57)) ^ (r102 >>> 54)) ^ (r102 >>> 49);
        long r105 = (r102 << 15) ^ (((r110[0] ^ (r102 << 5)) ^ (r102 << 7)) ^ (r102 << 10));
        long r106 = r210[8];
        long r107 = r106 >>> 59;
        r210[0] = (((r105 ^ r107) ^ (r107 << 2)) ^ (r107 << 5)) ^ (r107 << 10);
        r210[8] = M59 & r106;
    }

    public static void reduce5(long[] r110, int r111) {
        int r100 = r111 + 8;
        long r101 = r110[r100];
        long r102 = r101 >>> 59;
        long r103 = ((r102 << 2) ^ r102) ^ (r102 << 5);
        long r104 = (r102 << 10) ^ r103;
        r110[r111] = r104 ^ r110[r111];
        r110[r100] = r101 & M59;
    }

    public static void sqrt(long[] r110, long[] r111) {
        long[] r100 = Nat576.create64();
        long[] r101 = Nat576.create64();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 4) goto L6;
        int r104 = r103 + 1;
        long r105 = Interleave.unshuffle(r110[r103]);
        r103 = r104 + 1;
        long r112 = Interleave.unshuffle(r110[r104]);
        r100[r102] = (BodyPartID.bodyIdMax & r105) | (r112 << 32);
        r101[r102] = (r105 >>> 32) | ((-4294967296L) & r112);
        r102 = r102 + 1;
        goto L4
    L6:
        long r106 = Interleave.unshuffle(r110[r103]);
        r100[4] = BodyPartID.bodyIdMax & r106;
        r101[4] = r106 >>> 32;
        multiply(r101, ROOT_Z, r111);
        add(r111, r100, r111);
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat576.createExt64();
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat576.createExt64();
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat576.createExt64();
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        long r101 = r100[0];
        long r102 = r100[8];
        return ((int) ((r101 ^ (r102 >>> 49)) ^ (r102 >>> 57))) & 1;
    }
}
