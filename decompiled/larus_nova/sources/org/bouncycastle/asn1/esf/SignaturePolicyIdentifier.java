package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

/* JADX INFO: loaded from: classes42.dex */
public class SignaturePolicyIdentifier extends ASN1Object {
    private boolean isSignaturePolicyImplied;
    private SignaturePolicyId signaturePolicyId;

    public SignaturePolicyIdentifier() {
        this.isSignaturePolicyImplied = true;
    }

    public SignaturePolicyIdentifier(SignaturePolicyId r100) {
        this.signaturePolicyId = r100;
        this.isSignaturePolicyImplied = false;
    }

    public static SignaturePolicyIdentifier getInstance(Object r100) {
        if ((r100 instanceof SignaturePolicyIdentifier) == false) goto L7;
        return (SignaturePolicyIdentifier) r100;
    L7:
        if ((r100 instanceof ASN1Null) == true) goto L17;
        if (ASN1Object.hasEncodedTagValue(r100, 5) == true) goto L17;
        if (r100 != null) goto L13;
        return null;
    L13:
        return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(r100));
    L17:
        return new SignaturePolicyIdentifier();
    }

    public SignaturePolicyId getSignaturePolicyId() {
        return this.signaturePolicyId;
    }

    public boolean isSignaturePolicyImplied() {
        return this.isSignaturePolicyImplied;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.isSignaturePolicyImplied == false) goto L7;
        return DERNull.INSTANCE;
    L7:
        return this.signaturePolicyId.toASN1Primitive();
    }
}
