package org.bouncycastle.asn1.mozilla;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class SignedPublicKeyAndChallenge extends ASN1Object {
    private final ASN1Sequence pkacSeq;
    private final PublicKeyAndChallenge pubKeyAndChal;

    private SignedPublicKeyAndChallenge(ASN1Sequence r100) {
        this.pkacSeq = r100;
        this.pubKeyAndChal = PublicKeyAndChallenge.getInstance(r100.getObjectAt(0));
    }

    public static SignedPublicKeyAndChallenge getInstance(Object r100) {
        if ((r100 instanceof SignedPublicKeyAndChallenge) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SignedPublicKeyAndChallenge(ASN1Sequence.getInstance(r100));
    L5:
        return (SignedPublicKeyAndChallenge) r100;
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.pubKeyAndChal;
    }

    public DERBitString getSignature() {
        return DERBitString.getInstance(this.pkacSeq.getObjectAt(2));
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.pkacSeq.getObjectAt(1));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.pkacSeq;
    }
}
