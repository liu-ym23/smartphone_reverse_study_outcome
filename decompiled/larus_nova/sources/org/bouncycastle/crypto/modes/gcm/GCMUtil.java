package org.bouncycastle.crypto.modes.gcm;

import androidx.collection.SieveCacheKt;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class GCMUtil {
    private static final int E1 = -520093696;
    private static final long E1L = -2233785415175766016L;

    public GCMUtil() {
    }

    public static void asBytes(int[] r100, byte[] r101) {
        Pack.intToBigEndian(r100, r101, 0);
    }

    public static void asBytes(long[] r100, byte[] r101) {
        Pack.longToBigEndian(r100, r101, 0);
    }

    public static byte[] asBytes(int[] r100) {
        byte[] r101 = new byte[16];
        Pack.intToBigEndian(r100, r101, 0);
        return r101;
    }

    public static byte[] asBytes(long[] r100) {
        byte[] r101 = new byte[16];
        Pack.longToBigEndian(r100, r101, 0);
        return r101;
    }

    public static void asInts(byte[] r100, int[] r101) {
        Pack.bigEndianToInt(r100, 0, r101);
    }

    public static int[] asInts(byte[] r100) {
        int[] r101 = new int[4];
        Pack.bigEndianToInt(r100, 0, r101);
        return r101;
    }

    public static void asLongs(byte[] r100, long[] r101) {
        Pack.bigEndianToLong(r100, 0, r101);
    }

    public static long[] asLongs(byte[] r100) {
        long[] r101 = new long[2];
        Pack.bigEndianToLong(r100, 0, r101);
        return r101;
    }

    public static void copy(int[] r100, int[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
    }

    public static void copy(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
    }

    public static void divideP(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r100 >> 63;
        r111[0] = ((r100 ^ (E1L & r102)) << 1) | (r101 >>> 63);
        r111[1] = (r101 << 1) | (-r102);
    }

    private static long implMul64(long r310, long r311) {
        long r100 = r310 & 1229782938247303441L;
        long r101 = r310 & 2459565876494606882L;
        long r110 = r310 & 4919131752989213764L;
        long r111 = r310 & (-8608480567731124088L);
        long r112 = r311 & 1229782938247303441L;
        long r113 = r311 & 2459565876494606882L;
        long r210 = r311 & 4919131752989213764L;
        long r211 = r311 & (-8608480567731124088L);
        long r212 = (((r100 * r112) ^ (r101 * r211)) ^ (r110 * r210)) ^ (r111 * r113);
        long r213 = (((r100 * r113) ^ (r101 * r112)) ^ (r110 * r211)) ^ (r111 * r210);
        long r214 = (((r100 * r210) ^ (r101 * r113)) ^ (r110 * r112)) ^ (r111 * r211);
        long r102 = (((r100 * r211) ^ (r101 * r210)) ^ (r110 * r113)) ^ (r111 * r112);
        long r103 = (r212 & 1229782938247303441L) | (r213 & 2459565876494606882L);
        long r104 = r103 | (r214 & 4919131752989213764L);
        return r104 | (r102 & (-8608480567731124088L));
    }

    public static void multiply(byte[] r100, byte[] r101) {
        long[] r102 = asLongs(r100);
        multiply(r102, asLongs(r101));
        asBytes(r102, r100);
    }

    public static void multiply(int[] r110, int[] r111) {
        int r100 = r111[0];
        int r101 = r111[1];
        int r102 = r111[2];
        int r103 = r111[3];
        int r104 = 0;
        int r105 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L4:
        if (r104 >= 4) goto L10;
        int r115 = r110[r104];
        int r116 = 0;
    L7:
        if (r116 >= 32) goto L9;
        int r117 = r115 >> 31;
        r115 = r115 << 1;
        r105 = r105 ^ (r100 & r117);
        r112 = r112 ^ (r101 & r117);
        r113 = r113 ^ (r102 & r117);
        r114 = r114 ^ (r117 & r103);
        int r118 = (r103 << 31) >> 8;
        r103 = (r103 >>> 1) | (r102 << 31);
        r102 = (r102 >>> 1) | (r101 << 31);
        r101 = (r101 >>> 1) | (r100 << 31);
        r100 = (r100 >>> 1) ^ (r118 & E1);
        r116 = r116 + 1;
        goto L7
    L9:
        r104 = r104 + 1;
        goto L4
    L10:
        r110[0] = r105;
        r110[1] = r112;
        r110[2] = r113;
        r110[3] = r114;
    }

    public static void multiply(long[] r210, long[] r211) {
        long r100 = r210[0];
        long r101 = r210[1];
        long r102 = r211[0];
        long r103 = r211[1];
        long r110 = Longs.reverse(r100);
        long r111 = Longs.reverse(r101);
        long r112 = Longs.reverse(r102);
        long r104 = Longs.reverse(r103);
        long r113 = Longs.reverse(implMul64(r110, r112));
        long r212 = implMul64(r100, r102) << 1;
        long r213 = Longs.reverse(implMul64(r111, r104));
        long r114 = implMul64(r101, r103) << 1;
        long r105 = Longs.reverse(implMul64(r110 ^ r111, r112 ^ r104));
        long r106 = implMul64(r100 ^ r101, r102 ^ r103) << 1;
        long r107 = r105 ^ ((r212 ^ r113) ^ r213);
        long r108 = r106 ^ ((r213 ^ r212) ^ r114);
        long r109 = r107 ^ (((r114 ^ (r114 >>> 1)) ^ (r114 >>> 2)) ^ (r114 >>> 7));
        long r115 = r108 ^ ((r114 << 62) ^ (r114 << 57));
        long r116 = r115 >>> 7;
        long r117 = r113 ^ (r116 ^ ((r115 ^ (r115 >>> 1)) ^ (r115 >>> 2)));
        long r118 = (r115 << 63) ^ (r115 << 62);
        r210[0] = r117;
        r210[1] = ((r115 << 57) ^ r118) ^ r109;
    }

    public static void multiplyP(int[] r110) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r110[2];
        int r103 = r110[3];
        int r104 = ((r103 << 31) >> 31) & E1;
        r110[0] = r104 ^ (r100 >>> 1);
        r110[1] = (r101 >>> 1) | (r100 << 31);
        r110[2] = (r102 >>> 1) | (r101 << 31);
        r110[3] = (r103 >>> 1) | (r102 << 31);
    }

    public static void multiplyP(int[] r110, int[] r111) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r110[2];
        int r112 = r110[3];
        int r103 = ((r112 << 31) >> 31) & E1;
        r111[0] = r103 ^ (r100 >>> 1);
        r111[1] = (r101 >>> 1) | (r100 << 31);
        r111[2] = (r102 >>> 1) | (r101 << 31);
        r111[3] = (r112 >>> 1) | (r102 << 31);
    }

    public static void multiplyP(long[] r110) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = ((r101 << 63) >> 63) & E1L;
        r110[0] = r102 ^ (r100 >>> 1);
        long r103 = r100 << 63;
        r110[1] = r103 | (r101 >>> 1);
    }

    public static void multiplyP(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = ((r101 << 63) >> 63) & E1L;
        r111[0] = r102 ^ (r100 >>> 1);
        long r103 = r100 << 63;
        r111[1] = r103 | (r101 >>> 1);
    }

    public static void multiplyP3(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 << 61;
        long r103 = (((r100 >>> 3) ^ r102) ^ (r102 >>> 1)) ^ (r102 >>> 2);
        r111[0] = (r102 >>> 7) ^ r103;
        long r104 = r100 << 61;
        r111[1] = r104 | (r101 >>> 3);
    }

    public static void multiplyP4(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 << 60;
        long r103 = (((r100 >>> 4) ^ r102) ^ (r102 >>> 1)) ^ (r102 >>> 2);
        r111[0] = (r102 >>> 7) ^ r103;
        long r104 = r100 << 60;
        r111[1] = r104 | (r101 >>> 4);
    }

    public static void multiplyP7(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 << 57;
        long r103 = (((r100 >>> 7) ^ r102) ^ (r102 >>> 1)) ^ (r102 >>> 2);
        r111[0] = (r102 >>> 7) ^ r103;
        long r104 = r100 << 57;
        r111[1] = r104 | (r101 >>> 7);
    }

    public static void multiplyP8(int[] r110) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r110[2];
        int r103 = r110[3];
        int r104 = r103 << 24;
        int r105 = (((r100 >>> 8) ^ r104) ^ (r104 >>> 1)) ^ (r104 >>> 2);
        r110[0] = (r104 >>> 7) ^ r105;
        r110[1] = (r101 >>> 8) | (r100 << 24);
        r110[2] = (r102 >>> 8) | (r101 << 24);
        r110[3] = (r103 >>> 8) | (r102 << 24);
    }

    public static void multiplyP8(int[] r110, int[] r111) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r110[2];
        int r112 = r110[3];
        int r103 = r112 << 24;
        int r104 = (((r100 >>> 8) ^ r103) ^ (r103 >>> 1)) ^ (r103 >>> 2);
        r111[0] = (r103 >>> 7) ^ r104;
        r111[1] = (r101 >>> 8) | (r100 << 24);
        r111[2] = (r102 >>> 8) | (r101 << 24);
        r111[3] = (r112 >>> 8) | (r102 << 24);
    }

    public static void multiplyP8(long[] r110) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 << 56;
        long r111 = (((r100 >>> 8) ^ r102) ^ (r102 >>> 1)) ^ (r102 >>> 2);
        r110[0] = (r102 >>> 7) ^ r111;
        long r103 = r100 << 56;
        r110[1] = r103 | (r101 >>> 8);
    }

    public static void multiplyP8(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 << 56;
        long r103 = (((r100 >>> 8) ^ r102) ^ (r102 >>> 1)) ^ (r102 >>> 2);
        r111[0] = (r102 >>> 7) ^ r103;
        long r104 = r100 << 56;
        r111[1] = r104 | (r101 >>> 8);
    }

    public static byte[] oneAsBytes() {
        byte[] r100 = new byte[16];
        r100[0] = ByteCompanionObject.MIN_VALUE;
        return r100;
    }

    public static int[] oneAsInts() {
        int[] r100 = new int[4];
        r100[0] = Integer.MIN_VALUE;
        return r100;
    }

    public static long[] oneAsLongs() {
        return new long[]{Long.MIN_VALUE, 0};
    }

    public static long[] pAsLongs() {
        return new long[]{SieveCacheKt.NodeVisitedBit, 0};
    }

    public static void square(long[] r110, long[] r111) {
        long[] r100 = new long[4];
        Interleave.expand64To128Rev(r110[0], r100, 0);
        Interleave.expand64To128Rev(r110[1], r100, 2);
        long r101 = r100[0];
        long r102 = r100[1];
        long r103 = r100[2];
        long r112 = r100[3];
        long r104 = r102 ^ ((((r112 >>> 1) ^ r112) ^ (r112 >>> 2)) ^ (r112 >>> 7));
        long r113 = (r112 << 63) ^ (r112 << 62);
        long r105 = r103 ^ ((r112 << 57) ^ r113);
        long r106 = r101 ^ ((((r105 >>> 1) ^ r105) ^ (r105 >>> 2)) ^ (r105 >>> 7));
        long r114 = (r105 << 63) ^ (r105 << 62);
        r111[0] = r106;
        r111[1] = r104 ^ ((r105 << 57) ^ r114);
    }

    public static void xor(byte[] r100, int r101, byte[] r102, int r103, int r104) {
    L2:
        r104 = r104 - 1;
        if (r104 < 0) goto L5;
        int r105 = r101 + r104;
        r100[r105] = (byte) (r100[r105] ^ r102[r103 + r104]);
        goto L2
    }

    public static void xor(byte[] r100, int r101, byte[] r102, int r103, byte[] r104, int r105) {
        int r106 = 0;
    L3:
        r104[r105 + r106] = (byte) (r100[r101 + r106] ^ r102[r103 + r106]);
        int r107 = r106 + 1;
        r104[r105 + r107] = (byte) (r100[r101 + r107] ^ r102[r103 + r107]);
        int r108 = r107 + 1;
        r104[r105 + r108] = (byte) (r100[r101 + r108] ^ r102[r103 + r108]);
        int r109 = r108 + 1;
        r104[r105 + r109] = (byte) (r100[r101 + r109] ^ r102[r103 + r109]);
        r106 = r109 + 1;
        if (r106 < 16) goto L3;
    }

    public static void xor(byte[] r100, byte[] r101) {
        int r102 = 0;
    L3:
        r100[r102] = (byte) (r100[r102] ^ r101[r102]);
        int r103 = r102 + 1;
        r100[r103] = (byte) (r100[r103] ^ r101[r103]);
        int r104 = r103 + 1;
        r100[r104] = (byte) (r100[r104] ^ r101[r104]);
        int r105 = r104 + 1;
        r100[r105] = (byte) (r100[r105] ^ r101[r105]);
        r102 = r105 + 1;
        if (r102 < 16) goto L3;
    }

    public static void xor(byte[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L3:
        r100[r103] = (byte) (r100[r103] ^ r101[r102 + r103]);
        int r104 = r103 + 1;
        r100[r104] = (byte) (r100[r104] ^ r101[r102 + r104]);
        int r105 = r104 + 1;
        r100[r105] = (byte) (r100[r105] ^ r101[r102 + r105]);
        int r106 = r105 + 1;
        r100[r106] = (byte) (r100[r106] ^ r101[r102 + r106]);
        r103 = r106 + 1;
        if (r103 < 16) goto L3;
    }

    public static void xor(byte[] r100, byte[] r101, int r102, int r103) {
    L2:
        r103 = r103 - 1;
        if (r103 < 0) goto L5;
        r100[r103] = (byte) (r100[r103] ^ r101[r102 + r103]);
        goto L2
    }

    public static void xor(byte[] r100, byte[] r101, byte[] r102) {
        int r103 = 0;
    L3:
        r102[r103] = (byte) (r100[r103] ^ r101[r103]);
        int r104 = r103 + 1;
        r102[r104] = (byte) (r100[r104] ^ r101[r104]);
        int r105 = r104 + 1;
        r102[r105] = (byte) (r100[r105] ^ r101[r105]);
        int r106 = r105 + 1;
        r102[r106] = (byte) (r100[r106] ^ r101[r106]);
        r103 = r106 + 1;
        if (r103 < 16) goto L3;
    }

    public static void xor(int[] r100, int[] r101) {
        r100[0] = r100[0] ^ r101[0];
        r100[1] = r100[1] ^ r101[1];
        r100[2] = r100[2] ^ r101[2];
        int r102 = r100[3];
        r100[3] = r101[3] ^ r102;
    }

    public static void xor(int[] r100, int[] r101, int[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        r102[3] = r100[3] ^ r101[3];
    }

    public static void xor(long[] r100, long[] r101) {
        r100[0] = r100[0] ^ r101[0];
        r100[1] = r100[1] ^ r101[1];
    }

    public static void xor(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        long r103 = r100[1];
        r102[1] = r101[1] ^ r103;
    }
}
