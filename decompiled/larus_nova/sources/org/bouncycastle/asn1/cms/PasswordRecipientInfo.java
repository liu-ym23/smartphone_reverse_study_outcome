package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
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
public class PasswordRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    public PasswordRecipientInfo(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        if ((r100.getObjectAt(1) instanceof ASN1TaggedObject) == false) goto L5;
        this.keyDerivationAlgorithm = AlgorithmIdentifier.getInstance((ASN1TaggedObject) r100.getObjectAt(1), false);
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(2));
        ASN1Encodable r101 = r100.getObjectAt(3);
    L6:
        this.encryptedKey = (ASN1OctetString) r101;
        return;
    L5:
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        r101 = r100.getObjectAt(2);
        goto L6
    }

    public PasswordRecipientInfo(AlgorithmIdentifier r100, ASN1OctetString r101) {
        this.version = new ASN1Integer(0);
        this.keyEncryptionAlgorithm = r100;
        this.encryptedKey = r101;
    }

    public PasswordRecipientInfo(AlgorithmIdentifier r100, AlgorithmIdentifier r101, ASN1OctetString r102) {
        this.version = new ASN1Integer(0);
        this.keyDerivationAlgorithm = r100;
        this.keyEncryptionAlgorithm = r101;
        this.encryptedKey = r102;
    }

    public static PasswordRecipientInfo getInstance(Object r100) {
        if ((r100 instanceof PasswordRecipientInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PasswordRecipientInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PasswordRecipientInfo) r100;
    }

    public static PasswordRecipientInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
        return this.keyDerivationAlgorithm;
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
        AlgorithmIdentifier r101 = this.keyDerivationAlgorithm;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        r100.add(this.keyEncryptionAlgorithm);
        r100.add(this.encryptedKey);
        return new DERSequence(r100);
    }
}
