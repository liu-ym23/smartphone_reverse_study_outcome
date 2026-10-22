package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;

/* JADX INFO: loaded from: classes42.dex */
public class GLVMultiplier extends AbstractECMultiplier {
    protected final ECCurve curve;
    protected final GLVEndomorphism glvEndomorphism;

    public GLVMultiplier(ECCurve r100, GLVEndomorphism r101) {
        if (r100 == null) goto L9;
        if (r100.getOrder() == null) goto L9;
        this.curve = r100;
        this.glvEndomorphism = r101;
        return;
    L9:
        throw new IllegalArgumentException("Need curve with known group order");
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r100, BigInteger r101) {
        if (this.curve.equals(r100.getCurve()) == false) goto L11;
        BigInteger r102 = r100.getCurve().getOrder();
        BigInteger[] r103 = this.glvEndomorphism.decomposeScalar(r101.mod(r102));
        BigInteger r104 = r103[0];
        BigInteger r105 = r103[1];
        if (this.glvEndomorphism.hasEfficientPointMap() == false) goto L9;
        return ECAlgorithms.implShamirsTrickWNaf(this.glvEndomorphism, r100, r104, r105);
    L9:
        return ECAlgorithms.implShamirsTrickWNaf(r100, r104, EndoUtil.mapPoint(this.glvEndomorphism, r100), r105);
    L11:
        throw new IllegalStateException();
    }
}
