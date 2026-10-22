package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OtherKeyAttribute extends ASN1Object {
    private ASN1Encodable keyAttr;
    private ASN1ObjectIdentifier keyAttrId;

    public OtherKeyAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.keyAttrId = r100;
        this.keyAttr = r101;
    }

    private OtherKeyAttribute(ASN1Sequence r100) {
        this.keyAttrId = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.keyAttr = r100.getObjectAt(1);
    }

    public static OtherKeyAttribute getInstance(Object r100) {
        if ((r100 instanceof OtherKeyAttribute) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherKeyAttribute(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherKeyAttribute) r100;
    }

    public ASN1Encodable getKeyAttr() {
        return this.keyAttr;
    }

    public ASN1ObjectIdentifier getKeyAttrId() {
        return this.keyAttrId;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.keyAttrId);
        r100.add(this.keyAttr);
        return new DERSequence(r100);
    }
}
