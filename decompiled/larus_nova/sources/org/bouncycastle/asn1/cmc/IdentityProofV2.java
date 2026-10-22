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
public class IdentityProofV2 extends ASN1Object {
    private final AlgorithmIdentifier macAlgId;
    private final AlgorithmIdentifier proofAlgID;
    private final byte[] witness;

    private IdentityProofV2(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.proofAlgID = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.macAlgId = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.witness = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public IdentityProofV2(AlgorithmIdentifier r100, AlgorithmIdentifier r101, byte[] r102) {
        this.proofAlgID = r100;
        this.macAlgId = r101;
        this.witness = Arrays.clone(r102);
    }

    public static IdentityProofV2 getInstance(Object r100) {
        if ((r100 instanceof IdentityProofV2) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IdentityProofV2(ASN1Sequence.getInstance(r100));
    L5:
        return (IdentityProofV2) r100;
    }

    public AlgorithmIdentifier getMacAlgId() {
        return this.macAlgId;
    }

    public AlgorithmIdentifier getProofAlgID() {
        return this.proofAlgID;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.proofAlgID);
        r100.add(this.macAlgId);
        r100.add(new DEROctetString(getWitness()));
        return new DERSequence(r100);
    }
}
