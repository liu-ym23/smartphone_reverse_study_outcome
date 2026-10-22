package org.bouncycastle.pqc.math.linearalgebra;

import com.alipay.sdk.m.u.i;
import java.security.SecureRandom;
import kotlin.UByte;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public class PolynomialGF2mSmallM {
    public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField r100) {
        this.field = r100;
        this.degree = -1;
        this.coefficients = new int[1];
    }

    public PolynomialGF2mSmallM(GF2mField r100, int r101) {
        this.field = r100;
        this.degree = r101;
        int[] r102 = new int[r101 + 1];
        this.coefficients = r102;
        r102[r101] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField r100, int r101, char r102, SecureRandom r103) {
        this.field = r100;
        if (r102 != 'I') goto L7;
        this.coefficients = createRandomIrreduciblePolynomial(r101, r103);
        computeDegree();
        return;
    L7:
        throw new IllegalArgumentException(" Error: type " + r102 + " is not defined for GF2smallmPolynomial");
    }

    public PolynomialGF2mSmallM(GF2mField r110, byte[] r111) {
        this.field = r110;
        int r100 = 8;
        int r101 = 1;
    L4:
        if (r110.getDegree() <= r100) goto L7;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L7:
        if ((r111.length % r101) != 0) goto L29;
        this.coefficients = new int[r111.length / r101];
        int r102 = 0;
        int r103 = 0;
    L9:
        int[] r104 = this.coefficients;
        if (r102 >= r104.length) goto L20;
        int r105 = 0;
    L12:
        if (r105 >= r100) goto L15;
        int[] r106 = this.coefficients;
        int r107 = r106[r102];
        int r108 = r103 + 1;
        r106[r102] = ((r111[r103] & UByte.MAX_VALUE) << r105) ^ r107;
        r105 = r105 + 8;
        r103 = r108;
        goto L12
    L15:
        if (this.field.isElementOfThisField(this.coefficients[r102]) == false) goto L18;
        r102 = r102 + 1;
        goto L9
    L18:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L20:
        if (r104.length != 1) goto L22;
    L26:
        computeDegree();
        return;
    L22:
        if (r104[r104.length - 1] != 0) goto L26;
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L29:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    }

    public PolynomialGF2mSmallM(GF2mField r100, int[] r101) {
        this.field = r100;
        this.coefficients = normalForm(r101);
        computeDegree();
    }

    public PolynomialGF2mSmallM(GF2mVector r100) {
        this(r100.getField(), r100.getIntArrayForm());
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM r100) {
        this.field = r100.field;
        this.degree = r100.degree;
        this.coefficients = IntUtils.clone(r100.coefficients);
    }

    private int[] add(int[] r100, int[] r101) {
        if (r100.length >= r101.length) goto L5;
        int[] r102 = new int[r101.length];
        System.arraycopy(r101, 0, r102, 0, r101.length);
    L6:
        int r103 = r100.length - 1;
    L7:
        if (r103 < 0) goto L9;
        r102[r103] = this.field.add(r102[r103], r100[r103]);
        r103 = r103 - 1;
        goto L7
    L9:
        return r102;
    L5:
        r102 = new int[r100.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        r100 = r101;
        goto L6
    }

    private static int computeDegree(int[] r100) {
        int r101 = r100.length - 1;
    L3:
        if (r101 < 0) goto L7;
        if (r100[r101] != 0) goto L7;
        r101 = r101 - 1;
    L7:
        return r101;
    }

    private void computeDegree() {
        int r100 = this.coefficients.length;
    L3:
        this.degree = r100 - 1;
        r100 = this.degree;
        if (r100 < 0) goto L8;
        if (this.coefficients[r100] == 0) goto L3;
        return;
    }

    private int[] createRandomIrreduciblePolynomial(int r100, SecureRandom r101) {
        int[] r102 = new int[r100 + 1];
        int r103 = 1;
        r102[r100] = 1;
        r102[0] = this.field.getRandomNonZeroElement(r101);
    L3:
        if (r103 >= r100) goto L6;
        r102[r103] = this.field.getRandomElement(r101);
        r103 = r103 + 1;
    L6:
        if (isIrreducible(r102) == true) goto L11;
        int r104 = RandUtils.nextInt(r101, r100);
        if (r104 == 0) goto L9;
        r102[r104] = this.field.getRandomElement(r101);
        goto L6
    L9:
        r102[0] = this.field.getRandomNonZeroElement(r101);
        goto L6
    L11:
        return r102;
    }

    private int[][] div(int[] r100, int[] r101) {
        int r102 = computeDegree(r101);
        int r103 = computeDegree(r100) + 1;
        if (r102 == (-1)) goto L10;
        int[][] r104 = {new int[1], new int[r103]};
        int r105 = this.field.inverse(headCoefficient(r101));
        r104[0][0] = 0;
        int[] r106 = r104[1];
        System.arraycopy(r100, 0, r106, 0, r106.length);
    L6:
        if (r102 > computeDegree(r104[1])) goto L8;
        int r107 = this.field.mult(headCoefficient(r104[1]), r105);
        int[] r108 = {r107};
        int[] r109 = multWithElement(r101, r107);
        int r110 = computeDegree(r104[1]) - r102;
        int[] r111 = multWithMonomial(r109, r110);
        r104[0] = add(multWithMonomial(r108, r110), r104[0]);
        r104[1] = add(r111, r104[1]);
        goto L6
    L8:
        return r104;
    L10:
        throw new ArithmeticException("Division by zero.");
    }

    private int[] gcd(int[] r100, int[] r101) {
        if (computeDegree(r100) != (-1)) goto L6;
        return r101;
    L6:
        if (computeDegree(r101) == (-1)) goto L9;
        int[] r102 = mod(r100, r101);
        int r103 = r101.length;
        int[] r104 = new int[r103];
        System.arraycopy(r101, 0, r104, 0, r103);
        int r105 = r102.length;
        int[] r106 = new int[r105];
        System.arraycopy(r102, 0, r106, 0, r105);
        r101 = r106;
        r100 = r104;
        goto L6
    L9:
        return multWithElement(r100, this.field.inverse(headCoefficient(r100)));
    }

    private static int headCoefficient(int[] r100) {
        int r101 = computeDegree(r100);
        if (r101 != (-1)) goto L7;
        return 0;
    L7:
        return r100[r101];
    }

    private static boolean isEqual(int[] r100, int[] r101) {
        int r102 = computeDegree(r100);
        if (r102 == computeDegree(r101)) goto L5;
        return false;
    L5:
        int r103 = 0;
    L6:
        if (r103 > r102) goto L11;
        if (r100[r103] != r101[r103]) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private boolean isIrreducible(int[] r100) {
        if (r100[0] != 0) goto L5;
        return false;
    L5:
        int r101 = computeDegree(r100) >> 1;
        int[] r102 = {0, 1};
        int[] r103 = {0, 1};
        int r104 = this.field.getDegree();
        int r105 = 0;
    L6:
        if (r105 >= r101) goto L14;
        int r106 = r104 - 1;
    L8:
        if (r106 < 0) goto L10;
        r102 = modMultiply(r102, r102, r100);
        r106 = r106 - 1;
        goto L8
    L10:
        r102 = normalForm(r102);
        if (computeDegree(gcd(add(r102, r103), r100)) != 0) goto L12;
        r105 = r105 + 1;
        goto L6
    L12:
        return false;
    L14:
        return true;
    }

    private int[] mod(int[] r100, int[] r101) {
        int r102 = computeDegree(r101);
        if (r102 == (-1)) goto L10;
        int r103 = r100.length;
        int[] r104 = new int[r103];
        int r105 = headCoefficient(r101);
        int r106 = this.field.inverse(r105);
        System.arraycopy(r100, 0, r104, 0, r103);
    L6:
        if (r102 > computeDegree(r104)) goto L8;
        int r107 = this.field.mult(headCoefficient(r104), r106);
        r104 = add(multWithElement(multWithMonomial(r101, computeDegree(r104) - r102), r107), r104);
        goto L6
    L8:
        return r104;
    L10:
        throw new ArithmeticException("Division by zero");
    }

    private int[] modDiv(int[] r100, int[] r101, int[] r102) {
        int[] r103 = normalForm(r102);
        int[] r104 = mod(r101, r102);
        int[] r105 = {0};
        int[] r106 = mod(r100, r102);
    L4:
        if (computeDegree(r104) == (-1)) goto L7;
        int[][] r107 = div(r103, r104);
        int[] r108 = normalForm(r104);
        int[] r109 = normalForm(r107[1]);
        int[] r110 = add(r105, modMultiply(r107[0], r106, r102));
        r105 = normalForm(r106);
        r106 = normalForm(r110);
        r103 = r108;
        r104 = r109;
        goto L4
    L7:
        return multWithElement(r105, this.field.inverse(headCoefficient(r103)));
    }

    private int[] modMultiply(int[] r100, int[] r101, int[] r102) {
        return mod(multiply(r100, r101), r102);
    }

    private int[] multWithElement(int[] r100, int r101) {
        int r102 = computeDegree(r100);
        if (r102 == (-1)) goto L14;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L8;
        int[] r103 = new int[r102 + 1];
    L10:
        if (r102 < 0) goto L12;
        r103[r102] = this.field.mult(r100[r102], r101);
        r102 = r102 - 1;
        goto L10
    L12:
        return r103;
    L8:
        return IntUtils.clone(r100);
    L14:
        return new int[1];
    }

    private static int[] multWithMonomial(int[] r100, int r101) {
        int r102 = computeDegree(r100);
        if (r102 == (-1)) goto L5;
        int[] r103 = new int[(r102 + r101) + 1];
        System.arraycopy(r100, 0, r103, r101, r102 + 1);
        return r103;
    L5:
        return new int[1];
    }

    private int[] multiply(int[] r100, int[] r110) {
        if (computeDegree(r100) >= computeDegree(r110)) goto L5;
        r110 = r100;
        r100 = r110;
    L5:
        int[] r101 = normalForm(r100);
        int[] r111 = normalForm(r110);
        if (r111.length == 1) goto L8;
        int r102 = r101.length;
        int r103 = r111.length;
        int[] r104 = new int[(r102 + r103) - 1];
        if (r103 == r102) goto L12;
        int[] r105 = new int[r103];
        int r106 = r102 - r103;
        int[] r107 = new int[r106];
        System.arraycopy(r101, 0, r105, 0, r103);
        System.arraycopy(r101, r103, r107, 0, r106);
        return add(multiply(r105, r111), multWithMonomial(multiply(r107, r111), r103));
    L12:
        int r108 = (r102 + 1) >>> 1;
        int r109 = r102 - r108;
        int[] r112 = new int[r108];
        int[] r113 = new int[r108];
        int[] r114 = new int[r109];
        int[] r115 = new int[r109];
        System.arraycopy(r101, 0, r112, 0, r108);
        System.arraycopy(r101, r108, r114, 0, r109);
        System.arraycopy(r111, 0, r113, 0, r108);
        System.arraycopy(r111, r108, r115, 0, r109);
        int[] r116 = add(r112, r114);
        int[] r117 = add(r113, r115);
        int[] r118 = multiply(r112, r113);
        int[] r119 = multiply(r116, r117);
        int[] r120 = multiply(r114, r115);     // Catch: Throwable -> L16
        return add(multWithMonomial(add(add(add(r119, r118), r120), multWithMonomial(r120, r108)), r108), r118);
    L16:
        th = move-exception;
        throw th;
    L8:
        return multWithElement(r101, r111[0]);
    }

    private static int[] normalForm(int[] r100) {
        int r101 = computeDegree(r100);
        if (r101 == (-1)) goto L5;
        int r102 = r101 + 1;
        if (r100.length == r102) goto L9;
        int[] r103 = new int[r102];
        System.arraycopy(r100, 0, r103, 0, r102);
        return r103;
    L9:
        return IntUtils.clone(r100);
    L5:
        return new int[1];
    }

    public PolynomialGF2mSmallM add(PolynomialGF2mSmallM r100) {
        int[] r101 = add(this.coefficients, r100.coefficients);
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public PolynomialGF2mSmallM addMonomial(int r100) {
        int[] r101 = new int[r100 + 1];
        r101[r100] = 1;
        int[] r102 = add(this.coefficients, r101);
        return new PolynomialGF2mSmallM(this.field, r102);
    }

    public void addToThis(PolynomialGF2mSmallM r100) {
        this.coefficients = add(this.coefficients, r100.coefficients);
        computeDegree();
    }

    public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM r100) {
        int[][] r101 = div(this.coefficients, r100.coefficients);
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, r101[0]), new PolynomialGF2mSmallM(this.field, r101[1])};
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof PolynomialGF2mSmallM) == false) goto L15;
        PolynomialGF2mSmallM r101 = (PolynomialGF2mSmallM) r100;
        if (this.field.equals(r101.field) == false) goto L15;
        if (this.degree != r101.degree) goto L15;
        if (isEqual(this.coefficients, r101.coefficients) == false) goto L15;
        return true;
    }

    public int evaluateAt(int r100) {
        int[] r101 = this.coefficients;
        int r102 = this.degree;
        int r103 = r101[r102];
        int r104 = r102 - 1;
    L3:
        if (r104 < 0) goto L5;
        r103 = this.field.mult(r103, r100) ^ this.coefficients[r104];
        r104 = r104 - 1;
        goto L3
    L5:
        return r103;
    }

    public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM r100) {
        int[] r101 = gcd(this.coefficients, r100.coefficients);
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public int getCoefficient(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        if (r100 <= this.degree) goto L7;
        return 0;
    L7:
        return this.coefficients[r100];
    }

    public int getDegree() {
        int[] r100 = this.coefficients;
        int r101 = r100.length - 1;
        if (r100[r101] != 0) goto L6;
        return -1;
    L6:
        return r101;
    }

    public byte[] getEncoded() {
        int r100 = 8;
        int r101 = 1;
    L4:
        if (this.field.getDegree() <= r100) goto L6;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L6:
        byte[] r102 = new byte[this.coefficients.length * r101];
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= this.coefficients.length) goto L13;
        int r105 = 0;
    L10:
        if (r105 >= r100) goto L12;
        r102[r104] = (byte) (this.coefficients[r103] >>> r105);
        r105 = r105 + 8;
        r104 = r104 + 1;
        goto L10
    L12:
        r103 = r103 + 1;
        goto L8
    L13:
        return r102;
    }

    public int getHeadCoefficient() {
        int r100 = this.degree;
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        return this.coefficients[r100];
    }

    public int hashCode() {
        int r100 = this.field.hashCode();
        int r101 = 0;
    L3:
        int[] r102 = this.coefficients;
        if (r101 >= r102.length) goto L6;
        r100 = (r100 * 31) + r102[r101];
        r101 = r101 + 1;
        goto L3
    L6:
        return r100;
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM r100) {
        int[] r101 = mod(this.coefficients, r100.coefficients);
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM r100, PolynomialGF2mSmallM r101) {
        int[] r102 = modDiv(this.coefficients, r100.coefficients, r101.coefficients);
        return new PolynomialGF2mSmallM(this.field, r102);
    }

    public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM r100) {
        return new PolynomialGF2mSmallM(this.field, modDiv(new int[]{1}, this.coefficients, r100.coefficients));
    }

    public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM r100, PolynomialGF2mSmallM r101) {
        int[] r102 = modMultiply(this.coefficients, r100.coefficients, r101.coefficients);
        return new PolynomialGF2mSmallM(this.field, r102);
    }

    public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM r110) {
        int r100 = r110.degree >> 1;
        int[] r101 = normalForm(r110.coefficients);
        int[] r102 = r101;
        int[] r103 = mod(this.coefficients, r110.coefficients);
        int[] r104 = {0};
        int[] r105 = {1};
    L4:
        if (computeDegree(r103) <= r100) goto L7;
        int[][] r106 = div(r102, r103);
        int[] r107 = r106[1];
        int[] r108 = add(r104, modMultiply(r106[0], r105, r110.coefficients));
        r104 = r105;
        r105 = r108;
        r102 = r103;
        r103 = r107;
        goto L4
    L7:
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, r103), new PolynomialGF2mSmallM(this.field, r105)};
    }

    public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] r110) {
        int r100 = r110.length;
        int[] r101 = new int[r100];
        int[] r102 = new int[r100];
        int r103 = 0;
    L3:
        int[] r104 = this.coefficients;
        if (r103 >= r104.length) goto L6;
        GF2mField r105 = this.field;
        int r106 = r104[r103];
        r102[r103] = r105.mult(r106, r106);
        r103 = r103 + 1;
        goto L3
    L6:
        int r107 = 0;
    L7:
        if (r107 >= r100) goto L17;
        int r108 = 0;
    L9:
        if (r108 >= r100) goto L15;
        int[] r109 = r110[r108].coefficients;
        if (r107 >= r109.length) goto L14;
        int r111 = this.field.mult(r109[r107], r102[r108]);
        r101[r107] = this.field.add(r101[r107], r111);
    L14:
        r108 = r108 + 1;
        goto L9
    L15:
        r107 = r107 + 1;
        goto L7
    L17:
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM r100) {
        int[] r101 = IntUtils.clone(this.coefficients);
        int[] r102 = modMultiply(r101, r101, r100.coefficients);
    L4:
        if (isEqual(r102, this.coefficients) == true) goto L7;
        r101 = normalForm(r102);
        r102 = modMultiply(r101, r101, r100.coefficients);
        goto L4
    L7:
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] r100) {
        int r101 = r100.length;
        int[] r102 = new int[r101];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L14;
        int r105 = 0;
    L5:
        if (r105 >= r101) goto L13;
        int[] r106 = r100[r105].coefficients;
        if (r104 >= r106.length) goto L12;
        int[] r107 = this.coefficients;
        if (r105 >= r107.length) goto L12;
        int r108 = this.field.mult(r106[r104], r107[r105]);
        r102[r104] = this.field.add(r102[r104], r108);
    L12:
        r105 = r105 + 1;
        goto L5
    L13:
        r104 = r104 + 1;
    L14:
        if (r103 >= r101) goto L17;
        r102[r103] = this.field.sqRoot(r102[r103]);
        r103 = r103 + 1;
        goto L14
    L17:
        return new PolynomialGF2mSmallM(this.field, r102);
    }

    public void multThisWithElement(int r100) {
        if (this.field.isElementOfThisField(r100) == false) goto L7;
        this.coefficients = multWithElement(this.coefficients, r100);
        computeDegree();
        return;
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int r100) {
        if (this.field.isElementOfThisField(r100) == false) goto L7;
        int[] r101 = multWithElement(this.coefficients, r100);
        return new PolynomialGF2mSmallM(this.field, r101);
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithMonomial(int r100) {
        int[] r101 = multWithMonomial(this.coefficients, r100);
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM r100) {
        int[] r101 = multiply(this.coefficients, r100.coefficients);
        return new PolynomialGF2mSmallM(this.field, r101);
    }

    public String toString() {
        String r100 = " Polynomial over " + this.field.toString() + ": \n";
        int r101 = 0;
    L4:
        if (r101 >= this.coefficients.length) goto L7;
        r100 = r100 + this.field.elementToStr(this.coefficients[r101]) + "Y^" + r101 + Marker.ANY_NON_NULL_MARKER;
        r101 = r101 + 1;
        goto L4
    L7:
        return r100 + i.f25853b;
    }
}
