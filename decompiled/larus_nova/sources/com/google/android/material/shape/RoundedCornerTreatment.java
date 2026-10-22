package com.google.android.material.shape;

/* JADX INFO: loaded from: classes23.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    private final float radius;

    public RoundedCornerTreatment(float r100) {
        this.radius = r100;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float r110, float r111, ShapePath r112) {
        r112.reset(0.0f, this.radius * r111);
        float r100 = this.radius;
        r112.addArc(0.0f, 0.0f, (r100 * 2.0f) * r111, (r100 * 2.0f) * r111, r110 + 180.0f, 90.0f);
    }
}
