package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class TBSCertificate extends ASN1Object {
    Time endDate;
    Extensions extensions;
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

    private TBSCertificate(ASN1Sequence r100) {
        this.seq = r100;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == false) goto L5;
        this.version = ASN1Integer.getInstance((ASN1TaggedObject) r100.getObjectAt(0), true);
        int r101 = 0;
    L7:
        if (this.version.hasValue(BigInteger.valueOf(0)) == false) goto L11;
        boolean r102 = true;
    L9:
        boolean r103 = false;
    L16:
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(r101 + 1));
        this.signature = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101 + 2));
        this.issuer = X500Name.getInstance(r100.getObjectAt(r101 + 3));
        ASN1Sequence r104 = (ASN1Sequence) r100.getObjectAt(r101 + 4);
        this.startDate = Time.getInstance(r104.getObjectAt(0));
        this.endDate = Time.getInstance(r104.getObjectAt(1));
        this.subject = X500Name.getInstance(r100.getObjectAt(r101 + 5));
        int r105 = r101 + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(r100.getObjectAt(r105));
        int r106 = (r100.size() - r105) - 1;
        if (r106 == 0) goto L22;
        if (r102 == false) goto L22;
        throw new IllegalArgumentException("version 1 certificate contains extra data");
    L22:
        if (r106 <= 0) goto L38;
        ASN1TaggedObject r107 = (ASN1TaggedObject) r100.getObjectAt(r105 + r106);
        int r108 = r107.getTagNo();
        if (r108 != 1) goto L26;
        this.issuerUniqueId = DERBitString.getInstance(r107, false);
    L37:
        r106 = r106 - 1;
        goto L22
    L26:
        if (r108 != 2) goto L28;
        this.subjectUniqueId = DERBitString.getInstance(r107, false);
        goto L37
    L28:
        if (r108 != 3) goto L34;
        if (r103 == true) goto L32;
        this.extensions = Extensions.getInstance(ASN1Sequence.getInstance(r107, true));
        goto L37
    L32:
        throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
    L34:
        throw new IllegalArgumentException("Unknown tag encountered in structure: " + r107.getTagNo());
    L38:
        return;
    L11:
        if (this.version.hasValue(BigInteger.valueOf(1)) == false) goto L14;
        r102 = false;
        r103 = true;
        goto L16
    L14:
        if (this.version.hasValue(BigInteger.valueOf(2)) == false) goto L40;
        r102 = false;
        goto L9
    L40:
        throw new IllegalArgumentException("version number not recognised");
    L5:
        this.version = new ASN1Integer(0);
        r101 = -1;
        goto L7
    }

    public static TBSCertificate getInstance(Object r100) {
        if ((r100 instanceof TBSCertificate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TBSCertificate(ASN1Sequence.getInstance(r100));
    L5:
        return (TBSCertificate) r100;
    }

    public static TBSCertificate getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public Extensions getExtensions() {
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

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int getVersionNumber() {
        return this.version.intValueExact() + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (Properties.getPropertyValue("org.bouncycastle.x509.allow_non-der_tbscert") == null) goto L27;
        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_non-der_tbscert") == true) goto L7;
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        if (this.version.hasValue(BigIntegers.ZERO) == true) goto L11;
        r100.add(new DERTaggedObject(true, 0, this.version));
    L11:
        r100.add(this.serialNumber);
        r100.add(this.signature);
        r100.add(this.issuer);
        ASN1EncodableVector r101 = new ASN1EncodableVector(2);
        r101.add(this.startDate);
        r101.add(this.endDate);
        r100.add(new DERSequence(r101));
        ASN1Encodable r102 = this.subject;
        if (r102 != null) goto L15;
        r102 = new DERSequence();
    L15:
        r100.add(r102);
        r100.add(this.subjectPublicKeyInfo);
        DERBitString r103 = this.issuerUniqueId;
        if (r103 == null) goto L18;
        r100.add(new DERTaggedObject(false, 1, r103));
    L18:
        DERBitString r104 = this.subjectUniqueId;
        if (r104 == null) goto L21;
        r100.add(new DERTaggedObject(false, 2, r104));
    L21:
        Extensions r105 = this.extensions;
        if (r105 == null) goto L25;
        r100.add(new DERTaggedObject(true, 3, r105));
    L25:
        return new DERSequence(r100);
    L7:
        return this.seq;
    L27:
        return this.seq;
    }
}
