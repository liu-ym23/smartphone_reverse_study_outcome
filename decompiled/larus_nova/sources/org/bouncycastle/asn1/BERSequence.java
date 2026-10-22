package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class BERSequence extends ASN1Sequence {
    public BERSequence() {
    }

    public BERSequence(ASN1Encodable r100) {
        super(r100);
    }

    public BERSequence(ASN1EncodableVector r100) {
        super(r100);
    }

    public BERSequence(ASN1Encodable[] r100) {
        super(r100);
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncodedIndef(r101, 48, this.elements);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int r100 = this.elements.length;
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L6;
        r102 = r102 + this.elements[r101].toASN1Primitive().encodedLength();
        r101 = r101 + 1;
        goto L3
    L6:
        return (r102 + 2) + 2;
    }
}
