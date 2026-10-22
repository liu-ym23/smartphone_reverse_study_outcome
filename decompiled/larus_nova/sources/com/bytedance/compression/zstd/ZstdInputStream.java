package com.bytedance.compression.zstd;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdInputStream extends FilterInputStream {
    private ZstdInputStreamNoFinalizer inner;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.inner.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    public boolean getContinuous() {
        return this.inner.getContinuous();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.inner.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return this.inner.read();
    }

    public static long recommendedDInSize() {
        return ZstdInputStreamNoFinalizer.recommendedDInSize();
    }

    public static long recommendedDOutSize() {
        return ZstdInputStreamNoFinalizer.recommendedDOutSize();
    }

    public void finalize() throws Throwable {
        close();
    }

    public ZstdInputStream(InputStream r100) throws IOException {
        super(r100);
        this.inner = new ZstdInputStreamNoFinalizer(r100);
    }

    public ZstdInputStream setContinuous(boolean r100) {
        this.inner.setContinuous(r100);
        return this;
    }

    public ZstdInputStream setDict(ZstdDictDecompress r100) throws IOException {
        this.inner.setDict(r100);
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        return this.inner.skip(r100);
    }

    public ZstdInputStream setDict(byte[] r100) throws IOException {
        this.inner.setDict(r100);
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        return this.inner.read(r100, r101, r102);
    }
}
