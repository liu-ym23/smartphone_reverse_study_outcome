package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class ScaleYNegateXPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleYNegateXPointMap(ECFieldElement r100) {
        this.scale = r100;
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public ECPoint map(ECPoint r100) {
        return r100.scaleYNegateX(this.scale);
    }
}
