package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;

/* JADX INFO: loaded from: classes42.dex */
public class CertificationRequestInfo extends ASN1Object {
    ASN1Set attributes;
    X500Name subject;
    SubjectPublicKeyInfo subjectPKInfo;
    ASN1Integer version;

    public CertificationRequestInfo(ASN1Sequence r100) {
        this.version = new ASN1Integer(0);
        this.attributes = null;
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.subject = X500Name.getInstance(r100.getObjectAt(1));
        this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(r100.getObjectAt(2));
        if (r100.size() <= 3) goto L5;
        this.attributes = ASN1Set.getInstance((ASN1TaggedObject) r100.getObjectAt(3), false);
    L5:
        validateAttributes(this.attributes);
        if (this.subject == null) goto L13;
        if (this.version == null) goto L13;
        if (this.subjectPKInfo == null) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
    }

    public CertificationRequestInfo(X500Name r100, SubjectPublicKeyInfo r101, ASN1Set r102) {
        this.version = new ASN1Integer(0);
        this.attributes = null;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        validateAttributes(r102);
        this.subject = r100;
        this.subjectPKInfo = r101;
        this.attributes = r102;
        return;
    L8:
        throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
    }

    public CertificationRequestInfo(X509Name r100, SubjectPublicKeyInfo r101, ASN1Set r102) {
        this(X500Name.getInstance(r100.toASN1Primitive()), r101, r102);
    }

    public static CertificationRequestInfo getInstance(Object r100) {
        if ((r100 instanceof CertificationRequestInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificationRequestInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (CertificationRequestInfo) r100;
    }

    private static void validateAttributes(ASN1Set r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Enumeration r101 = r100.getObjects();
    L6:
        if (r101.hasMoreElements() == false) goto L14;
        Attribute r102 = Attribute.getInstance(r101.nextElement());
        if (r102.getAttrType().equals(PKCSObjectIdentifiers.pkcs_9_at_challengePassword) == false) goto L6;
        if (r102.getAttrValues().size() == 1) goto L6;
        throw new IllegalArgumentException("challengePassword attribute must have one value");
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPKInfo;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.version);
        r100.add(this.subject);
        r100.add(this.subjectPKInfo);
        ASN1Set r101 = this.attributes;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(false, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
