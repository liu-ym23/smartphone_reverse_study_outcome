package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("cronet")
public class TTCompressManager {
    public TTCompressManager() {
    }

    private static native byte[] nativeCompressData(byte[] r0, int r1, int r2, int r3);

    private static native byte[] nativeDecompressData(byte[] r0, int r1, int r2);

    public static byte[] decompressData(byte[] r0, int r1, CompressType r2) {
        return nativeDecompressData(r0, r1, r2.getValue());
    }

    public static byte[] compressData(byte[] r0, int r1, int r2, CompressType r3) {
        return nativeCompressData(r0, r1, r2, r3.getValue());
    }
}
