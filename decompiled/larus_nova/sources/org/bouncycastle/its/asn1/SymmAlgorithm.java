package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class SymmAlgorithm extends ASN1Object {
    public static SymmAlgorithm aes128Ccm;
    private ASN1Enumerated symmAlgorithm;

    static {
        aes128Ccm = new SymmAlgorithm(new ASN1Enumerated(0));
    }

    public SymmAlgorithm(int r100) {
        this.symmAlgorithm = new ASN1Enumerated(r100);
    }

    private SymmAlgorithm(ASN1Enumerated r100) {
        this.symmAlgorithm = r100;
    }

    public SymmAlgorithm getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof SymmAlgorithm) == false) goto L10;
        return (SymmAlgorithm) r100;
    L10:
        return new SymmAlgorithm(ASN1Enumerated.getInstance(r100));
    }

    public ASN1Enumerated getSymmAlgorithm() {
        return this.symmAlgorithm;
    }

    public void setSymmAlgorithm(ASN1Enumerated r100) {
        this.symmAlgorithm = r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.symmAlgorithm.toASN1Primitive();
    }
}
