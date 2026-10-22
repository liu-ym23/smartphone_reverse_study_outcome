package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OtherRevocationInfoFormat extends ASN1Object {
    private ASN1Encodable otherRevInfo;
    private ASN1ObjectIdentifier otherRevInfoFormat;

    public OtherRevocationInfoFormat(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.otherRevInfoFormat = r100;
        this.otherRevInfo = r101;
    }

    private OtherRevocationInfoFormat(ASN1Sequence r100) {
        this.otherRevInfoFormat = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.otherRevInfo = r100.getObjectAt(1);
    }

    public static OtherRevocationInfoFormat getInstance(Object r100) {
        if ((r100 instanceof OtherRevocationInfoFormat) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherRevocationInfoFormat(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherRevocationInfoFormat) r100;
    }

    public static OtherRevocationInfoFormat getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Encodable getInfo() {
        return this.otherRevInfo;
    }

    public ASN1ObjectIdentifier getInfoFormat() {
        return this.otherRevInfoFormat;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.otherRevInfoFormat);
        r100.add(this.otherRevInfo);
        return new DERSequence(r100);
    }
}
