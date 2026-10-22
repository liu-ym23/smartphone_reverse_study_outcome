package com.google.android.material.shape;

/* JADX INFO: loaded from: classes23.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float r100, boolean r101) {
        this.size = r100;
        this.inside = r101;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r100, float r101, ShapePath r102) {
        float r103 = r100 / 2.0f;
        r102.lineTo(r103 - (this.size * r101), 0.0f);
        if (this.inside == false) goto L5;
        float r104 = this.size;
    L6:
        r102.lineTo(r103, r104 * r101);
        r102.lineTo(r103 + (this.size * r101), 0.0f);
        r102.lineTo(r100, 0.0f);
        return;
    L5:
        r104 = -this.size;
        goto L6
    }
}
