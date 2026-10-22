package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedPrivateKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private ASN1OctetString data;

    private EncryptedPrivateKeyInfo(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(r101.nextElement());
        this.data = ASN1OctetString.getInstance(r101.nextElement());
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier r100, byte[] r101) {
        this.algId = r100;
        this.data = new DEROctetString(r101);
    }

    public static EncryptedPrivateKeyInfo getInstance(Object r100) {
        if ((r100 instanceof EncryptedPrivateKeyInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedPrivateKeyInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedPrivateKeyInfo) r100;
    }

    public byte[] getEncryptedData() {
        return this.data.getOctets();
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.algId;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algId);
        r100.add(this.data);
        return new DERSequence(r100);
    }
}
