package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class BERSequenceGenerator extends BERGenerator {
    public BERSequenceGenerator(OutputStream r100) throws IOException {
        super(r100);
        writeBERHeader(48);
    }

    public BERSequenceGenerator(OutputStream r100, int r101, boolean r102) throws IOException {
        super(r100, r101, r102);
        writeBERHeader(48);
    }

    public void addObject(ASN1Encodable r100) throws IOException {
        r100.toASN1Primitive().encodeTo(this._out);
    }

    public void close() throws IOException {
        writeBEREnd();
    }
}
