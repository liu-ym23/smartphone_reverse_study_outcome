package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ECPoint f525308q;

    public ECPublicKeyParameters(ECPoint r100, ECDomainParameters r101) {
        super(false, r101);
        this.f525308q = r101.validatePublicPoint(r100);
    }

    public ECPoint getQ() {
        return this.f525308q;
    }
}
