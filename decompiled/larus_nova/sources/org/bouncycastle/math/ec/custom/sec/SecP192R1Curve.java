package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192R1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SECP192R1_AFFINE_ZS = null;
    private static final int SECP192R1_DEFAULT_COORDS = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f525456q = null;
    protected SecP192R1Point infinity;

    static {
        f525456q = SecP192R1FieldElement.Q;
        SECP192R1_AFFINE_ZS = new ECFieldElement[]{new SecP192R1FieldElement(ECConstants.ONE)};
    }

    public SecP192R1Curve() {
        super(f525456q);
        this.infinity = new SecP192R1Point(this, null, null);
        this.f525423a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f525424b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return SECP192R1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecP192R1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r102) {
        final int[] r103 = new int[(r102 * 6) * 2];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L6;
        ECPoint r106 = r100[r101 + r104];
        Nat192.copy(((SecP192R1FieldElement) r106.getRawXCoord()).f525457x, 0, r103, r105);
        int r107 = r105 + 6;
        Nat192.copy(((SecP192R1FieldElement) r106.getRawYCoord()).f525457x, 0, r103, r107);
        r105 = r107 + 6;
        r104 = r104 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r102, r103);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new SecP192R1Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new SecP192R1Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new SecP192R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f525456q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f525456q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.random(r100, r101);
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.randomMult(r100, r101);
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
