package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public FixedPointUtil() {
    }

    public static int getCombSize(ECCurve r100) {
        BigInteger r101 = r100.getOrder();
        if (r101 != null) goto L6;
        return r100.getFieldSize() + 1;
    L6:
        return r101.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo r100) {
        if ((r100 instanceof FixedPointPreCompInfo) == true) goto L7;
        return null;
    L7:
        return (FixedPointPreCompInfo) r100;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint r100) {
        final ECCurve r101 = r100.getCurve();
        return (FixedPointPreCompInfo) r101.precompute(r100, PRECOMP_NAME, new AnonymousClass1(r101, r100));
    }
}
