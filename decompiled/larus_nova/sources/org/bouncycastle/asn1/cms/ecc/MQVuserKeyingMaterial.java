package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;

/* JADX INFO: loaded from: classes42.dex */
public class MQVuserKeyingMaterial extends ASN1Object {
    private ASN1OctetString addedukm;
    private OriginatorPublicKey ephemeralPublicKey;

    private MQVuserKeyingMaterial(ASN1Sequence r100) {
        if (r100.size() != 1) goto L5;
    L9:
        this.ephemeralPublicKey = OriginatorPublicKey.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L13;
        this.addedukm = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true);
        return;
    L13:
        return;
    L5:
        if (r100.size() == 2) goto L9;
        throw new IllegalArgumentException("Sequence has incorrect number of elements");
    }

    public MQVuserKeyingMaterial(OriginatorPublicKey r100, ASN1OctetString r101) {
        if (r100 == null) goto L7;
        this.ephemeralPublicKey = r100;
        this.addedukm = r101;
        return;
    L7:
        throw new IllegalArgumentException("Ephemeral public key cannot be null");
    }

    public static MQVuserKeyingMaterial getInstance(Object r100) {
        if ((r100 instanceof MQVuserKeyingMaterial) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MQVuserKeyingMaterial(ASN1Sequence.getInstance(r100));
    L5:
        return (MQVuserKeyingMaterial) r100;
    }

    public static MQVuserKeyingMaterial getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1OctetString getAddedukm() {
        return this.addedukm;
    }

    public OriginatorPublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.ephemeralPublicKey);
        ASN1OctetString r101 = this.addedukm;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
