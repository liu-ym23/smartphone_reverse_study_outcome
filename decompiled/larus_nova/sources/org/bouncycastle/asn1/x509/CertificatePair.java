package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CertificatePair extends ASN1Object {
    private Certificate forward;
    private Certificate reverse;

    private CertificatePair(ASN1Sequence r100) {
        if (r100.size() != 1) goto L5;
    L9:
        Enumeration r101 = r100.getObjects();
    L11:
        if (r101.hasMoreElements() == false) goto L20;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        if (r102.getTagNo() == 0) goto L14;
        if (r102.getTagNo() != 1) goto L19;
        this.reverse = Certificate.getInstance(r102, true);
        goto L11
    L19:
        throw new IllegalArgumentException("Bad tag number: " + r102.getTagNo());
    L14:
        this.forward = Certificate.getInstance(r102, true);
        goto L11
    L20:
        return;
    L5:
        if (r100.size() == 2) goto L9;
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public CertificatePair(Certificate r100, Certificate r101) {
        this.forward = r100;
        this.reverse = r101;
    }

    public static CertificatePair getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof CertificatePair) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new CertificatePair((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (CertificatePair) r100;
    }

    public Certificate getForward() {
        return this.forward;
    }

    public Certificate getReverse() {
        return this.reverse;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        Certificate r101 = this.forward;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(0, r101));
    L5:
        Certificate r102 = this.reverse;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(1, r102));
    L9:
        return new DERSequence(r100);
    }
}
