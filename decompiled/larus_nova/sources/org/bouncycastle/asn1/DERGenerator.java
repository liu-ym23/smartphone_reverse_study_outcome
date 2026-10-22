package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public DERGenerator(OutputStream r100) {
        super(r100);
        this._tagged = false;
    }

    public DERGenerator(OutputStream r100, int r101, boolean r102) {
        super(r100);
        this._tagged = true;
        this._isExplicit = r102;
        this._tagNo = r101;
    }

    private void writeLength(OutputStream r100, int r101) throws IOException {
        if (r101 <= 127) goto L11;
        int r102 = r101;
        int r103 = 1;
    L5:
        r102 = r102 >>> 8;
        if (r102 == 0) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        r100.write((byte) (r103 | 128));
        int r104 = (r103 - 1) * 8;
    L9:
        if (r104 < 0) goto L15;
        r100.write((byte) (r101 >> r104));
        r104 = r104 - 8;
        goto L9
    L15:
        return;
    L11:
        r100.write((byte) r101);
    }

    public void writeDEREncoded(int r100, byte[] r101) throws IOException {
        if (this._tagged == false) goto L11;
        int r102 = this._tagNo;
        int r103 = r102 | 128;
        if (this._isExplicit == false) goto L8;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        writeDEREncoded(r104, r100, r101);
        OutputStream r105 = this._out;
        writeDEREncoded(r105, (r102 | 32) | 128, r104.toByteArray());
        return;
    L8:
        if ((r100 & 32) == 0) goto L10;
        writeDEREncoded(this._out, r103 | 32, r101);
        return;
    L10:
        writeDEREncoded(this._out, r103, r101);
        return;
    L11:
        writeDEREncoded(this._out, r100, r101);
    }

    public void writeDEREncoded(OutputStream r100, int r101, byte[] r102) throws IOException {
        r100.write(r101);
        writeLength(r100, r102.length);
        r100.write(r102);
    }
}
