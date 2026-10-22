package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class RecipientEncryptedKey extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientIdentifier identifier;

    private RecipientEncryptedKey(ASN1Sequence r100) {
        this.identifier = KeyAgreeRecipientIdentifier.getInstance(r100.getObjectAt(0));
        this.encryptedKey = (ASN1OctetString) r100.getObjectAt(1);
    }

    public RecipientEncryptedKey(KeyAgreeRecipientIdentifier r100, ASN1OctetString r101) {
        this.identifier = r100;
        this.encryptedKey = r101;
    }

    public static RecipientEncryptedKey getInstance(Object r100) {
        if ((r100 instanceof RecipientEncryptedKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RecipientEncryptedKey(ASN1Sequence.getInstance(r100));
    L5:
        return (RecipientEncryptedKey) r100;
    }

    public static RecipientEncryptedKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KeyAgreeRecipientIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.identifier);
        r100.add(this.encryptedKey);
        return new DERSequence(r100);
    }
}
