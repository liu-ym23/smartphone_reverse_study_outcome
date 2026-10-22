package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class X509Extensions extends ASN1Object {
    public static final ASN1ObjectIdentifier AuditIdentity = null;
    public static final ASN1ObjectIdentifier AuthorityInfoAccess = null;
    public static final ASN1ObjectIdentifier AuthorityKeyIdentifier = null;
    public static final ASN1ObjectIdentifier BasicConstraints = null;
    public static final ASN1ObjectIdentifier BiometricInfo = null;
    public static final ASN1ObjectIdentifier CRLDistributionPoints = null;
    public static final ASN1ObjectIdentifier CRLNumber = null;
    public static final ASN1ObjectIdentifier CertificateIssuer = null;
    public static final ASN1ObjectIdentifier CertificatePolicies = null;
    public static final ASN1ObjectIdentifier DeltaCRLIndicator = null;
    public static final ASN1ObjectIdentifier ExtendedKeyUsage = null;
    public static final ASN1ObjectIdentifier FreshestCRL = null;
    public static final ASN1ObjectIdentifier InhibitAnyPolicy = null;
    public static final ASN1ObjectIdentifier InstructionCode = null;
    public static final ASN1ObjectIdentifier InvalidityDate = null;
    public static final ASN1ObjectIdentifier IssuerAlternativeName = null;
    public static final ASN1ObjectIdentifier IssuingDistributionPoint = null;
    public static final ASN1ObjectIdentifier KeyUsage = null;
    public static final ASN1ObjectIdentifier LogoType = null;
    public static final ASN1ObjectIdentifier NameConstraints = null;
    public static final ASN1ObjectIdentifier NoRevAvail = null;
    public static final ASN1ObjectIdentifier PolicyConstraints = null;
    public static final ASN1ObjectIdentifier PolicyMappings = null;
    public static final ASN1ObjectIdentifier PrivateKeyUsagePeriod = null;
    public static final ASN1ObjectIdentifier QCStatements = null;
    public static final ASN1ObjectIdentifier ReasonCode = null;
    public static final ASN1ObjectIdentifier SubjectAlternativeName = null;
    public static final ASN1ObjectIdentifier SubjectDirectoryAttributes = null;
    public static final ASN1ObjectIdentifier SubjectInfoAccess = null;
    public static final ASN1ObjectIdentifier SubjectKeyIdentifier = null;
    public static final ASN1ObjectIdentifier TargetInformation = null;
    private Hashtable extensions;
    private Vector ordering;

    static {
        SubjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
        SubjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
        KeyUsage = new ASN1ObjectIdentifier("2.5.29.15");
        PrivateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
        SubjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
        IssuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
        BasicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
        CRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
        ReasonCode = new ASN1ObjectIdentifier("2.5.29.21");
        InstructionCode = new ASN1ObjectIdentifier("2.5.29.23");
        InvalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
        DeltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
        IssuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
        CertificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
        NameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
        CRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
        CertificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
        PolicyMappings = new ASN1ObjectIdentifier("2.5.29.33");
        AuthorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
        PolicyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
        ExtendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
        FreshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
        InhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
        AuthorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        SubjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        LogoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        BiometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        QCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        AuditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        NoRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
        TargetInformation = new ASN1ObjectIdentifier("2.5.29.55");
    }

    public X509Extensions(Hashtable r100) {
        this(null, r100);
    }

    public X509Extensions(Vector r100, Hashtable r101) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        if (r100 != null) goto L5;
        Enumeration r102 = r101.keys();
    L7:
        if (r102.hasMoreElements() == false) goto L9;
        this.ordering.addElement(ASN1ObjectIdentifier.getInstance(r102.nextElement()));
        goto L7
    L9:
        Enumeration r103 = this.ordering.elements();
    L11:
        if (r103.hasMoreElements() == false) goto L13;
        ASN1ObjectIdentifier r104 = ASN1ObjectIdentifier.getInstance(r103.nextElement());
        X509Extension r105 = (X509Extension) r101.get(r104);
        this.extensions.put(r104, r105);
        goto L11
    L13:
        return;
    L5:
        r102 = r100.elements();
        goto L7
    }

    public X509Extensions(Vector r100, Vector r101) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        Enumeration r102 = r100.elements();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        this.ordering.addElement(r102.nextElement());
        goto L4
    L6:
        Enumeration r103 = this.ordering.elements();
        int r104 = 0;
    L8:
        if (r103.hasMoreElements() == false) goto L10;
        ASN1ObjectIdentifier r105 = (ASN1ObjectIdentifier) r103.nextElement();
        X509Extension r106 = (X509Extension) r101.elementAt(r104);
        this.extensions.put(r105, r106);
        r104 = r104 + 1;
        goto L8
    }

    public X509Extensions(ASN1Sequence r100) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L14;
        ASN1Sequence r102 = ASN1Sequence.getInstance(r101.nextElement());
        if (r102.size() != 3) goto L9;
        this.extensions.put(r102.getObjectAt(0), new X509Extension(ASN1Boolean.getInstance(r102.getObjectAt(1)), ASN1OctetString.getInstance(r102.getObjectAt(2))));
    L11:
        this.ordering.addElement(r102.getObjectAt(0));
        goto L4
    L9:
        if (r102.size() != 2) goto L13;
        this.extensions.put(r102.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(r102.getObjectAt(1))));
        goto L11
    L13:
        throw new IllegalArgumentException("Bad sequence size: " + r102.size());
    }

    private ASN1ObjectIdentifier[] getExtensionOIDs(boolean r100) {
        Vector r101 = new Vector();
        int r102 = 0;
    L4:
        if (r102 == this.ordering.size()) goto L10;
        Object r103 = this.ordering.elementAt(r102);
        if (((X509Extension) this.extensions.get(r103)).isCritical() != r100) goto L8;
        r101.addElement(r103);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return toOidArray(r101);
    }

    public static X509Extensions getInstance(Object r100) {
        if (r100 == null) goto L21;
        if ((r100 instanceof X509Extensions) == true) goto L21;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new X509Extensions((ASN1Sequence) r100);
    L11:
        if ((r100 instanceof Extensions) == false) goto L15;
        return new X509Extensions((ASN1Sequence) ((Extensions) r100).toASN1Primitive());
    L15:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L19;
        return getInstance(((ASN1TaggedObject) r100).getObject());
    L19:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L21:
        return (X509Extensions) r100;
    }

    public static X509Extensions getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private ASN1ObjectIdentifier[] toOidArray(Vector r100) {
        int r101 = r100.size();
        ASN1ObjectIdentifier[] r102 = new ASN1ObjectIdentifier[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (ASN1ObjectIdentifier) r100.elementAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public boolean equivalent(X509Extensions r100) {
        if (this.extensions.size() == r100.extensions.size()) goto L5;
        return false;
    L5:
        Enumeration r101 = this.extensions.keys();
    L7:
        if (r101.hasMoreElements() == false) goto L11;
        Object r102 = r101.nextElement();
        if (this.extensions.get(r102).equals(r100.extensions.get(r102)) == true) goto L7;
        return false;
    L11:
        return true;
    }

    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public X509Extension getExtension(ASN1ObjectIdentifier r100) {
        return (X509Extension) this.extensions.get(r100);
    }

    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        return toOidArray(this.ordering);
    }

    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public Enumeration oids() {
        return this.ordering.elements();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.ordering.size());
        Enumeration r101 = this.ordering.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L10;
        ASN1EncodableVector r102 = new ASN1EncodableVector(3);
        ASN1ObjectIdentifier r103 = (ASN1ObjectIdentifier) r101.nextElement();
        X509Extension r104 = (X509Extension) this.extensions.get(r103);
        r102.add(r103);
        if (r104.isCritical() == false) goto L8;
        r102.add(ASN1Boolean.TRUE);
    L8:
        r102.add(r104.getValue());
        r100.add(new DERSequence(r102));
        goto L4
    L10:
        return new DERSequence(r100);
    }
}
