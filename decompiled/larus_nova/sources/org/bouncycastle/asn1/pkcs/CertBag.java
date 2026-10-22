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
public class CertBag extends ASN1Object {
    private ASN1ObjectIdentifier certId;
    private ASN1Encodable certValue;

    public CertBag(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.certId = r100;
        this.certValue = r101;
    }

    private CertBag(ASN1Sequence r100) {
        this.certId = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.certValue = ASN1TaggedObject.getInstance(r100.getObjectAt(1)).getObject();
    }

    public static CertBag getInstance(Object r100) {
        if ((r100 instanceof CertBag) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertBag(ASN1Sequence.getInstance(r100));
    L5:
        return (CertBag) r100;
    }

    public ASN1ObjectIdentifier getCertId() {
        return this.certId;
    }

    public ASN1Encodable getCertValue() {
        return this.certValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.certId);
        r100.add(new DERTaggedObject(0, this.certValue));
        return new DERSequence(r100);
    }
}
