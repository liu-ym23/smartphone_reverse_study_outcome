package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class BodyPartList extends ASN1Object {
    private final BodyPartID[] bodyPartIDs;

    private BodyPartList(ASN1Sequence r100) {
        this.bodyPartIDs = Utils.toBodyPartIDArray(r100);
    }

    public BodyPartList(BodyPartID r100) {
        this.bodyPartIDs = new BodyPartID[]{r100};
    }

    public BodyPartList(BodyPartID[] r100) {
        this.bodyPartIDs = Utils.clone(r100);
    }

    public static BodyPartList getInstance(Object r100) {
        if ((r100 instanceof BodyPartList) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new BodyPartList(ASN1Sequence.getInstance(r100));
    L5:
        return (BodyPartList) r100;
    }

    public static BodyPartList getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BodyPartID[] getBodyPartIDs() {
        return Utils.clone(this.bodyPartIDs);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartIDs);
    }
}
