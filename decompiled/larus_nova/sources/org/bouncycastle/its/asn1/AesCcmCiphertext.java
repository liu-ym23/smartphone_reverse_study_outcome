package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AesCcmCiphertext extends ASN1Object {
    private final byte[] nonce;
    private final SequenceOfOctetString opaque;

    private AesCcmCiphertext(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.nonce = Utils.octetStringFixed(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets(), 12);
        this.opaque = SequenceOfOctetString.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static AesCcmCiphertext getInstance(Object r100) {
        if ((r100 instanceof AesCcmCiphertext) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AesCcmCiphertext(ASN1Sequence.getInstance(r100));
    L5:
        return (AesCcmCiphertext) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new DEROctetString(this.nonce));
        r100.add(this.opaque);
        return new DERSequence(r100);
    }
}
