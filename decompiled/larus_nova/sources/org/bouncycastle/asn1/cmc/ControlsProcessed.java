package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ControlsProcessed extends ASN1Object {
    private final ASN1Sequence bodyPartReferences;

    private ControlsProcessed(ASN1Sequence r100) {
        if (r100.size() != 1) goto L7;
        this.bodyPartReferences = ASN1Sequence.getInstance(r100.getObjectAt(0));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public ControlsProcessed(BodyPartReference r100) {
        this.bodyPartReferences = new DERSequence(r100);
    }

    public ControlsProcessed(BodyPartReference[] r100) {
        this.bodyPartReferences = new DERSequence(r100);
    }

    public static ControlsProcessed getInstance(Object r100) {
        if ((r100 instanceof ControlsProcessed) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ControlsProcessed(ASN1Sequence.getInstance(r100));
    L5:
        return (ControlsProcessed) r100;
    }

    public BodyPartReference[] getBodyList() {
        BodyPartReference[] r100 = new BodyPartReference[this.bodyPartReferences.size()];
        int r101 = 0;
    L4:
        if (r101 == this.bodyPartReferences.size()) goto L6;
        r100[r101] = BodyPartReference.getInstance(this.bodyPartReferences.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartReferences);
    }
}
