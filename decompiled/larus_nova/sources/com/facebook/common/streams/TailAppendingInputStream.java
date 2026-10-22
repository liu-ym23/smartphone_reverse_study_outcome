package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class TailAppendingInputStream extends FilterInputStream {
    private int mMarkedTailOffset;
    private final byte[] mTail;
    private int mTailOffset;

    private int readNextTailByte() {
        int r100 = this.mTailOffset;
        byte[] r101 = this.mTail;
        if (r100 < r101.length) goto L6;
        return -1;
    L6:
        this.mTailOffset = r100 + 1;
        return r101[r100] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        return readNextTailByte();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported() == false) goto L7;
        ((FilterInputStream) this).in.reset();
        this.mTailOffset = this.mMarkedTailOffset;
        return;
    L7:
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r100) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        super.mark(r100);
        this.mMarkedTailOffset = this.mTailOffset;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    public TailAppendingInputStream(InputStream r100, byte[] r101) {
        super(r100);
        if (r100 == null) goto L8;
        if (r101 == null) goto L7;
        this.mTail = r101;
        return;
    L7:
        throw null;
    L8:
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = ((FilterInputStream) this).in.read(r100, r101, r102);
        if (r103 == (-1)) goto L5;
        return r103;
    L5:
        int r104 = 0;
        if (r102 != 0) goto L8;
        return 0;
    L8:
        if (r104 >= r102) goto L13;
        int r105 = readNextTailByte();
        if (r105 == (-1)) goto L13;
        r100[r101 + r104] = (byte) r105;
        r104 = r104 + 1;
    L13:
        if (r104 > 0) goto L15;
        return -1;
    L15:
        return r104;
    }
}
