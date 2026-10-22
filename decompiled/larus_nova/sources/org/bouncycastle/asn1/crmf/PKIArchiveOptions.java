package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    private ASN1Encodable value;

    public PKIArchiveOptions(ASN1OctetString r100) {
        this.value = r100;
    }

    private PKIArchiveOptions(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        if (r101 != 0) goto L5;
        ASN1Encodable r102 = EncryptedKey.getInstance(r100.getObject());
    L13:
        this.value = r102;
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = ASN1OctetString.getInstance(r100, false);
        goto L13
    L7:
        if (r101 != 2) goto L10;
        r102 = ASN1Boolean.getInstance(r100, false);
        goto L13
    L10:
        throw new IllegalArgumentException("unknown tag number: " + r100.getTagNo());
    }

    public PKIArchiveOptions(EncryptedKey r100) {
        this.value = r100;
    }

    public PKIArchiveOptions(boolean r100) {
        this.value = ASN1Boolean.getInstance(r100);
    }

    public static PKIArchiveOptions getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof PKIArchiveOptions) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new PKIArchiveOptions((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("unknown object: " + r100);
    L13:
        return (PKIArchiveOptions) r100;
    }

    public int getType() {
        ASN1Encodable r100 = this.value;
        if ((r100 instanceof EncryptedKey) == false) goto L7;
        return 0;
    L7:
        if ((r100 instanceof ASN1OctetString) == false) goto L10;
        return 1;
    L10:
        return 2;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable r100 = this.value;
        if ((r100 instanceof EncryptedKey) == false) goto L7;
        return new DERTaggedObject(true, 0, r100);
    L7:
        if ((r100 instanceof ASN1OctetString) == false) goto L11;
        return new DERTaggedObject(false, 1, r100);
    L11:
        return new DERTaggedObject(false, 2, r100);
    }
}
