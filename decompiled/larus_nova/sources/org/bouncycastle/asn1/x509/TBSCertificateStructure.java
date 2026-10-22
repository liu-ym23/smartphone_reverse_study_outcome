package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class TBSCertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    Time endDate;
    X509Extensions extensions;
    X500Name issuer;
    DERBitString issuerUniqueId;
    ASN1Sequence seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    Time startDate;
    X500Name subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    DERBitString subjectUniqueId;
    ASN1Integer version;

    public TBSCertificateStructure(ASN1Sequence r100) {
        this.seq = r100;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == false) goto L5;
        this.version = ASN1Integer.getInstance((ASN1TaggedObject) r100.getObjectAt(0), true);
        int r101 = 0;
    L6:
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(r101 + 1));
        this.signature = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101 + 2));
        this.issuer = X500Name.getInstance(r100.getObjectAt(r101 + 3));
        ASN1Sequence r102 = (ASN1Sequence) r100.getObjectAt(r101 + 4);
        this.startDate = Time.getInstance(r102.getObjectAt(0));
        this.endDate = Time.getInstance(r102.getObjectAt(1));
        this.subject = X500Name.getInstance(r100.getObjectAt(r101 + 5));
        int r103 = r101 + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(r100.getObjectAt(r103));
        int r104 = (r100.size() - r103) - 1;
    L7:
        if (r104 <= 0) goto L19;
        ASN1TaggedObject r105 = ASN1TaggedObject.getInstance(r100.getObjectAt(r103 + r104));
        int r106 = r105.getTagNo();
        if (r106 != 1) goto L11;
        this.issuerUniqueId = DERBitString.getInstance(r105, false);
    L18:
        r104 = r104 - 1;
        goto L7
    L11:
        if (r106 != 2) goto L13;
        this.subjectUniqueId = DERBitString.getInstance(r105, false);
        goto L18
    L13:
        if (r106 != 3) goto L18;
        this.extensions = X509Extensions.getInstance(r105);
        goto L18
    L19:
        return;
    L5:
        this.version = new ASN1Integer(0);
        r101 = -1;
        goto L6
    }

    public static TBSCertificateStructure getInstance(Object r100) {
        if ((r100 instanceof TBSCertificateStructure) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TBSCertificateStructure(ASN1Sequence.getInstance(r100));
    L5:
        return (TBSCertificateStructure) r100;
    }

    public static TBSCertificateStructure getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getStartDate() {
        return this.startDate;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public DERBitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public int getVersion() {
        return this.version.intValueExact() + 1;
    }

    public ASN1Integer getVersionNumber() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
