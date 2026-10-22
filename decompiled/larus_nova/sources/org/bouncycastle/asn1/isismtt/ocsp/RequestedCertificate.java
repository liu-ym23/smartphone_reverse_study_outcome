package org.bouncycastle.asn1.isismtt.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    public static final int attributeCertificate = 1;
    public static final int certificate = -1;
    public static final int publicKeyCertificate = 0;
    private byte[] attributeCert;
    private Certificate cert;
    private byte[] publicKeyCert;

    public RequestedCertificate(int r100, byte[] r101) {
        this(new DERTaggedObject(r100, new DEROctetString(r101)));
    }

    private RequestedCertificate(ASN1TaggedObject r100) {
        if (r100.getTagNo() != 0) goto L6;
        this.publicKeyCert = ASN1OctetString.getInstance(r100, true).getOctets();
        return;
    L6:
        if (r100.getTagNo() != 1) goto L10;
        this.attributeCert = ASN1OctetString.getInstance(r100, true).getOctets();
        return;
    L10:
        throw new IllegalArgumentException("unknown tag number: " + r100.getTagNo());
    }

    public RequestedCertificate(Certificate r100) {
        this.cert = r100;
    }

    public static RequestedCertificate getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof RequestedCertificate) == true) goto L17;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new RequestedCertificate(Certificate.getInstance(r100));
    L11:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L15;
        return new RequestedCertificate((ASN1TaggedObject) r100);
    L15:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L17:
        return (RequestedCertificate) r100;
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == false) goto L6;
        return getInstance(r100.getObject());
    L6:
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public byte[] getCertificateBytes() {
        Certificate r100 = this.cert;
        if (r100 != null) goto L15;
        byte[] r101 = this.publicKeyCert;
        if (r101 == null) goto L14;
        return Arrays.clone(r101);
    L14:
        return Arrays.clone(this.attributeCert);
    L15:
        return r100.getEncoded();
    L6:
        e = move-exception;
        throw new IllegalStateException("can't decode certificate: " + e);
    }

    public int getType() {
        if (this.cert == null) goto L7;
        return -1;
    L7:
        if (this.publicKeyCert == null) goto L10;
        return 0;
    L10:
        return 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        byte[] r100 = this.publicKeyCert;
        if (r100 != null) goto L5;
        byte[] r101 = this.attributeCert;
        if (r101 == null) goto L11;
        return new DERTaggedObject(1, new DEROctetString(r101));
    L11:
        return this.cert.toASN1Primitive();
    L5:
        return new DERTaggedObject(0, new DEROctetString(r100));
    }
}
