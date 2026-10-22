package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class Signature extends ASN1Object {
    ASN1Sequence certs;
    DERBitString signature;
    AlgorithmIdentifier signatureAlgorithm;

    private Signature(ASN1Sequence r100) {
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.signature = (DERBitString) r100.getObjectAt(1);
        if (r100.size() != 3) goto L6;
        this.certs = ASN1Sequence.getInstance((ASN1TaggedObject) r100.getObjectAt(2), true);
        return;
    }

    public Signature(AlgorithmIdentifier r100, DERBitString r101) {
        this.signatureAlgorithm = r100;
        this.signature = r101;
    }

    public Signature(AlgorithmIdentifier r100, DERBitString r101, ASN1Sequence r102) {
        this.signatureAlgorithm = r100;
        this.signature = r101;
        this.certs = r102;
    }

    public static Signature getInstance(Object r100) {
        if ((r100 instanceof Signature) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Signature(ASN1Sequence.getInstance(r100));
    L5:
        return (Signature) r100;
    }

    public static Signature getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Sequence getCerts() {
        return this.certs;
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.signatureAlgorithm);
        r100.add(this.signature);
        ASN1Sequence r101 = this.certs;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
