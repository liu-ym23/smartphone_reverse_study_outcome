package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class RsaKemParameters extends ASN1Object {
    private final AlgorithmIdentifier keyDerivationFunction;
    private final BigInteger keyLength;

    private RsaKemParameters(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.keyDerivationFunction = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.keyLength = ASN1Integer.getInstance(r100.getObjectAt(1)).getValue();
        return;
    L7:
        throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
    }

    public RsaKemParameters(AlgorithmIdentifier r100, int r101) {
        this.keyDerivationFunction = r100;
        this.keyLength = BigInteger.valueOf(r101);
    }

    public static RsaKemParameters getInstance(Object r100) {
        if ((r100 instanceof RsaKemParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RsaKemParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (RsaKemParameters) r100;
    }

    public AlgorithmIdentifier getKeyDerivationFunction() {
        return this.keyDerivationFunction;
    }

    public BigInteger getKeyLength() {
        return this.keyLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.keyDerivationFunction);
        r100.add(new ASN1Integer(this.keyLength));
        return new DERSequence(r100);
    }
}
