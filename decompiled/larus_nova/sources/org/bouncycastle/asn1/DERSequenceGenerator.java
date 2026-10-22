package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class DERSequenceGenerator extends DERGenerator {
    private final ByteArrayOutputStream _bOut;

    public DERSequenceGenerator(OutputStream r100) throws IOException {
        super(r100);
        this._bOut = new ByteArrayOutputStream();
    }

    public DERSequenceGenerator(OutputStream r100, int r101, boolean r102) throws IOException {
        super(r100, r101, r102);
        this._bOut = new ByteArrayOutputStream();
    }

    public void addObject(ASN1Encodable r100) throws IOException {
        r100.toASN1Primitive().encodeTo(this._bOut, ASN1Encoding.DER);
    }

    public void close() throws IOException {
        writeDEREncoded(48, this._bOut.toByteArray());
    }

    @Override // org.bouncycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this._bOut;
    }
}
