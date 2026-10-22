package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.FiniteFields;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ECFieldElement f525423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ECFieldElement f525424b;
    protected BigInteger cofactor;
    protected int coord;
    protected ECEndomorphism endomorphism;
    protected FiniteField field;
    protected ECMultiplier multiplier;
    protected BigInteger order;

    public static abstract class AbstractF2m extends ECCurve {

        /* JADX INFO: renamed from: si, reason: collision with root package name */
        private BigInteger[] f525425si;

        public AbstractF2m(int r100, int r101, int r102, int r103) {
            super(buildField(r100, r101, r102, r103));
            this.f525425si = null;
        }

        private static FiniteField buildField(int r100, int r101, int r102, int r103) {
            if (r101 == 0) goto L19;
            if (r102 != 0) goto L10;
            if (r103 != 0) goto L9;
            return FiniteFields.getBinaryExtensionField(new int[]{0, r101, r100});
        L9:
            throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
        L10:
            if (r102 <= r101) goto L17;
            if (r103 <= r102) goto L15;
            return FiniteFields.getBinaryExtensionField(new int[]{0, r101, r102, r103, r100});
        L15:
            throw new IllegalArgumentException("k3 must be > k2");
        L17:
            throw new IllegalArgumentException("k2 must be > k1");
        L19:
            throw new IllegalArgumentException("k1 must be > 0");
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r100, int r101) {
        L2:
            BigInteger r102 = BigIntegers.createRandomBigInteger(r101, r100);
            if (r102.signum() <= 0) goto L2;
            return r102;
        }

        public static BigInteger inverse(int r100, int[] r101, BigInteger r102) {
            return new LongArray(r102).modInverse(r100, r101).toBigInteger();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger r100, BigInteger r101) {
            ECFieldElement r102 = fromBigInteger(r100);
            ECFieldElement r103 = fromBigInteger(r101);
            int r104 = getCoordinateSystem();
            if (r104 == 5) goto L8;
            if (r104 == 6) goto L8;
        L16:
            return createRawPoint(r102, r103);
        L8:
            if (r102.isZero() == true) goto L10;
            r103 = r103.divide(r102).add(r102);
            goto L16
        L10:
            if (r103.square().equals(getB()) == true) goto L16;
            throw new IllegalArgumentException();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int r100, BigInteger r101) {
            ECFieldElement r102 = fromBigInteger(r101);
            if (r102.isZero() == false) goto L5;
            ECFieldElement r103 = getB().sqrt();
        L20:
            if (r103 == null) goto L24;
            return createRawPoint(r102, r103);
        L24:
            throw new IllegalArgumentException("Invalid point compression");
        L5:
            ECFieldElement r104 = solveQuadraticEquation(r102.square().invert().multiply(getB()).add(getA()).add(r102));
            if (r104 == null) goto L19;
            boolean r105 = r104.testBitZero();
            boolean r106 = true;
            if (r100 == 1) goto L11;
            r106 = false;
        L11:
            if (r105 == r106) goto L13;
            r104 = r104.addOne();
        L13:
            int r107 = getCoordinateSystem();
            if (r107 != 5) goto L16;
        L18:
            r103 = r104.add(r102);
            goto L20
        L16:
            if (r107 == 6) goto L18;
            r103 = r104.multiply(r102);
            goto L20
        L19:
            r103 = null;
            goto L20
        }

        public synchronized BigInteger[] getSi() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.f525425si != null) goto L6;
            this.f525425si = Tnaf.getSi(this);     // Catch: Throwable -> L9
        L6:
            BigInteger[] r100 = this.f525425si;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r100;
        }

        public boolean isKoblitz() {
            if (this.order != null) goto L5;
        L13:
            return false;
        L5:
            if (this.cofactor == null) goto L13;
            if (this.f525424b.isOne() == false) goto L13;
            if (this.f525423a.isZero() == false) goto L11;
        L12:
            return true;
        L11:
            if (this.f525423a.isOne() == false) goto L13;
            goto L12
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean isValidFieldElement(BigInteger r100) {
            if (r100 != null) goto L4;
        L8:
            return false;
        L4:
            if (r100.signum() < 0) goto L8;
            if (r100.bitLength() > getFieldSize()) goto L8;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElement(SecureRandom r100) {
            return fromBigInteger(BigIntegers.createRandomBigInteger(getFieldSize(), r100));
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r100) {
            int r101 = getFieldSize();
            return fromBigInteger(implRandomFieldElementMult(r100, r101)).multiply(fromBigInteger(implRandomFieldElementMult(r100, r101)));
        }

        public ECFieldElement solveQuadraticEquation(ECFieldElement r110) {
            ECFieldElement.AbstractF2m r100 = (ECFieldElement.AbstractF2m) r110;
            boolean r101 = r100.hasFastTrace();
            if (r101 == true) goto L5;
        L7:
            int r102 = getFieldSize();
            if ((r102 & 1) == 0) goto L17;
            ECFieldElement r103 = r100.halfTrace();
            if (r101 == false) goto L12;
        L15:
            return r103;
        L12:
            if (r103.square().add(r103).add(r110).isZero() == true) goto L15;
            return null;
        L17:
            if (r110.isZero() == false) goto L19;
            return r110;
        L19:
            ECFieldElement r104 = fromBigInteger(ECConstants.ZERO);
            Random r105 = new Random();
        L20:
            ECFieldElement r106 = fromBigInteger(new BigInteger(r102, r105));
            int r107 = 1;
            ECFieldElement r108 = r110;
            ECFieldElement r109 = r104;
        L21:
            if (r107 >= r102) goto L24;
            ECFieldElement r111 = r108.square();
            r109 = r109.square().add(r111.multiply(r106));
            r108 = r111.add(r110);
            r107 = r107 + 1;
            goto L21
        L24:
            if (r108.isZero() == false) goto L25;
            if (r109.square().add(r109).isZero() == true) goto L20;
            return r109;
        L25:
            return null;
        L5:
            if (r100.trace() == 0) goto L7;
            return null;
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger r100) {
            super(FiniteFields.getPrimeField(r100));
        }

        private static BigInteger implRandomFieldElement(SecureRandom r100, BigInteger r101) {
        L2:
            BigInteger r102 = BigIntegers.createRandomBigInteger(r101.bitLength(), r100);
            if (r102.compareTo(r101) >= 0) goto L2;
            return r102;
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r100, BigInteger r101) {
        L2:
            BigInteger r102 = BigIntegers.createRandomBigInteger(r101.bitLength(), r100);
            if (r102.signum() <= 0) goto L2;
            if (r102.compareTo(r101) >= 0) goto L2;
            return r102;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int r100, BigInteger r101) {
            ECFieldElement r102 = fromBigInteger(r101);
            ECFieldElement r103 = r102.square().add(this.f525423a).multiply(r102).add(this.f525424b).sqrt();
            if (r103 == null) goto L13;
            boolean r104 = r103.testBitZero();
            boolean r105 = true;
            if (r100 == 1) goto L8;
            r105 = false;
        L8:
            if (r104 == r105) goto L11;
            r103 = r103.negate();
        L11:
            return createRawPoint(r102, r103);
        L13:
            throw new IllegalArgumentException("Invalid point compression");
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean isValidFieldElement(BigInteger r100) {
            if (r100 != null) goto L4;
        L8:
            return false;
        L4:
            if (r100.signum() < 0) goto L8;
            if (r100.compareTo(getField().getCharacteristic()) >= 0) goto L8;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElement(SecureRandom r100) {
            BigInteger r101 = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElement(r100, r101)).multiply(fromBigInteger(implRandomFieldElement(r100, r101)));
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r100) {
            BigInteger r101 = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElementMult(r100, r101)).multiply(fromBigInteger(implRandomFieldElementMult(r100, r101)));
        }
    }

    public class Config {
        protected int coord;
        protected ECEndomorphism endomorphism;
        protected ECMultiplier multiplier;
        final /* synthetic */ ECCurve this$0;

        public Config(ECCurve r100, int r101, ECEndomorphism r102, ECMultiplier r103) {
            this.this$0 = r100;
            this.coord = r101;
            this.endomorphism = r102;
            this.multiplier = r103;
        }

        public ECCurve create() {
            if (this.this$0.supportsCoordinateSystem(this.coord) == false) goto L16;
            ECCurve r100 = this.this$0.cloneCurve();
            if (r100 == this.this$0) goto L14;
            monitor-enter(r100);
            r100.coord = this.coord;     // Catch: Throwable -> L10
            r100.endomorphism = this.endomorphism;     // Catch: Throwable -> L10
            r100.multiplier = this.multiplier;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r100;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalStateException("implementation returned current curve");
        L16:
            throw new IllegalStateException("unsupported coordinate system");
        }

        public Config setCoordinateSystem(int r100) {
            this.coord = r100;
            return this;
        }

        public Config setEndomorphism(ECEndomorphism r100) {
            this.endomorphism = r100;
            return this;
        }

        public Config setMultiplier(ECMultiplier r100) {
            this.multiplier = r100;
            return this;
        }
    }

    public static class F2m extends AbstractF2m {
        private static final int F2M_DEFAULT_COORDS = 6;
        private ECPoint.F2m infinity;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        private int f525426k1;

        /* JADX INFO: renamed from: k2, reason: collision with root package name */
        private int f525427k2;

        /* JADX INFO: renamed from: k3, reason: collision with root package name */
        private int f525428k3;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f525429m;

        public F2m(int r110, int r111, int r112, int r113, BigInteger r114, BigInteger r115) {
            this(r110, r111, r112, r113, r114, r115, null, null);
        }

        public F2m(int r100, int r101, int r102, int r103, BigInteger r104, BigInteger r105, BigInteger r106, BigInteger r107) {
            super(r100, r101, r102, r103);
            this.f525429m = r100;
            this.f525426k1 = r101;
            this.f525427k2 = r102;
            this.f525428k3 = r103;
            this.order = r106;
            this.cofactor = r107;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f525423a = fromBigInteger(r104);
            this.f525424b = fromBigInteger(r105);
            this.coord = 6;
        }

        public F2m(int r100, int r101, int r102, int r103, ECFieldElement r104, ECFieldElement r105, BigInteger r106, BigInteger r107) {
            super(r100, r101, r102, r103);
            this.f525429m = r100;
            this.f525426k1 = r101;
            this.f525427k2 = r102;
            this.f525428k3 = r103;
            this.order = r106;
            this.cofactor = r107;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f525423a = r104;
            this.f525424b = r105;
            this.coord = 6;
        }

        public F2m(int r110, int r111, BigInteger r112, BigInteger r113) {
            this(r110, r111, 0, 0, r112, r113, null, null);
        }

        public F2m(int r110, int r111, BigInteger r112, BigInteger r113, BigInteger r114, BigInteger r115) {
            this(r110, r111, 0, 0, r112, r113, r114, r115);
        }

        public static /* synthetic */ int access$000(F2m r100) {
            return r100.f525429m;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new F2m(this.f525429m, this.f525426k1, this.f525427k2, this.f525428k3, this.f525423a, this.f525424b, this.order, this.cofactor);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r110) {
            final int r102 = (this.f525429m + 63) >>> 6;
            int r103 = 0;
            if (isTrinomial() == false) goto L5;
            int[] r104 = {this.f525426k1};
        L6:
            final int[] r105 = r104;
            final long[] r106 = new long[(r110 * r102) * 2];
            int r107 = 0;
        L7:
            if (r103 >= r110) goto L10;
            ECPoint r108 = r100[r101 + r103];
            ((ECFieldElement.F2m) r108.getRawXCoord()).f525434x.copyTo(r106, r107);
            int r109 = r107 + r102;
            ((ECFieldElement.F2m) r108.getRawYCoord()).f525434x.copyTo(r106, r109);
            r107 = r109 + r102;
            r103 = r103 + 1;
            goto L7
        L10:
            return new AnonymousClass1(this, r110, r102, r106, r105);
        L5:
            r104 = new int[]{this.f525426k1, this.f525427k2, this.f525428k3};
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECMultiplier createDefaultMultiplier() {
            if (isKoblitz() == false) goto L7;
            return new WTauNafMultiplier();
        L7:
            return super.createDefaultMultiplier();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
            return new ECPoint.F2m(this, r100, r101);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
            return new ECPoint.F2m(this, r100, r101, r102);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger r100) {
            return new ECFieldElement.F2m(this.f525429m, this.f525426k1, this.f525427k2, this.f525428k3, r100);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.f525429m;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.f525426k1;
        }

        public int getK2() {
            return this.f525427k2;
        }

        public int getK3() {
            return this.f525428k3;
        }

        public int getM() {
            return this.f525429m;
        }

        public boolean isTrinomial() {
            if (this.f525427k2 == 0) goto L5;
        L7:
            return false;
        L5:
            if (this.f525428k3 != 0) goto L7;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int r100) {
            if (r100 == 0) goto L9;
            if (r100 == 1) goto L9;
            if (r100 == 6) goto L9;
            return false;
        L9:
            return true;
        }
    }

    public static class Fp extends AbstractFp {
        private static final int FP_DEFAULT_COORDS = 4;
        ECPoint.Fp infinity;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        BigInteger f525430q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        BigInteger f525431r;

        public Fp(BigInteger r100, BigInteger r101, BigInteger r102) {
            this(r100, r101, r102, null, null);
        }

        public Fp(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104) {
            super(r100);
            this.f525430q = r100;
            this.f525431r = ECFieldElement.Fp.calculateResidue(r100);
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f525423a = fromBigInteger(r101);
            this.f525424b = fromBigInteger(r102);
            this.order = r103;
            this.cofactor = r104;
            this.coord = 4;
        }

        public Fp(BigInteger r100, BigInteger r101, ECFieldElement r102, ECFieldElement r103, BigInteger r104, BigInteger r105) {
            super(r100);
            this.f525430q = r100;
            this.f525431r = r101;
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f525423a = r102;
            this.f525424b = r103;
            this.order = r104;
            this.cofactor = r105;
            this.coord = 4;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new Fp(this.f525430q, this.f525431r, this.f525423a, this.f525424b, this.order, this.cofactor);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
            return new ECPoint.Fp(this, r100, r101);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
            return new ECPoint.Fp(this, r100, r101, r102);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger r100) {
            return new ECFieldElement.Fp(this.f525430q, this.f525431r, r100);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.f525430q.bitLength();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.f525430q;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint importPoint(ECPoint r100) {
            if (this == r100.getCurve()) goto L18;
            if (getCoordinateSystem() != 2) goto L18;
            if (r100.isInfinity() == true) goto L18;
            int r101 = r100.getCurve().getCoordinateSystem();
            if (r101 == 2) goto L16;
            if (r101 == 3) goto L16;
            if (r101 != 4) goto L18;
        L16:
            return new ECPoint.Fp(this, fromBigInteger(r100.f525438x.toBigInteger()), fromBigInteger(r100.f525439y.toBigInteger()), new ECFieldElement[]{fromBigInteger(r100.f525440zs[0].toBigInteger())});
        L18:
            return super.importPoint(r100);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L11;
            if (r100 == 4) goto L11;
            return false;
        L11:
            return true;
        }
    }

    public ECCurve(FiniteField r100) {
        this.coord = 0;
        this.endomorphism = null;
        this.multiplier = null;
        this.field = r100;
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public void checkPoint(ECPoint r100) {
        if (r100 == null) goto L7;
        if (this != r100.getCurve()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("'point' must be non-null and on this curve");
    }

    public void checkPoints(ECPoint[] r100) {
        checkPoints(r100, 0, r100.length);
    }

    public void checkPoints(ECPoint[] r100, int r101, int r102) {
        if (r100 == null) goto L21;
        if (r101 < 0) goto L19;
        if (r102 < 0) goto L19;
        if (r101 > (r100.length - r102)) goto L19;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        ECPoint r104 = r100[r101 + r103];
        if (r104 == null) goto L16;
        if (this == r104.getCurve()) goto L16;
        throw new IllegalArgumentException("'points' entries must be null or on this curve");
    L16:
        r103 = r103 + 1;
        goto L8
    L17:
        return;
    L19:
        throw new IllegalArgumentException("invalid range specified for 'points'");
    L21:
        throw new IllegalArgumentException("'points' cannot be null");
    }

    public abstract ECCurve cloneCurve();

    public synchronized Config configure() {
        monitor-enter(this);
        Config r100 = new Config(this, this.coord, this.endomorphism, this.multiplier);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r110, int r111, final int r112) {
        final int r100 = (getFieldSize() + 7) >>> 3;
        final byte[] r101 = new byte[(r112 * r100) * 2];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r112) goto L14;
        ECPoint r104 = r110[r111 + r102];
        byte[] r105 = r104.getRawXCoord().toBigInteger().toByteArray();
        byte[] r106 = r104.getRawYCoord().toBigInteger().toByteArray();
        int r107 = 1;
        if (r105.length <= r100) goto L7;
        int r108 = 1;
    L8:
        int r109 = r105.length - r108;
        if (r106.length > r100) goto L12;
        r107 = 0;
    L12:
        int r113 = r106.length - r107;
        int r114 = r103 + r100;
        System.arraycopy(r105, r108, r101, r114 - r109, r109);
        r103 = r114 + r100;
        System.arraycopy(r106, r107, r101, r103 - r113, r113);
        r102 = r102 + 1;
        goto L3
    L7:
        r108 = 0;
        goto L8
    L14:
        return new AnonymousClass1(this, r112, r100, r101);
    }

    public ECMultiplier createDefaultMultiplier() {
        ECEndomorphism r100 = this.endomorphism;
        if ((r100 instanceof GLVEndomorphism) == false) goto L7;
        return new GLVMultiplier(this, (GLVEndomorphism) r100);
    L7:
        return new WNafL2RMultiplier();
    }

    public ECPoint createPoint(BigInteger r100, BigInteger r101) {
        return createRawPoint(fromBigInteger(r100), fromBigInteger(r101));
    }

    public abstract ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101);

    public abstract ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102);

    public ECPoint decodePoint(byte[] r100) {
        int r101 = (getFieldSize() + 7) / 8;
        boolean r102 = false;
        byte r103 = r100[0];
        if (r103 == 0) goto L42;
        if (r103 == 2) goto L33;
        if (r103 == 3) goto L33;
        if (r103 == 4) goto L28;
        if (r103 == 6) goto L17;
        if (r103 == 7) goto L17;
        throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(r103, 16));
    L17:
        if (r100.length != ((r101 * 2) + 1)) goto L26;
        BigInteger r104 = BigIntegers.fromUnsignedByteArray(r100, 1, r101);
        BigInteger r105 = BigIntegers.fromUnsignedByteArray(r100, r101 + 1, r101);
        boolean r106 = r105.testBit(0);
        if (r103 != 7) goto L21;
        r102 = true;
    L21:
        if (r106 != r102) goto L24;
        ECPoint r107 = validatePoint(r104, r105);
    L44:
        if (r103 != 0) goto L46;
    L50:
        return r107;
    L46:
        if (r107.isInfinity() == false) goto L50;
        throw new IllegalArgumentException("Invalid infinity encoding");
    L24:
        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
    L26:
        throw new IllegalArgumentException("Incorrect length for hybrid encoding");
    L28:
        if (r100.length != ((r101 * 2) + 1)) goto L31;
        r107 = validatePoint(BigIntegers.fromUnsignedByteArray(r100, 1, r101), BigIntegers.fromUnsignedByteArray(r100, r101 + 1, r101));
        goto L44
    L31:
        throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
    L33:
        if (r100.length != (r101 + 1)) goto L40;
        r107 = decompressPoint(r103 & 1, BigIntegers.fromUnsignedByteArray(r100, 1, r101));
        if (r107.implIsValid(true, true) == true) goto L44;
        throw new IllegalArgumentException("Invalid point");
    L40:
        throw new IllegalArgumentException("Incorrect length for compressed encoding");
    L42:
        if (r100.length != 1) goto L52;
        r107 = getInfinity();
        goto L44
    L52:
        throw new IllegalArgumentException("Incorrect length for infinity encoding");
    }

    public abstract ECPoint decompressPoint(int r100, BigInteger r101);

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof ECCurve) == true) goto L6;
    L8:
        return false;
    L6:
        if (equals((ECCurve) r100) == false) goto L8;
        goto L8
    }

    public boolean equals(ECCurve r100) {
        if (this == r100) goto L12;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (getField().equals(r100.getField()) == false) goto L11;
        if (getA().toBigInteger().equals(r100.getA().toBigInteger()) == false) goto L11;
        if (getB().toBigInteger().equals(r100.getB().toBigInteger()) == false) goto L11;
    L12:
        return true;
    }

    public abstract ECFieldElement fromBigInteger(BigInteger r100);

    public ECFieldElement getA() {
        return this.f525423a;
    }

    public ECFieldElement getB() {
        return this.f525424b;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public FiniteField getField() {
        return this.field;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier != null) goto L6;
        this.multiplier = createDefaultMultiplier();
    L6:
        return this.multiplier;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public PreCompInfo getPreCompInfo(ECPoint r100, String r101) {
        checkPoint(r100);
        monitor-enter(r100);
        Hashtable r102 = r100.preCompTable;     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        if (r102 != null) goto L9;
        return null;
    L9:
        monitor-enter(r102);
        PreCompInfo r103 = (PreCompInfo) r102.get(r101);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return r103;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        return (getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8)) ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    public ECPoint importPoint(ECPoint r100) {
        if (this != r100.getCurve()) goto L6;
        return r100;
    L6:
        if (r100.isInfinity() == true) goto L8;
        ECPoint r101 = r100.normalize();
        return createPoint(r101.getXCoord().toBigInteger(), r101.getYCoord().toBigInteger());
    L8:
        return getInfinity();
    }

    public abstract boolean isValidFieldElement(BigInteger r100);

    public void normalizeAll(ECPoint[] r100) {
        normalizeAll(r100, 0, r100.length, null);
    }

    public void normalizeAll(ECPoint[] r100, int r110, int r111, ECFieldElement r112) {
        checkPoints(r100, r110, r111);
        int r101 = getCoordinateSystem();
        if (r101 != 0) goto L5;
    L21:
        if (r112 != null) goto L24;
        return;
    L24:
        throw new IllegalArgumentException("'iso' not valid for affine coordinates");
    L5:
        if (r101 == 5) goto L21;
        ECFieldElement[] r102 = new ECFieldElement[r111];
        int[] r103 = new int[r111];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r105 >= r111) goto L15;
        int r107 = r110 + r105;
        ECPoint r108 = r100[r107];
        if (r108 == null) goto L14;
        if (r112 == null) goto L12;
    L13:
        r102[r106] = r108.getZCoord(0);
        r103[r106] = r107;
        r106 = r106 + 1;
        goto L14
    L12:
        if (r108.isNormalized() == false) goto L13;
    L14:
        r105 = r105 + 1;
        goto L7
    L15:
        if (r106 != 0) goto L17;
        return;
    L17:
        ECAlgorithms.montgomeryTrick(r102, 0, r106, r112);
    L18:
        if (r104 >= r106) goto L20;
        int r113 = r103[r104];
        r100[r113] = r100[r113].normalize(r102[r104]);
        r104 = r104 + 1;
        goto L18
    }

    public PreCompInfo precompute(ECPoint r100, String r101, PreCompCallback r102) {
        checkPoint(r100);
        monitor-enter(r100);
        Hashtable r103 = r100.preCompTable;     // Catch: Throwable -> L17
        if (r103 != null) goto L7;
        r103 = new Hashtable(4);     // Catch: Throwable -> L17
        r100.preCompTable = r103;     // Catch: Throwable -> L17
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L17
        monitor-enter(r103);
        PreCompInfo r104 = (PreCompInfo) r103.get(r101);     // Catch: Throwable -> L14
        PreCompInfo r105 = r102.precompute(r104);     // Catch: Throwable -> L14
        if (r105 == r104) goto L12;
        r103.put(r101, r105);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L14
        return r105;
    L14:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    public abstract ECFieldElement randomFieldElement(SecureRandom r100);

    public abstract ECFieldElement randomFieldElementMult(SecureRandom r100);

    public boolean supportsCoordinateSystem(int r100) {
        if (r100 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    public ECPoint validatePoint(BigInteger r100, BigInteger r101) {
        ECPoint r102 = createPoint(r100, r101);
        if (r102.isValid() == false) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
