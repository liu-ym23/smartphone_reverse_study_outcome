package org.bouncycastle.asn1.x509;

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
public class RSAPublicKeyStructure extends ASN1Object {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RSAPublicKeyStructure(BigInteger r100, BigInteger r101) {
        this.modulus = r100;
        this.publicExponent = r101;
    }

    public RSAPublicKeyStructure(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        Enumeration r101 = r100.getObjects();
        this.modulus = ASN1Integer.getInstance(r101.nextElement()).getPositiveValue();
        this.publicExponent = ASN1Integer.getInstance(r101.nextElement()).getPositiveValue();
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static RSAPublicKeyStructure getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof RSAPublicKeyStructure) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new RSAPublicKeyStructure((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid RSAPublicKeyStructure: ".concat(r100.getClass().getName()));
    L13:
        return (RSAPublicKeyStructure) r100;
    }

    public static RSAPublicKeyStructure getInstance(ASN1TaggedObject r100, boolean r101) {
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
