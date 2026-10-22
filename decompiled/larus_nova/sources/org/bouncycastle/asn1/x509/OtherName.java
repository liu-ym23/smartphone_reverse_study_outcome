package org.bouncycastle.asn1.x509;

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
public class OtherName extends ASN1Object {
    private final ASN1ObjectIdentifier typeID;
    private final ASN1Encodable value;

    public OtherName(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.typeID = r100;
        this.value = r101;
    }

    private OtherName(ASN1Sequence r100) {
        this.typeID = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.value = ASN1TaggedObject.getInstance(r100.getObjectAt(1)).getObject();
    }

    public static OtherName getInstance(Object r100) {
        if ((r100 instanceof OtherName) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherName(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherName) r100;
    }

    public ASN1ObjectIdentifier getTypeID() {
        return this.typeID;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.typeID);
        r100.add(new DERTaggedObject(true, 0, this.value));
        return new DERSequence(r100);
    }
}
