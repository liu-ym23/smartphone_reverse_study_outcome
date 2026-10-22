package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateType {
    public static final CertificateType Explicit = null;
    public static final CertificateType Implicit = null;
    private final ASN1Enumerated enumerated;

    static {
        Explicit = new CertificateType(0);
        Implicit = new CertificateType(1);
    }

    public CertificateType(int r100) {
        this.enumerated = new ASN1Enumerated(r100);
    }

    private CertificateType(ASN1Enumerated r100) {
        this.enumerated = r100;
    }

    public CertificateType getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof CertificateType) == false) goto L10;
        return (CertificateType) r100;
    L10:
        return new CertificateType(ASN1Enumerated.getInstance(r100));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.enumerated;
    }
}
