package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class Zstd {
    public Zstd() {
    }

    public static native long errGeneric();

    public static native long getErrorCode(long r100);

    public static native String getErrorName(long r100);

    public static native long[] getFunAddressesBySymbols(String[] r100);

    public static native boolean isError(long r100);

    static {
        vg4.a.b();
    }

    public static final byte[] extractArray(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L9;
        if (r100.arrayOffset() != 0) goto L9;
        return r100.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static long getFunAddressBySymbol(String r100) {
        long[] r101 = getFunAddressesBySymbols(new String[]{r100});
        if (r101 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r101.length != 1) goto L7;
        return r101[0];
    }
}
