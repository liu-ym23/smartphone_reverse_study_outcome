package org.bouncycastle.pqc.math.linearalgebra;

import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public final class LittleEndianConversions {
    private LittleEndianConversions() {
    }

    public static void I2OSP(int r100, byte[] r101, int r102) {
        int r103 = r102 + 1;
        r101[r102] = (byte) r100;
        int r104 = r103 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        r101[r104] = (byte) (r100 >>> 16);
        r101[r104 + 1] = (byte) (r100 >>> 24);
    }

    public static void I2OSP(int r100, byte[] r101, int r102, int r103) {
        int r104 = r103 - 1;
    L3:
        if (r104 < 0) goto L5;
        r101[r102 + r104] = (byte) (r100 >>> (r104 * 8));
        r104 = r104 - 1;
        goto L3
    }

    public static void I2OSP(long r100, byte[] r101, int r102) {
        int r103 = r102 + 1;
        r101[r102] = (byte) r100;
        int r104 = r103 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        int r105 = r104 + 1;
        r101[r104] = (byte) (r100 >>> 16);
        int r106 = r105 + 1;
        r101[r105] = (byte) (r100 >>> 24);
        int r107 = r106 + 1;
        r101[r106] = (byte) (r100 >>> 32);
        int r108 = r107 + 1;
        r101[r107] = (byte) (r100 >>> 40);
        r101[r108] = (byte) (r100 >>> 48);
        r101[r108 + 1] = (byte) (r100 >>> 56);
    }

    public static byte[] I2OSP(int r100) {
        return new byte[]{(byte) r100, (byte) (r100 >>> 8), (byte) (r100 >>> 16), (byte) (r100 >>> 24)};
    }

    public static byte[] I2OSP(long r100) {
        return new byte[]{(byte) r100, (byte) (r100 >>> 8), (byte) (r100 >>> 16), (byte) (r100 >>> 24), (byte) (r100 >>> 32), (byte) (r100 >>> 40), (byte) (r100 >>> 48), (byte) (r100 >>> 56)};
    }

    public static int OS2IP(byte[] r100) {
        int r101 = ((r100[0] & UByte.MAX_VALUE) | ((r100[1] & UByte.MAX_VALUE) << 8)) | ((r100[2] & UByte.MAX_VALUE) << 16);
        return ((r100[3] & UByte.MAX_VALUE) << 24) | r101;
    }

    public static int OS2IP(byte[] r100, int r101) {
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] & UByte.MAX_VALUE) | ((r100[r102] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        return ((r100[r105] & UByte.MAX_VALUE) << 24) | r106;
    }

    public static int OS2IP(byte[] r100, int r101, int r102) {
        int r103 = r102 - 1;
        int r104 = 0;
    L3:
        if (r103 < 0) goto L5;
        r104 = r104 | ((r100[r101 + r103] & 255) << (r103 * 8));
        r103 = r103 - 1;
        goto L3
    L5:
        return r104;
    }

    public static long OS2LIP(byte[] r100, int r101) {
        int r102 = r101 + 1;
        long r103 = r100[r101] & UByte.MAX_VALUE;
        int r104 = r102 + 1;
        int r105 = r104 + 1;
        long r106 = (r103 | ((long) ((r100[r102] & UByte.MAX_VALUE) << 8))) | ((long) ((r100[r104] & UByte.MAX_VALUE) << 16));
        int r107 = r105 + 1;
        long r108 = r106 | ((((long) r100[r105]) & 255) << 24);
        int r109 = r107 + 1;
        long r110 = r108 | ((((long) r100[r107]) & 255) << 32);
        int r111 = r109 + 1;
        long r112 = r110 | ((((long) r100[r109]) & 255) << 40);
        int r113 = r111 + 1;
        return ((((long) r100[r113]) & 255) << 56) | (r112 | ((((long) r100[r111]) & 255) << 48));
    }

    public static byte[] toByteArray(int[] r100, int r101) {
        int r102 = r100.length;
        byte[] r103 = new byte[r101];
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 > (r102 - 2)) goto L6;
        I2OSP(r100[r104], r103, r105);
        r104 = r104 + 1;
        r105 = r105 + 4;
        goto L4
    L6:
        I2OSP(r100[r102 - 1], r103, r105, r101 - r105);
        return r103;
    }

    public static int[] toIntArray(byte[] r100) {
        int r101 = (r100.length + 3) / 4;
        int r102 = r100.length & 3;
        int[] r103 = new int[r101];
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 > (r101 - 2)) goto L6;
        r103[r104] = OS2IP(r100, r105);
        r104 = r104 + 1;
        r105 = r105 + 4;
        goto L4
    L6:
        int r106 = r101 - 1;
        if (r102 == 0) goto L9;
        r103[r106] = OS2IP(r100, r105, r102);
    L10:
        return r103;
    L9:
        r103[r106] = OS2IP(r100, r105);
        goto L10
    }
}
