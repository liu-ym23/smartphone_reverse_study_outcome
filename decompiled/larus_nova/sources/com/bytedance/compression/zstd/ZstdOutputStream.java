package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    public void setFinalize(boolean r100) {
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.inner.flush();
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    public void finalize() throws Throwable {
        close();
    }

    public ZstdOutputStream(OutputStream r100) throws IOException {
        this(r100, c.f203093a);
    }

    public ZstdOutputStream setChecksum(boolean r100) throws IOException {
        this.inner.setChecksum(r100);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r100) throws IOException {
        this.inner.setCloseFrameOnFlush(r100);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress r100) throws IOException {
        this.inner.setDict(r100);
        return this;
    }

    public ZstdOutputStream setLevel(int r100) throws IOException {
        this.inner.setLevel(r100);
        return this;
    }

    public ZstdOutputStream setLong(int r100) throws IOException {
        this.inner.setLong(r100);
        return this;
    }

    public ZstdOutputStream setWorkers(int r100) throws IOException {
        this.inner.setWorkers(r100);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        this.inner.write(r100);
    }

    public ZstdOutputStream setDict(byte[] r100) throws IOException {
        this.inner.setDict(r100);
        return this;
    }

    public ZstdOutputStream(OutputStream r100, int r101) throws IOException {
        this(r100, c.f203093a);
        this.inner.setLevel(r101);
    }

    private ZstdOutputStream(OutputStream r100, b r101) throws IOException {
        super(r100);
        this.inner = new ZstdOutputStreamNoFinalizer(r100, r101);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.inner.write(r100, r101, r102);
    }
}
