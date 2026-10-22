package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSPublicKey extends ASN1Object {
    private byte[] publicKey;
    private ASN1Integer version;

    private GMSSPublicKey(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.publicKey = ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets();
        return;
    L7:
        throw new IllegalArgumentException("size of seq = " + r100.size());
    }

    public GMSSPublicKey(byte[] r100) {
        this.version = new ASN1Integer(0);
        this.publicKey = r100;
    }

    public static GMSSPublicKey getInstance(Object r100) {
        if ((r100 instanceof GMSSPublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GMSSPublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (GMSSPublicKey) r100;
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.publicKey);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(this.version);
        r100.add(new DEROctetString(this.publicKey));
        return new DERSequence(r100);
    }
}
