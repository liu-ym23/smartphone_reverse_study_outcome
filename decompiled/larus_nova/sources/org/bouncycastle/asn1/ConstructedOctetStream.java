package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
class ConstructedOctetStream extends InputStream {
    private InputStream _currentStream;
    private boolean _first;
    private final ASN1StreamParser _parser;

    public ConstructedOctetStream(ASN1StreamParser r100) {
        this._first = true;
        this._parser = r100;
    }

    private ASN1OctetStringParser getNextParser() throws IOException {
        ASN1Encodable r100 = this._parser.readObject();
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((r100 instanceof ASN1OctetStringParser) == false) goto L11;
        return (ASN1OctetStringParser) r100;
    L11:
        throw new IOException("unknown object encountered: " + r100.getClass());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this._currentStream != null) goto L11;
        if (this._first == true) goto L7;
        return -1;
    L7:
        ASN1OctetStringParser r100 = getNextParser();
        if (r100 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r100.getOctetStream();
    L11:
        int r101 = this._currentStream.read();
        if (r101 >= 0) goto L13;
        ASN1OctetStringParser r102 = getNextParser();
        if (r102 == null) goto L16;
        this._currentStream = r102.getOctetStream();
        goto L11
    L16:
        this._currentStream = null;
        return -1;
    L13:
        return r101;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = 0;
        if (this._currentStream != null) goto L12;
        if (this._first == true) goto L7;
        return -1;
    L7:
        ASN1OctetStringParser r104 = getNextParser();
        if (r104 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r104.getOctetStream();
    L12:
        int r105 = this._currentStream.read(r100, r101 + r103, r102 - r103);
        if (r105 >= 0) goto L14;
        ASN1OctetStringParser r106 = getNextParser();
        if (r106 == null) goto L19;
        this._currentStream = r106.getOctetStream();
        goto L12
    L19:
        this._currentStream = null;
        if (r103 >= 1) goto L23;
        return -1;
    L23:
        return r103;
    L14:
        r103 = r103 + r105;
        if (r103 != r102) goto L12;
        return r103;
    }
}
