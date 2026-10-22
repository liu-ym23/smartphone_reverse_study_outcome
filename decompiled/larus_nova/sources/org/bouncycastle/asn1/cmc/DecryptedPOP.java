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
public class DecryptedPOP extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final byte[] thePOP;
    private final AlgorithmIdentifier thePOPAlgID;

    private DecryptedPOP(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.bodyPartID = BodyPartID.getInstance(r100.getObjectAt(0));
        this.thePOPAlgID = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.thePOP = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public DecryptedPOP(BodyPartID r100, AlgorithmIdentifier r101, byte[] r102) {
        this.bodyPartID = r100;
        this.thePOPAlgID = r101;
        this.thePOP = Arrays.clone(r102);
    }

    public static DecryptedPOP getInstance(Object r100) {
        if ((r100 instanceof DecryptedPOP) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DecryptedPOP(ASN1Sequence.getInstance(r100));
    L5:
        return (DecryptedPOP) r100;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public byte[] getThePOP() {
        return Arrays.clone(this.thePOP);
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.bodyPartID);
        r100.add(this.thePOPAlgID);
        r100.add(new DEROctetString(this.thePOP));
        return new DERSequence(r100);
    }
}
