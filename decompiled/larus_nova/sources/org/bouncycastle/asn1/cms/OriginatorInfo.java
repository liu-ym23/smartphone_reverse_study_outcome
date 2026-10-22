package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class OriginatorInfo extends ASN1Object {
    private ASN1Set certs;
    private ASN1Set crls;

    private OriginatorInfo(ASN1Sequence r100) {
        int r101 = r100.size();
        if (r101 != 0) goto L5;
        return;
    L5:
        if (r101 != 1) goto L7;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r100.getObjectAt(0);
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
    L9:
        this.crls = ASN1Set.getInstance(r102, false);
        return;
    L17:
        throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + r102.getTagNo());
    L18:
        this.certs = ASN1Set.getInstance(r102, false);
        return;
    L7:
        if (r101 != 2) goto L11;
        this.certs = ASN1Set.getInstance((ASN1TaggedObject) r100.getObjectAt(0), false);
        r102 = (ASN1TaggedObject) r100.getObjectAt(1);
        goto L9
    L11:
        throw new IllegalArgumentException("OriginatorInfo too big");
    }

    public OriginatorInfo(ASN1Set r100, ASN1Set r101) {
        this.certs = r100;
        this.crls = r101;
    }

    public static OriginatorInfo getInstance(Object r100) {
        if ((r100 instanceof OriginatorInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OriginatorInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (OriginatorInfo) r100;
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certs;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1Set r101 = this.certs;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        ASN1Set r102 = this.crls;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
