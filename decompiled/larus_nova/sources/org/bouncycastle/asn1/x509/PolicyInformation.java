package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PolicyInformation extends ASN1Object {
    private ASN1ObjectIdentifier policyIdentifier;
    private ASN1Sequence policyQualifiers;

    public PolicyInformation(ASN1ObjectIdentifier r100) {
        this.policyIdentifier = r100;
    }

    public PolicyInformation(ASN1ObjectIdentifier r100, ASN1Sequence r101) {
        this.policyIdentifier = r100;
        this.policyQualifiers = r101;
    }

    private PolicyInformation(ASN1Sequence r100) {
        if (r100.size() < 1) goto L11;
        if (r100.size() > 2) goto L11;
        this.policyIdentifier = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        this.policyQualifiers = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static PolicyInformation getInstance(Object r100) {
        if (r100 == null) goto L9;
        if ((r100 instanceof PolicyInformation) == true) goto L9;
        return new PolicyInformation(ASN1Sequence.getInstance(r100));
    L9:
        return (PolicyInformation) r100;
    }

    public ASN1ObjectIdentifier getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public ASN1Sequence getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.policyIdentifier);
        ASN1Sequence r101 = this.policyQualifiers;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("Policy information: ");
        r100.append(this.policyIdentifier);
        if (this.policyQualifiers == null) goto L13;
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L6:
        if (r102 >= this.policyQualifiers.size()) goto L11;
        if (r101.length() == 0) goto L10;
        r101.append(", ");
    L10:
        r101.append(PolicyQualifierInfo.getInstance(this.policyQualifiers.getObjectAt(r102)));
        r102 = r102 + 1;
        goto L6
    L11:
        r100.append("[");
        r100.append(r101);
        r100.append("]");
    L13:
        return r100.toString();
    }
}
