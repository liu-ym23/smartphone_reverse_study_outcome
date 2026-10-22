package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("cronet")
public class TTCompressManager {

    /* JADX INFO: loaded from: classes6.dex */
    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType ZSTD = null;
        final int mType;

        static {
            CompressType r100 = new CompressType("GZIP", 0, 1);
            GZIP = r100;
            CompressType r101 = new CompressType("BROTLI", 1, 2);
            BROTLI = r101;
            CompressType r102 = new CompressType("ZSTD", 2, 3);
            ZSTD = r102;
            $VALUES = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mType;
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) a.a(CompressType.class, r100);
        }

        private CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mType = r102;
        }
    }

    public TTCompressManager() {
    }

    private static native byte[] nativeCompressData(byte[] r100, int r101, int r102, int r103);

    private static native byte[] nativeDecompressData(byte[] r100, int r101, int r102);

    public static byte[] decompressData(byte[] r100, int r101, CompressType r102) {
        return nativeDecompressData(r100, r101, r102.getValue());
    }

    public static byte[] compressData(byte[] r100, int r101, int r102, CompressType r103) {
        return nativeCompressData(r100, r101, r102, r103.getValue());
    }
}
