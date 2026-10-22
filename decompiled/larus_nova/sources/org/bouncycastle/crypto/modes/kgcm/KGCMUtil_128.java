package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

/* JADX INFO: loaded from: classes42.dex */
public class KGCMUtil_128 {
    public static final int SIZE = 2;

    public KGCMUtil_128() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        long r103 = r100[1];
        r102[1] = r101[1] ^ r103;
    }

    public static void copy(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
    }

    public static boolean equal(long[] r100, long[] r101) {
        long r102 = (r100[0] ^ r101[0]) | 0;
        long r103 = r100[1];
        if (((r101[1] ^ r103) | r102) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void multiply(long[] r210, long[] r211, long[] r212) {
        int r100 = 0;
        long r101 = r210[0];
        long r102 = r210[1];
        long r103 = r211[0];
        long r104 = r211[1];
        long r110 = 0;
        long r111 = 0;
        long r112 = 0;
    L4:
        if (r100 >= 64) goto L6;
        long r213 = r111;
        long r113 = -(r101 & 1);
        r101 = r101 >>> 1;
        r110 = r110 ^ (r103 & r113);
        long r114 = (r113 & r104) ^ r112;
        long r115 = -(r102 & 1);
        r102 = r102 >>> 1;
        long r116 = r114 ^ (r103 & r115);
        long r117 = r213 ^ (r115 & r104);
        long r118 = r104 >> 63;
        r104 = (r104 << 1) | (r103 >>> 63);
        r103 = (r103 << 1) ^ (r118 & 135);
        r100 = r100 + 1;
        r111 = r117;
        r112 = r116;
        goto L4
    L6:
        long r119 = r111;
        r212[0] = (((r119 ^ (r119 << 1)) ^ (r119 << 2)) ^ (r119 << 7)) ^ r110;
        r212[1] = (((r119 >>> 63) ^ (r119 >>> 62)) ^ (r119 >>> 57)) ^ r112;
    }

    public static void multiplyX(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = (r101 >> 63) & 135;
        r111[0] = r102 ^ (r100 << 1);
        long r103 = r100 >>> 63;
        r111[1] = r103 | (r101 << 1);
    }

    public static void multiplyX8(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r101 >>> 56;
        long r103 = (((r100 << 8) ^ r102) ^ (r102 << 1)) ^ (r102 << 2);
        r111[0] = (r102 << 7) ^ r103;
        long r104 = r100 >>> 56;
        r111[1] = r104 | (r101 << 8);
    }

    public static void one(long[] r100) {
        r100[0] = 1;
        r100[1] = 0;
    }

    public static void square(long[] r110, long[] r111) {
        long[] r100 = new long[4];
        Interleave.expand64To128(r110[0], r100, 0);
        Interleave.expand64To128(r110[1], r100, 2);
        long r101 = r100[0];
        long r102 = r100[1];
        long r103 = r100[2];
        long r112 = r100[3];
        long r104 = r102 ^ ((((r112 << 1) ^ r112) ^ (r112 << 2)) ^ (r112 << 7));
        long r113 = (r112 >>> 63) ^ (r112 >>> 62);
        long r105 = r103 ^ ((r112 >>> 57) ^ r113);
        long r106 = r101 ^ ((((r105 << 1) ^ r105) ^ (r105 << 2)) ^ (r105 << 7));
        long r114 = (r105 >>> 63) ^ (r105 >>> 62);
        r111[0] = r106;
        r111[1] = r104 ^ ((r105 >>> 57) ^ r114);
    }

    public static void x(long[] r100) {
        r100[0] = 2;
        r100[1] = 0;
    }

    public static void zero(long[] r100) {
        r100[0] = 0;
        r100[1] = 0;
    }
}
