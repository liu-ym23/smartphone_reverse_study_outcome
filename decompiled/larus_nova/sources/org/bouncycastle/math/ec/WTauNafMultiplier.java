package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class WTauNafMultiplier extends AbstractECMultiplier {
    static final String PRECOMP_NAME = "bc_wtnaf";

    public WTauNafMultiplier() {
    }

    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m r100, byte[] r101) {
        ECCurve.AbstractF2m r102 = (ECCurve.AbstractF2m) r100.getCurve();
        final byte r103 = r102.getA().toBigInteger().byteValue();
        ECPoint.AbstractF2m[] r104 = ((WTauNafPreCompInfo) r102.precompute(r100, PRECOMP_NAME, new AnonymousClass1(r100, r103))).getPreComp();
        ECPoint.AbstractF2m[] r105 = new ECPoint.AbstractF2m[r104.length];
        int r106 = 0;
    L4:
        if (r106 >= r104.length) goto L6;
        r105[r106] = (ECPoint.AbstractF2m) r104[r106].negate();
        r106 = r106 + 1;
        goto L4
    L6:
        ECPoint.AbstractF2m r107 = (ECPoint.AbstractF2m) r100.getCurve().getInfinity();
        int r108 = r101.length - 1;
        int r109 = 0;
    L7:
        if (r108 < 0) goto L16;
        r109 = r109 + 1;
        byte r110 = r101[r108];
        if (r110 == 0) goto L15;
        ECPoint.AbstractF2m r111 = r107.tauPow(r109);
        if (r110 <= 0) goto L13;
        ECPoint.AbstractF2m r112 = r104[r110 >>> 1];
    L14:
        r107 = (ECPoint.AbstractF2m) r111.add(r112);
        r109 = 0;
        goto L15
    L13:
        r112 = r105[(-r110) >>> 1];
    L15:
        r108 = r108 - 1;
        goto L7
    L16:
        if (r109 > 0) goto L18;
        return r107;
    L18:
        return r107.tauPow(r109);
    }

    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m r100, ZTauElement r101, byte r102, byte r110) {
        if (r102 != 0) goto L4;
        ZTauElement[] r103 = Tnaf.alpha0;
    L5:
        BigInteger r104 = Tnaf.getTw(r110, 4);
        BigInteger r105 = BigInteger.valueOf(16);
        return multiplyFromWTnaf(r100, Tnaf.tauAdicWNaf(r110, r101, (byte) 4, r105, r104, r103));
    L4:
        r103 = Tnaf.alpha1;
        goto L5
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r110, BigInteger r111) {
        if ((r110 instanceof ECPoint.AbstractF2m) == false) goto L7;
        ECPoint.AbstractF2m r112 = (ECPoint.AbstractF2m) r110;
        ECCurve.AbstractF2m r100 = (ECCurve.AbstractF2m) r112.getCurve();
        int r101 = r100.getFieldSize();
        byte r102 = r100.getA().toBigInteger().byteValue();
        byte r103 = Tnaf.getMu(r102);
        return multiplyWTnaf(r112, Tnaf.partModReduction(r111, r101, r102, r100.getSi(), r103, (byte) 10), r102, r103);
    L7:
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }
}
