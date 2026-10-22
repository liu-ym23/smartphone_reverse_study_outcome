package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OtherMsg extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final ASN1ObjectIdentifier otherMsgType;
    private final ASN1Encodable otherMsgValue;

    private OtherMsg(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.bodyPartID = BodyPartID.getInstance(r100.getObjectAt(0));
        this.otherMsgType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(1));
        this.otherMsgValue = r100.getObjectAt(2);
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public OtherMsg(BodyPartID r100, ASN1ObjectIdentifier r101, ASN1Encodable r102) {
        this.bodyPartID = r100;
        this.otherMsgType = r101;
        this.otherMsgValue = r102;
    }

    public static OtherMsg getInstance(Object r100) {
        if ((r100 instanceof OtherMsg) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherMsg(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherMsg) r100;
    }

    public static OtherMsg getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public ASN1ObjectIdentifier getOtherMsgType() {
        return this.otherMsgType;
    }

    public ASN1Encodable getOtherMsgValue() {
        return this.otherMsgValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.bodyPartID);
        r100.add(this.otherMsgType);
        r100.add(this.otherMsgValue);
        return new DERSequence(r100);
    }
}
