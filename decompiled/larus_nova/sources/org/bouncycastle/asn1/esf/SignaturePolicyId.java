package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SignaturePolicyId extends ASN1Object {
    private OtherHashAlgAndValue sigPolicyHash;
    private ASN1ObjectIdentifier sigPolicyId;
    private SigPolicyQualifiers sigPolicyQualifiers;

    public SignaturePolicyId(ASN1ObjectIdentifier r100, OtherHashAlgAndValue r101) {
        this(r100, r101, null);
    }

    public SignaturePolicyId(ASN1ObjectIdentifier r100, OtherHashAlgAndValue r101, SigPolicyQualifiers r102) {
        this.sigPolicyId = r100;
        this.sigPolicyHash = r101;
        this.sigPolicyQualifiers = r102;
    }

    private SignaturePolicyId(ASN1Sequence r100) {
        if (r100.size() != 2) goto L5;
    L9:
        this.sigPolicyId = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.sigPolicyHash = OtherHashAlgAndValue.getInstance(r100.getObjectAt(1));
        if (r100.size() != 3) goto L13;
        this.sigPolicyQualifiers = SigPolicyQualifiers.getInstance(r100.getObjectAt(2));
        return;
    L13:
        return;
    L5:
        if (r100.size() == 3) goto L9;
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static SignaturePolicyId getInstance(Object r100) {
        if ((r100 instanceof SignaturePolicyId) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SignaturePolicyId(ASN1Sequence.getInstance(r100));
    L5:
        return (SignaturePolicyId) r100;
    }

    public OtherHashAlgAndValue getSigPolicyHash() {
        return this.sigPolicyHash;
    }

    public ASN1ObjectIdentifier getSigPolicyId() {
        return new ASN1ObjectIdentifier(this.sigPolicyId.getId());
    }

    public SigPolicyQualifiers getSigPolicyQualifiers() {
        return this.sigPolicyQualifiers;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.sigPolicyId);
        r100.add(this.sigPolicyHash);
        SigPolicyQualifiers r101 = this.sigPolicyQualifiers;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
