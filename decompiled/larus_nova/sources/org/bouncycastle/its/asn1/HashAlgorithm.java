package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class HashAlgorithm {
    public static final HashAlgorithm sha256 = null;
    public static final HashAlgorithm sha384 = null;
    private final ASN1Enumerated enumerated;

    static {
        sha256 = new HashAlgorithm(0);
        sha384 = new HashAlgorithm(1);
    }

    public HashAlgorithm(int r100) {
        this.enumerated = new ASN1Enumerated(r100);
    }

    private HashAlgorithm(ASN1Enumerated r100) {
        this.enumerated = r100;
    }

    public HashAlgorithm getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof HashAlgorithm) == false) goto L10;
        return (HashAlgorithm) r100;
    L10:
        return new HashAlgorithm(ASN1Enumerated.getInstance(r100));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.enumerated;
    }
}
