package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

/* JADX INFO: loaded from: classes42.dex */
public class KGCMUtil_256 {
    public static final int SIZE = 4;

    public KGCMUtil_256() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        long r103 = r100[3];
        r102[3] = r101[3] ^ r103;
    }

    public static void copy(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
    }

    public static boolean equal(long[] r110, long[] r111) {
        long r100 = (((r110[0] ^ r111[0]) | 0) | (r110[1] ^ r111[1])) | (r110[2] ^ r111[2]);
        long r101 = r110[3];
        if (((r111[3] ^ r101) | r100) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void multiply(long[] r310, long[] r410, long[] r411) {
        long r100 = r310[0];
        long r101 = r310[1];
        long r102 = r310[2];
        long r110 = r310[3];
        long r111 = r410[0];
        long r112 = r410[1];
        long r113 = r410[2];
        long r114 = r410[3];
        long r210 = 0;
        long r211 = 0;
        long r212 = 0;
        long r213 = 0;
        long r214 = 0;
        int r103 = 0;
    L3:
        int r104 = 64;
        long r311 = r102;
        if (r103 >= 64) goto L6;
        long r105 = -(r100 & 1);
        r210 = r210 ^ (r111 & r105);
        long r215 = r211 ^ (r112 & r105);
        long r216 = r212 ^ (r113 & r105);
        long r106 = -(r101 & 1);
        r101 = r101 >>> 1;
        r211 = r215 ^ (r111 & r106);
        r212 = r216 ^ (r112 & r106);
        r213 = (r213 ^ (r114 & r105)) ^ (r113 & r106);
        r214 = r214 ^ (r114 & r106);
        long r107 = r114 >> 63;
        r114 = (r114 << 1) | (r113 >>> 63);
        r113 = (r113 << 1) | (r112 >>> 63);
        r112 = (r111 >>> 63) | (r112 << 1);
        r111 = (r111 << 1) ^ (r107 & 1061);
        r103 = r103 + 1;
        r100 = r100 >>> 1;
        r102 = r311;
        goto L3
    L6:
        long r108 = (((r114 >>> 62) ^ r111) ^ (r114 >>> 59)) ^ (r114 >>> 54);
        long r115 = r113;
        int r109 = 0;
        long r116 = r112;
        long r117 = r110;
        long r118 = ((r114 ^ (r114 << 2)) ^ (r114 << 5)) ^ (r114 << 10);
        long r119 = r311;
    L7:
        if (r109 >= r104) goto L9;
        long r120 = -(r119 & 1);
        r119 = r119 >>> 1;
        r210 = r210 ^ (r118 & r120);
        long r217 = r211 ^ (r108 & r120);
        long r218 = r212 ^ (r116 & r120);
        long r312 = r118;
        long r121 = -(r117 & 1);
        r117 = r117 >>> 1;
        r211 = r217 ^ (r312 & r121);
        r212 = r218 ^ (r108 & r121);
        r213 = (r213 ^ (r115 & r120)) ^ (r116 & r121);
        r214 = r214 ^ (r115 & r121);
        long r122 = r115 >> 63;
        r115 = (r115 << 1) | (r116 >>> 63);
        r116 = (r108 >>> 63) | (r116 << 1);
        r108 = (r108 << 1) | (r312 >>> 63);
        r118 = (r312 << 1) ^ (r122 & 1061);
        r109 = r109 + 1;
        r104 = 64;
        goto L7
    L9:
        r411[0] = r210 ^ (((r214 ^ (r214 << 2)) ^ (r214 << 5)) ^ (r214 << 10));
        r411[1] = r211 ^ (((r214 >>> 62) ^ (r214 >>> 59)) ^ (r214 >>> 54));
        r411[2] = r212;
        r411[3] = r213;
    }

    public static void multiplyX(long[] r110, long[] r210) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r110[2];
        long r111 = r110[3];
        long r112 = (r111 >> 63) & 1061;
        r210[0] = r112 ^ (r100 << 1);
        long r103 = r100 >>> 63;
        r210[1] = r103 | (r101 << 1);
        r210[2] = (r102 << 1) | (r101 >>> 63);
        r210[3] = (r111 << 1) | (r102 >>> 63);
    }

    public static void multiplyX8(long[] r210, long[] r211) {
        long r100 = r210[0];
        long r101 = r210[1];
        long r102 = r210[2];
        long r110 = r210[3];
        long r111 = r110 >>> 56;
        r211[0] = ((((r100 << 8) ^ r111) ^ (r111 << 2)) ^ (r111 << 5)) ^ (r111 << 10);
        long r103 = r100 >>> 56;
        r211[1] = r103 | (r101 << 8);
        r211[2] = (r102 << 8) | (r101 >>> 56);
        r211[3] = (r110 << 8) | (r102 >>> 56);
    }

    public static void one(long[] r100) {
        r100[0] = 1;
        r100[1] = 0;
        r100[2] = 0;
        r100[3] = 0;
    }

    public static void square(long[] r110, long[] r111) {
        int r100 = 8;
        long[] r101 = new long[8];
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L6;
        Interleave.expand64To128(r110[r102], r101, r102 << 1);
        r102 = r102 + 1;
    L6:
        r100 = r100 - 1;
        if (r100 < 4) goto L9;
        long r103 = r101[r100];
        int r112 = r100 - 4;
        r101[r112] = r101[r112] ^ ((((r103 << 2) ^ r103) ^ (r103 << 5)) ^ (r103 << 10));
        int r113 = r112 + 1;
        r101[r113] = ((r103 >>> 54) ^ ((r103 >>> 62) ^ (r103 >>> 59))) ^ r101[r113];
        goto L6
    L9:
        copy(r101, r111);
    }

    public static void x(long[] r100) {
        r100[0] = 2;
        r100[1] = 0;
        r100[2] = 0;
        r100[3] = 0;
    }

    public static void zero(long[] r100) {
        r100[0] = 0;
        r100[1] = 0;
        r100[2] = 0;
        r100[3] = 0;
    }
}
