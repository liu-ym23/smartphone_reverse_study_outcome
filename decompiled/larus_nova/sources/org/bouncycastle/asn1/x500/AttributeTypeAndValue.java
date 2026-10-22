package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AttributeTypeAndValue extends ASN1Object {
    private ASN1ObjectIdentifier type;
    private ASN1Encodable value;

    public AttributeTypeAndValue(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.type = r100;
        this.value = r101;
    }

    private AttributeTypeAndValue(ASN1Sequence r100) {
        this.type = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.value = r100.getObjectAt(1);
    }

    public static AttributeTypeAndValue getInstance(Object r100) {
        if ((r100 instanceof AttributeTypeAndValue) == true) goto L5;
        if (r100 == null) goto L10;
        return new AttributeTypeAndValue(ASN1Sequence.getInstance(r100));
    L10:
        throw new IllegalArgumentException("null value in getInstance()");
    L5:
        return (AttributeTypeAndValue) r100;
    }

    public ASN1ObjectIdentifier getType() {
        return this.type;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.type);
        r100.add(this.value);
        return new DERSequence(r100);
    }
}
