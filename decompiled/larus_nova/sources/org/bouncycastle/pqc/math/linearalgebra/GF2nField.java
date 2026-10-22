package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public abstract class GF2nField {
    protected GF2Polynomial fieldPolynomial;
    protected java.util.Vector fields;
    protected int mDegree;
    protected java.util.Vector matrices;
    protected final SecureRandom random;

    public GF2nField(SecureRandom r100) {
        this.random = r100;
    }

    public abstract void computeCOBMatrix(GF2nField r100);

    public abstract void computeFieldPolynomial();

    public final GF2nElement convert(GF2nElement r100, GF2nField r101) throws RuntimeException {
        if (r101 != this) goto L6;
    L4:
        return (GF2nElement) r100.clone();
    L6:
        if (this.fieldPolynomial.equals(r101.fieldPolynomial) == true) goto L4;
        if (this.mDegree != r101.mDegree) goto L34;
        int r102 = this.fields.indexOf(r101);
        if (r102 != (-1)) goto L13;
        computeCOBMatrix(r101);
        r102 = this.fields.indexOf(r101);
    L13:
        GF2Polynomial[] r103 = (GF2Polynomial[]) this.matrices.elementAt(r102);
        GF2nElement r104 = (GF2nElement) r100.clone();
        if ((r104 instanceof GF2nONBElement) == false) goto L16;
        ((GF2nONBElement) r104).reverseOrder();
    L16:
        GF2Polynomial r105 = new GF2Polynomial(this.mDegree, r104.toFlexiBigInt());
        r105.expandN(this.mDegree);
        GF2Polynomial r106 = new GF2Polynomial(this.mDegree);
        int r107 = 0;
    L18:
        if (r107 >= this.mDegree) goto L24;
        if (r105.vectorMult(r103[r107]) == false) goto L22;
        r106.setBit((this.mDegree - 1) - r107);
    L22:
        r107 = r107 + 1;
        goto L18
    L24:
        if ((r101 instanceof GF2nPolynomialField) == false) goto L28;
        return new GF2nPolynomialElement((GF2nPolynomialField) r101, r106);
    L28:
        if ((r101 instanceof GF2nONBField) == false) goto L32;
        GF2nONBElement r108 = new GF2nONBElement((GF2nONBField) r101, r106.toFlexiBigInt());
        r108.reverseOrder();
        return r108;
    L32:
        throw new RuntimeException("GF2nField.convert: B1 must be an instance of GF2nPolynomialField or GF2nONBField!");
    L34:
        throw new RuntimeException("GF2nField.convert: B1 has a different degree and thus cannot be coverted to!");
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L25:
        return false;
    L5:
        if ((r100 instanceof GF2nField) == false) goto L25;
        GF2nField r101 = (GF2nField) r100;
        if (r101.mDegree == this.mDegree) goto L11;
        return false;
    L11:
        if (this.fieldPolynomial.equals(r101.fieldPolynomial) == true) goto L14;
        return false;
    L14:
        if ((this instanceof GF2nPolynomialField) == false) goto L19;
        if ((r101 instanceof GF2nPolynomialField) == true) goto L19;
        return false;
    L19:
        if ((this instanceof GF2nONBField) == true) goto L21;
        return true;
    L21:
        if ((r101 instanceof GF2nONBField) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getDegree() {
        return this.mDegree;
    }

    public final GF2Polynomial getFieldPolynomial() {
        if (this.fieldPolynomial != null) goto L6;
        computeFieldPolynomial();
    L6:
        return new GF2Polynomial(this.fieldPolynomial);
    }

    public abstract GF2nElement getRandomRoot(GF2Polynomial r100);

    public int hashCode() {
        return this.mDegree + this.fieldPolynomial.hashCode();
    }

    public final GF2Polynomial[] invertMatrix(GF2Polynomial[] r100) {
        GF2Polynomial[] r101 = new GF2Polynomial[r100.length];
        GF2Polynomial[] r102 = new GF2Polynomial[r100.length];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= this.mDegree) goto L6;
        r101[r104] = new GF2Polynomial(r100[r104]);
        GF2Polynomial r105 = new GF2Polynomial(this.mDegree);
        r102[r104] = r105;
        r105.setBit((this.mDegree - 1) - r104);
        r104 = r104 + 1;
    L6:
        int r106 = this.mDegree;
        if (r103 >= (r106 - 1)) goto L28;
        int r107 = r103;
    L9:
        int r108 = this.mDegree;
        if (r107 >= r108) goto L15;
        if (r101[r107].testBit((r108 - 1) - r103) == true) goto L15;
        r107 = r107 + 1;
    L15:
        if (r107 >= this.mDegree) goto L27;
        if (r103 == r107) goto L18;
        GF2Polynomial r109 = r101[r103];
        r101[r103] = r101[r107];
        r101[r107] = r109;
        GF2Polynomial r110 = r102[r103];
        r102[r103] = r102[r107];
        r102[r107] = r110;
    L18:
        int r111 = r103 + 1;
        int r112 = r111;
    L19:
        int r113 = this.mDegree;
        if (r112 >= r113) goto L25;
        if (r101[r112].testBit((r113 - 1) - r103) == false) goto L24;
        r101[r112].addToThis(r101[r103]);
        r102[r112].addToThis(r102[r103]);
    L24:
        r112 = r112 + 1;
        goto L19
    L25:
        r103 = r111;
        goto L6
    L27:
        throw new RuntimeException("GF2nField.invertMatrix: Matrix cannot be inverted!");
    L28:
        int r114 = r106 - 1;
    L29:
        if (r114 <= 0) goto L37;
        int r115 = r114 - 1;
    L31:
        if (r115 < 0) goto L36;
        if (r101[r115].testBit((this.mDegree - 1) - r114) == false) goto L35;
        r101[r115].addToThis(r101[r114]);
        r102[r115].addToThis(r102[r114]);
    L35:
        r115 = r115 - 1;
        goto L31
    L36:
        r114 = r114 - 1;
        goto L29
    L37:
        return r102;
    }
}
