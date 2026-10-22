package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Name;

/* JADX INFO: loaded from: classes42.dex */
public class IssuerAndSerialNumber extends ASN1Object {
    private X500Name name;
    private ASN1Integer serialNumber;

    public IssuerAndSerialNumber(ASN1Sequence r100) {
        this.name = X500Name.getInstance(r100.getObjectAt(0));
        this.serialNumber = (ASN1Integer) r100.getObjectAt(1);
    }

    public IssuerAndSerialNumber(X500Name r100, BigInteger r101) {
        this.name = r100;
        this.serialNumber = new ASN1Integer(r101);
    }

    public IssuerAndSerialNumber(Certificate r100) {
        this.name = r100.getIssuer();
        this.serialNumber = r100.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509CertificateStructure r100) {
        this.name = r100.getIssuer();
        this.serialNumber = r100.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509Name r100, BigInteger r101) {
        this.name = X500Name.getInstance(r100);
        this.serialNumber = new ASN1Integer(r101);
    }

    public IssuerAndSerialNumber(X509Name r100, ASN1Integer r101) {
        this.name = X500Name.getInstance(r100);
        this.serialNumber = r101;
    }

    public static IssuerAndSerialNumber getInstance(Object r100) {
        if ((r100 instanceof IssuerAndSerialNumber) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IssuerAndSerialNumber(ASN1Sequence.getInstance(r100));
    L5:
        return (IssuerAndSerialNumber) r100;
    }

    public X500Name getName() {
        return this.name;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.name);
        r100.add(this.serialNumber);
        return new DERSequence(r100);
    }
}
