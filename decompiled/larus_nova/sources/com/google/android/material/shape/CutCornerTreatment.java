package com.google.android.material.shape;

/* JADX INFO: loaded from: classes23.dex */
public class CutCornerTreatment extends CornerTreatment {
    private final float size;

    public CutCornerTreatment(float r100) {
        this.size = r100;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float r100, float r101, ShapePath r102) {
        r102.reset(0.0f, this.size * r101);
        double r103 = r100;
        double r104 = r101;
        r102.lineTo((float) ((Math.sin(r103) * ((double) this.size)) * r104), (float) ((Math.cos(r103) * ((double) this.size)) * r104));
    }
}
