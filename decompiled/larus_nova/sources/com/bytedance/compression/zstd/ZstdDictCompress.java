package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes6.dex */
public class ZstdDictCompress extends d {
    private int level;
    private long nativePtr;

    private native void free();

    private native void init(byte[] r100, int r101, int r102, int r103);

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

    public int level() {
        return this.level;
    }

    public ZstdDictCompress(byte[] r100, int r101) {
        this(r100, 0, r100.length, r101);
    }

    public ZstdDictCompress(byte[] r100, int r101, int r102, int r103) {
        this.nativePtr = 0;
        ZstdCompress.defaultCompressionLevel();
        this.level = r103;
        if ((r100.length - r101) < 0) goto L11;
        init(r100, r101, r102, r103);
        if (0 == this.nativePtr) goto L9;
        storeFence();
        return;
    L9:
        throw new IllegalStateException("ZSTD_createCDict failed");
    L11:
        throw new IllegalArgumentException("Dictionary buffer is to short");
    }
}
