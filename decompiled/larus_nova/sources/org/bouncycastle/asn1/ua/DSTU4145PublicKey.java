package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145PublicKey extends ASN1Object {
    private ASN1OctetString pubKey;

    private DSTU4145PublicKey(ASN1OctetString r100) {
        this.pubKey = r100;
    }

    public DSTU4145PublicKey(ECPoint r100) {
        this.pubKey = new DEROctetString(DSTU4145PointEncoder.encodePoint(r100));
    }

    public static DSTU4145PublicKey getInstance(Object r100) {
        if ((r100 instanceof DSTU4145PublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DSTU4145PublicKey(ASN1OctetString.getInstance(r100));
    L5:
        return (DSTU4145PublicKey) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.pubKey;
    }
}
