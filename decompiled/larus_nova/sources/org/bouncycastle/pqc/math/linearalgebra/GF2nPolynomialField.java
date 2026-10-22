package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class GF2nPolynomialField extends GF2nField {
    private boolean isPentanomial;
    private boolean isTrinomial;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private int[] f525608pc;
    GF2Polynomial[] squaringMatrix;

    /* JADX INFO: renamed from: tc, reason: collision with root package name */
    private int f525609tc;

    public GF2nPolynomialField(int r100, SecureRandom r101) {
        super(r101);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.f525608pc = new int[3];
        if (r100 < 3) goto L7;
        this.mDegree = r100;
        computeFieldPolynomial();
        computeSquaringMatrix();
        this.fields = new java.util.Vector();
        this.matrices = new java.util.Vector();
        return;
    L7:
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int r100, SecureRandom r101, GF2Polynomial r102) throws RuntimeException {
        super(r101);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.f525608pc = new int[3];
        if (r100 < 3) goto L30;
        if (r102.getLength() != (r100 + 1)) goto L28;
        if (r102.isIrreducible() == false) goto L26;
        this.mDegree = r100;
        this.fieldPolynomial = r102;
        computeSquaringMatrix();
        int r103 = 2;
        int r104 = 1;
    L10:
        if (r104 >= (this.fieldPolynomial.getLength() - 1)) goto L19;
        if (this.fieldPolynomial.testBit(r104) == false) goto L18;
        r103 = r103 + 1;
        if (r103 != 3) goto L16;
        this.f525609tc = r104;
    L16:
        if (r103 > 5) goto L18;
        this.f525608pc[r103 - 3] = r104;
    L18:
        r104 = r104 + 1;
        goto L10
    L19:
        if (r103 != 3) goto L21;
        this.isTrinomial = true;
    L21:
        if (r103 != 5) goto L23;
        this.isPentanomial = true;
    L23:
        this.fields = new java.util.Vector();
        this.matrices = new java.util.Vector();
        return;
    L26:
        throw new RuntimeException();
    L28:
        throw new RuntimeException();
    L30:
        throw new IllegalArgumentException("degree must be at least 3");
    }

    public GF2nPolynomialField(int r100, SecureRandom r101, boolean r102) {
        super(r101);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.f525608pc = new int[3];
        if (r100 < 3) goto L11;
        this.mDegree = r100;
        if (r102 == false) goto L7;
        computeFieldPolynomial();
    L8:
        computeSquaringMatrix();
        this.fields = new java.util.Vector();
        this.matrices = new java.util.Vector();
        return;
    L7:
        computeFieldPolynomial2();
        goto L8
    L11:
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeSquaringMatrix() {
        int r100 = this.mDegree;
        GF2Polynomial[] r101 = new GF2Polynomial[r100 - 1];
        this.squaringMatrix = new GF2Polynomial[r100];
        int r102 = 0;
        int r103 = 0;
    L3:
        GF2Polynomial[] r104 = this.squaringMatrix;
        if (r103 >= r104.length) goto L7;
        r104[r103] = new GF2Polynomial(this.mDegree, "ZERO");
        r103 = r103 + 1;
    L7:
        if (r102 >= (this.mDegree - 1)) goto L9;
        r101[r102] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + r102).remainder(this.fieldPolynomial);
        r102 = r102 + 1;
        goto L7
    L9:
        int r105 = 1;
    L11:
        if (r105 > Math.abs(this.mDegree >> 1)) goto L20;
        int r106 = 1;
    L13:
        int r107 = this.mDegree;
        if (r106 > r107) goto L19;
        if (r101[r107 - (r105 << 1)].testBit(r107 - r106) == false) goto L18;
        this.squaringMatrix[r106 - 1].setBit(this.mDegree - r105);
    L18:
        r106 = r106 + 1;
        goto L13
    L19:
        r105 = r105 + 1;
        goto L11
    L20:
        int r108 = Math.abs(this.mDegree >> 1) + 1;
    L21:
        int r109 = this.mDegree;
        if (r108 > r109) goto L24;
        this.squaringMatrix[((r108 << 1) - r109) - 1].setBit(r109 - r108);
        r108 = r108 + 1;
        goto L21
    }

    private boolean testPentanomials() {
        GF2Polynomial r100 = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = r100;
        r100.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        int r101 = 1;
        boolean r102 = false;
    L4:
        if (r101 > (this.mDegree - 3)) goto L39;
        if (r102 == true) goto L39;
        this.fieldPolynomial.setBit(r101);
        int r103 = r101 + 1;
        int r104 = r103;
    L8:
        if (r104 > (this.mDegree - 2)) goto L38;
        if (r102 == true) goto L38;
        this.fieldPolynomial.setBit(r104);
        int r105 = r104 + 1;
        int r106 = r105;
    L12:
        if (r106 > (this.mDegree - 1)) goto L37;
        if (r102 == true) goto L37;
        this.fieldPolynomial.setBit(r106);
        if ((this.mDegree & 1) == 0) goto L17;
        boolean r107 = true;
    L19:
        if ((r101 & 1) == 0) goto L21;
        boolean r110 = true;
    L22:
        boolean r108 = r107 | r110;
        if ((r104 & 1) == 0) goto L25;
        boolean r111 = true;
    L26:
        boolean r109 = r108 | r111;
        if ((r106 & 1) == 0) goto L29;
        boolean r112 = true;
    L31:
        if ((r109 | r112) == false) goto L36;
        r102 = this.fieldPolynomial.isIrreducible();
        if (r102 == false) goto L36;
        this.isPentanomial = true;
        int[] r113 = this.f525608pc;
        r113[0] = r101;
        r113[1] = r104;
        r113[2] = r106;
        return r102;
    L36:
        this.fieldPolynomial.resetBit(r106);
        r106 = r106 + 1;
        goto L12
    L29:
        r112 = false;
        goto L31
    L25:
        r111 = false;
        goto L26
    L21:
        r110 = false;
        goto L22
    L17:
        r107 = false;
    L37:
        this.fieldPolynomial.resetBit(r104);
        r104 = r105;
    L38:
        this.fieldPolynomial.resetBit(r101);
        r101 = r103;
    L39:
        return r102;
    }

    private boolean testRandom() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
    L3:
        this.fieldPolynomial.randomize();
        this.fieldPolynomial.setBit(this.mDegree);
        this.fieldPolynomial.setBit(0);
        if (this.fieldPolynomial.isIrreducible() == false) goto L3;
        return true;
    }

    private boolean testTrinomials() {
        GF2Polynomial r100 = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = r100;
        boolean r101 = false;
        r100.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        int r102 = 1;
    L4:
        if (r102 >= this.mDegree) goto L11;
        if (r101 == true) goto L11;
        this.fieldPolynomial.setBit(r102);
        boolean r103 = this.fieldPolynomial.isIrreducible();
        if (r103 == true) goto L8;
        this.fieldPolynomial.resetBit(r102);
        r101 = this.fieldPolynomial.isIrreducible();
        r102 = r102 + 1;
        goto L4
    L8:
        this.isTrinomial = true;
        this.f525609tc = r102;
        return r103;
    L11:
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public void computeCOBMatrix(GF2nField r100) {
        int r101 = this.mDegree;
        if (r101 != r100.mDegree) goto L47;
        boolean r102 = r100 instanceof GF2nONBField;
        if (r102 == false) goto L8;
        r100.computeCOBMatrix(this);
        return;
    L8:
        GF2Polynomial[] r103 = new GF2Polynomial[r101];
        int r104 = 0;
    L10:
        if (r104 >= this.mDegree) goto L12;
        r103[r104] = new GF2Polynomial(this.mDegree);
        r104 = r104 + 1;
    L12:
        GF2nElement r105 = r100.getRandomRoot(this.fieldPolynomial);
        if (r105.isZero() == true) goto L12;
        if ((r105 instanceof GF2nONBElement) == false) goto L17;
        int r106 = this.mDegree;
        GF2nElement[] r107 = new GF2nONBElement[r106];
        r107[r106 - 1] = GF2nONBElement.ONE((GF2nONBField) r100);
    L18:
        int r108 = this.mDegree;
        r107[r108 - 2] = r105;
        int r109 = r108 - 3;
    L19:
        if (r109 < 0) goto L21;
        r107[r109] = (GF2nElement) r107[r109 + 1].multiply(r105);
        r109 = r109 - 1;
        goto L19
    L21:
        if (r102 == false) goto L33;
        int r110 = 0;
    L24:
        if (r110 >= this.mDegree) goto L44;
        int r111 = 0;
    L26:
        int r112 = this.mDegree;
        if (r111 >= r112) goto L32;
        if (r107[r110].testBit((r112 - r111) - 1) == false) goto L31;
        int r113 = this.mDegree;
        r103[(r113 - r111) - 1].setBit((r113 - r110) - 1);
    L31:
        r111 = r111 + 1;
        goto L26
    L32:
        r110 = r110 + 1;
    L44:
        this.fields.addElement(r100);
        this.matrices.addElement(r103);
        r100.fields.addElement(this);
        r100.matrices.addElement(invertMatrix(r103));
        return;
    L33:
        int r114 = 0;
    L35:
        if (r114 >= this.mDegree) goto L44;
        int r115 = 0;
    L38:
        if (r115 >= this.mDegree) goto L43;
        if (r107[r114].testBit(r115) == false) goto L42;
        int r116 = this.mDegree;
        r103[(r116 - r115) - 1].setBit((r116 - r114) - 1);
    L42:
        r115 = r115 + 1;
        goto L38
    L43:
        r114 = r114 + 1;
        goto L35
    L17:
        int r117 = this.mDegree;
        r107 = new GF2nPolynomialElement[r117];
        r107[r117 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) r100);
        goto L18
    L47:
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public void computeFieldPolynomial() {
        if (testTrinomials() == false) goto L6;
        return;
    L6:
        if (testPentanomials() == false) goto L8;
        return;
    L8:
        testRandom();
    }

    public void computeFieldPolynomial2() {
        if (testTrinomials() == false) goto L6;
        return;
    L6:
        if (testPentanomials() == false) goto L8;
        return;
    L8:
        testRandom();
    }

    public int[] getPc() throws RuntimeException {
        if (this.isPentanomial == false) goto L7;
        int[] r100 = new int[3];
        System.arraycopy(this.f525608pc, 0, r100, 0, 3);
        return r100;
    L7:
        throw new RuntimeException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public GF2nElement getRandomRoot(GF2Polynomial r100) {
        GF2nPolynomial r101 = new GF2nPolynomial(r100, this);
    L4:
        if (r101.getDegree() <= 1) goto L17;
    L5:
        GF2nPolynomialElement r102 = new GF2nPolynomialElement(this, this.random);
        GF2nPolynomial r103 = new GF2nPolynomial(2, GF2nPolynomialElement.ZERO(this));
        r103.set(1, r102);
        GF2nPolynomial r104 = new GF2nPolynomial(r103);
        int r105 = 1;
    L7:
        if (r105 > (this.mDegree - 1)) goto L9;
        r104 = r104.multiplyAndReduce(r104, r101).add(r103);
        r105 = r105 + 1;
        goto L7
    L9:
        GF2nPolynomial r106 = r104.gcd(r101);
        int r107 = r106.getDegree();
        int r108 = r101.getDegree();
        if (r107 == 0) goto L5;
        if (r107 == r108) goto L5;
        if ((r107 << 1) > r108) goto L14;
        r101 = new GF2nPolynomial(r106);
        goto L4
    L14:
        r101 = r101.quotient(r106);
        goto L4
    L17:
        return r101.at(0);
    }

    public GF2Polynomial getSquaringVector(int r100) {
        return new GF2Polynomial(this.squaringMatrix[r100]);
    }

    public int getTc() throws RuntimeException {
        if (this.isTrinomial == false) goto L7;
        return this.f525609tc;
    L7:
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.isPentanomial;
    }

    public boolean isTrinomial() {
        return this.isTrinomial;
    }
}
