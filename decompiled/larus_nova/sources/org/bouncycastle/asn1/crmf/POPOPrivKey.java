package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

/* JADX INFO: loaded from: classes42.dex */
public class POPOPrivKey extends ASN1Object implements ASN1Choice {
    public static final int agreeMAC = 3;
    public static final int dhMAC = 2;
    public static final int encryptedKey = 4;
    public static final int subsequentMessage = 1;
    public static final int thisMessage = 0;
    private ASN1Encodable obj;
    private int tagNo;

    private POPOPrivKey(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        this.tagNo = r101;
        if (r101 != 0) goto L5;
    L17:
        ASN1Encodable r102 = DERBitString.getInstance(r100, false);
    L18:
        this.obj = r102;
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = SubsequentMessage.valueOf(ASN1Integer.getInstance(r100, false).intValueExact());
        goto L18
    L7:
        if (r101 == 2) goto L17;
        if (r101 != 3) goto L11;
        r102 = PKMACValue.getInstance(r100, false);
        goto L18
    L11:
        if (r101 != 4) goto L14;
        r102 = EnvelopedData.getInstance(r100, false);
        goto L18
    L14:
        throw new IllegalArgumentException("unknown tag in POPOPrivKey");
    }

    public POPOPrivKey(PKMACValue r100) {
        this.tagNo = 3;
        this.obj = r100;
    }

    public POPOPrivKey(SubsequentMessage r100) {
        this.tagNo = 1;
        this.obj = r100;
    }

    public static POPOPrivKey getInstance(Object r100) {
        if ((r100 instanceof POPOPrivKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new POPOPrivKey(ASN1TaggedObject.getInstance(r100));
    L5:
        return (POPOPrivKey) r100;
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1TaggedObject.getInstance(r100, r101));
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.obj;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
