package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class Curve25519 extends ECCurve.AbstractFp {
    private static final ECFieldElement[] CURVE25519_AFFINE_ZS = null;
    private static final int CURVE25519_DEFAULT_COORDS = 4;
    private static final BigInteger C_a = null;
    private static final BigInteger C_b = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f525443q = null;
    protected Curve25519Point infinity;

    static {
        f525443q = Curve25519FieldElement.Q;
        BigInteger r100 = new BigInteger(1, Hex.decodeStrict("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        C_a = r100;
        C_b = new BigInteger(1, Hex.decodeStrict("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        CURVE25519_AFFINE_ZS = new ECFieldElement[]{new Curve25519FieldElement(ECConstants.ONE), new Curve25519FieldElement(r100)};
    }

    public Curve25519() {
        super(f525443q);
        this.infinity = new Curve25519Point(this, null, null);
        this.f525423a = fromBigInteger(C_a);
        this.f525424b = fromBigInteger(C_b);
        this.order = new BigInteger(1, Hex.decodeStrict("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.cofactor = BigInteger.valueOf(8);
        this.coord = 4;
    }

    public static /* synthetic */ ECFieldElement[] access$000() {
        return CURVE25519_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new Curve25519();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r100, int r101, final int r102) {
        final int[] r103 = new int[(r102 * 8) * 2];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L6;
        ECPoint r106 = r100[r101 + r104];
        Nat256.copy(((Curve25519FieldElement) r106.getRawXCoord()).f525444x, 0, r103, r105);
        int r107 = r105 + 8;
        Nat256.copy(((Curve25519FieldElement) r106.getRawYCoord()).f525444x, 0, r103, r107);
        r105 = r107 + 8;
        r104 = r104 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r102, r103);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101) {
        return new Curve25519Point(this, r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r100, ECFieldElement r101, ECFieldElement[] r102) {
        return new Curve25519Point(this, r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r100) {
        return new Curve25519FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f525443q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f525443q;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.random(r100, r101);
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.randomMult(r100, r101);
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r100) {
        if (r100 == 4) goto L6;
        return false;
    L6:
        return true;
    }
}
