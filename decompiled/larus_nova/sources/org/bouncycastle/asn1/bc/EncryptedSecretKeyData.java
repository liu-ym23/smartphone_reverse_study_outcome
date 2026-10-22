package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedSecretKeyData extends ASN1Object {
    private final ASN1OctetString encryptedKeyData;
    private final AlgorithmIdentifier keyEncryptionAlgorithm;

    private EncryptedSecretKeyData(ASN1Sequence r100) {
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.encryptedKeyData = ASN1OctetString.getInstance(r100.getObjectAt(1));
    }

    public EncryptedSecretKeyData(AlgorithmIdentifier r100, byte[] r101) {
        this.keyEncryptionAlgorithm = r100;
        this.encryptedKeyData = new DEROctetString(Arrays.clone(r101));
    }

    public static EncryptedSecretKeyData getInstance(Object r100) {
        if ((r100 instanceof EncryptedSecretKeyData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedSecretKeyData(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedSecretKeyData) r100;
    }

    public byte[] getEncryptedKeyData() {
        return Arrays.clone(this.encryptedKeyData.getOctets());
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.keyEncryptionAlgorithm);
        r100.add(this.encryptedKeyData);
        return new DERSequence(r100);
    }
}
