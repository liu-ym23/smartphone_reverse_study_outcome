package org.apache.commons.compress.archivers.zip;

import androidx.collection.SieveCacheKt;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = null;

    public static long adjustToLong(int r100) {
        if (r100 >= 0) goto L6;
        return ((long) r100) + 4294967296L;
    L6:
        return r100;
    }

    public static int signedByteToUnsignedInt(byte r100) {
        if (r100 < 0) goto L5;
        return r100;
    L5:
        return r100 + 256;
    }

    static {
        DOS_TIME_MIN = ZipLong.getBytes(8448);
    }

    public static long bigToLong(BigInteger r100) {
        if (r100.bitLength() > 63) goto L7;
        return r100.longValue();
    L7:
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + r100 + "]");
    }

    public static BigInteger longToBig(long r100) {
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L11;
        if (r100 >= 0) goto L9;
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        r100 = adjustToLong((int) r100);
    L9:
        return BigInteger.valueOf(r100);
    L11:
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + r100 + "]");
    }

    public static byte[] reverse(byte[] r100) {
        int r101 = r100.length - 1;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length / 2)) goto L6;
        byte r103 = r100[r102];
        int r104 = r101 - r102;
        r100[r102] = r100[r104];
        r100[r104] = r103;
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public static byte unsignedIntToSignedByte(int r100) {
        if (r100 > 255) goto L12;
        if (r100 < 0) goto L12;
        if (r100 >= 128) goto L10;
        return (byte) r100;
    L10:
        return (byte) (r100 - 256);
    L12:
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + r100 + "]");
    }
}
