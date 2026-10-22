package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateList extends ASN1Object {
    int hashCodeValue;
    boolean isHashCodeSet;
    DERBitString sig;
    AlgorithmIdentifier sigAlgId;
    TBSCertList tbsCertList;

    public CertificateList(ASN1Sequence r100) {
        this.isHashCodeSet = false;
        if (r100.size() != 3) goto L7;
        this.tbsCertList = TBSCertList.getInstance(r100.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.sig = DERBitString.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    public static CertificateList getInstance(Object r100) {
        if ((r100 instanceof CertificateList) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificateList(ASN1Sequence.getInstance(r100));
    L5:
        return (CertificateList) r100;
    }

    public static CertificateList getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public X500Name getIssuer() {
        return this.tbsCertList.getIssuer();
    }

    public Time getNextUpdate() {
        return this.tbsCertList.getNextUpdate();
    }

    public Enumeration getRevokedCertificateEnumeration() {
        return this.tbsCertList.getRevokedCertificateEnumeration();
    }

    public TBSCertList.CRLEntry[] getRevokedCertificates() {
        return this.tbsCertList.getRevokedCertificates();
    }

    public DERBitString getSignature() {
        return this.sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public TBSCertList getTBSCertList() {
        return this.tbsCertList;
    }

    public Time getThisUpdate() {
        return this.tbsCertList.getThisUpdate();
    }

    public int getVersionNumber() {
        return this.tbsCertList.getVersionNumber();
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeSet == true) goto L6;
        this.hashCodeValue = super.hashCode();
        this.isHashCodeSet = true;
    L6:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.tbsCertList);
        r100.add(this.sigAlgId);
        r100.add(this.sig);
        return new DERSequence(r100);
    }
}
