package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class PooledByteArrayBufferedInputStream extends InputStream {
    private static final String TAG = "PooledByteInputStream";
    private int mBufferOffset;
    private int mBufferedSize;
    private final byte[] mByteArray;
    private boolean mClosed;
    private final InputStream mInputStream;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    private boolean ensureDataInBuffer() throws IOException {
        if (this.mBufferOffset >= this.mBufferedSize) goto L5;
        return true;
    L5:
        int r100 = this.mInputStream.read(this.mByteArray);
        if (r100 > 0) goto L8;
        return false;
    L8:
        this.mBufferedSize = r100;
        this.mBufferOffset = 0;
        return true;
    }

    private void ensureNotClosed() throws IOException {
        if (this.mClosed == true) goto L6;
        return;
    L6:
        throw new IOException("stream already closed");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.mBufferOffset > this.mBufferedSize) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100);
        ensureNotClosed();
        return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
    L5:
        r100 = false;
        goto L6
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mClosed == true) goto L6;
        this.mClosed = true;
        this.mResourceReleaser.release(this.mByteArray);
        super.close();
        return;
    }

    public void finalize() throws Throwable {
        if (this.mClosed == true) goto L5;
        FLog.e(TAG, "Finalized without closing");
        close();
    L5:
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.mBufferOffset > this.mBufferedSize) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100);
        ensureNotClosed();
        if (ensureDataInBuffer() == true) goto L10;
        return -1;
    L10:
        byte[] r101 = this.mByteArray;
        int r102 = this.mBufferOffset;
        this.mBufferOffset = r102 + 1;
        return r101[r102] & UByte.MAX_VALUE;
    L5:
        r100 = false;
        goto L6
    }

    @Override // java.io.InputStream
    public long skip(long r100) throws IOException {
        if (this.mBufferOffset > this.mBufferedSize) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkState(r101);
        ensureNotClosed();
        int r102 = this.mBufferedSize;
        int r103 = this.mBufferOffset;
        long r104 = r102 - r103;
        if (r104 < r100) goto L10;
        this.mBufferOffset = (int) (((long) r103) + r100);
        return r100;
    L10:
        this.mBufferOffset = r102;
        return r104 + this.mInputStream.skip(r100 - r104);
    L5:
        r101 = false;
        goto L6
    }

    public PooledByteArrayBufferedInputStream(InputStream r100, byte[] r101, ResourceReleaser<byte[]> r102) {
        this.mInputStream = (InputStream) Preconditions.checkNotNull(r100);
        this.mByteArray = (byte[]) Preconditions.checkNotNull(r101);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(r102);
        this.mBufferedSize = 0;
        this.mBufferOffset = 0;
        this.mClosed = false;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.mBufferOffset > this.mBufferedSize) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkState(r103);
        ensureNotClosed();
        if (ensureDataInBuffer() == true) goto L10;
        return -1;
    L10:
        int r104 = Math.min(this.mBufferedSize - this.mBufferOffset, r102);
        System.arraycopy(this.mByteArray, this.mBufferOffset, r100, r101, r104);
        this.mBufferOffset += r104;
        return r104;
    L5:
        r103 = false;
        goto L6
    }
}
