package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class PooledByteBufferInputStream extends InputStream {
    int mMark;
    int mOffset;
    final PooledByteBuffer mPooledByteBuffer;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.mPooledByteBuffer.size() - this.mOffset;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.mOffset = this.mMark;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() > 0) goto L6;
        return -1;
    L6:
        PooledByteBuffer r100 = this.mPooledByteBuffer;
        int r101 = this.mOffset;
        this.mOffset = r101 + 1;
        return r100.read(r101) & UByte.MAX_VALUE;
    }

    public PooledByteBufferInputStream(PooledByteBuffer r100) {
        Preconditions.checkArgument(!r100.isClosed());
        this.mPooledByteBuffer = (PooledByteBuffer) Preconditions.checkNotNull(r100);
        this.mOffset = 0;
        this.mMark = 0;
    }

    @Override // java.io.InputStream
    public void mark(int r100) {
        this.mMark = this.mOffset;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.InputStream
    public long skip(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        int r102 = Math.min((int) r100, available());
        this.mOffset += r102;
        return r102;
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) {
        if (r101 < 0) goto L16;
        if (r102 < 0) goto L16;
        if ((r101 + r102) > r100.length) goto L16;
        int r103 = available();
        if (r103 > 0) goto L10;
        return -1;
    L10:
        if (r102 > 0) goto L13;
        return 0;
    L13:
        int r104 = Math.min(r103, r102);
        this.mPooledByteBuffer.read(this.mOffset, r100, r101, r104);
        this.mOffset += r104;
        return r104;
    L16:
        throw new ArrayIndexOutOfBoundsException("length=" + r100.length + "; regionStart=" + r101 + "; regionLength=" + r102);
    }
}
