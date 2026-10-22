package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class RectangularRegion extends ASN1Object {
    private RectangularRegion(ASN1Sequence r100) {
    }

    public static RectangularRegion getInstance(Object r100) {
        if ((r100 instanceof RectangularRegion) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RectangularRegion(ASN1Sequence.getInstance(r100));
    L5:
        return (RectangularRegion) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
