package com.bytedance.compression.zstd;

import androidx.collection.SieveCacheKt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdCompressCtx extends a {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    private native long compressByteArray0(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105);

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] r100);

    private native long loadCDictFast0(ZstdDictCompress r100);

    private native long reset0();

    private native void setChecksum0(boolean r100);

    private native void setContentSize0(boolean r100);

    private native void setDictID0(boolean r100);

    private native void setLevel0(int r100);

    private native long setPledgedSrcSize0(long r100);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx() {
        this.nativePtr = 0;
        this.compression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createCompressCtx failed");
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

    public byte[] compress(byte[] r110) {
        long r100 = ZstdCompress.compressBound(r110.length);
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        int r101 = (int) r100;
        byte[] r102 = new byte[r101];
        return Arrays.copyOfRange(r102, 0, compressByteArray(r102, 0, r101, r110, 0, r110.length));
    L7:
        throw new ZstdException(Zstd.errGeneric(), "Max output size is greater than MAX_INT");
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r100) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r100.acquireSharedLock();
        long r101 = loadCDictFast0(r100);     // Catch: Throwable -> L12
        if (Zstd.isError(r101) == true) goto L11;
        this.compression_dict = r100;     // Catch: Throwable -> L12
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
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setChecksum(boolean r100) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r100);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setContentSize(boolean r100) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setContentSize0(r100);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setDictID(boolean r100) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setDictID0(r100);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLevel(int r100) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r100);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLong(int r100) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, r100);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public void setPledgedSrcSize(long r100) {
        ensureOpen();
        long r101 = setPledgedSrcSize0(r100);
        if (Zstd.isError(r101) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r101);
    }

    public ZstdCompressCtx setWorkers(int r100) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r100);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx loadDict(byte[] r100) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r101 = loadCDict0(r100);     // Catch: Throwable -> L12
        if (Zstd.isError(r101) == true) goto L11;
        this.compression_dict = null;     // Catch: Throwable -> L12
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

    public int compress(byte[] r100, byte[] r101) {
        return compressByteArray(r100, 0, r100.length, r101, 0, r101.length);
    }

    public int compressByteArray(byte[] r100, int r101, int r102, byte[] r103, int r110, int r111) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r104 = compressByteArray0(r100, r101, r102, r103, r110, r111);     // Catch: Throwable -> L15
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
        throw new IllegalStateException("Compression context is closed");
    }
}
