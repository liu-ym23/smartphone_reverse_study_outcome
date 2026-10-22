package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdDictDecompress extends d {
    private long nativePtr;

    private native void free();

    private native void init(byte[] r100, int r101, int r102);

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    static {
        vg4.a.b();
    }

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public ZstdDictDecompress(byte[] r100) {
        this(r100, 0, r100.length);
    }

    public ZstdDictDecompress(byte[] r100, int r101, int r102) {
        this.nativePtr = 0;
        init(r100, r101, r102);
        if (this.nativePtr == 0) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDDict failed");
    }
}
