package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes42.dex */
public class GF2mField {
    private int degree;
    private int polynomial;

    public GF2mField(int r100) {
        this.degree = 0;
        if (r100 >= 32) goto L11;
        if (r100 < 1) goto L9;
        this.degree = r100;
        this.polynomial = PolynomialRingGF2.getIrreduciblePolynomial(r100);
        return;
    L9:
        throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
    L11:
        throw new IllegalArgumentException(" Error: the degree of field is too large ");
    }

    public GF2mField(int r100, int r101) {
        this.degree = 0;
        if (r100 != PolynomialRingGF2.degree(r101)) goto L11;
        if (PolynomialRingGF2.isIrreducible(r101) == false) goto L9;
        this.degree = r100;
        this.polynomial = r101;
        return;
    L9:
        throw new IllegalArgumentException(" Error: given polynomial is reducible");
    L11:
        throw new IllegalArgumentException(" Error: the degree is not correct");
    }

    public GF2mField(GF2mField r100) {
        this.degree = 0;
        this.degree = r100.degree;
        this.polynomial = r100.polynomial;
    }

    public GF2mField(byte[] r100) {
        this.degree = 0;
        if (r100.length != 4) goto L11;
        int r101 = LittleEndianConversions.OS2IP(r100);
        this.polynomial = r101;
        if (PolynomialRingGF2.isIrreducible(r101) == false) goto L9;
        this.degree = PolynomialRingGF2.degree(this.polynomial);
        return;
    L9:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    L11:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String polyToString(int r100) {
        if (r100 != 0) goto L5;
        return "0";
    L5:
        if (((byte) (r100 & 1)) != 1) goto L7;
        String r101 = "1";
    L8:
        int r102 = r100 >>> 1;
        int r103 = 1;
    L9:
        if (r102 == 0) goto L15;
        if (((byte) (r102 & 1)) != 1) goto L13;
        r101 = r101 + "+x^" + r103;
    L13:
        r102 = r102 >>> 1;
        r103 = r103 + 1;
        goto L9
    L15:
        return r101;
    L7:
        r101 = "";
        goto L8
    }

    public int add(int r100, int r101) {
        return r100 ^ r101;
    }

    public String elementToStr(int r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= this.degree) goto L10;
        if ((((byte) r100) & 1) != 0) goto L8;
        StringBuilder r103 = new StringBuilder("0");
    L9:
        r103.append(r101);
        r101 = r103.toString();
        r100 = r100 >>> 1;
        r102 = r102 + 1;
        goto L4
    L8:
        r103 = new StringBuilder("1");
        goto L9
    L10:
        return r101;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if ((r100 instanceof GF2mField) == false) goto L13;
        GF2mField r101 = (GF2mField) r100;
        if (this.degree != r101.degree) goto L13;
        if (this.polynomial != r101.polynomial) goto L13;
        return true;
    }

    public int exp(int r100, int r101) {
        if (r101 != 0) goto L5;
        return 1;
    L5:
        if (r100 != 0) goto L8;
        return 0;
    L8:
        if (r100 != 1) goto L10;
        return 1;
    L10:
        if (r101 >= 0) goto L12;
        r100 = inverse(r100);
        r101 = -r101;
    L12:
        int r102 = 1;
    L13:
        if (r101 == 0) goto L18;
        if ((r101 & 1) != 1) goto L17;
        r102 = mult(r102, r100);
    L17:
        r100 = mult(r100, r100);
        r101 = r101 >>> 1;
        goto L13
    L18:
        return r102;
    }

    public int getDegree() {
        return this.degree;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.polynomial);
    }

    public int getPolynomial() {
        return this.polynomial;
    }

    public int getRandomElement(SecureRandom r100) {
        return RandUtils.nextInt(r100, 1 << this.degree);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(CryptoServicesRegistrar.getSecureRandom());
    }

    public int getRandomNonZeroElement(SecureRandom r100) {
        int r101 = RandUtils.nextInt(r100, 1 << this.degree);
        int r102 = 0;
    L4:
        if (r101 != 0) goto L7;
        if (r102 >= 1048576) goto L7;
        r101 = RandUtils.nextInt(r100, 1 << this.degree);
        r102 = r102 + 1;
    L7:
        if (r102 != 1048576) goto L10;
        return 1;
    L10:
        return r101;
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int r100) {
        return exp(r100, (1 << this.degree) - 2);
    }

    public boolean isElementOfThisField(int r100) {
        int r101 = this.degree;
        if (r101 != 31) goto L7;
        if (r100 < 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        if (r100 >= 0) goto L9;
        return false;
    L9:
        if (r100 >= (1 << r101)) goto L14;
        return true;
    L14:
        return false;
    }

    public int mult(int r100, int r101) {
        return PolynomialRingGF2.modMultiply(r100, r101, this.polynomial);
    }

    public int sqRoot(int r100) {
        int r101 = 1;
    L4:
        if (r101 >= this.degree) goto L6;
        r100 = mult(r100, r100);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.degree + ") = GF(2)[X]/<" + polyToString(this.polynomial) + "> ";
    }
}
