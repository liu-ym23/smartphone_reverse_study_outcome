package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SigPolicyQualifierInfo extends ASN1Object {
    private ASN1ObjectIdentifier sigPolicyQualifierId;
    private ASN1Encodable sigQualifier;

    public SigPolicyQualifierInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.sigPolicyQualifierId = r100;
        this.sigQualifier = r101;
    }

    private SigPolicyQualifierInfo(ASN1Sequence r100) {
        this.sigPolicyQualifierId = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.sigQualifier = r100.getObjectAt(1);
    }

    public static SigPolicyQualifierInfo getInstance(Object r100) {
        if ((r100 instanceof SigPolicyQualifierInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SigPolicyQualifierInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (SigPolicyQualifierInfo) r100;
    }

    public ASN1ObjectIdentifier getSigPolicyQualifierId() {
        return new ASN1ObjectIdentifier(this.sigPolicyQualifierId.getId());
    }

    public ASN1Encodable getSigQualifier() {
        return this.sigQualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.sigPolicyQualifierId);
        r100.add(this.sigQualifier);
        return new DERSequence(r100);
    }
}
