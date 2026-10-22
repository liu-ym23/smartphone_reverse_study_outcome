package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class KeyTransRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private RecipientIdentifier rid;
    private ASN1Integer version;

    public KeyTransRecipientInfo(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.rid = RecipientIdentifier.getInstance(r100.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(2));
        this.encryptedKey = (ASN1OctetString) r100.getObjectAt(3);
    }

    public KeyTransRecipientInfo(RecipientIdentifier r100, AlgorithmIdentifier r101, ASN1OctetString r102) {
        if ((r100.toASN1Primitive() instanceof ASN1TaggedObject) == false) goto L5;
        ASN1Integer r103 = new ASN1Integer(2);
    L6:
        this.version = r103;
        this.rid = r100;
        this.keyEncryptionAlgorithm = r101;
        this.encryptedKey = r102;
        return;
    L5:
        r103 = new ASN1Integer(0);
        goto L6
    }

    public static KeyTransRecipientInfo getInstance(Object r100) {
        if ((r100 instanceof KeyTransRecipientInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeyTransRecipientInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (KeyTransRecipientInfo) r100;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.rid;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.version);
        r100.add(this.rid);
        r100.add(this.keyEncryptionAlgorithm);
        r100.add(this.encryptedKey);
        return new DERSequence(r100);
    }
}
