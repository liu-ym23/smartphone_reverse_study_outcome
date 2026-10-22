package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ProcessingRequest {
    static final int PROGRESS_NOT_RECEIVED = -1;
    private final TakePictureCallback mCallback;
    final ListenableFuture<Void> mCaptureFuture;
    private final Rect mCropRect;
    private final int mJpegQuality;
    private int mLastCaptureProcessProgressed;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRequestId;
    private final int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private final List<Integer> mStageIds;
    private final String mTagBundleKey;

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public void onCaptureStarted() {
        this.mCallback.onCaptureStarted();
    }

    public void onImageCaptured() {
        if (this.mLastCaptureProcessProgressed == (-1)) goto L5;
        onCaptureProcessProgressed(100);
    L5:
        this.mCallback.onImageCaptured();
    }

    public boolean isInMemoryCapture() {
        if (getOutputFileOptions() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    public void onCaptureFailure(ImageCaptureException r2) {
        this.mCallback.onCaptureFailure(r2);
    }

    public void onCaptureProcessProgressed(int r2) {
        if (this.mLastCaptureProcessProgressed == r2) goto L6;
        this.mLastCaptureProcessProgressed = r2;
        this.mCallback.onCaptureProcessProgressed(r2);
        return;
    }

    public void onFinalResult(ImageCapture.OutputFileResults r2) {
        this.mCallback.onFinalResult(r2);
    }

    public void onPostviewBitmapAvailable(Bitmap r2) {
        this.mCallback.onPostviewBitmapAvailable(r2);
    }

    public void onProcessFailure(ImageCaptureException r2) {
        this.mCallback.onProcessFailure(r2);
    }

    public void onFinalResult(ImageProxy r2) {
        this.mCallback.onFinalResult(r2);
    }

    public ProcessingRequest(CaptureBundle r11, ImageCapture.OutputFileOptions r12, Rect r13, int r14, int r15, Matrix r16, TakePictureCallback r17, ListenableFuture<Void> r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, 0);
    }

    public ProcessingRequest(CaptureBundle r2, ImageCapture.OutputFileOptions r3, Rect r4, int r5, int r6, Matrix r7, TakePictureCallback r8, ListenableFuture<Void> r9, int r10) {
        this.mLastCaptureProcessProgressed = -1;
        this.mRequestId = r10;
        this.mOutputFileOptions = r3;
        this.mJpegQuality = r6;
        this.mRotationDegrees = r5;
        this.mCropRect = r4;
        this.mSensorToBufferTransform = r7;
        this.mCallback = r8;
        this.mTagBundleKey = String.valueOf(r2.hashCode());
        this.mStageIds = new ArrayList();
        List<CaptureStage> r11 = r2.getCaptureStages();
        Objects.requireNonNull(r11);
        Iterator<CaptureStage> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        CaptureStage r13 = r12.next();
        this.mStageIds.add(Integer.valueOf(r13.getId()));
        goto L4
    L6:
        this.mCaptureFuture = r9;
    }
}
