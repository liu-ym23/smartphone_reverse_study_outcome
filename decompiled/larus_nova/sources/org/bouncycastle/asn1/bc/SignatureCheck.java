package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureCheck extends ASN1Object {
    private final ASN1Sequence certificates;
    private final AlgorithmIdentifier signatureAlgorithm;
    private final ASN1BitString signatureValue;

    private SignatureCheck(ASN1Sequence r100) {
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        int r101 = 1;
        if ((r100.getObjectAt(1) instanceof ASN1TaggedObject) == false) goto L5;
        this.certificates = ASN1Sequence.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(1)).getObject());
        r101 = 2;
    L6:
        this.signatureValue = DERBitString.getInstance(r100.getObjectAt(r101));
        return;
    L5:
        this.certificates = null;
        goto L6
    }

    public SignatureCheck(AlgorithmIdentifier r100, byte[] r101) {
        this.signatureAlgorithm = r100;
        this.certificates = null;
        this.signatureValue = new DERBitString(Arrays.clone(r101));
    }

    public SignatureCheck(AlgorithmIdentifier r100, Certificate[] r101, byte[] r102) {
        this.signatureAlgorithm = r100;
        this.certificates = new DERSequence(r101);
        this.signatureValue = new DERBitString(Arrays.clone(r102));
    }

    public static SignatureCheck getInstance(Object r100) {
        if ((r100 instanceof SignatureCheck) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SignatureCheck(ASN1Sequence.getInstance(r100));
    L5:
        return (SignatureCheck) r100;
    }

    public Certificate[] getCertificates() {
        ASN1Sequence r100 = this.certificates;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        Certificate[] r102 = new Certificate[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = Certificate.getInstance(this.certificates.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public ASN1BitString getSignature() {
        return new DERBitString(this.signatureValue.getBytes(), this.signatureValue.getPadBits());
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.signatureAlgorithm);
        ASN1Sequence r101 = this.certificates;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(0, r101));
    L5:
        r100.add(this.signatureValue);
        return new DERSequence(r100);
    }
}
