package org.bouncycastle.jce.spec;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECPublicKeySpec extends ECKeySpec {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ECPoint f525407q;

    public ECPublicKeySpec(ECPoint r100, ECParameterSpec r101) {
        super(r101);
        if (r100.getCurve() == null) goto L5;
        r100 = r100.normalize();
    L5:
        this.f525407q = r100;
    }

    public ECPoint getQ() {
        return this.f525407q;
    }
}
