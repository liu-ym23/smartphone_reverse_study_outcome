package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class KeyAgreeRecipientIdentifier extends ASN1Object implements ASN1Choice {
    private IssuerAndSerialNumber issuerSerial;
    private RecipientKeyIdentifier rKeyID;

    public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber r100) {
        this.issuerSerial = r100;
        this.rKeyID = null;
    }

    public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier r100) {
        this.issuerSerial = null;
        this.rKeyID = r100;
    }

    public static KeyAgreeRecipientIdentifier getInstance(Object r100) {
        if (r100 == null) goto L19;
        if ((r100 instanceof KeyAgreeRecipientIdentifier) == true) goto L19;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(r100));
    L11:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L17;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        if (r101.getTagNo() != 0) goto L17;
        return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance(r101, false));
    L17:
        throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier: ".concat(r100.getClass().getName()));
    L19:
        return (KeyAgreeRecipientIdentifier) r100;
    }

    public static KeyAgreeRecipientIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerSerial;
    }

    public RecipientKeyIdentifier getRKeyID() {
        return this.rKeyID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        IssuerAndSerialNumber r100 = this.issuerSerial;
        if (r100 == null) goto L7;
        return r100.toASN1Primitive();
    L7:
        return new DERTaggedObject(false, 0, this.rKeyID);
    }
}
