package org.bouncycastle.asn1.cmp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;

/* JADX INFO: loaded from: classes42.dex */
public class CMPCertificate extends ASN1Object implements ASN1Choice {
    private ASN1Object otherCert;
    private int otherTagValue;
    private Certificate x509v3PKCert;

    public CMPCertificate(int r100, ASN1Object r101) {
        this.otherTagValue = r100;
        this.otherCert = r101;
    }

    public CMPCertificate(AttributeCertificate r100) {
        this(1, r100);
    }

    public CMPCertificate(Certificate r100) {
        if (r100.getVersionNumber() != 3) goto L7;
        this.x509v3PKCert = r100;
        return;
    L7:
        throw new IllegalArgumentException("only version 3 certificates allowed");
    }

    public static CMPCertificate getInstance(Object r100) {
        if (r100 == null) goto L23;
        if ((r100 instanceof CMPCertificate) == true) goto L23;
        if ((r100 instanceof byte[]) == false) goto L13;
        r100 = ASN1Primitive.fromByteArray((byte[]) r100);     // Catch: IOException -> L10
    L11:
        throw new IllegalArgumentException("Invalid encoding in CMPCertificate");
    L13:
        if ((r100 instanceof ASN1Sequence) == false) goto L17;
        return new CMPCertificate(Certificate.getInstance(r100));
    L17:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L21;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        return new CMPCertificate(r101.getTagNo(), r101.getObject());
    L21:
        throw new IllegalArgumentException("Invalid object: ".concat(r100.getClass().getName()));
    L23:
        return (CMPCertificate) r100;
    }

    public ASN1Object getOtherCert() {
        return this.otherCert;
    }

    public int getOtherCertTag() {
        return this.otherTagValue;
    }

    public AttributeCertificate getX509v2AttrCert() {
        return AttributeCertificate.getInstance(this.otherCert);
    }

    public Certificate getX509v3PKCert() {
        return this.x509v3PKCert;
    }

    public boolean isX509v3PKCert() {
        if (this.x509v3PKCert == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Object r100 = this.otherCert;
        if (r100 == null) goto L7;
        return new DERTaggedObject(true, this.otherTagValue, r100);
    L7:
        return this.x509v3PKCert.toASN1Primitive();
    }
}
