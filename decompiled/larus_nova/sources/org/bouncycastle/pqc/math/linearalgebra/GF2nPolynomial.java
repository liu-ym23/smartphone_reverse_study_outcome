package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public class GF2nPolynomial {
    private GF2nElement[] coeff;
    private int size;

    private GF2nPolynomial(int r100) {
        this.size = r100;
        this.coeff = new GF2nElement[r100];
    }

    public GF2nPolynomial(int r100, GF2nElement r101) {
        this.size = r100;
        this.coeff = new GF2nElement[r100];
        int r102 = 0;
    L4:
        if (r102 >= this.size) goto L6;
        this.coeff[r102] = (GF2nElement) r101.clone();
        r102 = r102 + 1;
        goto L4
    }

    public GF2nPolynomial(GF2Polynomial r100, GF2nField r101) {
        int r102 = r101.getDegree() + 1;
        this.size = r102;
        this.coeff = new GF2nElement[r102];
        int r103 = 0;
        if ((r101 instanceof GF2nONBField) == false) goto L12;
    L5:
        if (r103 >= this.size) goto L20;
        if (r100.testBit(r103) == false) goto L9;
        this.coeff[r103] = GF2nONBElement.ONE((GF2nONBField) r101);
    L10:
        r103 = r103 + 1;
        goto L5
    L9:
        this.coeff[r103] = GF2nONBElement.ZERO((GF2nONBField) r101);
        goto L10
    L20:
        return;
    L12:
        if ((r101 instanceof GF2nPolynomialField) == false) goto L22;
    L14:
        if (r103 >= this.size) goto L29;
        if (r100.testBit(r103) == false) goto L18;
        this.coeff[r103] = GF2nPolynomialElement.ONE((GF2nPolynomialField) r101);
    L19:
        r103 = r103 + 1;
        goto L14
    L18:
        this.coeff[r103] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) r101);
        goto L19
    L29:
        return;
    L22:
        throw new IllegalArgumentException("PolynomialGF2n(Bitstring, GF2nField): B1 must be an instance of GF2nONBField or GF2nPolynomialField!");
    }

    public GF2nPolynomial(GF2nPolynomial r100) {
        int r101 = r100.size;
        this.coeff = new GF2nElement[r101];
        this.size = r101;
        int r102 = 0;
    L4:
        if (r102 >= this.size) goto L6;
        this.coeff[r102] = (GF2nElement) r100.coeff[r102].clone();
        r102 = r102 + 1;
        goto L4
    }

    public final GF2nPolynomial add(GF2nPolynomial r100) {
        int r101 = 0;
        if (size() < r100.size()) goto L11;
        GF2nPolynomial r102 = new GF2nPolynomial(size());
    L6:
        if (r101 >= r100.size()) goto L9;
        r102.coeff[r101] = (GF2nElement) this.coeff[r101].add(r100.coeff[r101]);
        r101 = r101 + 1;
    L9:
        if (r101 >= size()) goto L18;
        r102.coeff[r101] = this.coeff[r101];
        r101 = r101 + 1;
    L18:
        return r102;
    L11:
        r102 = new GF2nPolynomial(r100.size());
    L13:
        if (r101 >= size()) goto L16;
        r102.coeff[r101] = (GF2nElement) this.coeff[r101].add(r100.coeff[r101]);
        r101 = r101 + 1;
    L16:
        if (r101 >= r100.size()) goto L18;
        r102.coeff[r101] = r100.coeff[r101];
        r101 = r101 + 1;
        goto L16
    }

    public final void assignZeroToElements() {
        int r100 = 0;
    L4:
        if (r100 >= this.size) goto L6;
        this.coeff[r100].assignZero();
        r100 = r100 + 1;
        goto L4
    }

    public final GF2nElement at(int r100) {
        return this.coeff[r100];
    }

    public final GF2nPolynomial[] divide(GF2nPolynomial r110) {
        GF2nPolynomial[] r100 = new GF2nPolynomial[2];
        GF2nPolynomial r101 = new GF2nPolynomial(this);
        r101.shrink();
        int r102 = r110.getDegree();
        GF2nElement r103 = (GF2nElement) r110.coeff[r102].invert();
        if (r101.getDegree() >= r102) goto L7;
        GF2nPolynomial r111 = new GF2nPolynomial(this);
        r100[0] = r111;
        r111.assignZeroToElements();
        r100[0].shrink();
        GF2nPolynomial r112 = new GF2nPolynomial(this);
        r100[1] = r112;
    L5:
        r112.shrink();
        return r100;
    L7:
        GF2nPolynomial r104 = new GF2nPolynomial(this);
        r100[0] = r104;
        r104.assignZeroToElements();
    L8:
        int r105 = r101.getDegree() - r102;
        if (r105 < 0) goto L11;
        GF2nElement r106 = (GF2nElement) r101.coeff[r101.getDegree()].multiply(r103);
        GF2nPolynomial r107 = r110.scalarMultiply(r106);
        r107.shiftThisLeft(r105);
        r101 = r101.add(r107);
        r101.shrink();
        r100[0].coeff[r105] = (GF2nElement) r106.clone();
        goto L8
    L11:
        r100[1] = r101;
        r112 = r100[0];
        goto L5
    }

    public final void enlarge(int r100) {
        int r101 = this.size;
        if (r100 > r101) goto L5;
        return;
    L5:
        GF2nElement[] r102 = new GF2nElement[r100];
        System.arraycopy(this.coeff, 0, r102, 0, r101);
        GF2nField r103 = this.coeff[0].getField();
        GF2nElement r104 = this.coeff[0];
        if ((r104 instanceof GF2nPolynomialElement) == false) goto L11;
        int r105 = this.size;
    L8:
        if (r105 >= r100) goto L15;
        r102[r105] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) r103);
        r105 = r105 + 1;
    L15:
        this.size = r100;
        this.coeff = r102;
        return;
    L11:
        if ((r104 instanceof GF2nONBElement) == false) goto L15;
        int r106 = this.size;
    L13:
        if (r106 >= r100) goto L15;
        r102[r106] = GF2nONBElement.ZERO((GF2nONBField) r103);
        r106 = r106 + 1;
        goto L13
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if ((r100 instanceof GF2nPolynomial) == false) goto L19;
        GF2nPolynomial r101 = (GF2nPolynomial) r100;
        if (getDegree() == r101.getDegree()) goto L10;
        return false;
    L10:
        int r102 = 0;
    L12:
        if (r102 >= this.size) goto L17;
        if (this.coeff[r102].equals(r101.coeff[r102]) == false) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public final GF2nPolynomial gcd(GF2nPolynomial r100) {
        GF2nPolynomial r101 = new GF2nPolynomial(this);
        GF2nPolynomial r102 = new GF2nPolynomial(r100);
        r101.shrink();
        r102.shrink();
        GF2nPolynomial r103 = r101;
        GF2nPolynomial r104 = r102;
    L4:
        if (r104.isZero() == true) goto L7;
        GF2nPolynomial r105 = r104;
        r104 = r103.remainder(r104);
        r103 = r105;
        goto L4
    L7:
        return r103.scalarMultiply((GF2nElement) r103.coeff[r103.getDegree()].invert());
    }

    public final int getDegree() {
        int r100 = this.size - 1;
    L3:
        if (r100 < 0) goto L8;
        if (this.coeff[r100].isZero() == false) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        return r100;
    L8:
        return -1;
    }

    public int hashCode() {
        return getDegree() + this.coeff.hashCode();
    }

    public final boolean isZero() {
        int r100 = 0;
    L4:
        if (r100 >= this.size) goto L11;
        GF2nElement r101 = this.coeff[r100];
        if (r101 == null) goto L10;
        if (r101.isZero() == true) goto L10;
        return false;
    L10:
        r100 = r100 + 1;
        goto L4
    L11:
        return true;
    }

    public final GF2nPolynomial multiply(GF2nPolynomial r110) {
        int r100 = size();
        if (r100 != r110.size()) goto L18;
        GF2nPolynomial r101 = new GF2nPolynomial((r100 << 1) - 1);
        int r102 = 0;
    L6:
        if (r102 >= size()) goto L16;
        int r103 = 0;
    L9:
        if (r103 >= r110.size()) goto L15;
        GF2nElement[] r104 = r101.coeff;
        int r105 = r102 + r103;
        GF2nElement r106 = r104[r105];
        if (r106 != null) goto L13;
        r104[r105] = (GF2nElement) this.coeff[r102].multiply(r110.coeff[r103]);
    L14:
        r103 = r103 + 1;
        goto L9
    L13:
        r104[r105] = (GF2nElement) r106.add(this.coeff[r102].multiply(r110.coeff[r103]));
        goto L14
    L15:
        r102 = r102 + 1;
        goto L6
    L16:
        return r101;
    L18:
        throw new IllegalArgumentException("PolynomialGF2n.multiply: this and b must have the same size!");
    }

    public final GF2nPolynomial multiplyAndReduce(GF2nPolynomial r100, GF2nPolynomial r101) {
        return multiply(r100).reduce(r101);
    }

    public final GF2nPolynomial quotient(GF2nPolynomial r100) throws RuntimeException, ArithmeticException {
        return divide(r100)[0];
    }

    public final GF2nPolynomial reduce(GF2nPolynomial r100) throws RuntimeException, ArithmeticException {
        return remainder(r100);
    }

    public final GF2nPolynomial remainder(GF2nPolynomial r100) throws RuntimeException, ArithmeticException {
        return divide(r100)[1];
    }

    public final GF2nPolynomial scalarMultiply(GF2nElement r100) {
        GF2nPolynomial r101 = new GF2nPolynomial(size());
        int r102 = 0;
    L4:
        if (r102 >= size()) goto L6;
        r101.coeff[r102] = (GF2nElement) this.coeff[r102].multiply(r100);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public final void set(int r100, GF2nElement r101) {
        if ((r101 instanceof GF2nPolynomialElement) == false) goto L5;
    L9:
        this.coeff[r100] = (GF2nElement) r101.clone();
        return;
    L5:
        if ((r101 instanceof GF2nONBElement) == true) goto L9;
        throw new IllegalArgumentException("PolynomialGF2n.set f must be an instance of either GF2nPolynomialElement or GF2nONBElement!");
    }

    public final GF2nPolynomial shiftLeft(int r100) {
        if (r100 <= 0) goto L4;
        int r101 = 0;
        GF2nPolynomial r102 = new GF2nPolynomial(this.size + r100, this.coeff[0]);
        r102.assignZeroToElements();
    L7:
        if (r101 >= this.size) goto L9;
        r102.coeff[r101 + r100] = this.coeff[r101];
        r101 = r101 + 1;
        goto L7
    L9:
        return r102;
    L4:
        return new GF2nPolynomial(this);
    }

    public final void shiftThisLeft(int r100) {
        if (r100 <= 0) goto L16;
        int r101 = this.size;
        GF2nField r102 = this.coeff[0].getField();
        enlarge(this.size + r100);
        int r103 = r101 - 1;
    L4:
        if (r103 < 0) goto L6;
        GF2nElement[] r104 = this.coeff;
        r104[r103 + r100] = r104[r103];
        r103 = r103 - 1;
        goto L4
    L6:
        GF2nElement r105 = this.coeff[0];
        if ((r105 instanceof GF2nPolynomialElement) == false) goto L12;
        int r106 = r100 - 1;
    L9:
        if (r106 < 0) goto L21;
        this.coeff[r106] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) r102);
        r106 = r106 - 1;
        goto L9
    L21:
        return;
    L12:
        if ((r105 instanceof GF2nONBElement) == false) goto L20;
        int r107 = r100 - 1;
    L14:
        if (r107 < 0) goto L22;
        this.coeff[r107] = GF2nONBElement.ZERO((GF2nONBField) r102);
        r107 = r107 - 1;
        goto L14
    L22:
        return;
    L20:
        return;
    }

    public final void shrink() {
        int r100 = this.size;
    L3:
        r100 = r100 - 1;
        if (this.coeff[r100].isZero() == false) goto L7;
        if (r100 > 0) goto L3;
    L7:
        int r101 = r100 + 1;
        if (r101 >= this.size) goto L13;
        GF2nElement[] r102 = new GF2nElement[r101];
        System.arraycopy(this.coeff, 0, r102, 0, r101);
        this.coeff = r102;
        this.size = r101;
        return;
    }

    public final int size() {
        return this.size;
    }
}
