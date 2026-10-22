package com.bytedance.zoin.zstd;

import java.io.IOException;
import java.io.InputStream;
import mr7.a;

/* JADX INFO: loaded from: classes22.dex */
public class ZstdInputStream extends com.bytedance.compression.zstd.ZstdInputStream {
    private boolean finalize;

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public void finalize() throws Throwable {
        if (this.finalize == false) goto L6;
        close();
        return;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return super.available();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public boolean getContinuous() {
        return super.getContinuous();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return super.markSupported();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return super.read();
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    public ZstdInputStream(InputStream r100) throws IOException {
        super(r100);
        this.finalize = true;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public /* bridge */ /* synthetic */ com.bytedance.compression.zstd.ZstdInputStream setContinuous(boolean r100) {
        return setContinuous(r100);
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public /* bridge */ /* synthetic */ com.bytedance.compression.zstd.ZstdInputStream setDict(byte[] r100) throws IOException {
        return setDict(r100);
    }

    public void setFinalize(boolean r100) {
        this.finalize = r100;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        return super.skip(r100);
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public ZstdInputStream setContinuous(boolean r100) {
        super.setContinuous(r100);
        return this;
    }

    public ZstdInputStream setDict(a r100) throws IOException {
        super.setDict(r100);
        return this;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream
    public ZstdInputStream setDict(byte[] r100) throws IOException {
        super.setDict(r100);
        return this;
    }

    @Override // com.bytedance.compression.zstd.ZstdInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        return super.read(r100, r101, r102);
    }
}
