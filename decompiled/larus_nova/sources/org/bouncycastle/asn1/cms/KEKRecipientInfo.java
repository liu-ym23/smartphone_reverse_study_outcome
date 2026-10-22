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
public class KEKRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KEKIdentifier kekid;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    public KEKRecipientInfo(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        this.kekid = KEKIdentifier.getInstance(r100.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(2));
        this.encryptedKey = (ASN1OctetString) r100.getObjectAt(3);
    }

    public KEKRecipientInfo(KEKIdentifier r100, AlgorithmIdentifier r101, ASN1OctetString r102) {
        this.version = new ASN1Integer(4);
        this.kekid = r100;
        this.keyEncryptionAlgorithm = r101;
        this.encryptedKey = r102;
    }

    public static KEKRecipientInfo getInstance(Object r100) {
        if ((r100 instanceof KEKRecipientInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KEKRecipientInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (KEKRecipientInfo) r100;
    }

    public static KEKRecipientInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KEKIdentifier getKekid() {
        return this.kekid;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.version);
        r100.add(this.kekid);
        r100.add(this.keyEncryptionAlgorithm);
        r100.add(this.encryptedKey);
        return new DERSequence(r100);
    }
}
