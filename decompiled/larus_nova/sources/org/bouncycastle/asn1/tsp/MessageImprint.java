package org.bouncycastle.asn1.tsp;

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
public class MessageImprint extends ASN1Object {
    AlgorithmIdentifier hashAlgorithm;
    byte[] hashedMessage;

    private MessageImprint(ASN1Sequence r100) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.hashedMessage = ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets();
    }

    public MessageImprint(AlgorithmIdentifier r100, byte[] r101) {
        this.hashAlgorithm = r100;
        this.hashedMessage = Arrays.clone(r101);
    }

    public static MessageImprint getInstance(Object r100) {
        if ((r100 instanceof MessageImprint) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MessageImprint(ASN1Sequence.getInstance(r100));
    L5:
        return (MessageImprint) r100;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getHashedMessage() {
        return Arrays.clone(this.hashedMessage);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.hashAlgorithm);
        r100.add(new DEROctetString(this.hashedMessage));
        return new DERSequence(r100);
    }
}
