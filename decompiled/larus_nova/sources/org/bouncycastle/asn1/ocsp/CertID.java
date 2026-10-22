package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CertID extends ASN1Object {
    AlgorithmIdentifier hashAlgorithm;
    ASN1OctetString issuerKeyHash;
    ASN1OctetString issuerNameHash;
    ASN1Integer serialNumber;

    private CertID(ASN1Sequence r100) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.issuerNameHash = (ASN1OctetString) r100.getObjectAt(1);
        this.issuerKeyHash = (ASN1OctetString) r100.getObjectAt(2);
        this.serialNumber = (ASN1Integer) r100.getObjectAt(3);
    }

    public CertID(AlgorithmIdentifier r100, ASN1OctetString r101, ASN1OctetString r102, ASN1Integer r103) {
        this.hashAlgorithm = r100;
        this.issuerNameHash = r101;
        this.issuerKeyHash = r102;
        this.serialNumber = r103;
    }

    public static CertID getInstance(Object r100) {
        if ((r100 instanceof CertID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertID(ASN1Sequence.getInstance(r100));
    L5:
        return (CertID) r100;
    }

    public static CertID getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getIssuerKeyHash() {
        return this.issuerKeyHash;
    }

    public ASN1OctetString getIssuerNameHash() {
        return this.issuerNameHash;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.hashAlgorithm);
        r100.add(this.issuerNameHash);
        r100.add(this.issuerKeyHash);
        r100.add(this.serialNumber);
        return new DERSequence(r100);
    }
}
