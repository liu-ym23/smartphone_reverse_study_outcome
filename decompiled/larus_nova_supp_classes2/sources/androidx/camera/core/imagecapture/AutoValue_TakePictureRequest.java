package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;

    public int hashCode() {
        int r0 = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback r2 = this.inMemoryCallback;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 ^ r4) * 1000003;
        ImageCapture.OnImageSavedCallback r5 = this.onDiskCallback;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r1 ^ r6) * 1000003;
        ImageCapture.OutputFileOptions r8 = this.outputFileOptions;
        if (r8 == null) goto L15;
        r3 = r8.hashCode();
    L15:
        return ((((((((((((r7 ^ r3) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + "}";
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Executor getAppExecutor() {
        return this.appExecutor;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getCaptureMode() {
        return this.captureMode;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TakePictureRequest) == false) goto L45;
        TakePictureRequest r6 = (TakePictureRequest) r5;
        if (this.appExecutor.equals(r6.getAppExecutor()) == false) goto L43;
        ImageCapture.OnImageCapturedCallback r1 = this.inMemoryCallback;
        if (r1 != null) goto L15;
        if (r6.getInMemoryCallback() != null) goto L43;
    L16:
        ImageCapture.OnImageSavedCallback r2 = this.onDiskCallback;
        if (r2 != null) goto L22;
        if (r6.getOnDiskCallback() != null) goto L43;
    L23:
        ImageCapture.OutputFileOptions r3 = this.outputFileOptions;
        if (r3 != null) goto L29;
        if (r6.getOutputFileOptions() != null) goto L43;
    L31:
        if (this.cropRect.equals(r6.getCropRect()) == false) goto L43;
        if (this.sensorToBufferTransform.equals(r6.getSensorToBufferTransform()) == false) goto L43;
        if (this.rotationDegrees != r6.getRotationDegrees()) goto L43;
        if (this.jpegQuality != r6.getJpegQuality()) goto L43;
        if (this.captureMode != r6.getCaptureMode()) goto L43;
        if (this.sessionConfigCameraCaptureCallbacks.equals(r6.getSessionConfigCameraCaptureCallbacks()) == false) goto L43;
        return true;
    L29:
        if (r3.equals(r6.getOutputFileOptions()) == false) goto L43;
    L22:
        if (r2.equals(r6.getOnDiskCallback()) == false) goto L43;
    L15:
        if (r1.equals(r6.getInMemoryCallback()) == true) goto L16;
    L43:
        return false;
    L45:
        return false;
    }

    public AutoValue_TakePictureRequest(Executor r1, ImageCapture.OnImageCapturedCallback r2, ImageCapture.OnImageSavedCallback r3, ImageCapture.OutputFileOptions r4, Rect r5, Matrix r6, int r7, int r8, int r9, List<CameraCaptureCallback> r10) {
        if (r1 == null) goto L19;
        this.appExecutor = r1;
        this.inMemoryCallback = r2;
        this.onDiskCallback = r3;
        this.outputFileOptions = r4;
        if (r5 == null) goto L17;
        this.cropRect = r5;
        if (r6 == null) goto L15;
        this.sensorToBufferTransform = r6;
        this.rotationDegrees = r7;
        this.jpegQuality = r8;
        this.captureMode = r9;
        if (r10 == null) goto L13;
        this.sessionConfigCameraCaptureCallbacks = r10;
        return;
    L13:
        throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
    L15:
        throw new NullPointerException("Null sensorToBufferTransform");
    L17:
        throw new NullPointerException("Null cropRect");
    L19:
        throw new NullPointerException("Null appExecutor");
    }
}
