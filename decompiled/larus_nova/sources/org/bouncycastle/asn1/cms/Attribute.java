package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class Attribute extends ASN1Object {
    private ASN1ObjectIdentifier attrType;
    private ASN1Set attrValues;

    public Attribute(ASN1ObjectIdentifier r100, ASN1Set r101) {
        this.attrType = r100;
        this.attrValues = r101;
    }

    private Attribute(ASN1Sequence r100) {
        this.attrType = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.attrValues = (ASN1Set) r100.getObjectAt(1);
    }

    public static Attribute getInstance(Object r100) {
        if ((r100 instanceof Attribute) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Attribute(ASN1Sequence.getInstance(r100));
    L5:
        return (Attribute) r100;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public ASN1Encodable[] getAttributeValues() {
        return this.attrValues.toArray();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.attrType);
        r100.add(this.attrValues);
        return new DERSequence(r100);
    }
}
