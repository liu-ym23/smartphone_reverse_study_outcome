package org.bouncycastle.asn1.eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ECDSAPublicKey extends PublicKeyDataObject {
    private static final int A = 2;
    private static final int B = 4;
    private static final int F = 64;
    private static final int G = 8;
    private static final int P = 1;
    private static final int R = 16;
    private static final int Y = 32;
    private byte[] basePointG;
    private BigInteger cofactorF;
    private BigInteger firstCoefA;
    private int options;
    private BigInteger orderOfBasePointR;
    private BigInteger primeModulusP;
    private byte[] publicPointY;
    private BigInteger secondCoefB;
    private ASN1ObjectIdentifier usage;

    public ECDSAPublicKey(ASN1ObjectIdentifier r100, BigInteger r101, BigInteger r102, BigInteger r103, byte[] r104, BigInteger r105, byte[] r106, int r107) {
        this.usage = r100;
        setPrimeModulusP(r101);
        setFirstCoefA(r102);
        setSecondCoefB(r103);
        setBasePointG(new DEROctetString(r104));
        setOrderOfBasePointR(r105);
        setPublicPointY(new DEROctetString(r106));
        setCofactorF(BigInteger.valueOf(r107));
    }

    public ECDSAPublicKey(ASN1ObjectIdentifier r100, byte[] r101) throws IllegalArgumentException {
        this.usage = r100;
        setPublicPointY(new DEROctetString(r101));
    }

    public ECDSAPublicKey(ASN1Sequence r100) throws IllegalArgumentException {
        Enumeration r101 = r100.getObjects();
        this.usage = ASN1ObjectIdentifier.getInstance(r101.nextElement());
        this.options = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L20;
        Object r102 = r101.nextElement();
        if ((r102 instanceof ASN1TaggedObject) == false) goto L19;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r102;
        switch(r103.getTagNo()) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        this.options = 0;
        throw new IllegalArgumentException("Unknown Object Identifier!");
    L12:
        setPublicPointY(ASN1OctetString.getInstance(r103, false));
        goto L4
    L13:
        setOrderOfBasePointR(UnsignedInteger.getInstance(r103).getValue());
        goto L4
    L14:
        setBasePointG(ASN1OctetString.getInstance(r103, false));
        goto L4
    L15:
        setSecondCoefB(UnsignedInteger.getInstance(r103).getValue());
        goto L4
    L16:
        setFirstCoefA(UnsignedInteger.getInstance(r103).getValue());
        goto L4
    L17:
        setPrimeModulusP(UnsignedInteger.getInstance(r103).getValue());
        goto L4
    L11:
        setCofactorF(UnsignedInteger.getInstance(r103).getValue());
        goto L4
    L19:
        throw new IllegalArgumentException("Unknown Object Identifier!");
    L20:
        int r104 = this.options;
        if (r104 != 32) goto L23;
        return;
    L23:
        if (r104 != 127) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("All options must be either present or absent!");
    }

    private void setBasePointG(ASN1OctetString r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 8) != 0) goto L7;
        this.options = r101 | 8;
        this.basePointG = r100.getOctets();
        return;
    L7:
        throw new IllegalArgumentException("Base Point G already set");
    }

    private void setCofactorF(BigInteger r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 64) != 0) goto L7;
        this.options = r101 | 64;
        this.cofactorF = r100;
        return;
    L7:
        throw new IllegalArgumentException("Cofactor F already set");
    }

    private void setFirstCoefA(BigInteger r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 2) != 0) goto L7;
        this.options = r101 | 2;
        this.firstCoefA = r100;
        return;
    L7:
        throw new IllegalArgumentException("First Coef A already set");
    }

    private void setOrderOfBasePointR(BigInteger r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 16) != 0) goto L7;
        this.options = r101 | 16;
        this.orderOfBasePointR = r100;
        return;
    L7:
        throw new IllegalArgumentException("Order of base point R already set");
    }

    private void setPrimeModulusP(BigInteger r100) {
        int r101 = this.options;
        if ((r101 & 1) != 0) goto L7;
        this.options = r101 | 1;
        this.primeModulusP = r100;
        return;
    L7:
        throw new IllegalArgumentException("Prime Modulus P already set");
    }

    private void setPublicPointY(ASN1OctetString r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 32) != 0) goto L7;
        this.options = r101 | 32;
        this.publicPointY = r100.getOctets();
        return;
    L7:
        throw new IllegalArgumentException("Public Point Y already set");
    }

    private void setSecondCoefB(BigInteger r100) throws IllegalArgumentException {
        int r101 = this.options;
        if ((r101 & 4) != 0) goto L7;
        this.options = r101 | 4;
        this.secondCoefB = r100;
        return;
    L7:
        throw new IllegalArgumentException("Second Coef B already set");
    }

    public ASN1EncodableVector getASN1EncodableVector(ASN1ObjectIdentifier r100, boolean r101) {
        ASN1EncodableVector r102 = new ASN1EncodableVector(8);
        r102.add(r100);
        if (r101 == true) goto L5;
        r102.add(new UnsignedInteger(1, getPrimeModulusP()));
        r102.add(new UnsignedInteger(2, getFirstCoefA()));
        r102.add(new UnsignedInteger(3, getSecondCoefB()));
        r102.add(new DERTaggedObject(false, 4, new DEROctetString(getBasePointG())));
        r102.add(new UnsignedInteger(5, getOrderOfBasePointR()));
    L5:
        r102.add(new DERTaggedObject(false, 6, new DEROctetString(getPublicPointY())));
        if (r101 == true) goto L8;
        r102.add(new UnsignedInteger(7, getCofactorF()));
    L8:
        return r102;
    }

    public byte[] getBasePointG() {
        if ((this.options & 8) != 0) goto L5;
        return null;
    L5:
        return Arrays.clone(this.basePointG);
    }

    public BigInteger getCofactorF() {
        if ((this.options & 64) != 0) goto L5;
        return null;
    L5:
        return this.cofactorF;
    }

    public BigInteger getFirstCoefA() {
        if ((this.options & 2) != 0) goto L5;
        return null;
    L5:
        return this.firstCoefA;
    }

    public BigInteger getOrderOfBasePointR() {
        if ((this.options & 16) != 0) goto L5;
        return null;
    L5:
        return this.orderOfBasePointR;
    }

    public BigInteger getPrimeModulusP() {
        if ((this.options & 1) != 0) goto L5;
        return null;
    L5:
        return this.primeModulusP;
    }

    public byte[] getPublicPointY() {
        if ((this.options & 32) != 0) goto L5;
        return null;
    L5:
        return Arrays.clone(this.publicPointY);
    }

    public BigInteger getSecondCoefB() {
        if ((this.options & 4) != 0) goto L5;
        return null;
    L5:
        return this.secondCoefB;
    }

    @Override // org.bouncycastle.asn1.eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.usage;
    }

    public boolean hasParameters() {
        if (this.primeModulusP == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(getASN1EncodableVector(this.usage, !hasParameters()));
    }
}
