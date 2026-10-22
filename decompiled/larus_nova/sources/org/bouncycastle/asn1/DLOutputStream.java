package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
class DLOutputStream extends ASN1OutputStream {
    public DLOutputStream(OutputStream r100) {
        super(r100);
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    public void writePrimitive(ASN1Primitive r100, boolean r101) throws IOException {
        r100.toDLObject().encode(this, r101);
    }
}
