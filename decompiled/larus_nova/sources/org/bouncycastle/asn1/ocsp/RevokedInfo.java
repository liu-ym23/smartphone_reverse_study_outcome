package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.CRLReason;

/* JADX INFO: loaded from: classes42.dex */
public class RevokedInfo extends ASN1Object {
    private CRLReason revocationReason;
    private ASN1GeneralizedTime revocationTime;

    public RevokedInfo(ASN1GeneralizedTime r100, CRLReason r101) {
        this.revocationTime = r100;
        this.revocationReason = r101;
    }

    private RevokedInfo(ASN1Sequence r100) {
        this.revocationTime = ASN1GeneralizedTime.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L6;
        this.revocationReason = CRLReason.getInstance(ASN1Enumerated.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true));
        return;
    }

    public static RevokedInfo getInstance(Object r100) {
        if ((r100 instanceof RevokedInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevokedInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (RevokedInfo) r100;
    }

    public static RevokedInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public CRLReason getRevocationReason() {
        return this.revocationReason;
    }

    public ASN1GeneralizedTime getRevocationTime() {
        return this.revocationTime;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.revocationTime);
        CRLReason r101 = this.revocationReason;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
