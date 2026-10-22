package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {
    private final Rect getCropRect;
    private final int getRotationDegrees;
    private final Matrix getSensorToBufferTransform;
    private final int getTargetRotation;
    private final boolean hasCameraTransform;
    private final boolean isMirroring;

    public int hashCode() {
        int r0 = (((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003;
        int r3 = 1231;
        if (this.hasCameraTransform == false) goto L5;
        int r2 = 1231;
    L6:
        int r1 = (((r0 ^ r2) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003;
        if (this.isMirroring == true) goto L11;
        r3 = 1237;
    L11:
        return r1 ^ r3;
    L5:
        r2 = 1237;
        goto L6
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", isMirroring=" + this.isMirroring + "}";
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public Rect getCropRect() {
        return this.getCropRect;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public Matrix getSensorToBufferTransform() {
        return this.getSensorToBufferTransform;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int getTargetRotation() {
        return this.getTargetRotation;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public boolean hasCameraTransform() {
        return this.hasCameraTransform;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public boolean isMirroring() {
        return this.isMirroring;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceRequest.TransformationInfo) == false) goto L22;
        SurfaceRequest.TransformationInfo r6 = (SurfaceRequest.TransformationInfo) r5;
        if (this.getCropRect.equals(r6.getCropRect()) == true) goto L10;
    L20:
        return false;
    L10:
        if (this.getRotationDegrees != r6.getRotationDegrees()) goto L20;
        if (this.getTargetRotation != r6.getTargetRotation()) goto L20;
        if (this.hasCameraTransform != r6.hasCameraTransform()) goto L20;
        if (this.getSensorToBufferTransform.equals(r6.getSensorToBufferTransform()) == false) goto L20;
        if (this.isMirroring != r6.isMirroring()) goto L20;
        return true;
    L22:
        return false;
    }

    public AutoValue_SurfaceRequest_TransformationInfo(Rect r1, int r2, int r3, boolean r4, Matrix r5, boolean r6) {
        if (r1 == null) goto L11;
        this.getCropRect = r1;
        this.getRotationDegrees = r2;
        this.getTargetRotation = r3;
        this.hasCameraTransform = r4;
        if (r5 == null) goto L9;
        this.getSensorToBufferTransform = r5;
        this.isMirroring = r6;
        return;
    L9:
        throw new NullPointerException("Null getSensorToBufferTransform");
    L11:
        throw new NullPointerException("Null getCropRect");
    }
}
