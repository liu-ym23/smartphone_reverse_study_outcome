package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public class PolynomialRingGF2m {
    private GF2mField field;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PolynomialGF2mSmallM f525615p;
    protected PolynomialGF2mSmallM[] sqMatrix;
    protected PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField r100, PolynomialGF2mSmallM r101) {
        this.field = r100;
        this.f525615p = r101;
        computeSquaringMatrix();
        computeSquareRootMatrix();
    }

    private void computeSquareRootMatrix() {
        int r100 = this.f525615p.getDegree();
        PolynomialGF2mSmallM[] r101 = new PolynomialGF2mSmallM[r100];
        int r102 = r100 - 1;
        int r103 = r102;
    L3:
        if (r103 < 0) goto L5;
        r101[r103] = new PolynomialGF2mSmallM(this.sqMatrix[r103]);
        r103 = r103 - 1;
        goto L3
    L5:
        this.sqRootMatrix = new PolynomialGF2mSmallM[r100];
    L6:
        if (r102 < 0) goto L8;
        this.sqRootMatrix[r102] = new PolynomialGF2mSmallM(this.field, r102);
        r102 = r102 - 1;
        goto L6
    L8:
        int r104 = 0;
    L9:
        if (r104 >= r100) goto L30;
        if (r101[r104].getCoefficient(r104) != 0) goto L22;
        int r105 = r104 + 1;
        boolean r106 = false;
    L13:
        if (r105 >= r100) goto L18;
        if (r101[r105].getCoefficient(r104) == 0) goto L17;
        swapColumns(r101, r104, r105);
        swapColumns(this.sqRootMatrix, r104, r105);
        r105 = r100;
        r106 = true;
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        if (r106 == true) goto L22;
        throw new ArithmeticException("Squaring matrix is not invertible.");
    L22:
        int r107 = this.field.inverse(r101[r104].getCoefficient(r104));
        r101[r104].multThisWithElement(r107);
        this.sqRootMatrix[r104].multThisWithElement(r107);
        int r108 = 0;
    L23:
        if (r108 >= r100) goto L29;
        if (r108 == r104) goto L28;
        int r109 = r101[r108].getCoefficient(r104);
        if (r109 == 0) goto L28;
        PolynomialGF2mSmallM r110 = r101[r104].multWithElement(r109);
        PolynomialGF2mSmallM r111 = this.sqRootMatrix[r104].multWithElement(r109);
        r101[r108].addToThis(r110);
        this.sqRootMatrix[r108].addToThis(r111);
    L28:
        r108 = r108 + 1;
        goto L23
    L29:
        r104 = r104 + 1;
        goto L9
    }

    private void computeSquaringMatrix() {
        int r100 = this.f525615p.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[r100];
        int r101 = 0;
    L3:
        int r102 = r100 >> 1;
        if (r101 >= r102) goto L6;
        int r103 = r101 << 1;
        int[] r104 = new int[r103 + 1];
        r104[r103] = 1;
        this.sqMatrix[r101] = new PolynomialGF2mSmallM(this.field, r104);
        r101 = r101 + 1;
    L6:
        if (r102 >= r100) goto L8;
        int r105 = r102 << 1;
        int[] r106 = new int[r105 + 1];
        r106[r105] = 1;
        PolynomialGF2mSmallM r107 = new PolynomialGF2mSmallM(this.field, r106);
        this.sqMatrix[r102] = r107.mod(this.f525615p);
        r102 = r102 + 1;
        goto L6
    }

    private static void swapColumns(PolynomialGF2mSmallM[] r100, int r101, int r102) {
        PolynomialGF2mSmallM r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    public PolynomialGF2mSmallM[] getSquareRootMatrix() {
        return this.sqRootMatrix;
    }

    public PolynomialGF2mSmallM[] getSquaringMatrix() {
        return this.sqMatrix;
    }
}
