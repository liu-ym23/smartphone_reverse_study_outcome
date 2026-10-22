package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SecretKeyData extends ASN1Object {
    private final ASN1ObjectIdentifier keyAlgorithm;
    private final ASN1OctetString keyBytes;

    public SecretKeyData(ASN1ObjectIdentifier r100, byte[] r101) {
        this.keyAlgorithm = r100;
        this.keyBytes = new DEROctetString(Arrays.clone(r101));
    }

    private SecretKeyData(ASN1Sequence r100) {
        this.keyAlgorithm = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.keyBytes = ASN1OctetString.getInstance(r100.getObjectAt(1));
    }

    public static SecretKeyData getInstance(Object r100) {
        if ((r100 instanceof SecretKeyData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SecretKeyData(ASN1Sequence.getInstance(r100));
    L5:
        return (SecretKeyData) r100;
    }

    public ASN1ObjectIdentifier getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public byte[] getKeyBytes() {
        return Arrays.clone(this.keyBytes.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.keyAlgorithm);
        r100.add(this.keyBytes);
        return new DERSequence(r100);
    }
}
