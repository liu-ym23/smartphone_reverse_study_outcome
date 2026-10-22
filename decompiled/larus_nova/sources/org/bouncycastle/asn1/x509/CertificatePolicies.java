package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertificatePolicies extends ASN1Object {
    private final PolicyInformation[] policyInformation;

    private CertificatePolicies(ASN1Sequence r100) {
        this.policyInformation = new PolicyInformation[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        this.policyInformation[r101] = PolicyInformation.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    public CertificatePolicies(PolicyInformation r100) {
        this.policyInformation = new PolicyInformation[]{r100};
    }

    public CertificatePolicies(PolicyInformation[] r100) {
        this.policyInformation = copy(r100);
    }

    private static PolicyInformation[] copy(PolicyInformation[] r100) {
        PolicyInformation[] r101 = new PolicyInformation[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static CertificatePolicies fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.certificatePolicies));
    }

    public static CertificatePolicies getInstance(Object r100) {
        if ((r100 instanceof CertificatePolicies) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificatePolicies(ASN1Sequence.getInstance(r100));
    L5:
        return (CertificatePolicies) r100;
    }

    public static CertificatePolicies getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public PolicyInformation getPolicyInformation(ASN1ObjectIdentifier r100) {
        int r101 = 0;
    L3:
        PolicyInformation[] r102 = this.policyInformation;
        if (r101 == r102.length) goto L10;
        if (r100.equals(r102[r101].getPolicyIdentifier()) == true) goto L8;
        r101 = r101 + 1;
        goto L3
    L8:
        return this.policyInformation[r101];
    L10:
        return null;
    }

    public PolicyInformation[] getPolicyInformation() {
        return copy(this.policyInformation);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.policyInformation);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        int r101 = 0;
    L4:
        if (r101 >= this.policyInformation.length) goto L10;
        if (r100.length() == 0) goto L8;
        r100.append(", ");
    L8:
        r100.append(this.policyInformation[r101]);
        r101 = r101 + 1;
        goto L4
    L10:
        return "CertificatePolicies: [" + r100 + "]";
    }
}
