package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedKey extends ASN1Object implements ASN1Choice {
    private EncryptedValue encryptedValue;
    private EnvelopedData envelopedData;

    public EncryptedKey(EnvelopedData r100) {
        this.envelopedData = r100;
    }

    public EncryptedKey(EncryptedValue r100) {
        this.encryptedValue = r100;
    }

    public static EncryptedKey getInstance(Object r100) {
        if ((r100 instanceof EncryptedKey) == false) goto L7;
        return (EncryptedKey) r100;
    L7:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new EncryptedKey(EnvelopedData.getInstance((ASN1TaggedObject) r100, false));
    L11:
        if ((r100 instanceof EncryptedValue) == false) goto L15;
        return new EncryptedKey((EncryptedValue) r100);
    L15:
        return new EncryptedKey(EncryptedValue.getInstance(r100));
    }

    public ASN1Encodable getValue() {
        EncryptedValue r100 = this.encryptedValue;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.envelopedData;
    }

    public boolean isEncryptedValue() {
        if (this.encryptedValue == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        EncryptedValue r100 = this.encryptedValue;
        if (r100 == null) goto L7;
        return r100.toASN1Primitive();
    L7:
        return new DERTaggedObject(false, 0, this.envelopedData);
    }
}
