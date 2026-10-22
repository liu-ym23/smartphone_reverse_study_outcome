package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PKIResponse extends ASN1Object {
    private final ASN1Sequence cmsSequence;
    private final ASN1Sequence controlSequence;
    private final ASN1Sequence otherMsgSequence;

    private PKIResponse(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.controlSequence = ASN1Sequence.getInstance(r100.getObjectAt(0));
        this.cmsSequence = ASN1Sequence.getInstance(r100.getObjectAt(1));
        this.otherMsgSequence = ASN1Sequence.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static PKIResponse getInstance(Object r100) {
        if ((r100 instanceof PKIResponse) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIResponse(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIResponse) r100;
    }

    public static PKIResponse getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Sequence getCmsSequence() {
        return this.cmsSequence;
    }

    public ASN1Sequence getControlSequence() {
        return this.controlSequence;
    }

    public ASN1Sequence getOtherMsgSequence() {
        return this.otherMsgSequence;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.controlSequence);
        r100.add(this.cmsSequence);
        r100.add(this.otherMsgSequence);
        return new DERSequence(r100);
    }
}
