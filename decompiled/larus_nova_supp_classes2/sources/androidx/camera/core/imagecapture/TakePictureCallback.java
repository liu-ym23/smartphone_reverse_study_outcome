package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface TakePictureCallback {
    boolean isAborted();

    void onCaptureFailure(ImageCaptureException r1);

    void onCaptureProcessProgressed(int r1);

    void onCaptureStarted();

    void onFinalResult(ImageCapture.OutputFileResults r1);

    void onFinalResult(ImageProxy r1);

    void onImageCaptured();

    void onPostviewBitmapAvailable(Bitmap r1);

    void onProcessFailure(ImageCaptureException r1);
}
