package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes42.dex */
public class SecT131Field {
    private static final long M03 = 7;
    private static final long M44 = 17592186044415L;
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{2791191049453778211L, 2791191049453778402L, 6};
    }

    public SecT131Field() {
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
        long r103 = r100[4];
        r102[4] = r101[4] ^ r103;
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
        return Nat.fromBigInteger64(131, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(5);
        Nat192.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 131) goto L6;
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
        r210[0] = r100 ^ (r101 << 44);
        r210[1] = (r101 >>> 20) ^ (r102 << 24);
        r210[2] = ((r102 >>> 40) ^ (r110 << 4)) ^ (r111 << 48);
        r210[3] = ((r110 >>> 60) ^ (r112 << 28)) ^ (r111 >>> 16);
        r210[4] = r112 >>> 36;
        r210[5] = 0;
    }

    public static void implMultiply(long[] r310, long[] r311, long[] r312) {
        long r100 = r310[0];
        long r101 = r310[1];
        long r102 = r310[2] << 40;
        long r110 = (r102 ^ (r101 >>> 24)) & M44;
        long r103 = r101 << 20;
        long r111 = (r103 ^ (r100 >>> 44)) & M44;
        long r112 = r100 & M44;
        long r104 = r311[0];
        long r105 = r311[1];
        long r210 = ((r105 >>> 24) ^ (r311[2] << 40)) & M44;
        long r106 = r105 << 20;
        long r211 = (r106 ^ (r104 >>> 44)) & M44;
        long r212 = r104 & M44;
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
        long r107 = r113[6];
        long r108 = r113[8] ^ r107;
        long r109 = r113[7];
        long r116 = r113[9] ^ r109;
        long r117 = (r108 << 1) ^ r107;
        long r118 = (r108 ^ (r116 << 1)) ^ r109;
        long r119 = r113[0];
        long r120 = r113[1];
        long r121 = (r120 ^ r119) ^ r113[4];
        long r122 = r120 ^ r113[5];
        long r215 = r113[2];
        long r123 = ((r117 ^ r119) ^ (r215 << 4)) ^ (r215 << 1);
        long r216 = r113[3];
        long r124 = (((r121 ^ r118) ^ (r216 << 4)) ^ (r216 << 1)) ^ (r123 >>> 44);
        long r125 = r123 & M44;
        long r126 = (r122 ^ r116) ^ (r124 >>> 44);
        long r127 = r124 & M44;
        long r128 = (r125 >>> 1) ^ ((r127 & 1) << 43);
        long r129 = (r127 >>> 1) ^ ((r126 & 1) << 43);
        long r130 = r128 ^ (r128 << 1);
        long r131 = r130 ^ (r130 << 2);
        long r132 = r131 ^ (r131 << 4);
        long r133 = r132 ^ (r132 << 8);
        long r134 = r133 ^ (r133 << 16);
        long r135 = (r134 ^ (r134 << 32)) & M44;
        long r136 = r129 ^ (r135 >>> 43);
        long r137 = r136 ^ (r136 << 1);
        long r138 = r137 ^ (r137 << 2);
        long r139 = r138 ^ (r138 << 4);
        long r140 = r139 ^ (r139 << 8);
        long r141 = r140 ^ (r140 << 16);
        long r142 = (r141 ^ (r141 << 32)) & M44;
        long r143 = r142 >>> 43;
        long r144 = r143 ^ (r126 >>> 1);
        long r145 = r144 ^ (r144 << 1);
        long r146 = r145 ^ (r145 << 2);
        long r147 = r146 ^ (r146 << 4);
        long r148 = r147 ^ (r147 << 8);
        long r149 = r148 ^ (r148 << 16);
        long r150 = r149 ^ (r149 << 32);
        r312[0] = r119;
        r312[1] = (r121 ^ r135) ^ r215;
        r312[2] = (r135 ^ (r122 ^ r142)) ^ r216;
        r312[3] = r150 ^ r142;
        r312[4] = r113[2] ^ r150;
        r312[5] = r113[3];
        implCompactExt(r312);
    }

    public static void implMulw(long[] r110, long r210, long r211, long[] r212, int r213) {
        r110[1] = r211;
        long r100 = r211 << 1;
        r110[2] = r100;
        long r101 = r100 ^ r211;
        r110[3] = r101;
        long r102 = r100 << 1;
        r110[4] = r102;
        r110[5] = r102 ^ r211;
        long r103 = r101 << 1;
        r110[6] = r103;
        r110[7] = r103 ^ r211;
        int r104 = (int) r210;
        long r105 = (((r110[r104 & 7] ^ (r110[(r104 >>> 3) & 7] << 3)) ^ (r110[(r104 >>> 6) & 7] << 6)) ^ (r110[(r104 >>> 9) & 7] << 9)) ^ (r110[(r104 >>> 12) & 7] << 12);
        long r111 = 0;
        int r106 = 30;
    L3:
        int r112 = (int) (r210 >>> r106);
        long r113 = (r110[(r112 >>> 12) & 7] << 12) ^ (((r110[r112 & 7] ^ (r110[(r112 >>> 3) & 7] << 3)) ^ (r110[(r112 >>> 6) & 7] << 6)) ^ (r110[(r112 >>> 9) & 7] << 9));
        r105 = r105 ^ (r113 << r106);
        r111 = r111 ^ (r113 >>> (-r106));
        r106 = r106 - 15;
        if (r106 > 0) goto L3;
        r212[r213] = M44 & r105;
        r212[r213 + 1] = (r105 >>> 44) ^ (r111 << 20);
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 2, r101, 0);
        r101[4] = ((long) Interleave.expand8to16((int) r100[2])) & BodyPartID.bodyIdMax;
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat192.isZero64(r100) == true) goto L7;
        long[] r102 = Nat192.create64();
        long[] r103 = Nat192.create64();
        square(r100, r102);
        multiply(r102, r100, r102);
        squareN(r102, 2, r103);
        multiply(r103, r102, r103);
        squareN(r103, 4, r102);
        multiply(r102, r103, r102);
        squareN(r102, 8, r103);
        multiply(r103, r102, r103);
        squareN(r103, 16, r102);
        multiply(r102, r103, r102);
        squareN(r102, 32, r103);
        multiply(r103, r102, r103);
        square(r103, r103);
        multiply(r103, r100, r103);
        squareN(r103, 65, r102);
        multiply(r102, r103, r102);
        square(r102, r101);
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
        long r103 = r101 ^ ((r111 << 61) ^ (r111 << 63));
        long r104 = r102 ^ ((((r111 >>> 3) ^ (r111 >>> 1)) ^ r111) ^ (r111 << 5));
        long r112 = r110 ^ (r111 >>> 59);
        long r105 = r100 ^ ((r112 << 61) ^ (r112 << 63));
        long r106 = r103 ^ ((((r112 >>> 3) ^ (r112 >>> 1)) ^ r112) ^ (r112 << 5));
        long r107 = r104 ^ (r112 >>> 59);
        long r113 = r107 >>> 3;
        r211[0] = (((r105 ^ r113) ^ (r113 << 2)) ^ (r113 << 3)) ^ (r113 << 8);
        r211[1] = (r113 >>> 56) ^ r106;
        r211[2] = 7 & r107;
    }

    public static void reduce61(long[] r110, int r111) {
        int r100 = r111 + 2;
        long r101 = r110[r100];
        long r102 = r101 >>> 3;
        r110[r111] = r110[r111] ^ ((((r102 << 2) ^ r102) ^ (r102 << 3)) ^ (r102 << 8));
        int r112 = r111 + 1;
        long r103 = r102 >>> 56;
        r110[r112] = r103 ^ r110[r112];
        r110[r100] = r101 & 7;
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
        long[] r102 = Nat.create64(5);
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(5);
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat.create64(5);
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        return ((int) ((r100[0] ^ (r100[1] >>> 59)) ^ (r100[2] >>> 1))) & 1;
    }
}
