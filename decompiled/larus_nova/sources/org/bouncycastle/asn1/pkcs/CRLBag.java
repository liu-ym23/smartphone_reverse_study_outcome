package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CRLBag extends ASN1Object {
    private ASN1ObjectIdentifier crlId;
    private ASN1Encodable crlValue;

    public CRLBag(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.crlId = r100;
        this.crlValue = r101;
    }

    private CRLBag(ASN1Sequence r100) {
        this.crlId = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.crlValue = ((ASN1TaggedObject) r100.getObjectAt(1)).getObject();
    }

    public static CRLBag getInstance(Object r100) {
        if ((r100 instanceof CRLBag) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CRLBag(ASN1Sequence.getInstance(r100));
    L5:
        return (CRLBag) r100;
    }

    public ASN1ObjectIdentifier getCrlId() {
        return this.crlId;
    }

    public ASN1Encodable getCrlValue() {
        return this.crlValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.crlId);
        r100.add(new DERTaggedObject(0, this.crlValue));
        return new DERSequence(r100);
    }
}
