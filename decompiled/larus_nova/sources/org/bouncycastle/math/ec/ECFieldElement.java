package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public AbstractF2m() {
        }

        public ECFieldElement halfTrace() {
            int r100 = getFieldSize();
            if ((r100 & 1) == 0) goto L11;
            int r101 = (r100 + 1) >>> 1;
            int r102 = 31 - Integers.numberOfLeadingZeros(r101);
            int r103 = 1;
            ECFieldElement r104 = this;
        L5:
            if (r102 <= 0) goto L9;
            r104 = r104.squarePow(r103 << 1).add(r104);
            r102 = r102 - 1;
            r103 = r101 >>> r102;
            if ((r103 & 1) == 0) goto L5;
            r104 = r104.squarePow(2).add(this);
            goto L5
        L9:
            return r104;
        L11:
            throw new IllegalStateException("Half-trace only defined for odd m");
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int r100 = getFieldSize();
            int r101 = 31 - Integers.numberOfLeadingZeros(r100);
            int r102 = 1;
            ECFieldElement r103 = this;
        L3:
            if (r101 <= 0) goto L8;
            r103 = r103.squarePow(r102).add(r103);
            r101 = r101 - 1;
            r102 = r100 >>> r101;
            if ((r102 & 1) == 0) goto L3;
            r103 = r103.square().add(this);
            goto L3
        L8:
            if (r103.isZero() == false) goto L12;
            return 0;
        L12:
            if (r103.isOne() == false) goto L15;
            return 1;
        L15:
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
        public AbstractFp() {
        }
    }

    public static class F2m extends AbstractF2m {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* JADX INFO: renamed from: ks, reason: collision with root package name */
        private int[] f525432ks;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f525433m;
        private int representation;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        LongArray f525434x;

        public F2m(int r100, int r101, int r102, int r103, BigInteger r104) {
            if (r104 == null) goto L22;
            if (r104.signum() < 0) goto L22;
            if (r104.bitLength() > r100) goto L22;
            if (r102 != 0) goto L12;
            if (r103 != 0) goto L12;
            this.representation = 2;
            this.f525432ks = new int[]{r101};
        L15:
            this.f525433m = r100;
            this.f525434x = new LongArray(r104);
            return;
        L12:
            if (r102 >= r103) goto L20;
            if (r102 <= 0) goto L18;
            this.representation = 3;
            this.f525432ks = new int[]{r101, r102, r103};
            goto L15
        L18:
            throw new IllegalArgumentException("k2 must be larger than 0");
        L20:
            throw new IllegalArgumentException("k2 must be smaller than k3");
        L22:
            throw new IllegalArgumentException("x value invalid in F2m field element");
        }

        public F2m(int r100, int[] r101, LongArray r102) {
            this.f525433m = r100;
            if (r101.length != 1) goto L5;
            int r103 = 2;
        L6:
            this.representation = r103;
            this.f525432ks = r101;
            this.f525434x = r102;
            return;
        L5:
            r103 = 3;
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement r100) {
            LongArray r101 = (LongArray) this.f525434x.clone();
            r101.addShiftedByWords(((F2m) r100).f525434x, 0);
            return new F2m(this.f525433m, this.f525432ks, r101);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.f525433m, this.f525432ks, this.f525434x.addOne());
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.f525434x.degree();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement r100) {
            return multiply(r100.invert());
        }

        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof F2m) == true) goto L8;
            return false;
        L8:
            F2m r101 = (F2m) r100;
            if (this.f525433m == r101.f525433m) goto L11;
        L17:
            return false;
        L11:
            if (this.representation != r101.representation) goto L17;
            if (Arrays.areEqual(this.f525432ks, r101.f525432ks) == false) goto L17;
            if (this.f525434x.equals(r101.f525434x) == false) goto L17;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.f525433m;
        }

        public int getK1() {
            return this.f525432ks[0];
        }

        public int getK2() {
            int[] r100 = this.f525432ks;
            if (r100.length >= 2) goto L7;
            return 0;
        L7:
            return r100[1];
        }

        public int getK3() {
            int[] r100 = this.f525432ks;
            if (r100.length >= 3) goto L7;
            return 0;
        L7:
            return r100[2];
        }

        public int getM() {
            return this.f525433m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (this.f525434x.hashCode() ^ this.f525433m) ^ Arrays.hashCode(this.f525432ks);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int r100 = this.f525433m;
            int[] r101 = this.f525432ks;
            return new F2m(r100, r101, this.f525434x.modInverse(r100, r101));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.f525434x.isOne();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.f525434x.isZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement r100) {
            int r101 = this.f525433m;
            int[] r102 = this.f525432ks;
            return new F2m(r101, r102, this.f525434x.modMultiply(((F2m) r100).f525434x, r101, r102));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
            return multiplyPlusProduct(r100, r101, r102);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
            LongArray r103 = this.f525434x;
            LongArray r104 = ((F2m) r100).f525434x;
            LongArray r105 = ((F2m) r101).f525434x;
            LongArray r106 = ((F2m) r102).f525434x;
            LongArray r107 = r103.multiply(r104, this.f525433m, this.f525432ks);
            LongArray r108 = r105.multiply(r106, this.f525433m, this.f525432ks);
            if (r107 == r103) goto L5;
            if (r107 == r104) goto L5;
        L6:
            r107.addShiftedByWords(r108, 0);
            r107.reduce(this.f525433m, this.f525432ks);
            return new F2m(this.f525433m, this.f525432ks, r107);
        L5:
            r107 = (LongArray) r107.clone();
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (this.f525434x.isZero() == true) goto L9;
            if (this.f525434x.isOne() == true) goto L9;
            return squarePow(this.f525433m - 1);
        L9:
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int r100 = this.f525433m;
            int[] r101 = this.f525432ks;
            return new F2m(r100, r101, this.f525434x.modSquare(r100, r101));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
            return squarePlusProduct(r100, r101);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
            LongArray r102 = this.f525434x;
            LongArray r103 = ((F2m) r100).f525434x;
            LongArray r104 = ((F2m) r101).f525434x;
            LongArray r105 = r102.square(this.f525433m, this.f525432ks);
            LongArray r106 = r103.multiply(r104, this.f525433m, this.f525432ks);
            if (r105 != r102) goto L5;
            r105 = (LongArray) r105.clone();
        L5:
            r105.addShiftedByWords(r106, 0);
            r105.reduce(this.f525433m, this.f525432ks);
            return new F2m(this.f525433m, this.f525432ks, r105);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePow(int r100) {
            if (r100 < 1) goto L7;
            int r101 = this.f525433m;
            int[] r102 = this.f525432ks;
            return new F2m(r101, r102, this.f525434x.modSquareN(r100, r101, r102));
        L7:
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement r100) {
            return add(r100);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            return this.f525434x.testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f525434x.toBigInteger();
        }
    }

    public static class Fp extends AbstractFp {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        BigInteger f525435q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        BigInteger f525436r;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        BigInteger f525437x;

        public Fp(BigInteger r100, BigInteger r101) {
            this(r100, calculateResidue(r100), r101);
        }

        public Fp(BigInteger r100, BigInteger r101, BigInteger r102) {
            if (r102 == null) goto L11;
            if (r102.signum() < 0) goto L11;
            if (r102.compareTo(r100) >= 0) goto L11;
            this.f525435q = r100;
            this.f525436r = r101;
            this.f525437x = r102;
            return;
        L11:
            throw new IllegalArgumentException("x value invalid in Fp field element");
        }

        public static BigInteger calculateResidue(BigInteger r100) {
            int r101 = r100.bitLength();
            if (r101 >= 96) goto L5;
            return null;
        L5:
            if (r100.shiftRight(r101 - 64).longValue() == (-1)) goto L7;
            return null;
        L7:
            return ECConstants.ONE.shiftLeft(r101).subtract(r100);
        }

        private ECFieldElement checkSqrt(ECFieldElement r100) {
            if (r100.square().equals(this) == true) goto L7;
            return null;
        L7:
            return r100;
        }

        private BigInteger[] lucasSequence(BigInteger r110, BigInteger r111, BigInteger r112) {
            int r100 = r112.bitLength();
            int r101 = r112.getLowestSetBit();
            BigInteger r102 = ECConstants.ONE;
            int r103 = r100 - 1;
            BigInteger r104 = r110;
            BigInteger r105 = r102;
            BigInteger r106 = ECConstants.TWO;
            BigInteger r107 = r105;
        L4:
            if (r103 < (r101 + 1)) goto L10;
            r102 = modMult(r102, r107);
            if (r112.testBit(r103) == false) goto L8;
            r107 = modMult(r102, r111);
            r105 = modMult(r105, r104);
            r106 = modReduce(r104.multiply(r106).subtract(r110.multiply(r102)));
            r104 = modReduce(r104.multiply(r104).subtract(r107.shiftLeft(1)));
        L9:
            r103 = r103 - 1;
            goto L4
        L8:
            BigInteger r108 = modReduce(r105.multiply(r106).subtract(r102));
            BigInteger r109 = modReduce(r104.multiply(r106).subtract(r110.multiply(r102)));
            r106 = modReduce(r106.multiply(r106).subtract(r102.shiftLeft(1)));
            r104 = r109;
            r105 = r108;
            r107 = r102;
            goto L9
        L10:
            BigInteger r113 = modMult(r102, r107);
            BigInteger r114 = modMult(r113, r111);
            BigInteger r115 = modReduce(r105.multiply(r106).subtract(r113));
            BigInteger r116 = modReduce(r104.multiply(r106).subtract(r110.multiply(r113)));
            BigInteger r117 = modMult(r113, r114);
            int r118 = 1;
        L11:
            if (r118 > r101) goto L14;
            r115 = modMult(r115, r116);
            r116 = modReduce(r116.multiply(r116).subtract(r117.shiftLeft(1)));
            r117 = modMult(r117, r117);
            r118 = r118 + 1;
            goto L11
        L14:
            return new BigInteger[]{r115, r116};
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement r100) {
            return new Fp(this.f525435q, this.f525436r, modAdd(this.f525437x, r100.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger r100 = this.f525437x.add(ECConstants.ONE);
            if (r100.compareTo(this.f525435q) != 0) goto L6;
            r100 = ECConstants.ZERO;
        L6:
            return new Fp(this.f525435q, this.f525436r, r100);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement r100) {
            return new Fp(this.f525435q, this.f525436r, modMult(this.f525437x, modInverse(r100.toBigInteger())));
        }

        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof Fp) == true) goto L8;
            return false;
        L8:
            Fp r101 = (Fp) r100;
            if (this.f525435q.equals(r101.f525435q) == true) goto L11;
        L13:
            return false;
        L11:
            if (this.f525437x.equals(r101.f525437x) == false) goto L13;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.f525435q.bitLength();
        }

        public BigInteger getQ() {
            return this.f525435q;
        }

        public int hashCode() {
            return this.f525435q.hashCode() ^ this.f525437x.hashCode();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.f525435q, this.f525436r, modInverse(this.f525437x));
        }

        public BigInteger modAdd(BigInteger r100, BigInteger r101) {
            BigInteger r102 = r100.add(r101);
            if (r102.compareTo(this.f525435q) >= 0) goto L5;
            return r102;
        L5:
            return r102.subtract(this.f525435q);
        }

        public BigInteger modDouble(BigInteger r100) {
            BigInteger r101 = r100.shiftLeft(1);
            if (r101.compareTo(this.f525435q) >= 0) goto L5;
            return r101;
        L5:
            return r101.subtract(this.f525435q);
        }

        public BigInteger modHalf(BigInteger r100) {
            if (r100.testBit(0) == false) goto L6;
            r100 = this.f525435q.add(r100);
        L6:
            return r100.shiftRight(1);
        }

        public BigInteger modHalfAbs(BigInteger r100) {
            if (r100.testBit(0) == false) goto L6;
            r100 = this.f525435q.subtract(r100);
        L6:
            return r100.shiftRight(1);
        }

        public BigInteger modInverse(BigInteger r100) {
            return BigIntegers.modOddInverse(this.f525435q, r100);
        }

        public BigInteger modMult(BigInteger r100, BigInteger r101) {
            return modReduce(r100.multiply(r101));
        }

        public BigInteger modReduce(BigInteger r100) {
            if (this.f525436r == null) goto L25;
            if (r100.signum() >= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L10;
            r100 = r100.abs();
        L10:
            int r102 = this.f525435q.bitLength();
            boolean r103 = this.f525436r.equals(ECConstants.ONE);
        L12:
            if (r100.bitLength() <= (r102 + 1)) goto L18;
            BigInteger r104 = r100.shiftRight(r102);
            BigInteger r105 = r100.subtract(r104.shiftLeft(r102));
            if (r103 == true) goto L16;
            r104 = r104.multiply(this.f525436r);
        L16:
            r100 = r104.add(r105);
        L18:
            if (r100.compareTo(this.f525435q) < 0) goto L20;
            r100 = r100.subtract(this.f525435q);
            goto L18
        L20:
            if (r101 == true) goto L22;
            return r100;
        L22:
            if (r100.signum() != 0) goto L32;
            return r100;
        L32:
            return this.f525435q.subtract(r100);
        L7:
            r101 = false;
            goto L8
        L25:
            return r100.mod(this.f525435q);
        }

        public BigInteger modSubtract(BigInteger r100, BigInteger r101) {
            BigInteger r102 = r100.subtract(r101);
            if (r102.signum() < 0) goto L5;
            return r102;
        L5:
            return r102.add(this.f525435q);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement r100) {
            return new Fp(this.f525435q, this.f525436r, modMult(this.f525437x, r100.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
            BigInteger r103 = this.f525437x;
            BigInteger r104 = r100.toBigInteger();
            BigInteger r105 = r101.toBigInteger();
            BigInteger r106 = r102.toBigInteger();
            BigInteger r107 = r103.multiply(r104);
            BigInteger r108 = r105.multiply(r106);
            return new Fp(this.f525435q, this.f525436r, modReduce(r107.subtract(r108)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
            BigInteger r103 = this.f525437x;
            BigInteger r104 = r100.toBigInteger();
            BigInteger r105 = r101.toBigInteger();
            BigInteger r106 = r102.toBigInteger();
            BigInteger r107 = r103.multiply(r104);
            BigInteger r108 = r105.multiply(r106);
            return new Fp(this.f525435q, this.f525436r, modReduce(r107.add(r108)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.f525437x.signum() == 0) goto L7;
            BigInteger r100 = this.f525435q;
            return new Fp(r100, this.f525436r, r100.subtract(this.f525437x));
        L7:
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (isZero() == false) goto L5;
        L40:
            return this;
        L5:
            if (isOne() == true) goto L40;
            if (this.f525435q.testBit(0) == false) goto L39;
            if (this.f525435q.testBit(1) == false) goto L14;
            BigInteger r100 = this.f525435q.shiftRight(2).add(ECConstants.ONE);
            BigInteger r101 = this.f525435q;
            return checkSqrt(new Fp(r101, this.f525436r, this.f525437x.modPow(r100, r101)));
        L14:
            if (this.f525435q.testBit(2) == false) goto L21;
            BigInteger r102 = this.f525437x.modPow(this.f525435q.shiftRight(3), this.f525435q);
            BigInteger r103 = modMult(r102, this.f525437x);
            if (modMult(r103, r102).equals(ECConstants.ONE) == true) goto L18;
            BigInteger r104 = modMult(r103, ECConstants.TWO.modPow(this.f525435q.shiftRight(2), this.f525435q));
            return checkSqrt(new Fp(this.f525435q, this.f525436r, r104));
        L18:
            return checkSqrt(new Fp(this.f525435q, this.f525436r, r103));
        L21:
            BigInteger r105 = this.f525435q.shiftRight(1);
            BigInteger r106 = this.f525437x.modPow(r105, this.f525435q);
            BigInteger r107 = ECConstants.ONE;
            if (r106.equals(r107) == true) goto L24;
            return null;
        L24:
            BigInteger r108 = this.f525437x;
            BigInteger r109 = modDouble(modDouble(r108));
            BigInteger r110 = r105.add(r107);
            BigInteger r111 = this.f525435q.subtract(r107);
            Random r112 = new Random();
        L25:
            BigInteger r113 = new BigInteger(this.f525435q.bitLength(), r112);
            if (r113.compareTo(this.f525435q) >= 0) goto L25;
            if (modReduce(r113.multiply(r113).subtract(r109)).modPow(r105, this.f525435q).equals(r111) == false) goto L25;
            BigInteger[] r114 = lucasSequence(r113, r108, r110);
            BigInteger r115 = r114[0];
            BigInteger r116 = r114[1];
            if (modMult(r116, r116).equals(r109) == true) goto L32;
            if (r115.equals(ECConstants.ONE) == true) goto L25;
            if (r115.equals(r111) == true) goto L25;
            return null;
        L32:
            return new Fp(this.f525435q, this.f525436r, modHalfAbs(r116));
        L39:
            throw new RuntimeException("not done yet");
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger r100 = this.f525435q;
            BigInteger r101 = this.f525436r;
            BigInteger r102 = this.f525437x;
            return new Fp(r100, r101, modMult(r102, r102));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
            BigInteger r102 = this.f525437x;
            BigInteger r103 = r100.toBigInteger();
            BigInteger r104 = r101.toBigInteger();
            BigInteger r105 = r102.multiply(r102);
            BigInteger r106 = r103.multiply(r104);
            return new Fp(this.f525435q, this.f525436r, modReduce(r105.subtract(r106)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
            BigInteger r102 = this.f525437x;
            BigInteger r103 = r100.toBigInteger();
            BigInteger r104 = r101.toBigInteger();
            BigInteger r105 = r102.multiply(r102);
            BigInteger r106 = r103.multiply(r104);
            return new Fp(this.f525435q, this.f525436r, modReduce(r105.add(r106)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement r100) {
            return new Fp(this.f525435q, this.f525436r, modSubtract(this.f525437x, r100.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f525437x;
        }
    }

    public ECFieldElement() {
    }

    public abstract ECFieldElement add(ECFieldElement r100);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement r100);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        if (bitLength() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isZero() {
        if (toBigInteger().signum() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract ECFieldElement multiply(ECFieldElement r100);

    public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        return multiply(r100).subtract(r101.multiply(r102));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        return multiply(r100).add(r101.multiply(r102));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
        return square().subtract(r100.multiply(r101));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
        return square().add(r100.multiply(r101));
    }

    public ECFieldElement squarePow(int r100) {
        int r101 = 0;
        ECFieldElement r102 = this;
    L3:
        if (r101 >= r100) goto L5;
        r102 = r102.square();
        r101 = r101 + 1;
        goto L3
    L5:
        return r102;
    }

    public abstract ECFieldElement subtract(ECFieldElement r100);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
