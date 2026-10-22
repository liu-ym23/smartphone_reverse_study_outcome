package org.bouncycastle.math.ec.endo;

import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

/* JADX INFO: loaded from: classes42.dex */
public class EndoPreCompInfo implements PreCompInfo {
    protected ECEndomorphism endomorphism;
    protected ECPoint mappedPoint;

    public EndoPreCompInfo() {
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public ECPoint getMappedPoint() {
        return this.mappedPoint;
    }

    public void setEndomorphism(ECEndomorphism r100) {
        this.endomorphism = r100;
    }

    public void setMappedPoint(ECPoint r100) {
        this.mappedPoint = r100;
    }
}
