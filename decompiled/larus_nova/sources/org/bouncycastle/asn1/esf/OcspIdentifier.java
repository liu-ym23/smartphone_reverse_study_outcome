package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.ResponderID;

/* JADX INFO: loaded from: classes42.dex */
public class OcspIdentifier extends ASN1Object {
    private ResponderID ocspResponderID;
    private ASN1GeneralizedTime producedAt;

    private OcspIdentifier(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.ocspResponderID = ResponderID.getInstance(r100.getObjectAt(0));
        this.producedAt = (ASN1GeneralizedTime) r100.getObjectAt(1);
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OcspIdentifier(ResponderID r100, ASN1GeneralizedTime r101) {
        this.ocspResponderID = r100;
        this.producedAt = r101;
    }

    public static OcspIdentifier getInstance(Object r100) {
        if ((r100 instanceof OcspIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OcspIdentifier(ASN1Sequence.getInstance(r100));
    L5:
        return (OcspIdentifier) r100;
    }

    public ResponderID getOcspResponderID() {
        return this.ocspResponderID;
    }

    public ASN1GeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.ocspResponderID);
        r100.add(this.producedAt);
        return new DERSequence(r100);
    }
}
