package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
class CronetInputStream extends InputStream {
    private static final int READ_BUFFER_SIZE = 32768;
    private static final int READ_BUFFER_SIZE_MIN = 8192;
    private ByteBuffer mBuffer;
    protected IOException mException;
    protected final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    private void getMoreDataIfNeeded() throws IOException {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r100 = this.mException;
        if (r100 != null) goto L7;
        return;
    L7:
        throw r100;
    L9:
        if (hasUnreadData() == false) goto L11;
        return;
    L11:
        if (this.mBuffer == null) goto L13;
    L17:
        this.mBuffer.clear();
        this.mHttpURLConnection.getMoreData(this.mBuffer);
        IOException r101 = this.mException;
        if (r101 != null) goto L22;
        ByteBuffer r102 = this.mBuffer;
        if (r102 == null) goto L24;
        r102.flip();
        return;
    L24:
        return;
    L22:
        throw r101;
    L13:
        if (this.mHttpURLConnection.getInputStreamBufferSize() < 8192) goto L15;
        int r103 = this.mHttpURLConnection.getInputStreamBufferSize();
    L16:
        this.mBuffer = ByteBuffer.allocateDirect(r103);
        goto L17
    L15:
        r103 = 32768;
        goto L16
    }

    private boolean hasUnreadData() {
        ByteBuffer r100 = this.mBuffer;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasRemaining() == false) goto L7;
        return true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r100 = this.mException;
        if (r100 != null) goto L7;
        return 0;
    L7:
        throw r100;
    L9:
        if (hasUnreadData() == true) goto L11;
        return 0;
    L11:
        return this.mBuffer.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CronetHttpURLConnection r100 = this.mHttpURLConnection;
        if (r100 == null) goto L5;
        r100.disconnect();
    L5:
        super.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        getMoreDataIfNeeded();
        if (hasUnreadData() == true) goto L5;
        return -1;
    L5:
        return this.mBuffer.get() & UByte.MAX_VALUE;
    }

    public CronetInputStream(CronetHttpURLConnection r100) {
        this.mHttpURLConnection = r100;
    }

    public void setResponseDataCompleted(IOException r100) {
        this.mException = r100;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (r101 < 0) goto L16;
        if (r102 < 0) goto L16;
        if ((r101 + r102) > r100.length) goto L16;
        if (r102 != 0) goto L9;
        return 0;
    L9:
        getMoreDataIfNeeded();
        if (hasUnreadData() == false) goto L13;
        int r103 = Math.min(this.mBuffer.limit() - this.mBuffer.position(), r102);
        this.mBuffer.get(r100, r101, r103);
        return r103;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }
}
