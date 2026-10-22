package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PolicyQualifierInfo extends ASN1Object {
    private ASN1ObjectIdentifier policyQualifierId;
    private ASN1Encodable qualifier;

    public PolicyQualifierInfo(String r100) {
        this.policyQualifierId = PolicyQualifierId.id_qt_cps;
        this.qualifier = new DERIA5String(r100);
    }

    public PolicyQualifierInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.policyQualifierId = r100;
        this.qualifier = r101;
    }

    public PolicyQualifierInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.policyQualifierId = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.qualifier = r100.getObjectAt(1);
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static PolicyQualifierInfo getInstance(Object r100) {
        if ((r100 instanceof PolicyQualifierInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PolicyQualifierInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PolicyQualifierInfo) r100;
    }

    public ASN1ObjectIdentifier getPolicyQualifierId() {
        return this.policyQualifierId;
    }

    public ASN1Encodable getQualifier() {
        return this.qualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.policyQualifierId);
        r100.add(this.qualifier);
        return new DERSequence(r100);
    }
}
