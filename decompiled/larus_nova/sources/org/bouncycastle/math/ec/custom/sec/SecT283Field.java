package org.bouncycastle.math.ec.custom.sec;

import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;

/* JADX INFO: loaded from: classes42.dex */
public class SecT283Field {
    private static final long M27 = 134217727;
    private static final long M57 = 144115188075855871L;
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};
    }

    public SecT283Field() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
        long r103 = r100[4];
        r102[4] = r101[4] ^ r103;
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
        r102[4] = r100[4] ^ r101[4];
        r102[5] = r100[5] ^ r101[5];
        r102[6] = r100[6] ^ r101[6];
        r102[7] = r100[7] ^ r101[7];
        long r103 = r100[8];
        r102[8] = r101[8] ^ r103;
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
        r101[4] = r100[4];
    }

    private static void addTo(long[] r100, long[] r101) {
        r101[0] = r101[0] ^ r100[0];
        r101[1] = r101[1] ^ r100[1];
        r101[2] = r101[2] ^ r100[2];
        r101[3] = r101[3] ^ r100[3];
        r101[4] = r101[4] ^ r100[4];
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(9);
        Nat320.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 283) goto L6;
        implSquare(r101, r102);
        reduce(r102, r101);
        implSquare(r101, r102);
        reduce(r102, r101);
        addTo(r100, r101);
        r103 = r103 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r310) {
        long r100 = r310[0];
        long r101 = r310[1];
        long r102 = r310[2];
        long r110 = r310[3];
        long r111 = r310[4];
        long r112 = r310[5];
        long r113 = r310[6];
        long r210 = r310[7];
        long r211 = r310[8];
        long r212 = r310[9];
        r310[0] = r100 ^ (r101 << 57);
        r310[1] = (r101 >>> 7) ^ (r102 << 50);
        r310[2] = (r102 >>> 14) ^ (r110 << 43);
        r310[3] = (r110 >>> 21) ^ (r111 << 36);
        r310[4] = (r111 >>> 28) ^ (r112 << 29);
        r310[5] = (r112 >>> 35) ^ (r113 << 22);
        r310[6] = (r113 >>> 42) ^ (r210 << 15);
        r310[7] = (r210 >>> 49) ^ (r211 << 8);
        r310[8] = (r211 >>> 56) ^ (r212 << 1);
        r310[9] = r212 >>> 63;
    }

    public static void implExpand(long[] r110, long[] r210) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r110[2];
        long r111 = r110[3];
        long r112 = r110[4];
        r210[0] = r100 & M57;
        r210[1] = ((r100 >>> 57) ^ (r101 << 7)) & M57;
        r210[2] = ((r101 >>> 50) ^ (r102 << 14)) & M57;
        r210[3] = ((r102 >>> 43) ^ (r111 << 21)) & M57;
        r210[4] = (r111 >>> 36) ^ (r112 << 28);
    }

    public static void implMultiply(long[] r310, long[] r311, long[] r312) {
        long[] r100 = new long[5];
        long[] r101 = new long[5];
        implExpand(r310, r100);
        implExpand(r311, r101);
        long[] r110 = new long[26];
        implMulw(r312, r100[0], r101[0], r110, 0);
        implMulw(r312, r100[1], r101[1], r110, 2);
        implMulw(r312, r100[2], r101[2], r110, 4);
        implMulw(r312, r100[3], r101[3], r110, 6);
        implMulw(r312, r100[4], r101[4], r110, 8);
        long r102 = r100[0];
        long r111 = r102 ^ r100[1];
        long r103 = r101[0];
        long r112 = r103 ^ r101[1];
        long r104 = r100[2];
        long r210 = r102 ^ r104;
        long r105 = r101[2];
        long r211 = r103 ^ r105;
        long r106 = r100[4];
        long r212 = r104 ^ r106;
        long r107 = r101[4];
        long r213 = r105 ^ r107;
        long r108 = r100[3];
        long r214 = r108 ^ r106;
        long r109 = r101[3];
        long r313 = r109 ^ r107;
        implMulw(r312, r210 ^ r108, r211 ^ r109, r110, 18);
        implMulw(r312, r212 ^ r100[1], r213 ^ r101[1], r110, 20);
        long r113 = r111 ^ r214;
        long r114 = r112 ^ r313;
        long r314 = r113 ^ r100[2];
        long r115 = r114 ^ r101[2];
        implMulw(r312, r113, r114, r110, 22);
        implMulw(r312, r314, r115, r110, 24);
        implMulw(r312, r111, r112, r110, 10);
        implMulw(r312, r210, r211, r110, 12);
        implMulw(r312, r212, r213, r110, 14);
        implMulw(r312, r214, r313, r110, 16);
        r312[0] = r110[0];
        r312[9] = r110[9];
        long r116 = r110[0];
        long r117 = r110[1] ^ r116;
        long r118 = r110[2] ^ r117;
        long r119 = r110[10] ^ r118;
        r312[1] = r119;
        long r120 = r110[3] ^ r110[4];
        long r121 = r118 ^ (r120 ^ (r110[11] ^ r110[12]));
        r312[2] = r121;
        long r122 = r117 ^ r120;
        long r123 = r110[5] ^ r110[6];
        long r124 = r110[8];
        long r125 = (r122 ^ r123) ^ r124;
        long r126 = r110[13] ^ r110[14];
        long r215 = r110[18];
        long r216 = r110[22];
        long r217 = r110[24];
        r312[3] = (r125 ^ r126) ^ ((r215 ^ r216) ^ r217);
        long r127 = r110[7] ^ r124;
        long r218 = r110[9];
        long r128 = r127 ^ r218;
        long r219 = r128 ^ r110[17];
        r312[8] = r219;
        long r129 = (r128 ^ r123) ^ (r110[15] ^ r110[16]);
        r312[7] = r129;
        long r130 = r119 ^ r129;
        long r131 = r110[19] ^ r110[20];
        long r132 = r110[25];
        long r315 = r110[23];
        long r133 = r131 ^ (r132 ^ r217);
        r312[4] = (r133 ^ (r215 ^ r315)) ^ r130;
        long r134 = r110[21];
        r312[5] = ((r121 ^ r219) ^ r133) ^ (r134 ^ r216);
        r312[6] = (((((r125 ^ r116) ^ r218) ^ r126) ^ r134) ^ r315) ^ r132;
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
        long r104 = r110[((int) r111) & 7];
        long r105 = 0;
        int r112 = 48;
    L3:
        int r113 = (int) (r111 >>> r112);
        long r114 = (r110[(r113 >>> 6) & 7] << 6) ^ (r110[r113 & 7] ^ (r110[(r113 >>> 3) & 7] << 3));
        r104 = r104 ^ (r114 << r112);
        r105 = r105 ^ (r114 >>> (-r112));
        r112 = r112 - 9;
        if (r112 > 0) goto L3;
        r211[r212] = M57 & r104;
        r211[r212 + 1] = (((((r111 & 72198606942111744L) & ((r210 << 7) >> 63)) >>> 8) ^ r105) << 7) ^ (r104 >>> 57);
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 4, r101, 0);
        r101[8] = Interleave.expand32to64((int) r100[4]);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat320.isZero64(r100) == true) goto L7;
        long[] r102 = Nat320.create64();
        long[] r103 = Nat320.create64();
        square(r100, r102);
        multiply(r102, r100, r102);
        squareN(r102, 2, r103);
        multiply(r103, r102, r103);
        squareN(r103, 4, r102);
        multiply(r102, r103, r102);
        squareN(r102, 8, r103);
        multiply(r103, r102, r103);
        square(r103, r103);
        multiply(r103, r100, r103);
        squareN(r103, 17, r102);
        multiply(r102, r103, r102);
        square(r102, r102);
        multiply(r102, r100, r102);
        squareN(r102, 35, r103);
        multiply(r103, r102, r103);
        squareN(r103, 70, r102);
        multiply(r102, r103, r102);
        square(r102, r102);
        multiply(r102, r100, r102);
        squareN(r102, 141, r103);
        multiply(r103, r102, r103);
        square(r103, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat320.createExt64();
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = Nat320.createExt64();
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
        long r211 = r310[8];
        long r114 = r110 ^ ((((r211 << 37) ^ (r211 << 42)) ^ (r211 << 44)) ^ (r211 << 49));
        long r115 = r111 ^ ((((r211 >>> 27) ^ (r211 >>> 22)) ^ (r211 >>> 20)) ^ (r211 >>> 15));
        long r103 = r102 ^ ((((r210 << 37) ^ (r210 << 42)) ^ (r210 << 44)) ^ (r210 << 49));
        long r116 = r114 ^ ((((r210 >>> 27) ^ (r210 >>> 22)) ^ (r210 >>> 20)) ^ (r210 >>> 15));
        long r104 = r101 ^ ((((r113 << 37) ^ (r113 << 42)) ^ (r113 << 44)) ^ (r113 << 49));
        long r105 = r103 ^ ((((r113 >>> 27) ^ (r113 >>> 22)) ^ (r113 >>> 20)) ^ (r113 >>> 15));
        long r106 = r100 ^ ((((r112 << 37) ^ (r112 << 42)) ^ (r112 << 44)) ^ (r112 << 49));
        long r107 = r104 ^ ((((r112 >>> 27) ^ (r112 >>> 22)) ^ (r112 >>> 20)) ^ (r112 >>> 15));
        long r117 = r115 >>> 27;
        r311[0] = (((r106 ^ r117) ^ (r117 << 5)) ^ (r117 << 7)) ^ (r117 << 12);
        r311[1] = r107;
        r311[2] = r105;
        r311[3] = r116;
        r311[4] = M27 & r115;
    }

    public static void reduce37(long[] r110, int r111) {
        int r100 = r111 + 4;
        long r101 = r110[r100];
        long r102 = r101 >>> 27;
        long r103 = ((r102 << 5) ^ r102) ^ (r102 << 7);
        long r104 = (r102 << 12) ^ r103;
        r110[r111] = r104 ^ r110[r111];
        r110[r100] = r101 & M27;
    }

    public static void sqrt(long[] r210, long[] r211) {
        long[] r100 = Nat320.create64();
        long r101 = Interleave.unshuffle(r210[0]);
        long r102 = Interleave.unshuffle(r210[1]);
        long r110 = (r101 & BodyPartID.bodyIdMax) | (r102 << 32);
        r100[0] = (r101 >>> 32) | (r102 & (-4294967296L));
        long r103 = Interleave.unshuffle(r210[2]);
        long r111 = Interleave.unshuffle(r210[3]);
        long r112 = (r103 & BodyPartID.bodyIdMax) | (r111 << 32);
        r100[1] = (r103 >>> 32) | ((-4294967296L) & r111);
        long r104 = Interleave.unshuffle(r210[4]);
        long r105 = BodyPartID.bodyIdMax & r104;
        r100[2] = r104 >>> 32;
        multiply(r100, ROOT_Z, r211);
        r211[0] = r211[0] ^ r110;
        r211[1] = r211[1] ^ r112;
        r211[2] = r211[2] ^ r105;
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(9);
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat.create64(9);
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat.create64(9);
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        return ((int) (r100[0] ^ (r100[4] >>> 15))) & 1;
    }
}
