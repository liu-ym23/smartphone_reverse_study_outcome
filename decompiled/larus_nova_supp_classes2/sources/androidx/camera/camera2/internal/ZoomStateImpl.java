package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.compose.material3.MenuKt;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ZoomStateImpl implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    private float getPercentageByRatio(float r6) {
        float r0 = this.mMaxZoomRatio;
        float r1 = this.mMinZoomRatio;
        if (r0 != r1) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        if (r6 != r0) goto L9;
        return 1.0f;
    L9:
        if (r6 != r1) goto L11;
        return MenuKt.ClosedAlphaTarget;
    L11:
        float r3 = 1.0f / r1;
        return ((1.0f / r6) - r3) / ((1.0f / r0) - r3);
    }

    private float getRatioByPercentage(float r14) {
        if (r14 != 1.0f) goto L7;
        return this.mMaxZoomRatio;
    L7:
        if (r14 == MenuKt.ClosedAlphaTarget) goto L9;
        float r1 = this.mMaxZoomRatio;
        float r4 = this.mMinZoomRatio;
        double r5 = 1.0f / r4;
        return (float) MathUtils.clamp(1.0d / (r5 + ((((double) (1.0f / r1)) - r5) * ((double) r14))), r4, r1);
    L9:
        return this.mMinZoomRatio;
    }

    public void setLinearZoom(float r3) throws IllegalArgumentException {
        if (r3 > 1.0f) goto L9;
        if (r3 < MenuKt.ClosedAlphaTarget) goto L9;
        this.mLinearZoom = r3;
        this.mZoomRatio = getRatioByPercentage(r3);
        return;
    L9:
        throw new IllegalArgumentException("Requested linearZoom " + r3 + " is not within valid range [0..1]");
    }

    public void setZoomRatio(float r3) throws IllegalArgumentException {
        if (r3 > this.mMaxZoomRatio) goto L9;
        if (r3 < this.mMinZoomRatio) goto L9;
        this.mZoomRatio = r3;
        this.mLinearZoom = getPercentageByRatio(r3);
        return;
    L9:
        throw new IllegalArgumentException("Requested zoomRatio " + r3 + " is not within valid range [" + this.mMinZoomRatio + " , " + this.mMaxZoomRatio + "]");
    }

    public ZoomStateImpl(float r1, float r2) {
        this.mMaxZoomRatio = r1;
        this.mMinZoomRatio = r2;
    }
}
