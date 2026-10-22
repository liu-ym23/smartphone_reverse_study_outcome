package com.bytedance.compression.zstd;

import androidx.collection.SieveCacheKt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdDecompressCtx extends a {
    private ZstdDictDecompress decompression_dict;
    private long nativePtr;

    private native long decompressByteArray0(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105);

    private native void free();

    private native void init();

    private native long loadDDict0(byte[] r100);

    private native long loadDDictFast0(ZstdDictDecompress r100);

    private native long reset0();

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Decompression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdDecompressCtx() {
        this.nativePtr = 0;
        this.decompression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
    }

    public void reset() {
        ensureOpen();
        long r100 = reset0();
        if (Zstd.isError(r100) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r100);
    }

    static {
        vg4.a.b();
    }

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public ZstdDecompressCtx loadDict(ZstdDictDecompress r100) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r100.acquireSharedLock();
        long r101 = loadDDictFast0(r100);     // Catch: Throwable -> L12
        if (Zstd.isError(r101) == true) goto L11;
        this.decompression_dict = r100;     // Catch: Throwable -> L12
        r100.releaseSharedLock();
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r100.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Decompression context is closed");
    }

    public ZstdDecompressCtx loadDict(byte[] r100) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r101 = loadDDict0(r100);     // Catch: Throwable -> L12
        if (Zstd.isError(r101) == true) goto L11;
        this.decompression_dict = null;     // Catch: Throwable -> L12
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    public byte[] decompress(byte[] r100, int r101) throws ZstdException {
        byte[] r102 = new byte[r101];
        int r103 = decompress(r102, r100);
        if (r103 != r101) goto L5;
        return r102;
    L5:
        return Arrays.copyOfRange(r102, 0, r103);
    }

    public int decompress(byte[] r100, byte[] r101) {
        return decompressByteArray(r100, 0, r100.length, r101, 0, r101.length);
    }

    public int decompressByteArray(byte[] r100, int r101, int r102, byte[] r103, int r110, int r111) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r104 = decompressByteArray0(r100, r101, r102, r103, r110, r111);     // Catch: Throwable -> L15
        if (Zstd.isError(r104) == true) goto L14;
        if (r104 > SieveCacheKt.NodeLinkMask) goto L12;
        int r105 = (int) r104;
        releaseSharedLock();
        return r105;
    L12:
        throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");     // Catch: Throwable -> L15
    L14:
        throw new ZstdException(r104);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L19:
        throw new IllegalStateException("Decompression context is closed");
    }
}
