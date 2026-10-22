package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CertificationRequest extends ASN1Object {
    protected CertificationRequestInfo reqInfo;
    protected AlgorithmIdentifier sigAlgId;
    protected DERBitString sigBits;

    public CertificationRequest() {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
    }

    public CertificationRequest(ASN1Sequence r100) {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
        this.reqInfo = CertificationRequestInfo.getInstance(r100.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.sigBits = (DERBitString) r100.getObjectAt(2);
    }

    public CertificationRequest(CertificationRequestInfo r100, AlgorithmIdentifier r101, DERBitString r102) {
        this.reqInfo = r100;
        this.sigAlgId = r101;
        this.sigBits = r102;
    }

    public static CertificationRequest getInstance(Object r100) {
        if ((r100 instanceof CertificationRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificationRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (CertificationRequest) r100;
    }

    public CertificationRequestInfo getCertificationRequestInfo() {
        return this.reqInfo;
    }

    public DERBitString getSignature() {
        return this.sigBits;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.reqInfo);
        r100.add(this.sigAlgId);
        r100.add(this.sigBits);
        return new DERSequence(r100);
    }
}
