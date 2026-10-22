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
public class SecP521R1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SECP521R1_AFFINE_ZS = null;
    private static final int SECP521R1_DEFAULT_COORDS = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f525468q = null;
    protected SecP521R1Point infinity;

    static {
        f525468q = SecP521R1FieldElement.Q;
        SECP521R1_AFFINE_ZS = new ECFieldElement[]{new SecP521R1FieldElement(ECConstants.ONE)};
    }

    public SecP521R1Curve() {
        super(f525468q);
        this.infinity = new SecP521R1Point(this, null, null);
        this.f525423a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f525424b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.order = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return SECP521R1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecP521R1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r110) {
        final int[] r102 = new int[(r110 * 17) * 2];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r110) goto L6;
        ECPoint r105 = r100[r101 + r103];
        Nat.copy(17, ((SecP521R1FieldElement) r105.getRawXCoord()).f525469x, 0, r102, r104);
        int r106 = r104 + 17;
        Nat.copy(17, ((SecP521R1FieldElement) r105.getRawYCoord()).f525469x, 0, r102, r106);
        r104 = r106 + 17;
        r103 = r103 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r110, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new SecP521R1Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new SecP521R1Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new SecP521R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f525468q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f525468q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.random(r100, r101);
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.randomMult(r100, r101);
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
