package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes42.dex */
public class CertTemplate extends ASN1Object {
    private Extensions extensions;
    private X500Name issuer;
    private DERBitString issuerUID;
    private SubjectPublicKeyInfo publicKey;
    private ASN1Sequence seq;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signingAlg;
    private X500Name subject;
    private DERBitString subjectUID;
    private OptionalValidity validity;
    private ASN1Integer version;

    private CertTemplate(ASN1Sequence r100) {
        this.seq = r100;
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L19;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        switch(r102.getTagNo()) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L8:
        throw new IllegalArgumentException("unknown tag: " + r102.getTagNo());
    L10:
        this.subjectUID = DERBitString.getInstance(r102, false);
        goto L4
    L11:
        this.issuerUID = DERBitString.getInstance(r102, false);
        goto L4
    L12:
        this.publicKey = SubjectPublicKeyInfo.getInstance(r102, false);
        goto L4
    L13:
        this.subject = X500Name.getInstance(r102, true);
        goto L4
    L14:
        this.validity = OptionalValidity.getInstance(ASN1Sequence.getInstance(r102, false));
        goto L4
    L15:
        this.issuer = X500Name.getInstance(r102, true);
        goto L4
    L16:
        this.signingAlg = AlgorithmIdentifier.getInstance(r102, false);
        goto L4
    L17:
        this.serialNumber = ASN1Integer.getInstance(r102, false);
        goto L4
    L18:
        this.version = ASN1Integer.getInstance(r102, false);
        goto L4
    L9:
        this.extensions = Extensions.getInstance(r102, false);
        goto L4
    }

    public static CertTemplate getInstance(Object r100) {
        if ((r100 instanceof CertTemplate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertTemplate(ASN1Sequence.getInstance(r100));
    L5:
        return (CertTemplate) r100;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUID() {
        return this.issuerUID;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.publicKey;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSigningAlg() {
        return this.signingAlg;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public DERBitString getSubjectUID() {
        return this.subjectUID;
    }

    public OptionalValidity getValidity() {
        return this.validity;
    }

    public int getVersion() {
        ASN1Integer r100 = this.version;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
