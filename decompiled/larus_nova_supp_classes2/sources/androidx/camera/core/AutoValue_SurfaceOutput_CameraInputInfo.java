package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceOutput_CameraInputInfo extends SurfaceOutput.CameraInputInfo {
    private final CameraInternal cameraInternal;
    private final Rect inputCropRect;
    private final Size inputSize;
    private final boolean mirroring;
    private final int rotationDegrees;

    public int hashCode() {
        int r0 = (((this.inputSize.hashCode() ^ 1000003) * 1000003) ^ this.inputCropRect.hashCode()) * 1000003;
        CameraInternal r2 = this.cameraInternal;
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        int r1 = (((r0 ^ r3) * 1000003) ^ this.rotationDegrees) * 1000003;
        if (this.mirroring == false) goto L9;
        int r4 = 1231;
    L11:
        return r1 ^ r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r3 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraInputInfo{inputSize=" + this.inputSize + ", inputCropRect=" + this.inputCropRect + ", cameraInternal=" + this.cameraInternal + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + "}";
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public CameraInternal getCameraInternal() {
        return this.cameraInternal;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public Rect getInputCropRect() {
        return this.inputCropRect;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public Size getInputSize() {
        return this.inputSize;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public boolean getMirroring() {
        return this.mirroring;
    }

    @Override // androidx.camera.core.SurfaceOutput.CameraInputInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceOutput.CameraInputInfo) == false) goto L25;
        SurfaceOutput.CameraInputInfo r6 = (SurfaceOutput.CameraInputInfo) r5;
        if (this.inputSize.equals(r6.getInputSize()) == true) goto L10;
    L23:
        return false;
    L10:
        if (this.inputCropRect.equals(r6.getInputCropRect()) == false) goto L23;
        CameraInternal r1 = this.cameraInternal;
        if (r1 != null) goto L17;
        if (r6.getCameraInternal() != null) goto L23;
    L19:
        if (this.rotationDegrees != r6.getRotationDegrees()) goto L23;
        if (this.mirroring != r6.getMirroring()) goto L23;
        return true;
    L17:
        if (r1.equals(r6.getCameraInternal()) == false) goto L23;
    L25:
        return false;
    }

    public AutoValue_SurfaceOutput_CameraInputInfo(Size r1, Rect r2, CameraInternal r3, int r4, boolean r5) {
        if (r1 == null) goto L11;
        this.inputSize = r1;
        if (r2 == null) goto L9;
        this.inputCropRect = r2;
        this.cameraInternal = r3;
        this.rotationDegrees = r4;
        this.mirroring = r5;
        return;
    L9:
        throw new NullPointerException("Null inputCropRect");
    L11:
        throw new NullPointerException("Null inputSize");
    }
}
