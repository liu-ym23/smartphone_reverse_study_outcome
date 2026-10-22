package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SequenceOfRectangularRegion extends ASN1Object {
    private final RectangularRegion[] sequence;

    private SequenceOfRectangularRegion(ASN1Sequence r100) {
        this.sequence = new RectangularRegion[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        this.sequence[r101] = RectangularRegion.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.sequence);
    }
}
