package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedObjectStoreData extends ASN1Object {
    private final ASN1OctetString encryptedContent;
    private final AlgorithmIdentifier encryptionAlgorithm;

    private EncryptedObjectStoreData(ASN1Sequence r100) {
        this.encryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.encryptedContent = ASN1OctetString.getInstance(r100.getObjectAt(1));
    }

    public EncryptedObjectStoreData(AlgorithmIdentifier r100, byte[] r101) {
        this.encryptionAlgorithm = r100;
        this.encryptedContent = new DEROctetString(r101);
    }

    public static EncryptedObjectStoreData getInstance(Object r100) {
        if ((r100 instanceof EncryptedObjectStoreData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedObjectStoreData(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedObjectStoreData) r100;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.encryptionAlgorithm);
        r100.add(this.encryptedContent);
        return new DERSequence(r100);
    }
}
