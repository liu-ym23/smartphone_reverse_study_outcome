package androidx.camera.core;

import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceRequest_Result extends SurfaceRequest.Result {
    private final int resultCode;
    private final Surface surface;

    public int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public int getResultCode() {
        return this.resultCode;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public Surface getSurface() {
        return this.surface;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceRequest.Result) == false) goto L14;
        SurfaceRequest.Result r6 = (SurfaceRequest.Result) r5;
        if (this.resultCode == r6.getResultCode()) goto L10;
    L12:
        return false;
    L10:
        if (this.surface.equals(r6.getSurface()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceRequest_Result(int r1, Surface r2) {
        this.resultCode = r1;
        if (r2 == null) goto L7;
        this.surface = r2;
        return;
    L7:
        throw new NullPointerException("Null surface");
    }
}
