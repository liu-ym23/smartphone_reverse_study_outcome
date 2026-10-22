package androidx.camera.core.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_ImmutableZoomState extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.zoomRatio) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.linearZoom);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.zoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", linearZoom=" + this.linearZoom + "}";
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.linearZoom;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImmutableZoomState) == false) goto L18;
        ImmutableZoomState r6 = (ImmutableZoomState) r5;
        if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(r6.getZoomRatio())) goto L10;
    L16:
        return false;
    L10:
        if (Float.floatToIntBits(this.maxZoomRatio) != Float.floatToIntBits(r6.getMaxZoomRatio())) goto L16;
        if (Float.floatToIntBits(this.minZoomRatio) != Float.floatToIntBits(r6.getMinZoomRatio())) goto L16;
        if (Float.floatToIntBits(this.linearZoom) != Float.floatToIntBits(r6.getLinearZoom())) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_ImmutableZoomState(float r1, float r2, float r3, float r4) {
        this.zoomRatio = r1;
        this.maxZoomRatio = r2;
        this.minZoomRatio = r3;
        this.linearZoom = r4;
    }
}
