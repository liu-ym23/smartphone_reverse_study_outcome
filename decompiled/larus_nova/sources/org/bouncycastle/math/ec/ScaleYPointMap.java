package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class ScaleYPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleYPointMap(ECFieldElement r100) {
        this.scale = r100;
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public ECPoint map(ECPoint r100) {
        return r100.scaleY(this.scale);
    }
}
