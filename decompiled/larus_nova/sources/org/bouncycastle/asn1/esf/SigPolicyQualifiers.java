package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SigPolicyQualifiers extends ASN1Object {
    ASN1Sequence qualifiers;

    private SigPolicyQualifiers(ASN1Sequence r100) {
        this.qualifiers = r100;
    }

    public SigPolicyQualifiers(SigPolicyQualifierInfo[] r100) {
        this.qualifiers = new DERSequence(r100);
    }

    public static SigPolicyQualifiers getInstance(Object r100) {
        if ((r100 instanceof SigPolicyQualifiers) == false) goto L7;
        return (SigPolicyQualifiers) r100;
    L7:
        if ((r100 instanceof ASN1Sequence) == true) goto L9;
        return null;
    L9:
        return new SigPolicyQualifiers(ASN1Sequence.getInstance(r100));
    }

    public SigPolicyQualifierInfo getInfoAt(int r100) {
        return SigPolicyQualifierInfo.getInstance(this.qualifiers.getObjectAt(r100));
    }

    public int size() {
        return this.qualifiers.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.qualifiers;
    }
}
