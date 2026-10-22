package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes42.dex */
public class FixedPointCombMultiplier extends AbstractECMultiplier {
    public FixedPointCombMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r110, BigInteger r111) {
        ECCurve r100 = r110.getCurve();
        int r101 = FixedPointUtil.getCombSize(r100);
        if (r111.bitLength() > r101) goto L13;
        FixedPointPreCompInfo r112 = FixedPointUtil.precompute(r110);
        ECLookupTable r102 = r112.getLookupTable();
        int r103 = r112.getWidth();
        int r104 = ((r101 + r103) - 1) / r103;
        ECPoint r105 = r100.getInfinity();
        int r106 = r103 * r104;
        int[] r113 = Nat.fromBigInteger(r106, r111);
        int r107 = r106 - 1;
        int r108 = 0;
    L5:
        if (r108 >= r104) goto L11;
        int r109 = r107 - r108;
        int r114 = 0;
    L7:
        if (r109 < 0) goto L9;
        int r115 = r113[r109 >>> 5] >>> (r109 & 31);
        r114 = ((r114 ^ (r115 >>> 1)) << 1) ^ r115;
        r109 = r109 - r104;
        goto L7
    L9:
        r105 = r105.twicePlus(r102.lookup(r114));
        r108 = r108 + 1;
        goto L5
    L11:
        return r105.add(r112.getOffset());
    L13:
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
