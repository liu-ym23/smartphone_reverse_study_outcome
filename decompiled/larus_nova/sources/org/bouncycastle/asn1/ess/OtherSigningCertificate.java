package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.PolicyInformation;

/* JADX INFO: loaded from: classes42.dex */
public class OtherSigningCertificate extends ASN1Object {
    ASN1Sequence certs;
    ASN1Sequence policies;

    private OtherSigningCertificate(ASN1Sequence r100) {
        if (r100.size() < 1) goto L11;
        if (r100.size() > 2) goto L11;
        this.certs = ASN1Sequence.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        this.policies = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OtherSigningCertificate(OtherCertID r100) {
        this.certs = new DERSequence(r100);
    }

    public static OtherSigningCertificate getInstance(Object r100) {
        if ((r100 instanceof OtherSigningCertificate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherSigningCertificate(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherSigningCertificate) r100;
    }

    public OtherCertID[] getCerts() {
        OtherCertID[] r100 = new OtherCertID[this.certs.size()];
        int r101 = 0;
    L4:
        if (r101 == this.certs.size()) goto L6;
        r100[r101] = OtherCertID.getInstance(this.certs.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public PolicyInformation[] getPolicies() {
        ASN1Sequence r100 = this.policies;
        if (r100 != null) goto L6;
        return null;
    L6:
        PolicyInformation[] r101 = new PolicyInformation[r100.size()];
        int r102 = 0;
    L8:
        if (r102 == this.policies.size()) goto L10;
        r101[r102] = PolicyInformation.getInstance(this.policies.getObjectAt(r102));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.certs);
        ASN1Sequence r101 = this.policies;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
