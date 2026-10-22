package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class CRLNumber extends ASN1Object {
    private BigInteger number;

    public CRLNumber(BigInteger r100) {
        this.number = r100;
    }

    public static CRLNumber getInstance(Object r100) {
        if ((r100 instanceof CRLNumber) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CRLNumber(ASN1Integer.getInstance(r100).getValue());
    L5:
        return (CRLNumber) r100;
    }

    public BigInteger getCRLNumber() {
        return this.number;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.number);
    }

    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
