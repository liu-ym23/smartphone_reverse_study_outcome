package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PendInfo extends ASN1Object {
    private final ASN1GeneralizedTime pendTime;
    private final byte[] pendToken;

    private PendInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.pendToken = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        this.pendTime = ASN1GeneralizedTime.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public PendInfo(byte[] r100, ASN1GeneralizedTime r101) {
        this.pendToken = Arrays.clone(r100);
        this.pendTime = r101;
    }

    public static PendInfo getInstance(Object r100) {
        if ((r100 instanceof PendInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PendInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PendInfo) r100;
    }

    public ASN1GeneralizedTime getPendTime() {
        return this.pendTime;
    }

    public byte[] getPendToken() {
        return Arrays.clone(this.pendToken);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(new DEROctetString(this.pendToken));
        r100.add(this.pendTime);
        return new DERSequence(r100);
    }
}
