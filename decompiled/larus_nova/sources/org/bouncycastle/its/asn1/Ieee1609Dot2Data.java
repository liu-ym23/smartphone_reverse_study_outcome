package org.bouncycastle.its.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class Ieee1609Dot2Data extends ASN1Object {
    private final Ieee1609Dot2Content content;
    private final BigInteger protcolVersion;

    private Ieee1609Dot2Data(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.protcolVersion = ASN1Integer.getInstance(r100.getObjectAt(0)).getValue();
        this.content = Ieee1609Dot2Content.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static Ieee1609Dot2Data getInstance(Object r100) {
        if ((r100 instanceof Ieee1609Dot2Data) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Ieee1609Dot2Data(ASN1Sequence.getInstance(r100));
    L5:
        return (Ieee1609Dot2Data) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
