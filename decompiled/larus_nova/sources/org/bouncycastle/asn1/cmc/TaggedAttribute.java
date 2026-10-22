package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class TaggedAttribute extends ASN1Object {
    private final ASN1ObjectIdentifier attrType;
    private final ASN1Set attrValues;
    private final BodyPartID bodyPartID;

    private TaggedAttribute(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.bodyPartID = BodyPartID.getInstance(r100.getObjectAt(0));
        this.attrType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(1));
        this.attrValues = ASN1Set.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public TaggedAttribute(BodyPartID r100, ASN1ObjectIdentifier r101, ASN1Set r102) {
        this.bodyPartID = r100;
        this.attrType = r101;
        this.attrValues = r102;
    }

    public static TaggedAttribute getInstance(Object r100) {
        if ((r100 instanceof TaggedAttribute) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TaggedAttribute(ASN1Sequence.getInstance(r100));
    L5:
        return (TaggedAttribute) r100;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.bodyPartID, this.attrType, this.attrValues});
    }
}
