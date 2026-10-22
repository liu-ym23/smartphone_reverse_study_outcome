package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class OOBCertHash extends ASN1Object {
    private CertId certId;
    private AlgorithmIdentifier hashAlg;
    private DERBitString hashVal;

    private OOBCertHash(ASN1Sequence r100) {
        int r101 = r100.size() - 1;
        int r102 = r101 - 1;
        this.hashVal = DERBitString.getInstance(r100.getObjectAt(r101));
    L3:
        if (r102 < 0) goto L9;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r100.getObjectAt(r102);
        if (r103.getTagNo() != 0) goto L7;
        this.hashAlg = AlgorithmIdentifier.getInstance(r103, true);
    L8:
        r102 = r102 - 1;
        goto L3
    L7:
        this.certId = CertId.getInstance(r103, true);
        goto L8
    }

    public OOBCertHash(AlgorithmIdentifier r100, CertId r101, DERBitString r102) {
        this.hashAlg = r100;
        this.certId = r101;
        this.hashVal = r102;
    }

    public OOBCertHash(AlgorithmIdentifier r100, CertId r101, byte[] r102) {
        this(r100, r101, new DERBitString(r102));
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(true, r101, r102));
        return;
    }

    public static OOBCertHash getInstance(Object r100) {
        if ((r100 instanceof OOBCertHash) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OOBCertHash(ASN1Sequence.getInstance(r100));
    L5:
        return (OOBCertHash) r100;
    }

    public CertId getCertId() {
        return this.certId;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public DERBitString getHashVal() {
        return this.hashVal;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        addOptional(r100, 0, this.hashAlg);
        addOptional(r100, 1, this.certId);
        r100.add(this.hashVal);
        return new DERSequence(r100);
    }
}
