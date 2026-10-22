package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = null;
    private final int _originalLength;
    private int _remaining;

    static {
        EMPTY_BYTES = new byte[0];
    }

    public DefiniteLengthInputStream(InputStream r100, int r101, int r102) {
        super(r100, r102);
        if (r101 < 0) goto L9;
        this._originalLength = r101;
        this._remaining = r101;
        if (r101 != 0) goto L10;
        setParentEofDetect(true);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public int getRemaining() {
        return this._remaining;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this._remaining != 0) goto L6;
        return -1;
    L6:
        int r100 = this._in.read();
        if (r100 < 0) goto L13;
        int r101 = this._remaining - 1;
        this._remaining = r101;
        if (r101 != 0) goto L11;
        setParentEofDetect(true);
    L11:
        return r100;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this._remaining;
        if (r103 != 0) goto L6;
        return -1;
    L6:
        int r104 = this._in.read(r100, r101, Math.min(r102, r103));
        if (r104 < 0) goto L13;
        int r105 = this._remaining - r104;
        this._remaining = r105;
        if (r105 != 0) goto L11;
        setParentEofDetect(true);
    L11:
        return r104;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public void readAllIntoByteArray(byte[] r100) throws IOException {
        int r101 = this._remaining;
        if (r101 != r100.length) goto L17;
        if (r101 != 0) goto L6;
        return;
    L6:
        int r102 = getLimit();
        int r103 = this._remaining;
        if (r103 >= r102) goto L15;
        int r104 = r103 - Streams.readFully(this._in, r100);
        this._remaining = r104;
        if (r104 != 0) goto L13;
        setParentEofDetect(true);
        return;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + r102);
    L17:
        throw new IllegalArgumentException("buffer length not right for data");
    }

    public byte[] toByteArray() throws IOException {
        if (this._remaining == 0) goto L5;
        int r100 = getLimit();
        int r101 = this._remaining;
        if (r101 >= r100) goto L15;
        byte[] r102 = new byte[r101];
        int r103 = r101 - Streams.readFully(this._in, r102);
        this._remaining = r103;
        if (r103 != 0) goto L13;
        setParentEofDetect(true);
        return r102;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + r100);
    L5:
        return EMPTY_BYTES;
    }
}
