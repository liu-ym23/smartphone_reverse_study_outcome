package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractECMultiplier implements ECMultiplier {
    public AbstractECMultiplier() {
    }

    public ECPoint checkResult(ECPoint r100) {
        return ECAlgorithms.implCheckResult(r100);
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint r100, BigInteger r101) {
        int r102 = r101.signum();
        if (r102 == 0) goto L14;
        if (r100.isInfinity() == true) goto L14;
        ECPoint r103 = multiplyPositive(r100, r101.abs());
        if (r102 > 0) goto L12;
        r103 = r103.negate();
    L12:
        return checkResult(r103);
    L14:
        return r100.getCurve().getInfinity();
    }

    public abstract ECPoint multiplyPositive(ECPoint r100, BigInteger r101);
}
