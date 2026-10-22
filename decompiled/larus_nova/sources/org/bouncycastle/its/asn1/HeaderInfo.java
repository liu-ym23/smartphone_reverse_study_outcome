package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class HeaderInfo extends ASN1Object {
    private HeaderInfo(ASN1Sequence r100) {
    }

    public static HeaderInfo getInstance(Object r100) {
        if ((r100 instanceof HeaderInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new HeaderInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (HeaderInfo) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
