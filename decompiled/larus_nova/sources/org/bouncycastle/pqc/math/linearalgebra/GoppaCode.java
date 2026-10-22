package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public final class GoppaCode {

    public static class MaMaPe {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private GF2Matrix f525610h;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Permutation f525611p;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private GF2Matrix f525612s;

        public MaMaPe(GF2Matrix r100, GF2Matrix r101, Permutation r102) {
            this.f525612s = r100;
            this.f525610h = r101;
            this.f525611p = r102;
        }

        public GF2Matrix getFirstMatrix() {
            return this.f525612s;
        }

        public Permutation getPermutation() {
            return this.f525611p;
        }

        public GF2Matrix getSecondMatrix() {
            return this.f525610h;
        }
    }

    public static class MatrixSet {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private GF2Matrix f525613g;
        private int[] setJ;

        public MatrixSet(GF2Matrix r100, int[] r101) {
            this.f525613g = r100;
            this.setJ = r101;
        }

        public GF2Matrix getG() {
            return this.f525613g;
        }

        public int[] getSetJ() {
            return this.setJ;
        }
    }

    private GoppaCode() {
    }

    public static MaMaPe computeSystematicForm(GF2Matrix r100, SecureRandom r101) {
        int r102 = r100.getNumColumns();
        GF2Matrix r103 = null;
    L3:
        Permutation r104 = new Permutation(r102, r101);
        GF2Matrix r105 = (GF2Matrix) r100.rightMultiply(r104);
        GF2Matrix r106 = r105.getLeftSubMatrix();
        GF2Matrix r107 = (GF2Matrix) r106.computeInverse();     // Catch: ArithmeticException -> L6
        boolean r108 = true;
    L7:
        if (r108 == true) goto L9;
        r103 = r107;
        goto L3
    L9:
        return new MaMaPe(r106, ((GF2Matrix) r107.rightMultiply(r105)).getRightSubMatrix(), r104);
    L6:
        r107 = r103;
        r108 = false;
        goto L7
    }

    public static GF2Matrix createCanonicalCheckMatrix(GF2mField r110, PolynomialGF2mSmallM r111) {
        int r100 = r110.getDegree();
        int r101 = 1 << r100;
        int r102 = r111.getDegree();
        Class r103 = Integer.TYPE;
        int[][] r104 = (int[][]) Array.newInstance(r103, new int[]{r102, r101});
        int[][] r105 = (int[][]) Array.newInstance(r103, new int[]{r102, r101});
        int r112 = 0;
    L3:
        if (r112 >= r101) goto L5;
        r105[0][r112] = r110.inverse(r111.evaluateAt(r112));
        r112 = r112 + 1;
        goto L3
    L5:
        int r113 = 1;
    L6:
        if (r113 >= r102) goto L11;
        int r114 = 0;
    L8:
        if (r114 >= r101) goto L10;
        r105[r113][r114] = r110.mult(r105[r113 - 1][r114], r114);
        r114 = r114 + 1;
        goto L8
    L10:
        r113 = r113 + 1;
        goto L6
    L11:
        int r115 = 0;
    L12:
        if (r115 >= r102) goto L20;
        int r116 = 0;
    L14:
        if (r116 >= r101) goto L19;
        int r117 = 0;
    L16:
        if (r117 > r115) goto L18;
        int[] r118 = r104[r115];
        r118[r116] = r110.add(r118[r116], r110.mult(r105[r117][r116], r111.getCoefficient((r102 + r117) - r115)));
        r117 = r117 + 1;
        goto L16
    L18:
        r116 = r116 + 1;
        goto L14
    L19:
        r115 = r115 + 1;
        goto L12
    L20:
        int[][] r106 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r102 * r100, (r101 + 31) >>> 5});
        int r107 = 0;
    L21:
        if (r107 >= r101) goto L33;
        int r108 = r107 >>> 5;
        int r109 = 1 << (r107 & 31);
        int r119 = 0;
    L23:
        if (r119 >= r102) goto L31;
        int r120 = r104[r119][r107];
        int r121 = 0;
    L25:
        if (r121 >= r100) goto L30;
        if (((r120 >>> r121) & 1) == 0) goto L29;
        int[] r122 = r106[(((r119 + 1) * r100) - r121) - 1];
        r122[r108] = r122[r108] ^ r109;
    L29:
        r121 = r121 + 1;
        goto L25
    L30:
        r119 = r119 + 1;
        goto L23
    L31:
        r107 = r107 + 1;
        goto L21
    L33:
        return new GF2Matrix(r101, r106);
    }

    public static GF2Vector syndromeDecode(GF2Vector r100, GF2mField r101, PolynomialGF2mSmallM r102, PolynomialGF2mSmallM[] r103) {
        int r104 = 1 << r101.getDegree();
        GF2Vector r105 = new GF2Vector(r104);
        if (r100.isZero() == true) goto L10;
        PolynomialGF2mSmallM[] r106 = new PolynomialGF2mSmallM(r100.toExtensionFieldVector(r101)).modInverse(r102).addMonomial(1).modSquareRootMatrix(r103).modPolynomialToFracton(r102);
        int r107 = 0;
        PolynomialGF2mSmallM r108 = r106[0];
        PolynomialGF2mSmallM r109 = r108.multiply(r108);
        PolynomialGF2mSmallM r110 = r106[1];
        PolynomialGF2mSmallM r111 = r109.add(r110.multiply(r110).multWithMonomial(1));
        PolynomialGF2mSmallM r112 = r111.multWithElement(r101.inverse(r111.getHeadCoefficient()));
    L5:
        if (r107 >= r104) goto L10;
        if (r112.evaluateAt(r107) != 0) goto L9;
        r105.setBit(r107);
    L9:
        r107 = r107 + 1;
    L10:
        return r105;
    }
}
