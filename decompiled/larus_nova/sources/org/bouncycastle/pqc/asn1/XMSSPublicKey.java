package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
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
public class XMSSPublicKey extends ASN1Object {
    private final byte[] publicSeed;
    private final byte[] root;

    private XMSSPublicKey(ASN1Sequence r100) {
        if (ASN1Integer.getInstance(r100.getObjectAt(0)).hasValue(BigInteger.valueOf(0)) == false) goto L7;
        this.publicSeed = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets());
        this.root = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public XMSSPublicKey(byte[] r100, byte[] r101) {
        this.publicSeed = Arrays.clone(r100);
        this.root = Arrays.clone(r101);
    }

    public static XMSSPublicKey getInstance(Object r100) {
        if ((r100 instanceof XMSSPublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new XMSSPublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (XMSSPublicKey) r100;
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new ASN1Integer(0));
        r100.add(new DEROctetString(this.publicSeed));
        r100.add(new DEROctetString(this.root));
        return new DERSequence(r100);
    }
}
