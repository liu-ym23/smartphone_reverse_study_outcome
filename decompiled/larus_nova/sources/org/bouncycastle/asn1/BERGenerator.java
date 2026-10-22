package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public BERGenerator(OutputStream r100) {
        super(r100);
        this._tagged = false;
    }

    public BERGenerator(OutputStream r100, int r101, boolean r102) {
        super(r100);
        this._tagged = true;
        this._isExplicit = r102;
        this._tagNo = r101;
    }

    private void writeHdr(int r100) throws IOException {
        this._out.write(r100);
        this._out.write(128);
    }

    @Override // org.bouncycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this._out;
    }

    public void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if (this._tagged == true) goto L5;
        return;
    L5:
        if (this._isExplicit == false) goto L9;
        this._out.write(0);
        this._out.write(0);
        return;
    }

    public void writeBERHeader(int r100) throws IOException {
        if (this._tagged == false) goto L11;
        int r101 = this._tagNo | 128;
        if (this._isExplicit == false) goto L8;
        writeHdr(r101 | 32);
        goto L11
    L8:
        if ((r100 & 32) == 0) goto L10;
        r100 = r101 | 32;
        goto L11
    L10:
        writeHdr(r101);
        return;
    L11:
        writeHdr(r100);
    }
}
