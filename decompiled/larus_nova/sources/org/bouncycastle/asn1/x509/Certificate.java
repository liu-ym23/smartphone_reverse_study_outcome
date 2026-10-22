package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class Certificate extends ASN1Object {
    ASN1Sequence seq;
    DERBitString sig;
    AlgorithmIdentifier sigAlgId;
    TBSCertificate tbsCert;

    private Certificate(ASN1Sequence r100) {
        this.seq = r100;
        if (r100.size() != 3) goto L7;
        this.tbsCert = TBSCertificate.getInstance(r100.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.sig = DERBitString.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public static Certificate getInstance(Object r100) {
        if ((r100 instanceof Certificate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Certificate(ASN1Sequence.getInstance(r100));
    L5:
        return (Certificate) r100;
    }

    public static Certificate getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Time getEndDate() {
        return this.tbsCert.getEndDate();
    }

    public X500Name getIssuer() {
        return this.tbsCert.getIssuer();
    }

    public ASN1Integer getSerialNumber() {
        return this.tbsCert.getSerialNumber();
    }

    public DERBitString getSignature() {
        return this.sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public Time getStartDate() {
        return this.tbsCert.getStartDate();
    }

    public X500Name getSubject() {
        return this.tbsCert.getSubject();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.tbsCert.getSubjectPublicKeyInfo();
    }

    public TBSCertificate getTBSCertificate() {
        return this.tbsCert;
    }

    public ASN1Integer getVersion() {
        return this.tbsCert.getVersion();
    }

    public int getVersionNumber() {
        return this.tbsCert.getVersionNumber();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
