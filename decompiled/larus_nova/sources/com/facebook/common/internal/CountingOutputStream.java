package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes22.dex */
public class CountingOutputStream extends FilterOutputStream {
    private long mCount;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public long getCount() {
        return this.mCount;
    }

    public CountingOutputStream(OutputStream r100) {
        super(r100);
        this.mCount = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        ((FilterOutputStream) this).out.write(r100);
        this.mCount++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        ((FilterOutputStream) this).out.write(r100, r101, r102);
        this.mCount += (long) r102;
    }
}
