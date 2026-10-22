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
public class RSAPrivateKeyStructure extends ASN1Object {
    private BigInteger coefficient;
    private BigInteger exponent1;
    private BigInteger exponent2;
    private BigInteger modulus;
    private ASN1Sequence otherPrimeInfos;
    private BigInteger prime1;
    private BigInteger prime2;
    private BigInteger privateExponent;
    private BigInteger publicExponent;
    private int version;

    public RSAPrivateKeyStructure(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, BigInteger r105, BigInteger r106, BigInteger r107) {
        this.otherPrimeInfos = null;
        this.version = 0;
        this.modulus = r100;
        this.publicExponent = r101;
        this.privateExponent = r102;
        this.prime1 = r103;
        this.prime2 = r104;
        this.exponent1 = r105;
        this.exponent2 = r106;
        this.coefficient = r107;
    }

    public RSAPrivateKeyStructure(ASN1Sequence r100) {
        this.otherPrimeInfos = null;
        Enumeration r101 = r100.getObjects();
        int r102 = ((ASN1Integer) r101.nextElement()).intValueExact();
        if (r102 < 0) goto L11;
        if (r102 > 1) goto L11;
        this.version = r102;
        this.modulus = ((ASN1Integer) r101.nextElement()).getValue();
        this.publicExponent = ((ASN1Integer) r101.nextElement()).getValue();
        this.privateExponent = ((ASN1Integer) r101.nextElement()).getValue();
        this.prime1 = ((ASN1Integer) r101.nextElement()).getValue();
        this.prime2 = ((ASN1Integer) r101.nextElement()).getValue();
        this.exponent1 = ((ASN1Integer) r101.nextElement()).getValue();
        this.exponent2 = ((ASN1Integer) r101.nextElement()).getValue();
        this.coefficient = ((ASN1Integer) r101.nextElement()).getValue();
        if (r101.hasMoreElements() == false) goto L12;
        this.otherPrimeInfos = (ASN1Sequence) r101.nextElement();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("wrong version for RSA private key");
    }

    public static RSAPrivateKeyStructure getInstance(Object r100) {
        if ((r100 instanceof RSAPrivateKeyStructure) == false) goto L7;
        return (RSAPrivateKeyStructure) r100;
    L7:
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new RSAPrivateKeyStructure((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    }

    public static RSAPrivateKeyStructure getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getCoefficient() {
        return this.coefficient;
    }

    public BigInteger getExponent1() {
        return this.exponent1;
    }

    public BigInteger getExponent2() {
        return this.exponent2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPrime1() {
        return this.prime1;
    }

    public BigInteger getPrime2() {
        return this.prime2;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(10);
        r100.add(new ASN1Integer(this.version));
        r100.add(new ASN1Integer(getModulus()));
        r100.add(new ASN1Integer(getPublicExponent()));
        r100.add(new ASN1Integer(getPrivateExponent()));
        r100.add(new ASN1Integer(getPrime1()));
        r100.add(new ASN1Integer(getPrime2()));
        r100.add(new ASN1Integer(getExponent1()));
        r100.add(new ASN1Integer(getExponent2()));
        r100.add(new ASN1Integer(getCoefficient()));
        ASN1Sequence r101 = this.otherPrimeInfos;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
