package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class RSAPublicKey extends ASN1Object {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RSAPublicKey(BigInteger r100, BigInteger r101) {
        this.modulus = r100;
        this.publicExponent = r101;
    }

    private RSAPublicKey(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        Enumeration r101 = r100.getObjects();
        this.modulus = ASN1Integer.getInstance(r101.nextElement()).getPositiveValue();
        this.publicExponent = ASN1Integer.getInstance(r101.nextElement()).getPositiveValue();
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static RSAPublicKey getInstance(Object r100) {
        if ((r100 instanceof RSAPublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RSAPublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (RSAPublicKey) r100;
    }

    public static RSAPublicKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(new ASN1Integer(getModulus()));
        r100.add(new ASN1Integer(getPublicExponent()));
        return new DERSequence(r100);
    }
}
