package org.bouncycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECPrivateKey extends ASN1Object {
    private ASN1Sequence seq;

    public ECPrivateKey(int r100, BigInteger r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray((r100 + 7) / 8, r101);
        ASN1EncodableVector r103 = new ASN1EncodableVector(2);
        r103.add(new ASN1Integer(1));
        r103.add(new DEROctetString(r102));
        this.seq = new DERSequence(r103);
    }

    public ECPrivateKey(int r100, BigInteger r101, ASN1Encodable r102) {
        this(r100, r101, null, r102);
    }

    public ECPrivateKey(int r100, BigInteger r101, DERBitString r102, ASN1Encodable r103) {
        byte[] r104 = BigIntegers.asUnsignedByteArray((r100 + 7) / 8, r101);
        ASN1EncodableVector r105 = new ASN1EncodableVector(4);
        r105.add(new ASN1Integer(1));
        r105.add(new DEROctetString(r104));
        if (r103 == null) goto L5;
        r105.add(new DERTaggedObject(true, 0, r103));
    L5:
        if (r102 == null) goto L7;
        r105.add(new DERTaggedObject(true, 1, r102));
    L7:
        this.seq = new DERSequence(r105);
    }

    public ECPrivateKey(BigInteger r100) {
        this(r100.bitLength(), r100);
    }

    public ECPrivateKey(BigInteger r100, ASN1Encodable r101) {
        this(r100, null, r101);
    }

    public ECPrivateKey(BigInteger r100, DERBitString r101, ASN1Encodable r102) {
        this(r100.bitLength(), r100, r101, r102);
    }

    private ECPrivateKey(ASN1Sequence r100) {
        this.seq = r100;
    }

    public static ECPrivateKey getInstance(Object r100) {
        if ((r100 instanceof ECPrivateKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ECPrivateKey(ASN1Sequence.getInstance(r100));
    L5:
        return (ECPrivateKey) r100;
    }

    private ASN1Primitive getObjectInTag(int r100) {
        Enumeration r101 = this.seq.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L11;
        ASN1Encodable r102 = (ASN1Encodable) r101.nextElement();
        if ((r102 instanceof ASN1TaggedObject) == false) goto L4;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r102;
        if (r103.getTagNo() != r100) goto L4;
        return r103.getObject().toASN1Primitive();
    L11:
        return null;
    }

    public BigInteger getKey() {
        return new BigInteger(1, ((ASN1OctetString) this.seq.getObjectAt(1)).getOctets());
    }

    public ASN1Primitive getParameters() {
        return getObjectInTag(0);
    }

    public DERBitString getPublicKey() {
        return (DERBitString) getObjectInTag(1);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
