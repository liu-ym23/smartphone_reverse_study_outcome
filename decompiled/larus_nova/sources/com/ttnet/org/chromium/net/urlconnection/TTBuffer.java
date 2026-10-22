package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.EOFException;

/* JADX INFO: loaded from: classes41.dex */
public final class TTBuffer {
    private Segment head;
    public int size;

    public byte get() {
        if (this.size > 0) goto L5;
        return 0;
    L5:
        byte[] r100 = new byte[1];
        read(r100, 0, 1);
        return r100[0];
    }

    public Segment getWritableSegment() {
        Segment r100 = this.head;
        if (r100 != null) goto L6;
        Segment r101 = SegmentPool.take();
        this.head = r101;
        r101.prev = r101;
        r101.next = r101;
        return r101;
    L6:
        Segment r102 = r100.prev;
        if (r102.isWritable() == true) goto L10;
        r102.push(SegmentPool.take());
    L10:
        return this.head.prev;
    }

    public void releaseAllSegments() {
    L2:
        Segment r100 = this.head;
        if (r100 == null) goto L5;
        this.head = r100.release();
        goto L2
    }

    public TTBuffer() {
        this.head = null;
        this.size = 0;
    }

    public static void checkOffsetAndCount(long r100, long r101, long r102) {
        if ((r101 | r102) < 0) goto L10;
        if (r101 > r100) goto L10;
        if ((r100 - r101) < r102) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(r100), Long.valueOf(r101), Long.valueOf(r102)}));
    }

    private int read(byte[] r100, int r101, int r110) {
        checkOffsetAndCount(r100.length, r101, r110);
        Segment r102 = this.head;
        if (r102 != null) goto L6;
        return -1;
    L6:
        int r103 = r102.getInnerBufferTo(r100, r101, r110);
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "head curReadLength is " + r103);
    L9:
        this.size -= r103;
        if (r102.getInnerBuffer().hasRemaining() == true) goto L12;
        this.head = r102.release();
    L12:
        return r103;
    }

    public int readToByteArray(byte[] r100, int r101, int r110) throws EOFException {
        checkOffsetAndCount(r100.length, r101, r110);
        int r102 = Math.min(this.size, r110);
        if (Logger.debug() == false) goto L5;
        Logger.d("TTBuffer", "start get buffer, size is " + this.size + " byteCount is " + r110);
    L5:
        int r111 = r101;
    L6:
        if (r102 <= 0) goto L15;
        int r103 = read(r100, r111, r102);
        if (r103 == (-1)) goto L13;
        r111 = r111 + r103;
        r102 = r102 - r103;
        if (Logger.debug() == false) goto L6;
        Logger.d("TTBuffer", "get segment buffer, n is " + r103 + " offset is " + r111 + " bytesRead is " + r102);
        goto L6
    L13:
        throw new EOFException();
    L15:
        return r111 - r101;
    }
}
