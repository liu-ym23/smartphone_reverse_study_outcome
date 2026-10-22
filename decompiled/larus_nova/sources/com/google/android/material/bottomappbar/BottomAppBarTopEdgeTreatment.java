package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes23.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float r100) {
        this.cradleVerticalOffset = r100;
    }

    public void setFabCradleMargin(float r100) {
        this.fabMargin = r100;
    }

    public void setFabCradleRoundedCornerRadius(float r100) {
        this.roundedCornerRadius = r100;
    }

    public void setFabDiameter(float r100) {
        this.fabDiameter = r100;
    }

    public void setHorizontalOffset(float r100) {
        this.horizontalOffset = r100;
    }

    public BottomAppBarTopEdgeTreatment(float r100, float r101, float r102) {
        this.fabMargin = r100;
        this.roundedCornerRadius = r101;
        this.cradleVerticalOffset = r102;
        if (r102 < 0.0f) goto L7;
        this.horizontalOffset = 0.0f;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r210, float r211, ShapePath r212) {
        float r100 = this.fabDiameter;
        if (r100 != 0.0f) goto L6;
        r212.lineTo(r210, 0.0f);
        return;
    L6:
        float r110 = ((this.fabMargin * 2.0f) + r100) / 2.0f;
        float r111 = r211 * this.roundedCornerRadius;
        float r112 = (r210 / 2.0f) + this.horizontalOffset;
        float r113 = (this.cradleVerticalOffset * r211) + ((1.0f - r211) * r110);
        if ((r113 / r110) < 1.0f) goto L10;
        r212.lineTo(r210, 0.0f);
        return;
    L10:
        float r101 = r110 + r111;
        float r102 = r113 + r111;
        float r103 = (float) Math.sqrt((r101 * r101) - (r102 * r102));
        float r104 = r112 - r103;
        float r114 = r112 + r103;
        float r105 = (float) Math.toDegrees(Math.atan(r103 / r102));
        float r115 = 90.0f - r105;
        float r106 = r104 - r111;
        r212.lineTo(r106, 0.0f);
        float r116 = r111 * 2.0f;
        r212.addArc(r106, 0.0f, r104 + r111, r116, 270.0f, r105);
        r212.addArc(r112 - r110, (-r110) - r113, r112 + r110, r110 - r113, 180.0f - r115, (r115 * 2.0f) - 180.0f);
        r212.addArc(r114 - r111, 0.0f, r114 + r111, r116, 270.0f - r105, r105);
        r212.lineTo(r210, 0.0f);
    }
}
