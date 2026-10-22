package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class OriginatorPublicKey extends ASN1Object {
    private AlgorithmIdentifier algorithm;
    private DERBitString publicKey;

    public OriginatorPublicKey(ASN1Sequence r100) {
        this.algorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.publicKey = (DERBitString) r100.getObjectAt(1);
    }

    public OriginatorPublicKey(AlgorithmIdentifier r100, byte[] r101) {
        this.algorithm = r100;
        this.publicKey = new DERBitString(r101);
    }

    public static OriginatorPublicKey getInstance(Object r100) {
        if ((r100 instanceof OriginatorPublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OriginatorPublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (OriginatorPublicKey) r100;
    }

    public static OriginatorPublicKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public DERBitString getPublicKey() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algorithm);
        r100.add(this.publicKey);
        return new DERSequence(r100);
    }
}
