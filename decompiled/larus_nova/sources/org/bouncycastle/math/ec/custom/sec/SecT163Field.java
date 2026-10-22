package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes42.dex */
public class SecT163Field {
    private static final long M35 = 34359738367L;
    private static final long M55 = 36028797018963967L;
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{-5270498306774157648L, 5270498306774195053L, 19634136210L};
    }

    public SecT163Field() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        long r103 = r100[2];
        r102[2] = r101[2] ^ r103;
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
        r102[4] = r100[4] ^ r101[4];
        long r103 = r100[5];
        r102[5] = r101[5] ^ r103;
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        r101[1] = r100[1];
        r101[2] = r100[2];
    }

    private static void addTo(long[] r100, long[] r101) {
        r101[0] = r101[0] ^ r100[0];
        r101[1] = r101[1] ^ r100[1];
        r101[2] = r101[2] ^ r100[2];
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(163, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat192.createExt64();
        Nat192.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 163) goto L6;
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
        r210[0] = r100 ^ (r101 << 55);
        r210[1] = (r101 >>> 9) ^ (r102 << 46);
        r210[2] = (r102 >>> 18) ^ (r110 << 37);
        r210[3] = (r110 >>> 27) ^ (r111 << 28);
        r210[4] = (r111 >>> 36) ^ (r112 << 19);
        r210[5] = r112 >>> 45;
    }

    public static void implMultiply(long[] r310, long[] r311, long[] r312) {
        long r100 = r310[0];
        long r101 = r310[1];
        long r110 = (r101 >>> 46) ^ (r310[2] << 18);
        long r102 = r101 << 9;
        long r111 = (r102 ^ (r100 >>> 55)) & M55;
        long r112 = r100 & M55;
        long r103 = r311[0];
        long r104 = r311[1];
        long r210 = (r104 >>> 46) ^ (r311[2] << 18);
        long r105 = r104 << 9;
        long r211 = (r105 ^ (r103 >>> 55)) & M55;
        long r212 = r103 & M55;
        long[] r113 = new long[10];
        implMulw(r312, r112, r212, r113, 0);
        implMulw(r312, r110, r210, r113, 2);
        long r213 = (r112 ^ r111) ^ r110;
        long r214 = (r212 ^ r211) ^ r210;
        implMulw(r312, r213, r214, r113, 4);
        long r114 = (r111 << 1) ^ (r110 << 2);
        long r115 = (r211 << 1) ^ (r210 << 2);
        implMulw(r312, r112 ^ r114, r212 ^ r115, r113, 6);
        implMulw(r312, r213 ^ r114, r214 ^ r115, r113, 8);
        long r106 = r113[6];
        long r107 = r113[8] ^ r106;
        long r108 = r113[7];
        long r116 = r113[9] ^ r108;
        long r109 = (r107 << 1) ^ r106;
        long r117 = (r107 ^ (r116 << 1)) ^ r108;
        long r118 = r113[0];
        long r119 = r113[1];
        long r120 = (r119 ^ r118) ^ r113[4];
        long r121 = r119 ^ r113[5];
        long r215 = r113[2];
        long r122 = ((r109 ^ r118) ^ (r215 << 4)) ^ (r215 << 1);
        long r216 = r113[3];
        long r123 = (((r120 ^ r117) ^ (r216 << 4)) ^ (r216 << 1)) ^ (r122 >>> 55);
        long r124 = r122 & M55;
        long r125 = (r121 ^ r116) ^ (r123 >>> 55);
        long r126 = r123 & M55;
        long r127 = (r124 >>> 1) ^ ((r126 & 1) << 54);
        long r128 = (r126 >>> 1) ^ ((r125 & 1) << 54);
        long r129 = r127 ^ (r127 << 1);
        long r130 = r129 ^ (r129 << 2);
        long r131 = r130 ^ (r130 << 4);
        long r132 = r131 ^ (r131 << 8);
        long r133 = r132 ^ (r132 << 16);
        long r134 = (r133 ^ (r133 << 32)) & M55;
        long r135 = r128 ^ (r134 >>> 54);
        long r136 = r135 ^ (r135 << 1);
        long r137 = r136 ^ (r136 << 2);
        long r138 = r137 ^ (r137 << 4);
        long r139 = r138 ^ (r138 << 8);
        long r140 = r139 ^ (r139 << 16);
        long r141 = (r140 ^ (r140 << 32)) & M55;
        long r142 = (r125 >>> 1) ^ (r141 >>> 54);
        long r143 = r142 ^ (r142 << 1);
        long r144 = r143 ^ (r143 << 2);
        long r145 = r144 ^ (r144 << 4);
        long r146 = r145 ^ (r145 << 8);
        long r147 = r146 ^ (r146 << 16);
        long r148 = r147 ^ (r147 << 32);
        r312[0] = r118;
        r312[1] = (r120 ^ r134) ^ r215;
        r312[2] = (r134 ^ (r121 ^ r141)) ^ r216;
        r312[3] = r148 ^ r141;
        r312[4] = r113[2] ^ r148;
        r312[5] = r113[3];
        implCompactExt(r312);
    }

    public static void implMulw(long[] r110, long r111, long r210, long[] r211, int r212) {
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
        long r104 = r110[((int) r111) & 3];
        long r105 = 0;
        int r112 = 47;
    L3:
        int r113 = (int) (r111 >>> r112);
        long r114 = (r110[(r113 >>> 6) & 7] << 6) ^ (r110[r113 & 7] ^ (r110[(r113 >>> 3) & 7] << 3));
        r104 = r104 ^ (r114 << r112);
        r105 = r105 ^ (r114 >>> (-r112));
        r112 = r112 - 9;
        if (r112 > 0) goto L3;
        r211[r212] = M55 & r104;
        r211[r212 + 1] = (r104 >>> 55) ^ (r105 << 9);
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 3, r101, 0);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat192.isZero64(r100) == true) goto L7;
        long[] r102 = Nat192.create64();
        long[] r103 = Nat192.create64();
        square(r100, r102);
        squareN(r102, 1, r103);
        multiply(r102, r103, r102);
        squareN(r103, 1, r103);
        multiply(r102, r103, r102);
        squareN(r102, 3, r103);
        multiply(r102, r103, r102);
        squareN(r103, 3, r103);
        multiply(r102, r103, r102);
        squareN(r102, 9, r103);
        multiply(r102, r103, r102);
        squareN(r103, 9, r103);
        multiply(r102, r103, r102);
        squareN(r102, 27, r103);
        multiply(r102, r103, r102);
        squareN(r103, 27, r103);
        multiply(r102, r103, r102);
        squareN(r102, 81, r103);
        multiply(r102, r103, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = new long[8];
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = new long[8];
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
        long r103 = r102 ^ ((((r112 << 29) ^ (r112 << 32)) ^ (r112 << 35)) ^ (r112 << 36));
        long r113 = r110 ^ ((((r112 >>> 35) ^ (r112 >>> 32)) ^ (r112 >>> 29)) ^ (r112 >>> 28));
        long r104 = r101 ^ ((((r111 << 29) ^ (r111 << 32)) ^ (r111 << 35)) ^ (r111 << 36));
        long r114 = ((r111 >>> 35) ^ (r111 >>> 32)) ^ (r111 >>> 29);
        long r105 = r103 ^ ((r111 >>> 28) ^ r114);
        long r106 = r100 ^ ((((r113 << 29) ^ (r113 << 32)) ^ (r113 << 35)) ^ (r113 << 36));
        long r115 = ((r113 >>> 35) ^ (r113 >>> 32)) ^ (r113 >>> 29);
        long r107 = r104 ^ ((r113 >>> 28) ^ r115);
        long r116 = r105 >>> 35;
        r211[0] = (((r106 ^ r116) ^ (r116 << 3)) ^ (r116 << 6)) ^ (r116 << 7);
        r211[1] = r107;
        r211[2] = M35 & r105;
    }

    public static void reduce29(long[] r110, int r111) {
        int r100 = r111 + 2;
        long r101 = r110[r100];
        long r102 = r101 >>> 35;
        long r103 = ((r102 << 3) ^ r102) ^ (r102 << 6);
        long r104 = (r102 << 7) ^ r103;
        r110[r111] = r104 ^ r110[r111];
        r110[r100] = r101 & M35;
    }

    public static void sqrt(long[] r110, long[] r111) {
        long[] r100 = Nat192.create64();
        long r101 = Interleave.unshuffle(r110[0]);
        long r102 = Interleave.unshuffle(r110[1]);
        long r103 = (r101 & BodyPartID.bodyIdMax) | (r102 << 32);
        r100[0] = (r101 >>> 32) | (r102 & (-4294967296L));
        long r104 = Interleave.unshuffle(r110[2]);
        long r105 = r104 & BodyPartID.bodyIdMax;
        r100[1] = r104 >>> 32;
        multiply(r100, ROOT_Z, r111);
        r111[0] = r111[0] ^ r103;
        r111[1] = r111[1] ^ r105;
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat192.createExt64();
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat192.createExt64();
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat192.createExt64();
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        return ((int) (r100[0] ^ (r100[2] >>> 29))) & 1;
    }
}
