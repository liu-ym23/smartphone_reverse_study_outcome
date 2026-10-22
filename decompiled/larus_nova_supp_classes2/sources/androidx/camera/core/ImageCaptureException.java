package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }

    public ImageCaptureException(int r1, String r2, Throwable r3) {
        super(r2, r3);
        this.mImageCaptureError = r1;
    }
}
