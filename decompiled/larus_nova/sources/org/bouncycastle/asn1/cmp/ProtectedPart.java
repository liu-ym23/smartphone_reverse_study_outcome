package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ProtectedPart extends ASN1Object {
    private PKIBody body;
    private PKIHeader header;

    private ProtectedPart(ASN1Sequence r100) {
        this.header = PKIHeader.getInstance(r100.getObjectAt(0));
        this.body = PKIBody.getInstance(r100.getObjectAt(1));
    }

    public ProtectedPart(PKIHeader r100, PKIBody r101) {
        this.header = r100;
        this.body = r101;
    }

    public static ProtectedPart getInstance(Object r100) {
        if ((r100 instanceof ProtectedPart) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ProtectedPart(ASN1Sequence.getInstance(r100));
    L5:
        return (ProtectedPart) r100;
    }

    public PKIBody getBody() {
        return this.body;
    }

    public PKIHeader getHeader() {
        return this.header;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.header);
        r100.add(this.body);
        return new DERSequence(r100);
    }
}
