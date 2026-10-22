package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class GenericHybridParameters extends ASN1Object {
    private final AlgorithmIdentifier dem;
    private final AlgorithmIdentifier kem;

    private GenericHybridParameters(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.kem = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.dem = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
    }

    public GenericHybridParameters(AlgorithmIdentifier r100, AlgorithmIdentifier r101) {
        this.kem = r100;
        this.dem = r101;
    }

    public static GenericHybridParameters getInstance(Object r100) {
        if ((r100 instanceof GenericHybridParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GenericHybridParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (GenericHybridParameters) r100;
    }

    public AlgorithmIdentifier getDem() {
        return this.dem;
    }

    public AlgorithmIdentifier getKem() {
        return this.kem;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.kem);
        r100.add(this.dem);
        return new DERSequence(r100);
    }
}
