package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class Ieee1609Dot2Content extends ASN1Object implements ASN1Choice {
    public Ieee1609Dot2Content() {
    }

    public static Ieee1609Dot2Content getInstance(Object r100) {
        if ((r100 instanceof Ieee1609Dot2Content) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return getInstance(ASN1Sequence.getInstance(r100));
    L5:
        return (Ieee1609Dot2Content) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
