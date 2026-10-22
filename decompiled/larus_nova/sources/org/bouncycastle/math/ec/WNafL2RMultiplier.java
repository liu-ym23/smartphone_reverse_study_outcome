package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    public WNafL2RMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r110, BigInteger r111) {
        WNafPreCompInfo r100 = WNafUtil.precompute(r110, WNafUtil.getWindowSize(r111.bitLength()), true);
        ECPoint[] r101 = r100.getPreComp();
        ECPoint[] r102 = r100.getPreCompNeg();
        int r103 = r100.getWidth();
        int[] r112 = WNafUtil.generateCompactWindowNaf(r103, r111);
        ECPoint r113 = r110.getCurve().getInfinity();
        int r104 = r112.length;
        if (r104 <= 1) goto L13;
        r104 = r104 - 1;
        int r114 = r112[r104];
        int r105 = r114 >> 16;
        int r115 = r114 & 65535;
        int r106 = Math.abs(r105);
        if (r105 >= 0) goto L7;
        ECPoint[] r107 = r102;
    L9:
        if ((r106 << 2) >= (1 << r103)) goto L11;
        int r108 = 32 - Integers.numberOfLeadingZeros(r106);
        int r109 = r103 - r108;
        ECPoint r116 = r107[((1 << (r103 - 1)) - 1) >>> 1].add(r107[(((r106 ^ (1 << (r108 - 1))) << r109) + 1) >>> 1]);
        r115 = r115 - r109;
    L12:
        r113 = r116.timesPow2(r115);
        goto L13
    L11:
        r116 = r107[r106 >>> 1];
        goto L12
    L7:
        r107 = r101;
    L13:
        if (r104 <= 0) goto L19;
        r104 = r104 - 1;
        int r117 = r112[r104];
        int r118 = r117 >> 16;
        int r119 = r117 & 65535;
        int r120 = Math.abs(r118);
        if (r118 >= 0) goto L17;
        ECPoint[] r121 = r102;
    L18:
        r113 = r113.twicePlus(r121[r120 >>> 1]).timesPow2(r119);
        goto L13
    L17:
        r121 = r101;
        goto L18
    L19:
        return r113;
    }
}
