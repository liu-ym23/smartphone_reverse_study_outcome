package androidx.camera.core.internal;

import androidx.camera.core.ZoomState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ImmutableZoomState implements ZoomState {
    public ImmutableZoomState() {
    }

    @Override // androidx.camera.core.ZoomState
    public abstract float getLinearZoom();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMaxZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMinZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getZoomRatio();

    public static ZoomState create(ZoomState r4) {
        return new AutoValue_ImmutableZoomState(r4.getZoomRatio(), r4.getMaxZoomRatio(), r4.getMinZoomRatio(), r4.getLinearZoom());
    }

    public static ZoomState create(float r1, float r2, float r3, float r4) {
        return new AutoValue_ImmutableZoomState(r1, r2, r3, r4);
    }
}
