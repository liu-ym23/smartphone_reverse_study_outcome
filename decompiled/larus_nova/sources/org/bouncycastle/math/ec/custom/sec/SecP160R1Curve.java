package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP160R1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SECP160R1_AFFINE_ZS = null;
    private static final int SECP160R1_DEFAULT_COORDS = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f525450q = null;
    protected SecP160R1Point infinity;

    static {
        f525450q = SecP160R1FieldElement.Q;
        SECP160R1_AFFINE_ZS = new ECFieldElement[]{new SecP160R1FieldElement(ECConstants.ONE)};
    }

    public SecP160R1Curve() {
        super(f525450q);
        this.infinity = new SecP160R1Point(this, null, null);
        this.f525423a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f525424b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return SECP160R1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecP160R1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r102) {
        final int[] r103 = new int[(r102 * 5) * 2];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L6;
        ECPoint r106 = r100[r101 + r104];
        Nat160.copy(((SecP160R1FieldElement) r106.getRawXCoord()).f525451x, 0, r103, r105);
        int r107 = r105 + 5;
        Nat160.copy(((SecP160R1FieldElement) r106.getRawYCoord()).f525451x, 0, r103, r107);
        r105 = r107 + 5;
        r104 = r104 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r102, r103);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new SecP160R1Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new SecP160R1Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new SecP160R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f525450q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f525450q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.random(r100, r101);
        return new SecP160R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.randomMult(r100, r101);
        return new SecP160R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
