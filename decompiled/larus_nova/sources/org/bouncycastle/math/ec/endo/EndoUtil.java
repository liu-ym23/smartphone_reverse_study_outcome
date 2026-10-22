package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public abstract class EndoUtil {
    public static final String PRECOMP_NAME = "bc_endo";

    public EndoUtil() {
    }

    private static BigInteger calculateB(BigInteger r100, BigInteger r101, int r102) {
        if (r101.signum() >= 0) goto L5;
        boolean r103 = true;
    L6:
        BigInteger r104 = r100.multiply(r101.abs());
        boolean r105 = r104.testBit(r102 - 1);
        BigInteger r106 = r104.shiftRight(r102);
        if (r105 == false) goto L9;
        r106 = r106.add(ECConstants.ONE);
    L9:
        if (r103 == true) goto L11;
        return r106;
    L11:
        return r106.negate();
    L5:
        r103 = false;
        goto L6
    }

    public static BigInteger[] decomposeScalar(ScalarSplitParameters r100, BigInteger r101) {
        int r102 = r100.getBits();
        BigInteger r103 = calculateB(r101, r100.getG1(), r102);
        BigInteger r104 = calculateB(r101, r100.getG2(), r102);
        return new BigInteger[]{r101.subtract(r103.multiply(r100.getV1A()).add(r104.multiply(r100.getV2A()))), r103.multiply(r100.getV1B()).add(r104.multiply(r100.getV2B())).negate()};
    }

    public static ECPoint mapPoint(final ECEndomorphism r100, final ECPoint r101) {
        return ((EndoPreCompInfo) r101.getCurve().precompute(r101, PRECOMP_NAME, new AnonymousClass1(r100, r101))).getMappedPoint();
    }
}
