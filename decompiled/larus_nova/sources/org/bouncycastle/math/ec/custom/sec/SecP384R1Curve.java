package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP384R1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SECP384R1_AFFINE_ZS = null;
    private static final int SECP384R1_DEFAULT_COORDS = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f525466q = null;
    protected SecP384R1Point infinity;

    static {
        f525466q = SecP384R1FieldElement.Q;
        SECP384R1_AFFINE_ZS = new ECFieldElement[]{new SecP384R1FieldElement(ECConstants.ONE)};
    }

    public SecP384R1Curve() {
        super(f525466q);
        this.infinity = new SecP384R1Point(this, null, null);
        this.f525423a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f525424b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return SECP384R1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecP384R1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r110) {
        final int[] r102 = new int[(r110 * 12) * 2];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r110) goto L6;
        ECPoint r105 = r100[r101 + r103];
        Nat.copy(12, ((SecP384R1FieldElement) r105.getRawXCoord()).f525467x, 0, r102, r104);
        int r106 = r104 + 12;
        Nat.copy(12, ((SecP384R1FieldElement) r105.getRawYCoord()).f525467x, 0, r102, r106);
        r104 = r106 + 12;
        r103 = r103 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r110, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new SecP384R1Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new SecP384R1Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new SecP384R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f525466q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f525466q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.random(r100, r101);
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.randomMult(r100, r101);
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
