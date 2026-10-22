package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AttributeCertificate extends ASN1Object {
    AttributeCertificateInfo acinfo;
    AlgorithmIdentifier signatureAlgorithm;
    DERBitString signatureValue;

    public AttributeCertificate(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.acinfo = AttributeCertificateInfo.getInstance(r100.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.signatureValue = DERBitString.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public AttributeCertificate(AttributeCertificateInfo r100, AlgorithmIdentifier r101, DERBitString r102) {
        this.acinfo = r100;
        this.signatureAlgorithm = r101;
        this.signatureValue = r102;
    }

    public static AttributeCertificate getInstance(Object r100) {
        if ((r100 instanceof AttributeCertificate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AttributeCertificate(ASN1Sequence.getInstance(r100));
    L5:
        return (AttributeCertificate) r100;
    }

    public AttributeCertificateInfo getAcinfo() {
        return this.acinfo;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public DERBitString getSignatureValue() {
        return this.signatureValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.acinfo);
        r100.add(this.signatureAlgorithm);
        r100.add(this.signatureValue);
        return new DERSequence(r100);
    }
}
