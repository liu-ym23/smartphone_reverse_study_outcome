package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class GostR3410KeyTransport extends ASN1Object {
    private final Gost2814789EncryptedKey sessionEncryptedKey;
    private final GostR3410TransportParameters transportParameters;

    private GostR3410KeyTransport(ASN1Sequence r100) {
        this.sessionEncryptedKey = Gost2814789EncryptedKey.getInstance(r100.getObjectAt(0));
        this.transportParameters = GostR3410TransportParameters.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(1)), false);
    }

    public GostR3410KeyTransport(Gost2814789EncryptedKey r100, GostR3410TransportParameters r101) {
        this.sessionEncryptedKey = r100;
        this.transportParameters = r101;
    }

    public static GostR3410KeyTransport getInstance(Object r100) {
        if ((r100 instanceof GostR3410KeyTransport) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GostR3410KeyTransport(ASN1Sequence.getInstance(r100));
    L5:
        return (GostR3410KeyTransport) r100;
    }

    public Gost2814789EncryptedKey getSessionEncryptedKey() {
        return this.sessionEncryptedKey;
    }

    public GostR3410TransportParameters getTransportParameters() {
        return this.transportParameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.sessionEncryptedKey);
        GostR3410TransportParameters r101 = this.transportParameters;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(false, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
