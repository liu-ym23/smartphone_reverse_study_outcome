package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CertStatus extends ASN1Object implements ASN1Choice {
    private int tagNo;
    private ASN1Encodable value;

    public CertStatus() {
        this.tagNo = 0;
        this.value = DERNull.INSTANCE;
    }

    public CertStatus(int r100, ASN1Encodable r101) {
        this.tagNo = r100;
        this.value = r101;
    }

    private CertStatus(ASN1TaggedObject r100) {
        this.tagNo = r100.getTagNo();
        int r101 = r100.getTagNo();
        if (r101 != 0) goto L5;
    L12:
        ASN1Encodable r102 = DERNull.INSTANCE;
    L13:
        this.value = r102;
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = RevokedInfo.getInstance(r100, false);
        goto L13
    L7:
        if (r101 == 2) goto L12;
        throw new IllegalArgumentException("Unknown tag encountered: " + r100.getTagNo());
    }

    public CertStatus(RevokedInfo r100) {
        this.tagNo = 1;
        this.value = r100;
    }

    public static CertStatus getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof CertStatus) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new CertStatus((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    L13:
        return (CertStatus) r100;
    }

    public static CertStatus getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public ASN1Encodable getStatus() {
        return this.value;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.value);
    }
}
