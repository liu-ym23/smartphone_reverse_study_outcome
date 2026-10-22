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
public class OtherRecipientInfo extends ASN1Object {
    private ASN1ObjectIdentifier oriType;
    private ASN1Encodable oriValue;

    public OtherRecipientInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.oriType = r100;
        this.oriValue = r101;
    }

    private OtherRecipientInfo(ASN1Sequence r100) {
        this.oriType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.oriValue = r100.getObjectAt(1);
    }

    public static OtherRecipientInfo getInstance(Object r100) {
        if ((r100 instanceof OtherRecipientInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherRecipientInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherRecipientInfo) r100;
    }

    public static OtherRecipientInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getType() {
        return this.oriType;
    }

    public ASN1Encodable getValue() {
        return this.oriValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.oriType);
        r100.add(this.oriValue);
        return new DERSequence(r100);
    }
}
