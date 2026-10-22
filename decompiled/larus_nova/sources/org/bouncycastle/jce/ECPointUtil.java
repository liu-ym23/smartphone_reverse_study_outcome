package org.bouncycastle.jce;

import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes42.dex */
public class ECPointUtil {
    public ECPointUtil() {
    }

    public static ECPoint decodePoint(EllipticCurve r110, byte[] r111) {
        if ((r110.getField() instanceof ECFieldFp) == false) goto L5;
        ECCurve r100 = new ECCurve.Fp(((ECFieldFp) r110.getField()).getP(), r110.getA(), r110.getB());
    L11:
        return EC5Util.convertPoint(r100.decodePoint(r111));
    L5:
        int[] r101 = ((ECFieldF2m) r110.getField()).getMidTermsOfReductionPolynomial();
        if (r101.length != 3) goto L8;
        ECCurve.F2m r102 = new ECCurve.F2m(((ECFieldF2m) r110.getField()).getM(), r101[2], r101[1], r101[0], r110.getA(), r110.getB());
    L9:
        r100 = r102;
        goto L11
    L8:
        r102 = new ECCurve.F2m(((ECFieldF2m) r110.getField()).getM(), r101[0], r110.getA(), r110.getB());
        goto L9
    }
}
