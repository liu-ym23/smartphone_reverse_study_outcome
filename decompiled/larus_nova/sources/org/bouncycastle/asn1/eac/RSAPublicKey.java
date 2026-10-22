package org.bouncycastle.asn1.eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class RSAPublicKey extends PublicKeyDataObject {
    private static int exponentValid = 2;
    private static int modulusValid = 1;
    private BigInteger exponent;
    private BigInteger modulus;
    private ASN1ObjectIdentifier usage;
    private int valid;

    public RSAPublicKey(ASN1ObjectIdentifier r100, BigInteger r101, BigInteger r102) {
        this.valid = 0;
        this.usage = r100;
        this.modulus = r101;
        this.exponent = r102;
    }

    public RSAPublicKey(ASN1Sequence r100) {
        this.valid = 0;
        Enumeration r101 = r100.getObjects();
        this.usage = ASN1ObjectIdentifier.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L14;
        UnsignedInteger r102 = UnsignedInteger.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        if (r103 != 1) goto L8;
        setModulus(r102);
        goto L4
    L8:
        if (r103 != 2) goto L11;
        setExponent(r102);
        goto L4
    L11:
        throw new IllegalArgumentException("Unknown DERTaggedObject :" + r102.getTagNo() + "-> not an Iso7816RSAPublicKeyStructure");
    L14:
        if (this.valid != 3) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("missing argument -> not an Iso7816RSAPublicKeyStructure");
    }

    private void setExponent(UnsignedInteger r100) {
        int r101 = this.valid;
        int r102 = exponentValid;
        if ((r101 & r102) != 0) goto L7;
        this.valid = r101 | r102;
        this.exponent = r100.getValue();
        return;
    L7:
        throw new IllegalArgumentException("Exponent already set");
    }

    private void setModulus(UnsignedInteger r100) {
        int r101 = this.valid;
        int r102 = modulusValid;
        if ((r101 & r102) != 0) goto L7;
        this.valid = r101 | r102;
        this.modulus = r100.getValue();
        return;
    L7:
        throw new IllegalArgumentException("Modulus already set");
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.exponent;
    }

    @Override // org.bouncycastle.asn1.eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.usage;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.usage);
        r100.add(new UnsignedInteger(1, getModulus()));
        r100.add(new UnsignedInteger(2, getPublicExponent()));
        return new DERSequence(r100);
    }
}
