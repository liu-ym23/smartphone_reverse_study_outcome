package com.xiaomi.push;

import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public class x {
    public static byte[] a(int r100) {
        return new byte[]{(byte) (r100 >> 24), (byte) (r100 >> 16), (byte) (r100 >> 8), (byte) r100};
    }

    public static int a(byte[] r100) {
        if (r100.length != 4) goto L7;
        int r101 = ((0 | ((r100[0] & UByte.MAX_VALUE) << 24)) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8);
        return (r100[3] & UByte.MAX_VALUE) | r101;
    L7:
        throw new IllegalArgumentException("the length of bytes must be 4");
    }
}
