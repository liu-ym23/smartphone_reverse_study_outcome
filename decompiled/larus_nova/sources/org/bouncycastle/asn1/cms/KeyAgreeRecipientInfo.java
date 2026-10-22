package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class KeyAgreeRecipientInfo extends ASN1Object {
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private OriginatorIdentifierOrKey originator;
    private ASN1Sequence recipientEncryptedKeys;
    private ASN1OctetString ukm;
    private ASN1Integer version;

    public KeyAgreeRecipientInfo(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.originator = OriginatorIdentifierOrKey.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true);
        int r101 = 2;
        if ((r100.getObjectAt(2) instanceof ASN1TaggedObject) == false) goto L5;
        this.ukm = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(2), true);
        r101 = 3;
    L5:
        int r102 = r101 + 1;
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101));
        this.recipientEncryptedKeys = (ASN1Sequence) r100.getObjectAt(r102);
    }

    public KeyAgreeRecipientInfo(OriginatorIdentifierOrKey r100, ASN1OctetString r101, AlgorithmIdentifier r102, ASN1Sequence r103) {
        this.version = new ASN1Integer(3);
        this.originator = r100;
        this.ukm = r101;
        this.keyEncryptionAlgorithm = r102;
        this.recipientEncryptedKeys = r103;
    }

    public static KeyAgreeRecipientInfo getInstance(Object r100) {
        if ((r100 instanceof KeyAgreeRecipientInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeyAgreeRecipientInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (KeyAgreeRecipientInfo) r100;
    }

    public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public OriginatorIdentifierOrKey getOriginator() {
        return this.originator;
    }

    public ASN1Sequence getRecipientEncryptedKeys() {
        return this.recipientEncryptedKeys;
    }

    public ASN1OctetString getUserKeyingMaterial() {
        return this.ukm;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.version);
        r100.add(new DERTaggedObject(true, 0, this.originator));
        ASN1OctetString r101 = this.ukm;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 1, r101));
    L5:
        r100.add(this.keyEncryptionAlgorithm);
        r100.add(this.recipientEncryptedKeys);
        return new DERSequence(r100);
    }
}
