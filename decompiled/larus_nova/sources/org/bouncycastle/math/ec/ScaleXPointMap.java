package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class ScaleXPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleXPointMap(ECFieldElement r100) {
        this.scale = r100;
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public ECPoint map(ECPoint r100) {
        return r100.scaleX(this.scale);
    }
}
