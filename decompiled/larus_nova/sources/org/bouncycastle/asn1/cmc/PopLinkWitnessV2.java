package org.bouncycastle.asn1.cmc;

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
public class PopLinkWitnessV2 extends ASN1Object {
    private final AlgorithmIdentifier keyGenAlgorithm;
    private final AlgorithmIdentifier macAlgorithm;
    private final byte[] witness;

    private PopLinkWitnessV2(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.keyGenAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.macAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.witness = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public PopLinkWitnessV2(AlgorithmIdentifier r100, AlgorithmIdentifier r101, byte[] r102) {
        this.keyGenAlgorithm = r100;
        this.macAlgorithm = r101;
        this.witness = Arrays.clone(r102);
    }

    public static PopLinkWitnessV2 getInstance(Object r100) {
        if ((r100 instanceof PopLinkWitnessV2) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PopLinkWitnessV2(ASN1Sequence.getInstance(r100));
    L5:
        return (PopLinkWitnessV2) r100;
    }

    public AlgorithmIdentifier getKeyGenAlgorithm() {
        return this.keyGenAlgorithm;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.keyGenAlgorithm);
        r100.add(this.macAlgorithm);
        r100.add(new DEROctetString(getWitness()));
        return new DERSequence(r100);
    }
}
