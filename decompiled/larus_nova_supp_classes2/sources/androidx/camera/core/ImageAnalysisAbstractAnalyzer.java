package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import android.os.Build;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.compose.material3.MenuKt;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock;
    protected boolean mIsAttached;
    private volatile boolean mOnePixelShiftEnabled;
    private Matrix mOriginalSensorToBufferTransformMatrix;
    private Rect mOriginalViewPortCropRect;
    private volatile int mOutputImageFormat;
    private volatile boolean mOutputImageRotationEnabled;
    private volatile int mPrevBufferRotationDegrees;
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;
    private ImageWriter mProcessedImageWriter;
    ByteBuffer mRGBConvertedBuffer;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    ByteBuffer mURotatedBuffer;
    private Matrix mUpdatedSensorToBufferTransformMatrix;
    private Rect mUpdatedViewPortCropRect;
    private Executor mUserExecutor;
    ByteBuffer mVRotatedBuffer;
    ByteBuffer mYRotatedBuffer;

    public static /* synthetic */ Object a(ImageAnalysisAbstractAnalyzer r0, Executor r1, ImageProxy r2, Matrix r3, ImageProxy r4, Rect r5, ImageAnalysis.Analyzer r6, CallbackToFutureAdapter.Completer r7) {
        return r0.lambda$analyzeImage$1(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void b(ImageAnalysisAbstractAnalyzer r0, ImageProxy r1, Matrix r2, ImageProxy r3, Rect r4, ImageAnalysis.Analyzer r5, CallbackToFutureAdapter.Completer r6) {
        r0.lambda$analyzeImage$0(r1, r2, r3, r4, r5, r6);
    }

    public abstract ImageProxy acquireImage(ImageReaderProxy r1);

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    public abstract void onValidImageAvailable(ImageProxy r1);

    public ImageAnalysisAbstractAnalyzer() {
        this.mOutputImageFormat = 1;
        this.mOriginalViewPortCropRect = new Rect();
        this.mUpdatedViewPortCropRect = new Rect();
        this.mOriginalSensorToBufferTransformMatrix = new Matrix();
        this.mUpdatedSensorToBufferTransformMatrix = new Matrix();
        this.mAnalyzerLock = new Object();
        this.mIsAttached = true;
    }

    private void createHelperBuffer(ImageProxy r4) {
        if (this.mOutputImageFormat != 1) goto L15;
        if (this.mYRotatedBuffer != null) goto L7;
        this.mYRotatedBuffer = ByteBuffer.allocateDirect(r4.getWidth() * r4.getHeight());
    L7:
        this.mYRotatedBuffer.position(0);
        if (this.mURotatedBuffer != null) goto L10;
        this.mURotatedBuffer = ByteBuffer.allocateDirect((r4.getWidth() * r4.getHeight()) / 4);
    L10:
        this.mURotatedBuffer.position(0);
        if (this.mVRotatedBuffer != null) goto L13;
        this.mVRotatedBuffer = ByteBuffer.allocateDirect((r4.getWidth() * r4.getHeight()) / 4);
    L13:
        this.mVRotatedBuffer.position(0);
        return;
    L15:
        if (this.mOutputImageFormat == 2) goto L17;
        return;
    L17:
        if (this.mRGBConvertedBuffer != null) goto L22;
        this.mRGBConvertedBuffer = ByteBuffer.allocateDirect((r4.getWidth() * r4.getHeight()) * 4);
        return;
    }

    public ListenableFuture<Void> analyzeImage(final ImageProxy r15) {
        boolean r1 = false;
        if (this.mOutputImageRotationEnabled == false) goto L5;
        int r0 = this.mRelativeRotation;
    L6:
        Object r2 = this.mAnalyzerLock;
        monitor-enter(r2);
        final Executor r9 = this.mUserExecutor;     // Catch: Throwable -> L58
        final ImageAnalysis.Analyzer r10 = this.mSubscribedAnalyzer;     // Catch: Throwable -> L58
        if (this.mOutputImageRotationEnabled == true) goto L11;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L17;
        recreateImageReaderProxy(r15, r0);     // Catch: Throwable -> L58
    L17:
        if (this.mOutputImageRotationEnabled == false) goto L19;
        createHelperBuffer(r15);     // Catch: Throwable -> L58
    L19:
        SafeCloseImageReaderProxy r3 = this.mProcessedImageReaderProxy;     // Catch: Throwable -> L58
        ImageWriter r4 = this.mProcessedImageWriter;     // Catch: Throwable -> L58
        ByteBuffer r5 = this.mRGBConvertedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r6 = this.mYRotatedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r7 = this.mURotatedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r8 = this.mVRotatedBuffer;     // Catch: Throwable -> L58
        monitor-exit(r2);     // Catch: Throwable -> L58
        if (r10 == null) goto L57;
        if (r9 == null) goto L57;
        if (this.mIsAttached == false) goto L57;
        if (r3 != null) goto L27;
    L39:
        ImageProxy r11 = null;
    L40:
        if (r11 != null) goto L42;
        r1 = true;
    L42:
        if (r1 == false) goto L44;
        final ImageProxy r13 = r15;
    L45:
        final Rect r14 = new Rect();
        final Matrix r16 = new Matrix();
        Object r17 = this.mAnalyzerLock;
        monitor-enter(r17);
        if (r12 == false) goto L50;
        if (r1 == true) goto L50;
        recalculateTransformMatrixAndCropRect(r15.getWidth(), r15.getHeight(), r13.getWidth(), r13.getHeight());     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L50:
        this.mPrevBufferRotationDegrees = r0;     // Catch: Throwable -> L53
        r14.set(this.mUpdatedViewPortCropRect);     // Catch: Throwable -> L53
        r16.set(this.mUpdatedSensorToBufferTransformMatrix);     // Catch: Throwable -> L53
        monitor-exit(r17);     // Catch: Throwable -> L53
        return CallbackToFutureAdapter.getFuture(new m(this, r9, r15, r16, r13, r14, r10));
    L44:
        r13 = r11;
        goto L45
    L27:
        if (this.mOutputImageFormat != 2) goto L30;
        r11 = ImageProcessingUtil.convertYUVToRGB(r15, r3, r5, r0, this.mOnePixelShiftEnabled);
        goto L40
    L30:
        if (this.mOutputImageFormat != 1) goto L39;
        if (this.mOnePixelShiftEnabled == false) goto L34;
        ImageProcessingUtil.applyPixelShiftForYUV(r15);
    L34:
        if (r4 == null) goto L39;
        if (r6 == null) goto L39;
        if (r7 == null) goto L39;
        if (r8 == null) goto L39;
        r11 = ImageProcessingUtil.rotateYUV(r15, r3, r4, r6, r7, r8, r0);
    L57:
        return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
    L11:
        if (r0 == this.mPrevBufferRotationDegrees) goto L13;
        r12 = true;
    L58:
        th = move-exception;
        throw th;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy r3) {
        ImageProxy r4 = acquireImage(r3);     // Catch: IllegalStateException -> L6
        if (r4 == null) goto L11;
        onValidImageAvailable(r4);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire image.", e);
    }

    public void setOnePixelShiftEnabled(boolean r1) {
        this.mOnePixelShiftEnabled = r1;
    }

    public void setOutputImageFormat(int r1) {
        this.mOutputImageFormat = r1;
    }

    public void setOutputImageRotationEnabled(boolean r1) {
        this.mOutputImageRotationEnabled = r1;
    }

    public void setProcessedImageReaderProxy(SafeCloseImageReaderProxy r2) {
        Object r0 = this.mAnalyzerLock;
        monitor-enter(r0);
        this.mProcessedImageReaderProxy = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRelativeRotation(int r1) {
        this.mRelativeRotation = r1;
    }

    public void setSensorToBufferTransformMatrix(Matrix r3) {
        Object r0 = this.mAnalyzerLock;
        monitor-enter(r0);
        this.mOriginalSensorToBufferTransformMatrix = r3;     // Catch: Throwable -> L7
        this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setViewPortCropRect(Rect r3) {
        Object r0 = this.mAnalyzerLock;
        monitor-enter(r0);
        this.mOriginalViewPortCropRect = r3;     // Catch: Throwable -> L7
        this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Rect getUpdatedCropRect(Rect r1, Matrix r2) {
        RectF r0 = new RectF(r1);
        r2.mapRect(r0);
        Rect r3 = new Rect();
        r0.round(r3);
        return r3;
    }

    private void recreateImageReaderProxy(ImageProxy r4, int r5) {
        SafeCloseImageReaderProxy r0 = this.mProcessedImageReaderProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.safeClose();
        this.mProcessedImageReaderProxy = createImageReaderProxy(r4.getWidth(), r4.getHeight(), r5, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return;
    L8:
        if (this.mOutputImageFormat != 1) goto L15;
        ImageWriter r6 = this.mProcessedImageWriter;
        if (r6 == null) goto L12;
        ImageWriterCompat.close(r6);
    L12:
        this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
        return;
    }

    public void setAnalyzer(Executor r2, ImageAnalysis.Analyzer r3) {
        if (r3 != null) goto L4;
        clearCache();
    L4:
        Object r0 = this.mAnalyzerLock;
        monitor-enter(r0);
        this.mSubscribedAnalyzer = r3;     // Catch: Throwable -> L9
        this.mUserExecutor = r2;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void recalculateTransformMatrixAndCropRect(int r2, int r3, int r4, int r5) {
        Matrix r6 = getAdditionalTransformMatrixAppliedByProcessor(r2, r3, r4, r5, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, r6);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, r6);
    }

    private static SafeCloseImageReaderProxy createImageReaderProxy(int r1, int r2, int r3, int r4, int r5) {
        if (r3 != 90) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        int r0 = r2;
    L12:
        if (r6 == true) goto L16;
        r1 = r2;
    L16:
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r0, r1, r4, r5));
    L11:
        r0 = r1;
        goto L12
    L5:
        if (r3 == 270) goto L8;
        r6 = false;
        goto L9
    }

    public static Matrix getAdditionalTransformMatrixAppliedByProcessor(int r3, int r4, int r5, int r6, int r7) {
        Matrix r0 = new Matrix();
        if (r7 <= 0) goto L5;
        r0.setRectToRect(new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r3, r4), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        r0.postRotate(r7);
        r0.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r5, r6)));
    L5:
        return r0;
    }

    private /* synthetic */ void lambda$analyzeImage$0(ImageProxy r4, Matrix r5, ImageProxy r6, Rect r7, ImageAnalysis.Analyzer r8, CallbackToFutureAdapter.Completer r9) {
        if (this.mIsAttached == false) goto L12;
        TagBundle r0 = r4.getImageInfo().getTagBundle();
        long r1 = r4.getImageInfo().getTimestamp();
        if (this.mOutputImageRotationEnabled == false) goto L7;
        int r10 = 0;
    L8:
        SettableImageProxy r11 = new SettableImageProxy(r6, ImmutableImageInfo.create(r0, r1, r10, r5));
        if (r7.isEmpty() == true) goto L11;
        r11.setCropRect(r7);
    L11:
        r8.analyze(r11);
        r9.set(null);
        return;
    L7:
        r10 = this.mRelativeRotation;
        goto L8
    L12:
        r9.setException(new OperationCanceledException("ImageAnalysis is detached"));
    }

    private /* synthetic */ Object lambda$analyzeImage$1(Executor r10, final ImageProxy r11, final Matrix r12, final ImageProxy r13, final Rect r14, final ImageAnalysis.Analyzer r15, final CallbackToFutureAdapter.Completer r16) throws Exception {
        r10.execute(new n(this, r11, r12, r13, r14, r15, r16));
        return "analyzeImage";
    }
}
