package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class LraPopWitness extends ASN1Object {
    private final ASN1Sequence bodyIds;
    private final BodyPartID pkiDataBodyid;

    private LraPopWitness(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.pkiDataBodyid = BodyPartID.getInstance(r100.getObjectAt(0));
        this.bodyIds = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public LraPopWitness(BodyPartID r100, ASN1Sequence r101) {
        this.pkiDataBodyid = r100;
        this.bodyIds = r101;
    }

    public static LraPopWitness getInstance(Object r100) {
        if ((r100 instanceof LraPopWitness) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LraPopWitness(ASN1Sequence.getInstance(r100));
    L5:
        return (LraPopWitness) r100;
    }

    public BodyPartID[] getBodyIds() {
        BodyPartID[] r100 = new BodyPartID[this.bodyIds.size()];
        int r101 = 0;
    L4:
        if (r101 == this.bodyIds.size()) goto L6;
        r100[r101] = BodyPartID.getInstance(this.bodyIds.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public BodyPartID getPkiDataBodyid() {
        return this.pkiDataBodyid;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.pkiDataBodyid);
        r100.add(this.bodyIds);
        return new DERSequence(r100);
    }
}
