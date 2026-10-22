package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

/* JADX INFO: loaded from: classes42.dex */
public class PKIConfirmContent extends ASN1Object {
    private ASN1Null val;

    public PKIConfirmContent() {
        this.val = DERNull.INSTANCE;
    }

    private PKIConfirmContent(ASN1Null r100) {
        this.val = r100;
    }

    public static PKIConfirmContent getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof PKIConfirmContent) == true) goto L13;
        if ((r100 instanceof ASN1Null) == false) goto L11;
        return new PKIConfirmContent((ASN1Null) r100);
    L11:
        throw new IllegalArgumentException("Invalid object: ".concat(r100.getClass().getName()));
    L13:
        return (PKIConfirmContent) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.val;
    }
}
