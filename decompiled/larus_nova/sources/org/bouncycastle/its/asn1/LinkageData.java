package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class LinkageData extends ASN1Object {
    private final GroupLinkageValue groupLinkageValue;
    private final IValue iCert;
    private final LinkageValue linkageValue;

    private LinkageData(ASN1Sequence r100) {
        if (r100.size() != 2) goto L5;
    L9:
        this.iCert = IValue.getInstance(r100.getObjectAt(2));
        this.linkageValue = LinkageValue.getInstance(r100.getObjectAt(2));
        this.groupLinkageValue = GroupLinkageValue.getInstance(r100.getObjectAt(2));
        return;
    L5:
        if (r100.size() == 3) goto L9;
        throw new IllegalArgumentException("sequence must be size 2 or 3");
    }

    public static LinkageData getInstance(Object r100) {
        if ((r100 instanceof LinkageData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LinkageData(ASN1Sequence.getInstance(r100));
    L5:
        return (LinkageData) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
