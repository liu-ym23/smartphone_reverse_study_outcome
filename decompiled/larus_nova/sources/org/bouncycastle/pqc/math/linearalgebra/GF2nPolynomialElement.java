package org.bouncycastle.pqc.math.linearalgebra;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes42.dex */
public class GF2nPolynomialElement extends GF2nElement {
    private static final int[] bitMask = null;
    private GF2Polynomial polynomial;

    static {
        bitMask = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, AMapEngineUtils.HALF_MAX_P20_WIDTH, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
    }

    public GF2nPolynomialElement(GF2nPolynomialElement r100) {
        this.mField = r100.mField;
        this.mDegree = r100.mDegree;
        this.polynomial = new GF2Polynomial(r100.polynomial);
    }

    public GF2nPolynomialElement(GF2nPolynomialField r100, Random r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        this.polynomial = new GF2Polynomial(this.mDegree);
        randomize(r101);
    }

    public GF2nPolynomialElement(GF2nPolynomialField r100, GF2Polynomial r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        GF2Polynomial r102 = new GF2Polynomial(r101);
        this.polynomial = r102;
        r102.expandN(this.mDegree);
    }

    public GF2nPolynomialElement(GF2nPolynomialField r100, byte[] r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        GF2Polynomial r102 = new GF2Polynomial(this.mDegree, r101);
        this.polynomial = r102;
        r102.expandN(this.mDegree);
    }

    public GF2nPolynomialElement(GF2nPolynomialField r100, int[] r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        GF2Polynomial r102 = new GF2Polynomial(this.mDegree, r101);
        this.polynomial = r102;
        r102.expandN(r100.mDegree);
    }

    public static GF2nPolynomialElement ONE(GF2nPolynomialField r100) {
        return new GF2nPolynomialElement(r100, new GF2Polynomial(r100.getDegree(), new int[]{1}));
    }

    public static GF2nPolynomialElement ZERO(GF2nPolynomialField r100) {
        return new GF2nPolynomialElement(r100, new GF2Polynomial(r100.getDegree()));
    }

    private GF2Polynomial getGF2Polynomial() {
        return new GF2Polynomial(this.polynomial);
    }

    private GF2nPolynomialElement halfTrace() throws RuntimeException {
        if ((this.mDegree & 1) == 0) goto L10;
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        int r101 = 1;
    L6:
        if (r101 > ((this.mDegree - 1) >> 1)) goto L8;
        r100.squareThis();
        r100.squareThis();
        r100.addToThis(this);
        r101 = r101 + 1;
        goto L6
    L8:
        return r100;
    L10:
        throw new RuntimeException();
    }

    private void randomize(Random r100) {
        this.polynomial.expandN(this.mDegree);
        this.polynomial.randomize(r100);
    }

    private void reducePentanomialBitwise(int[] r100) {
        int r101 = this.mDegree;
        int r102 = r101 - r100[2];
        int r103 = r101 - r100[1];
        int r104 = r101 - r100[0];
        int r105 = this.polynomial.getLength() - 1;
    L4:
        if (r105 < this.mDegree) goto L9;
        if (this.polynomial.testBit(r105) == false) goto L8;
        this.polynomial.xorBit(r105);
        this.polynomial.xorBit(r105 - r102);
        this.polynomial.xorBit(r105 - r103);
        this.polynomial.xorBit(r105 - r104);
        this.polynomial.xorBit(r105 - this.mDegree);
    L8:
        r105 = r105 - 1;
        goto L4
    L9:
        this.polynomial.reduceN();
        this.polynomial.expandN(this.mDegree);
    }

    private void reduceThis() {
        if (this.polynomial.getLength() > this.mDegree) goto L5;
        int r100 = this.polynomial.getLength();
        int r101 = this.mDegree;
        if (r100 >= r101) goto L42;
        this.polynomial.expandN(r101);
        return;
    L42:
        return;
    L5:
        if (((GF2nPolynomialField) this.mField).isTrinomial() == false) goto L19;
        int r102 = ((GF2nPolynomialField) this.mField).getTc();     // Catch: RuntimeException -> L16
        if ((this.mDegree - r102) <= 32) goto L14;
        int r103 = this.polynomial.getLength();
        int r104 = this.mDegree;
        if (r103 > (r104 << 1)) goto L14;
        this.polynomial.reduceTrinomial(r104, r102);
        return;
    L14:
        reduceTrinomialBitwise(r102);
        return;
    L17:
        throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a trinomial");
    L19:
        if (((GF2nPolynomialField) this.mField).isPentanomial() == true) goto L38;
        GF2Polynomial r105 = this.polynomial.remainder(this.mField.getFieldPolynomial());
        this.polynomial = r105;
        r105.expandN(this.mDegree);
        return;
    L38:
        int[] r106 = ((GF2nPolynomialField) this.mField).getPc();     // Catch: RuntimeException -> L30
        if ((this.mDegree - r106[2]) <= 32) goto L28;
        int r107 = this.polynomial.getLength();
        int r108 = this.mDegree;
        if (r107 > (r108 << 1)) goto L28;
        this.polynomial.reducePentanomial(r108, r106);
        return;
    L28:
        reducePentanomialBitwise(r106);
        return;
    L31:
        throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a pentanomial");
    }

    private void reduceTrinomialBitwise(int r100) {
        int r101 = this.mDegree - r100;
        int r102 = this.polynomial.getLength();
    L3:
        r102 = r102 - 1;
        if (r102 < this.mDegree) goto L9;
        if (this.polynomial.testBit(r102) == false) goto L3;
        this.polynomial.xorBit(r102);
        this.polynomial.xorBit(r102 - r101);
        this.polynomial.xorBit(r102 - this.mDegree);
        goto L3
    L9:
        this.polynomial.reduceN();
        this.polynomial.expandN(this.mDegree);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement r100) throws RuntimeException {
        GF2nPolynomialElement r101 = new GF2nPolynomialElement(this);
        r101.addToThis(r100);
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement r100) throws RuntimeException {
        if ((r100 instanceof GF2nPolynomialElement) == false) goto L11;
        GF2nPolynomialElement r101 = (GF2nPolynomialElement) r100;
        if (this.mField.equals(r101.mField) == false) goto L9;
        this.polynomial.addToThis(r101.polynomial);
        return;
    L9:
        throw new RuntimeException();
    L11:
        throw new RuntimeException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignOne() {
        this.polynomial.assignOne();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignZero() {
        this.polynomial.assignZero();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement, org.bouncycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nPolynomialElement(this);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if ((r100 instanceof GF2nPolynomialElement) == false) goto L14;
        GF2nPolynomialElement r101 = (GF2nPolynomialElement) r100;
        GF2nField r102 = this.mField;
        if (r102 == r101.mField) goto L13;
        if (r102.getFieldPolynomial().equals(r101.mField.getFieldPolynomial()) == true) goto L13;
        return false;
    L13:
        return this.polynomial.equals(r101.polynomial);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return this.mField.hashCode() + this.polynomial.hashCode();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        r100.increaseThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() {
        this.polynomial.increaseThis();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws ArithmeticException {
        return invertMAIA();
    }

    public GF2nPolynomialElement invertEEA() throws ArithmeticException {
        if (isZero() == true) goto L14;
        GF2Polynomial r100 = new GF2Polynomial(this.mDegree + 32, "ONE");
        r100.reduceN();
        GF2Polynomial r101 = new GF2Polynomial(this.mDegree + 32);
        r101.reduceN();
        GF2Polynomial r102 = getGF2Polynomial();
        GF2Polynomial r103 = this.mField.getFieldPolynomial();
        r102.reduceN();
    L6:
        if (r102.isOne() == true) goto L11;
        r102.reduceN();
        r103.reduceN();
        int r104 = r102.getLength() - r103.getLength();
        if (r104 >= 0) goto L10;
        r104 = -r104;
        r100.reduceN();
        GF2Polynomial r105 = r101;
        r101 = r100;
        r100 = r105;
        GF2Polynomial r106 = r103;
        r103 = r102;
        r102 = r106;
    L10:
        r102.shiftLeftAddThis(r103, r104);
        r100.shiftLeftAddThis(r101, r104);
        goto L6
    L11:
        r100.reduceN();
        return new GF2nPolynomialElement((GF2nPolynomialField) this.mField, r100);
    L14:
        throw new ArithmeticException();
    }

    public GF2nPolynomialElement invertMAIA() throws ArithmeticException {
        if (isZero() == true) goto L21;
        GF2Polynomial r100 = new GF2Polynomial(this.mDegree, "ONE");
        GF2Polynomial r101 = new GF2Polynomial(this.mDegree);
        GF2Polynomial r102 = getGF2Polynomial();
        GF2Polynomial r103 = this.mField.getFieldPolynomial();
    L6:
        if (r102.testBit(0) == false) goto L7;
        if (r102.isOne() == true) goto L15;
        r102.reduceN();
        r103.reduceN();
        if (r102.getLength() >= r103.getLength()) goto L19;
        GF2Polynomial r104 = r101;
        r101 = r100;
        r100 = r104;
        GF2Polynomial r105 = r103;
        r103 = r102;
        r102 = r105;
    L19:
        r102.addToThis(r103);
        r100.addToThis(r101);
        goto L6
    L15:
        return new GF2nPolynomialElement((GF2nPolynomialField) this.mField, r100);
    L7:
        r102.shiftRightThis();
        if (r100.testBit(0) == false) goto L11;
        r100.addToThis(this.mField.getFieldPolynomial());
    L11:
        r100.shiftRightThis();
        goto L6
    L21:
        throw new ArithmeticException();
    }

    public GF2nPolynomialElement invertSquare() throws ArithmeticException {
        if (isZero() == true) goto L16;
        int r100 = this.mField.getDegree() - 1;
        GF2nPolynomialElement r101 = new GF2nPolynomialElement(this);
        r101.polynomial.expandN((this.mDegree << 1) + 32);
        r101.polynomial.reduceN();
        int r102 = IntegerFunctions.floorLog(r100) - 1;
        int r103 = 1;
    L5:
        if (r102 < 0) goto L13;
        GF2nPolynomialElement r104 = new GF2nPolynomialElement(r101);
        int r105 = 1;
    L7:
        if (r105 > r103) goto L9;
        r104.squareThisPreCalc();
        r105 = r105 + 1;
        goto L7
    L9:
        r101.multiplyThisBy(r104);
        r103 = r103 << 1;
        if ((bitMask[r102] & r100) == 0) goto L12;
        r101.squareThisPreCalc();
        r101.multiplyThisBy(this);
        r103 = r103 + 1;
    L12:
        r102 = r102 - 1;
        goto L5
    L13:
        r101.squareThisPreCalc();
        return r101;
    L16:
        throw new ArithmeticException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        return this.polynomial.isOne();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        return this.polynomial.isZero();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement r100) throws RuntimeException {
        GF2nPolynomialElement r101 = new GF2nPolynomialElement(this);
        r101.multiplyThisBy(r100);
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public void multiplyThisBy(GFElement r100) throws RuntimeException {
        if ((r100 instanceof GF2nPolynomialElement) == false) goto L15;
        GF2nPolynomialElement r101 = (GF2nPolynomialElement) r100;
        if (this.mField.equals(r101.mField) == false) goto L13;
        if (equals(r100) == false) goto L10;
        squareThis();
        return;
    L10:
        this.polynomial = this.polynomial.multiply(r101.polynomial);
        reduceThis();
        return;
    L13:
        throw new RuntimeException();
    L15:
        throw new RuntimeException();
    }

    public GF2nPolynomialElement power(int r100) {
        if (r100 == 1) goto L5;
        GF2nPolynomialElement r101 = ONE((GF2nPolynomialField) this.mField);
        if (r100 != 0) goto L9;
        return r101;
    L9:
        GF2nPolynomialElement r102 = new GF2nPolynomialElement(this);
        r102.polynomial.expandN((r102.mDegree << 1) + 32);
        r102.polynomial.reduceN();
        int r103 = 0;
    L11:
        if (r103 >= this.mDegree) goto L16;
        if (((1 << r103) & r100) == 0) goto L15;
        r101.multiplyThisBy(r102);
    L15:
        r102.square();
        r103 = r103 + 1;
        goto L11
    L16:
        return r101;
    L5:
        return new GF2nPolynomialElement(this);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        if (isZero() == false) goto L7;
        return ZERO((GF2nPolynomialField) this.mField);
    L7:
        if ((this.mDegree & 1) == 1) goto L9;
    L10:
        GF2nPolynomialElement r100 = new GF2nPolynomialElement((GF2nPolynomialField) this.mField, new Random());
        GF2nPolynomialElement r101 = ZERO((GF2nPolynomialField) this.mField);
        GF2nPolynomialElement r102 = (GF2nPolynomialElement) r100.clone();
        int r103 = 1;
    L12:
        if (r103 >= this.mDegree) goto L15;
        r101.squareThis();
        r102.squareThis();
        r101.addToThis(r102.multiply(this));
        r102.addToThis(r100);
        r103 = r103 + 1;
        goto L12
    L15:
        if (r102.isZero() == true) goto L10;
        if (equals(r101.square().add(r101)) == false) goto L20;
        return r101;
    L20:
        throw new RuntimeException();
    L9:
        return halfTrace();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        return squarePreCalc();
    }

    public GF2nPolynomialElement squareBitwise() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        r100.squareThisBitwise();
        r100.reduceThis();
        return r100;
    }

    public GF2nPolynomialElement squareMatrix() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        r100.squareThisMatrix();
        r100.reduceThis();
        return r100;
    }

    public GF2nPolynomialElement squarePreCalc() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        r100.squareThisPreCalc();
        r100.reduceThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        r100.squareRootThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        this.polynomial.expandN((this.mDegree << 1) + 32);
        this.polynomial.reduceN();
        int r100 = 0;
    L4:
        if (r100 >= (this.mField.getDegree() - 1)) goto L6;
        squareThis();
        r100 = r100 + 1;
        goto L4
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        squareThisPreCalc();
    }

    public void squareThisBitwise() {
        this.polynomial.squareThisBitwise();
        reduceThis();
    }

    public void squareThisMatrix() {
        GF2Polynomial r100 = new GF2Polynomial(this.mDegree);
        int r101 = 0;
    L3:
        int r102 = this.mDegree;
        if (r101 >= r102) goto L9;
        if (this.polynomial.vectorMult(((GF2nPolynomialField) this.mField).squaringMatrix[(r102 - r101) - 1]) == false) goto L8;
        r100.setBit(r101);
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        this.polynomial = r100;
    }

    public void squareThisPreCalc() {
        this.polynomial.squareThisPreCalc();
        reduceThis();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testBit(int r100) {
        return this.polynomial.testBit(r100);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        return this.polynomial.testBit(0);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        return this.polynomial.toByteArray();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return this.polynomial.toFlexiBigInt();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return this.polynomial.toString(16);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString(int r100) {
        return this.polynomial.toString(r100);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        GF2nPolynomialElement r100 = new GF2nPolynomialElement(this);
        int r101 = 1;
    L4:
        if (r101 >= this.mDegree) goto L7;
        r100.squareThis();
        r100.addToThis(this);
        r101 = r101 + 1;
        goto L4
    L7:
        if (r100.isOne() == false) goto L9;
        return 1;
    L9:
        return 0;
    }
}
