package org.bouncycastle.asn1;

import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
abstract class LimitedInputStream extends InputStream {
    protected final InputStream _in;
    private int _limit;

    public LimitedInputStream(InputStream r100, int r101) {
        this._in = r100;
        this._limit = r101;
    }

    public int getLimit() {
        return this._limit;
    }

    public void setParentEofDetect(boolean r100) {
        InputStream r101 = this._in;
        if ((r101 instanceof IndefiniteLengthInputStream) == false) goto L6;
        ((IndefiniteLengthInputStream) r101).setEofOn00(r100);
        return;
    }
}
