package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
class CronetInputStreamWithTTBuffer extends CronetInputStream {
    private static final int MAX_LENGTH = 5242880;
    private boolean mReadDone;
    private TTBuffer mTTBuffer;

    private void ensureReadFromCronetDone() throws IOException {
        if (this.mReadDone == true) goto L6;
        readAllBytesFromCronet();
        return;
    }

    private void readAllBytesFromCronet() throws IOException {
        if (this.mReadDone == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTBuffer", "calling ensureReadFromCronetDone");
    L8:
        this.mTTBuffer = new TTBuffer();
    L9:
        Segment r100 = this.mTTBuffer.getWritableSegment();
        ByteBuffer r101 = r100.getInnerBuffer();
        if (Logger.debug() == false) goto L12;
        Logger.d("TTBuffer", "getMoreData");
    L12:
        int r102 = r101.position();
        this.mHttpURLConnection.getMoreData(r101);
        if (this.mException != null) goto L40;
        int r103 = r101.position() - r102;
        if (r103 == 0) goto L16;
        TTBuffer r104 = this.mTTBuffer;
        int r105 = r104.size + r103;
        r104.size = r105;
        if (r105 > 5242880) goto L38;
        if (r100.isWritable() == true) goto L32;
        if (Logger.debug() == false) goto L37;
        Logger.d("TTBuffer", "new data but full, will use new segment next " + this.mTTBuffer.size);
    L37:
        r100.completeRead();
        goto L9
    L32:
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "new data, continue read with this segment " + this.mTTBuffer.size + " remaining: " + r101.remaining());
        goto L9
    L38:
        r104.releaseAllSegments();
        throw new IOException("Download too large " + this.mTTBuffer.size + " 5242880");
    L16:
        if (r102 != 0) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TTBuffer", "no new data, release empty segment " + this.mTTBuffer.size);
    L20:
        r100.release();
    L25:
        this.mReadDone = true;
        return;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("TTBuffer", "no new data, save this segment " + this.mTTBuffer.size);
    L24:
        r100.completeRead();
        goto L25
    L40:
        this.mTTBuffer.releaseAllSegments();
        throw this.mException;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureReadFromCronetDone();
        TTBuffer r100 = this.mTTBuffer;
        int r101 = r100.size;
        if (r101 == 0) goto L5;
        if (r101 <= 0) goto L11;
        return r101;
    L11:
        return 0;
    L5:
        if (this.mException != null) goto L7;
        return 0;
    L7:
        r100.releaseAllSegments();
        throw this.mException;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read() throws IOException {
        ensureReadFromCronetDone();
        TTBuffer r100 = this.mTTBuffer;
        if (r100.size > 0) goto L5;
        return -1;
    L5:
        return r100.get() & UByte.MAX_VALUE;
    }

    public CronetInputStreamWithTTBuffer(CronetHttpURLConnection r100) {
        super(r100);
        this.mReadDone = false;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        ensureReadFromCronetDone();
        if (r100.length != 0) goto L6;
        return 0;
    L6:
        TTBuffer r103 = this.mTTBuffer;
        if (r103.size > 0) goto L9;
        return -1;
    L9:
        return r103.readToByteArray(r100, r101, r102);
    }
}
