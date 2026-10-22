package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_TakePictureManager_CaptureError extends TakePictureManager.CaptureError {
    private final ImageCaptureException imageCaptureException;
    private final int requestId;

    public int hashCode() {
        return ((this.requestId ^ 1000003) * 1000003) ^ this.imageCaptureException.hashCode();
    }

    public String toString() {
        return "CaptureError{requestId=" + this.requestId + ", imageCaptureException=" + this.imageCaptureException + "}";
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    public ImageCaptureException getImageCaptureException() {
        return this.imageCaptureException;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    public int getRequestId() {
        return this.requestId;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TakePictureManager.CaptureError) == false) goto L14;
        TakePictureManager.CaptureError r6 = (TakePictureManager.CaptureError) r5;
        if (this.requestId == r6.getRequestId()) goto L10;
    L12:
        return false;
    L10:
        if (this.imageCaptureException.equals(r6.getImageCaptureException()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_TakePictureManager_CaptureError(int r1, ImageCaptureException r2) {
        this.requestId = r1;
        if (r2 == null) goto L7;
        this.imageCaptureException = r2;
        return;
    L7:
        throw new NullPointerException("Null imageCaptureException");
    }
}
