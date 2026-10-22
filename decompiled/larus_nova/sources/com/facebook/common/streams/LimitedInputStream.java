package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public class LimitedInputStream extends FilterInputStream {
    private int mBytesToRead;
    private int mBytesToReadWhenMarked;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(((FilterInputStream) this).in.available(), this.mBytesToRead);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.mBytesToRead != 0) goto L5;
        return -1;
    L5:
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 == (-1)) goto L8;
        this.mBytesToRead--;
    L8:
        return r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported() == false) goto L11;
        if (this.mBytesToReadWhenMarked == (-1)) goto L9;
        ((FilterInputStream) this).in.reset();
        this.mBytesToRead = this.mBytesToReadWhenMarked;
        return;
    L9:
        throw new IOException("mark not set");
    L11:
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r100) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        ((FilterInputStream) this).in.mark(r100);
        this.mBytesToReadWhenMarked = this.mBytesToRead;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        long r101 = ((FilterInputStream) this).in.skip(Math.min(r100, this.mBytesToRead));
        this.mBytesToRead = (int) (((long) this.mBytesToRead) - r101);
        return r101;
    }

    public LimitedInputStream(InputStream r100, int r101) {
        super(r100);
        if (r100 == null) goto L10;
        if (r101 < 0) goto L8;
        this.mBytesToRead = r101;
        this.mBytesToReadWhenMarked = -1;
        return;
    L8:
        throw new IllegalArgumentException("limit must be >= 0");
    L10:
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.mBytesToRead;
        if (r103 != 0) goto L6;
        return -1;
    L6:
        int r104 = ((FilterInputStream) this).in.read(r100, r101, Math.min(r102, r103));
        if (r104 <= 0) goto L9;
        this.mBytesToRead -= r104;
    L9:
        return r104;
    }
}
