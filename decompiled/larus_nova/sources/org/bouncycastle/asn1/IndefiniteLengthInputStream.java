package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    public IndefiniteLengthInputStream(InputStream r100, int r101) throws IOException {
        super(r100, r101);
        this._eofReached = false;
        this._eofOn00 = true;
        this._b1 = r100.read();
        int r102 = r100.read();
        this._b2 = r102;
        if (r102 < 0) goto L7;
        checkForEof();
        return;
    L7:
        throw new EOFException();
    }

    private boolean checkForEof() {
        if (this._eofReached == true) goto L12;
        if (this._eofOn00 == false) goto L12;
        if (this._b1 != 0) goto L12;
        if (this._b2 != 0) goto L12;
        this._eofReached = true;
        setParentEofDetect(true);
    L12:
        return this._eofReached;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (checkForEof() == false) goto L6;
        return -1;
    L6:
        int r100 = this._in.read();
        if (r100 < 0) goto L11;
        int r101 = this._b1;
        this._b1 = this._b2;
        this._b2 = r100;
        return r101;
    L11:
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (this._eofOn00 == true) goto L22;
        if (r102 < 3) goto L22;
        if (this._eofReached == false) goto L11;
        return -1;
    L11:
        int r103 = this._in.read(r100, r101 + 2, r102 - 2);
        if (r103 < 0) goto L20;
        r100[r101] = (byte) this._b1;
        r100[r101 + 1] = (byte) this._b2;
        this._b1 = this._in.read();
        int r104 = this._in.read();
        this._b2 = r104;
        if (r104 < 0) goto L18;
        return r103 + 2;
    L18:
        throw new EOFException();
    L20:
        throw new EOFException();
    L22:
        return super.read(r100, r101, r102);
    }

    public void setEofOn00(boolean r100) {
        this._eofOn00 = r100;
        checkForEof();
    }
}
