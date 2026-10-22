package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class ScaleXNegateYPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleXNegateYPointMap(ECFieldElement r100) {
        this.scale = r100;
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public ECPoint map(ECPoint r100) {
        return r100.scaleXNegateY(this.scale);
    }
}
