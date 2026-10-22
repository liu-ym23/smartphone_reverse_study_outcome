package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AttCertValidityPeriod extends ASN1Object {
    ASN1GeneralizedTime notAfterTime;
    ASN1GeneralizedTime notBeforeTime;

    public AttCertValidityPeriod(ASN1GeneralizedTime r100, ASN1GeneralizedTime r101) {
        this.notBeforeTime = r100;
        this.notAfterTime = r101;
    }

    private AttCertValidityPeriod(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.notBeforeTime = ASN1GeneralizedTime.getInstance(r100.getObjectAt(0));
        this.notAfterTime = ASN1GeneralizedTime.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static AttCertValidityPeriod getInstance(Object r100) {
        if ((r100 instanceof AttCertValidityPeriod) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AttCertValidityPeriod(ASN1Sequence.getInstance(r100));
    L5:
        return (AttCertValidityPeriod) r100;
    }

    public ASN1GeneralizedTime getNotAfterTime() {
        return this.notAfterTime;
    }

    public ASN1GeneralizedTime getNotBeforeTime() {
        return this.notBeforeTime;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.notBeforeTime);
        r100.add(this.notAfterTime);
        return new DERSequence(r100);
    }
}
