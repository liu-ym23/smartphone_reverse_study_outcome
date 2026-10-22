package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.video.AudioConfig;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final ImageCapture.ScreenFlash NO_OP_SCREEN_FLASH = null;
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private static final String VIDEO_RECORDING_UNFINISHED = "Recording video. Only one recording can be active at a time.";
    Recording mActiveRecording;
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisBackgroundExecutor;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    Camera mCamera;
    ProcessCameraProviderWrapper mCameraProvider;
    CameraSelector mCameraSelector;
    final RotationProvider.Listener mDeviceRotationListener;
    private final Set<CameraEffect> mEffects;
    private int mEnabledUseCases;
    ImageAnalysis mImageAnalysis;
    ResolutionSelector mImageAnalysisResolutionSelector;
    OutputSize mImageAnalysisTargetSize;
    ImageCapture mImageCapture;
    Executor mImageCaptureIoExecutor;
    ResolutionSelector mImageCaptureResolutionSelector;
    OutputSize mImageCaptureTargetSize;
    private final ListenableFuture<Void> mInitializationFuture;
    private final PendingValue<Boolean> mPendingEnableTorch;
    private final PendingValue<Float> mPendingLinearZoom;
    private final PendingValue<Float> mPendingZoomRatio;
    private boolean mPinchToZoomEnabled;
    Preview mPreview;
    private DynamicRange mPreviewDynamicRange;
    ResolutionSelector mPreviewResolutionSelector;
    OutputSize mPreviewTargetSize;
    Map<Consumer<VideoRecordEvent>, Recording> mRecordingMap;
    private final RotationProvider mRotationProvider;
    private final Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> mScreenFlashUiInfoMap;
    Preview.SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled;
    final MutableLiveData<Integer> mTapToFocusState;
    private final ForwardingLiveData<Integer> mTorchState;
    VideoCapture<Recorder> mVideoCapture;
    private DynamicRange mVideoCaptureDynamicRange;
    private int mVideoCaptureMirrorMode;
    QualitySelector mVideoCaptureQualitySelector;
    private Range<Integer> mVideoCaptureTargetFrameRate;
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState;

    /* JADX INFO: renamed from: androidx.camera.view.CameraController$2, reason: invalid class name */
    public class AnonymousClass2 implements Consumer<VideoRecordEvent> {
        final /* synthetic */ CameraController this$0;
        final /* synthetic */ Consumer val$listener;
        final /* synthetic */ Executor val$mainExecutor;

        public static /* synthetic */ void a(AnonymousClass2 r0) {
            r0.lambda$accept$0();
        }

        private /* synthetic */ void lambda$accept$0() {
            this.this$0.deactivateRecordingByListener(this);
        }

        public void accept(VideoRecordEvent r3) {
            if ((r3 instanceof VideoRecordEvent.Finalize) == true) goto L5;
        L8:
            this.val$listener.accept(r3);
            return;
        L5:
            if (Threads.isMainThread() == true) goto L7;
            this.val$mainExecutor.execute(new i(this));
            goto L8
        L7:
            this.this$0.deactivateRecordingByListener(this);
            goto L8
        }

        public /* bridge */ /* synthetic */ void accept(Object r1) {
            accept((VideoRecordEvent) r1);
        }

        public AnonymousClass2(CameraController r1, Executor r2, Consumer r3) {
            this.this$0 = r1;
            this.val$mainExecutor = r2;
            this.val$listener = r3;
        }
    }

    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        private final Size mResolution;

        @Retention(RetentionPolicy.SOURCE)
        public @interface OutputAspectRatio {
        }

        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        public Size getResolution() {
            return this.mResolution;
        }

        public OutputSize(int r2) {
            if (r2 == (-1)) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            this.mAspectRatio = r2;
            this.mResolution = null;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public OutputSize(Size r2) {
            Preconditions.checkNotNull(r2);
            this.mAspectRatio = -1;
            this.mResolution = r2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UseCases {
    }

    public static /* synthetic */ void a(CameraController r0, int r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void b(CameraController r0, int r1) {
        r0.lambda$setEnabledUseCases$2(r1);
    }

    public static /* synthetic */ void c(CameraController r0, CameraSelector r1) {
        r0.lambda$setCameraSelector$3(r1);
    }

    public static /* synthetic */ Void d(CameraController r0, ProcessCameraProviderWrapper r1) {
        return r0.lambda$new$0(r1);
    }

    private float speedUpZoomBy2X(float r4) {
        if (r4 <= 1.0f) goto L7;
        return ((r4 - 1.0f) * 2.0f) + 1.0f;
    L7:
        return 1.0f - ((1.0f - r4) * 2.0f);
    }

    public abstract Camera startCamera();

    public void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    static {
        NO_OP_SCREEN_FLASH = new AnonymousClass1();
    }

    private void checkAudioPermissionGranted() {
        if (PermissionChecker.checkSelfPermission(this.mAppContext, "android.permission.RECORD_AUDIO") == (-1)) goto L6;
        return;
    L6:
        throw new SecurityException("Attempted to start recording with audio, but application does not have RECORD_AUDIO permission granted.");
    }

    private Preview createPreview() {
        Preview.Builder r0 = new Preview.Builder();
        configureResolution(r0, this.mPreviewResolutionSelector, this.mPreviewTargetSize);
        r0.setDynamicRange(this.mPreviewDynamicRange);
        return r0.build();
    }

    private VideoCapture<Recorder> createVideoCapture() {
        Recorder.Builder r0 = new Recorder.Builder().setQualitySelector(this.mVideoCaptureQualitySelector);
        ViewPort r1 = this.mViewPort;
        if (r1 == null) goto L10;
        if (this.mVideoCaptureQualitySelector != Recorder.DEFAULT_QUALITY_SELECTOR) goto L10;
        int r2 = getViewportAspectRatioInt(r1);
        if (r2 == (-1)) goto L10;
        r0.setAspectRatio(r2);
    L10:
        return new VideoCapture.Builder(r0.build()).setTargetFrameRate(this.mVideoCaptureTargetFrameRate).setMirrorMode(this.mVideoCaptureMirrorMode).setDynamicRange(this.mVideoCaptureDynamicRange).build();
    }

    private boolean isCameraAttached() {
        if (this.mCamera == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCameraInitialized() {
        if (this.mCameraProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isPreviewViewAttached() {
        if (this.mSurfaceProvider != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mViewPort == null) goto L7;
        return true;
    }

    private void startListeningToRotationEvents() {
        this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener);
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    public ScreenFlashUiInfo getScreenFlashUiInfoByPriority() {
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> r0 = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType r1 = ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW;
        if (r0.get(r1) != null) goto L5;
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> r2 = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType r3 = ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW;
        if (r2.get(r3) != null) goto L9;
        return null;
    L9:
        return this.mScreenFlashUiInfoMap.get(r3);
    L5:
        return this.mScreenFlashUiInfoMap.get(r1);
    }

    private void stopRecording() {
        Threads.checkMainThread();
        Recording r0 = this.mActiveRecording;
        if (r0 == null) goto L6;
        r0.stop();
        deactivateRecording(this.mActiveRecording);
        return;
    }

    private void throwExceptionForInvalidScreenFlashCapture() {
        if (getImageCaptureFlashMode() == 3) goto L5;
        return;
    L5:
        if (getScreenFlashUiInfoByPriority() == null) goto L10;
        if (getScreenFlashUiInfoByPriority().getScreenFlash() == null) goto L10;
        return;
    L10:
        throw new IllegalStateException("No window set in PreviewView despite setting FLASH_MODE_SCREEN");
    }

    private void unbindAllAndRecreate() {
        unbindPreviewAndRecreate();
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        unbindVideoAndRecreate();
    }

    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mPreview});
    L5:
        this.mPreview = createPreview();
        if (this.mSurfaceProvider == null) goto L9;
        this.mPreview.setSurfaceProvider(this.mSurfaceProvider);
        return;
    }

    private void unbindVideoAndRecreate() {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mVideoCapture});
    L5:
        this.mVideoCapture = createVideoCapture();
    }

    public void clearEffects() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L5;
        r0.unbindAll();
    L5:
        this.mEffects.clear();
        startCameraAndTrackStates();
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r0 = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(r0, null);
    }

    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L5;
        r0.unbind(new UseCase[]{this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture});
    L5:
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        stopListeningToRotationEvents();
    }

    public UseCaseGroup createUseCaseGroup() {
        if (isCameraInitialized() == true) goto L7;
        Logger.d(TAG, CAMERA_NOT_INITIALIZED);
        return null;
    L7:
        if (isPreviewViewAttached() == true) goto L10;
        Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
        return null;
    L10:
        UseCaseGroup.Builder r0 = new UseCaseGroup.Builder().addUseCase(this.mPreview);
        if (isImageCaptureEnabled() == false) goto L13;
        r0.addUseCase(this.mImageCapture);
    L15:
        if (isImageAnalysisEnabled() == false) goto L17;
        r0.addUseCase(this.mImageAnalysis);
    L19:
        if (isVideoCaptureEnabled() == false) goto L21;
        r0.addUseCase(this.mVideoCapture);
    L22:
        r0.setViewPort(this.mViewPort);
        Iterator<CameraEffect> r1 = this.mEffects.iterator();
    L24:
        if (r1.hasNext() == false) goto L27;
        r0.addEffect(r1.next());
        goto L24
    L27:
        return r0.build();
    L21:
        this.mCameraProvider.unbind(new UseCase[]{this.mVideoCapture});
        goto L22
    L17:
        this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
        goto L19
    L13:
        this.mCameraProvider.unbind(new UseCase[]{this.mImageCapture});
        goto L15
    }

    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera r0 = this.mCamera;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera r0 = this.mCamera;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getCameraInfo();
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public int getImageAnalysisOutputImageFormat() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getOutputImageFormat();
    }

    public ResolutionSelector getImageAnalysisResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageAnalysisResolutionSelector;
    }

    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    public ResolutionSelector getImageCaptureResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageCaptureResolutionSelector;
    }

    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    public DynamicRange getPreviewDynamicRange() {
        Threads.checkMainThread();
        return this.mPreviewDynamicRange;
    }

    public ResolutionSelector getPreviewResolutionSelector() {
        Threads.checkMainThread();
        return this.mPreviewResolutionSelector;
    }

    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public DynamicRange getVideoCaptureDynamicRange() {
        Threads.checkMainThread();
        return this.mVideoCaptureDynamicRange;
    }

    public int getVideoCaptureMirrorMode() {
        Threads.checkMainThread();
        return this.mVideoCaptureMirrorMode;
    }

    public QualitySelector getVideoCaptureQualitySelector() {
        Threads.checkMainThread();
        return this.mVideoCaptureQualitySelector;
    }

    public Range<Integer> getVideoCaptureTargetFrameRate() {
        Threads.checkMainThread();
        return this.mVideoCaptureTargetFrameRate;
    }

    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        Recording r0 = this.mActiveRecording;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isClosed() == true) goto L7;
        return true;
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    public void updateScreenFlashToImageCapture() {
        ScreenFlashUiInfo r0 = getScreenFlashUiInfoByPriority();
        if (r0 != null) goto L6;
        Logger.d(TAG, "No ScreenFlash instance set yet, need to wait for controller to be set to either ScreenFlashView or PreviewView");
        this.mImageCapture.setScreenFlash(NO_OP_SCREEN_FLASH);
        return;
    L6:
        this.mImageCapture.setScreenFlash(r0.getScreenFlash());
        Logger.d(TAG, "Set ScreenFlash instance to ImageCapture, provided by " + r0.getProviderType().name());
    }

    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    public CameraController(Context r4) {
        this(r4, Futures.transform(ProcessCameraProvider.getInstance(r4), new b(), CameraXExecutors.directExecutor()));
    }

    private ImageCapture createImageCapture(Integer r3) {
        ImageCapture.Builder r0 = new ImageCapture.Builder();
        if (r3 == null) goto L5;
        r0.setCaptureMode(r3.intValue());
    L5:
        configureResolution(r0, this.mImageCaptureResolutionSelector, this.mImageCaptureTargetSize);
        Executor r4 = this.mImageCaptureIoExecutor;
        if (r4 == null) goto L9;
        r0.setIoExecutor(r4);
    L9:
        return r0.build();
    }

    private void deactivateRecording(Recording r2) {
        if (this.mActiveRecording != r2) goto L6;
        this.mActiveRecording = null;
        return;
    }

    private int getViewportAspectRatioInt(ViewPort r7) {
        if (r7 != null) goto L5;
        int r1 = 0;
    L6:
        ProcessCameraProviderWrapper r2 = this.mCameraProvider;
        if (r2 != null) goto L9;
        int r3 = 0;
    L10:
        ProcessCameraProviderWrapper r4 = this.mCameraProvider;
        if (r4 != null) goto L14;
    L12:
        boolean r5 = true;
    L17:
        int r6 = CameraOrientationUtil.getRelativeImageRotation(r1, r3, r5);
        Rational r8 = r7.getAspectRatio();
        if (r6 != 90) goto L20;
    L21:
        r8 = new Rational(r8.getDenominator(), r8.getNumerator());
    L23:
        if (r8.equals(new Rational(4, 3)) == false) goto L26;
        return 0;
    L26:
        if (r8.equals(new Rational(16, 9)) == false) goto L28;
        return 1;
    L28:
        return -1;
    L20:
        if (r6 != 270) goto L23;
    L14:
        if (r4.getCameraInfo(this.mCameraSelector).getLensFacing() == 1) goto L12;
        r5 = false;
        goto L17
    L9:
        r3 = r2.getCameraInfo(this.mCameraSelector).getSensorRotationDegrees();
        goto L10
    L5:
        r1 = CameraOrientationUtil.surfaceRotationToDegrees(r7.getRotation());
        goto L6
    }

    private AspectRatioStrategy getViewportAspectRatioStrategy(ViewPort r3) {
        int r4 = getViewportAspectRatioInt(r3);
        if (r4 != (-1)) goto L5;
        return null;
    L5:
        return new AspectRatioStrategy(r4, 1);
    }

    private boolean isUseCaseEnabled(int r2) {
        if ((r2 & this.mEnabledUseCases) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ Void lambda$new$0(ProcessCameraProviderWrapper r1) {
        this.mCameraProvider = r1;
        unbindAllAndRecreate();
        startCameraAndTrackStates();
        return null;
    }

    private /* synthetic */ void lambda$new$1(int r2) {
        this.mImageAnalysis.setTargetRotation(r2);
        this.mImageCapture.setTargetRotation(r2);
        this.mVideoCapture.setTargetRotation(r2);
    }

    private /* synthetic */ void lambda$setCameraSelector$3(CameraSelector r1) {
        this.mCameraSelector = r1;
    }

    private /* synthetic */ void lambda$setEnabledUseCases$2(int r1) {
        this.mEnabledUseCases = r1;
    }

    private PendingRecording prepareRecording(OutputOptions r4) {
        Recorder r0 = (Recorder) this.mVideoCapture.getOutput();
        if ((r4 instanceof FileOutputOptions) == false) goto L7;
        return r0.prepareRecording(this.mAppContext, (FileOutputOptions) r4);
    L7:
        if ((r4 instanceof FileDescriptorOutputOptions) == false) goto L15;
        if (Build.VERSION.SDK_INT < 26) goto L13;
        return r0.prepareRecording(this.mAppContext, (FileDescriptorOutputOptions) r4);
    L13:
        throw new UnsupportedOperationException("File descriptors are not supported on pre-Android O (API 26) devices.");
    L15:
        if ((r4 instanceof MediaStoreOutputOptions) == false) goto L19;
        return r0.prepareRecording(this.mAppContext, (MediaStoreOutputOptions) r4);
    L19:
        throw new IllegalArgumentException("Unsupported OutputOptions type.");
    }

    private void unbindImageCaptureAndRecreate(Integer r5) {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mImageCapture});
    L5:
        int r0 = this.mImageCapture.getFlashMode();
        this.mImageCapture = createImageCapture(r5);
        setImageCaptureFlashMode(r0);
    }

    private Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized(Consumer<VideoRecordEvent> r3) {
        return new AnonymousClass2(this, ContextCompat.getMainExecutor(this.mAppContext), r3);
    }

    public void deactivateRecordingByListener(Consumer<VideoRecordEvent> r2) {
        Recording r3 = this.mRecordingMap.remove(r2);
        if (r3 == null) goto L6;
        deactivateRecording(r3);
        return;
    }

    public ListenableFuture<Void> enableTorch(boolean r2) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingEnableTorch.setValue(Boolean.valueOf(r2));
    L7:
        return this.mCamera.getCameraControl().enableTorch(r2);
    }

    public boolean hasCamera(CameraSelector r3) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(r3);
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L10;
        return r0.hasCamera(r3);
    L6:
        e = move-exception;
        Logger.w(TAG, "Failed to check camera availability", e);
        return false;
    L10:
        throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
    }

    public void onPinchToZoom(float r4) {
        if (isCameraAttached() == true) goto L7;
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        if (this.mPinchToZoomEnabled == true) goto L10;
        Logger.d(TAG, "Pinch to zoom disabled.");
        return;
    L10:
        Logger.d(TAG, "Pinch to zoom with scale: " + r4);
        ZoomState r0 = (ZoomState) getZoomState().getValue();
        if (r0 != null) goto L13;
        return;
    L13:
        setZoomRatio(Math.min(Math.max(r0.getZoomRatio() * speedUpZoomBy2X(r4), r0.getMinZoomRatio()), r0.getMaxZoomRatio()));
    }

    public void setCameraSelector(CameraSelector r6) {
        Threads.checkMainThread();
        if (this.mCameraSelector != r6) goto L5;
        return;
    L5:
        Integer r0 = r6.getLensFacing();
        if (this.mImageCapture.getFlashMode() != 3) goto L13;
        if (r0 == null) goto L13;
        if (r0.intValue() == 0) goto L13;
        throw new IllegalStateException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L13:
        final CameraSelector r1 = this.mCameraSelector;
        this.mCameraSelector = r6;
        ProcessCameraProviderWrapper r7 = this.mCameraProvider;
        if (r7 != null) goto L16;
        return;
    L16:
        r7.unbind(new UseCase[]{this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture});
        startCameraAndTrackStates(new a(this, r1));
    }

    public void setEffects(Set<CameraEffect> r2) {
        Threads.checkMainThread();
        if (Objects.equals(this.mEffects, r2) == false) goto L5;
        return;
    L5:
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L8;
        r0.unbindAll();
    L8:
        this.mEffects.clear();
        this.mEffects.addAll(r2);
        startCameraAndTrackStates();
    }

    public void setEnabledUseCases(int r2) {
        Threads.checkMainThread();
        final int r0 = this.mEnabledUseCases;
        if (r2 != r0) goto L5;
        return;
    L5:
        this.mEnabledUseCases = r2;
        if (isVideoCaptureEnabled() == false) goto L8;
    L10:
        startCameraAndTrackStates(new h(this, r0));
        return;
    L8:
        if (isRecording() == false) goto L10;
        stopRecording();
        goto L10
    }

    public void setImageAnalysisBackgroundExecutor(Executor r3) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor != r3) goto L5;
        return;
    L5:
        this.mAnalysisBackgroundExecutor = r3;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisBackpressureStrategy(int r3) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() != r3) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(r3), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisImageQueueDepth(int r3) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() != r3) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(r3), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisOutputImageFormat(int r3) {
        Threads.checkMainThread();
        if (r3 != this.mImageAnalysis.getOutputImageFormat()) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(r3));
    }

    public void setImageAnalysisResolutionSelector(ResolutionSelector r3) {
        Threads.checkMainThread();
        if (this.mImageAnalysisResolutionSelector != r3) goto L5;
        return;
    L5:
        this.mImageAnalysisResolutionSelector = r3;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisTargetSize(OutputSize r3) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, r3) == false) goto L5;
        return;
    L5:
        this.mImageAnalysisTargetSize = r3;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureFlashMode(int r2) {
        Threads.checkMainThread();
        if (r2 != 3) goto L12;
        Integer r0 = this.mCameraSelector.getLensFacing();
        if (r0 != null) goto L7;
    L11:
        updateScreenFlashToImageCapture();
        goto L12
    L7:
        if (r0.intValue() == 0) goto L11;
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L12:
        this.mImageCapture.setFlashMode(r2);
    }

    public void setImageCaptureIoExecutor(Executor r2) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor != r2) goto L5;
        return;
    L5:
        this.mImageCaptureIoExecutor = r2;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureMode(int r2) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() != r2) goto L5;
        return;
    L5:
        unbindImageCaptureAndRecreate(Integer.valueOf(r2));
        startCameraAndTrackStates();
    }

    public void setImageCaptureResolutionSelector(ResolutionSelector r2) {
        Threads.checkMainThread();
        if (this.mImageCaptureResolutionSelector != r2) goto L5;
        return;
    L5:
        this.mImageCaptureResolutionSelector = r2;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureTargetSize(OutputSize r2) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, r2) == false) goto L5;
        return;
    L5:
        this.mImageCaptureTargetSize = r2;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setLinearZoom(float r2) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingLinearZoom.setValue(Float.valueOf(r2));
    L7:
        return this.mCamera.getCameraControl().setLinearZoom(r2);
    }

    public void setPinchToZoomEnabled(boolean r1) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = r1;
    }

    public void setPreviewDynamicRange(DynamicRange r1) {
        Threads.checkMainThread();
        this.mPreviewDynamicRange = r1;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setPreviewResolutionSelector(ResolutionSelector r2) {
        Threads.checkMainThread();
        if (this.mPreviewResolutionSelector != r2) goto L5;
        return;
    L5:
        this.mPreviewResolutionSelector = r2;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setPreviewTargetSize(OutputSize r2) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mPreviewTargetSize, r2) == false) goto L5;
        return;
    L5:
        this.mPreviewTargetSize = r2;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setScreenFlashUiInfo(ScreenFlashUiInfo r4) {
        ScreenFlashUiInfo r0 = getScreenFlashUiInfoByPriority();
        this.mScreenFlashUiInfoMap.put(r4.getProviderType(), r4);
        ScreenFlashUiInfo r5 = getScreenFlashUiInfoByPriority();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.equals(r0) == true) goto L9;
        updateScreenFlashToImageCapture();
        return;
    }

    public void setTapToFocusEnabled(boolean r1) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = r1;
    }

    public void setVideoCaptureDynamicRange(DynamicRange r1) {
        Threads.checkMainThread();
        this.mVideoCaptureDynamicRange = r1;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureMirrorMode(int r1) {
        Threads.checkMainThread();
        this.mVideoCaptureMirrorMode = r1;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureQualitySelector(QualitySelector r1) {
        Threads.checkMainThread();
        this.mVideoCaptureQualitySelector = r1;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureTargetFrameRate(Range<Integer> r1) {
        Threads.checkMainThread();
        this.mVideoCaptureTargetFrameRate = r1;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setZoomRatio(float r2) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingZoomRatio.setValue(Float.valueOf(r2));
    L7:
        return this.mCamera.getCameraControl().setZoomRatio(r2);
    }

    public void startCameraAndTrackStates(Runnable r2) {
        this.mCamera = startCamera();     // Catch: RuntimeException -> L9
        if (isCameraAttached() == true) goto L7;
        Logger.d(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
        this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
        this.mPendingEnableTorch.propagateIfHasValue(new e(this));
        this.mPendingLinearZoom.propagateIfHasValue(new f(this));
        this.mPendingZoomRatio.propagateIfHasValue(new g(this));
        return;
    L9:
        e = move-exception;
        if (r2 == null) goto L12;
        r2.run();
    L12:
        throw e;
    }

    public void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions r2) {
        if (this.mCameraSelector.getLensFacing() != null) goto L5;
        return;
    L5:
        if (r2.getMetadata().isReversedHorizontalSet() == true) goto L13;
        ImageCapture.Metadata r3 = r2.getMetadata();
        if (this.mCameraSelector.getLensFacing().intValue() != 0) goto L9;
        boolean r0 = true;
    L10:
        r3.setReversedHorizontal(r0);
        return;
    L9:
        r0 = false;
        goto L10
    }

    public void updatePreviewViewTransform(Matrix r3) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r0 = this.mAnalysisAnalyzer;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getTargetCoordinateSystem() != 1) goto L9;
        this.mAnalysisAnalyzer.updateTransform(r3);
        return;
    }

    public CameraController(Context r4, ListenableFuture<ProcessCameraProviderWrapper> r5) {
        this.mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mEnabledUseCases = 3;
        this.mActiveRecording = null;
        this.mRecordingMap = new HashMap();
        this.mVideoCaptureQualitySelector = Recorder.DEFAULT_QUALITY_SELECTOR;
        this.mVideoCaptureMirrorMode = 0;
        DynamicRange r2 = DynamicRange.UNSPECIFIED;
        this.mVideoCaptureDynamicRange = r2;
        this.mPreviewDynamicRange = r2;
        this.mVideoCaptureTargetFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        this.mPinchToZoomEnabled = true;
        this.mTapToFocusEnabled = true;
        this.mZoomState = new ForwardingLiveData();
        this.mTorchState = new ForwardingLiveData();
        this.mTapToFocusState = new MutableLiveData(0);
        this.mPendingEnableTorch = new PendingValue();
        this.mPendingLinearZoom = new PendingValue();
        this.mPendingZoomRatio = new PendingValue();
        this.mEffects = new HashSet();
        this.mScreenFlashUiInfoMap = new HashMap();
        Context r6 = ContextUtil.getApplicationContext(r4);
        this.mAppContext = r6;
        this.mPreview = createPreview();
        this.mImageCapture = createImageCapture(null);
        this.mImageAnalysis = createImageAnalysis(null, null, null);
        this.mVideoCapture = createVideoCapture();
        this.mInitializationFuture = Futures.transform(r5, new c(this), CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(r6);
        this.mDeviceRotationListener = new d(this);
    }

    private boolean isOutputSizeEqual(OutputSize r2, OutputSize r3) {
        if (r2 != r3) goto L5;
        return true;
    L5:
        if (r2 != null) goto L7;
    L9:
        return false;
    L7:
        if (r2.equals(r3) == false) goto L9;
        return true;
    }

    private void restartCameraIfAnalyzerResolutionChanged(ImageAnalysis.Analyzer r2, ImageAnalysis.Analyzer r3) {
        Size r0 = null;
        if (r2 != null) goto L5;
        Size r4 = null;
    L6:
        if (r3 == null) goto L10;
        r0 = r3.getDefaultTargetResolution();
    L10:
        if (Objects.equals(r4, r0) == true) goto L13;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
        return;
    L13:
        return;
    L5:
        r4 = r2.getDefaultTargetResolution();
        goto L6
    }

    private void setActiveRecording(Recording r2, Consumer<VideoRecordEvent> r3) {
        this.mRecordingMap.put(r3, r2);
        this.mActiveRecording = r2;
    }

    private void setTargetOutputSize(ImageOutputConfig.Builder<?> r3, OutputSize r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getResolution() == null) goto L8;
        r3.setTargetResolution(r4.getResolution());
        return;
    L8:
        if (r4.getAspectRatio() == (-1)) goto L10;
        r3.setTargetAspectRatio(r4.getAspectRatio());
        return;
    L10:
        Logger.e(TAG, "Invalid target surface size. " + r4);
    }

    public void attachPreviewSurface(Preview.SurfaceProvider r2, ViewPort r3) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider == r2) goto L6;
        this.mSurfaceProvider = r2;
        this.mPreview.setSurfaceProvider(r2);
    L6:
        if (this.mViewPort != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        this.mViewPort = r3;
        startListeningToRotationEvents();
        if (r4 == false) goto L15;
        unbindAllAndRecreate();
    L15:
        startCameraAndTrackStates();
        return;
    L8:
        if (getViewportAspectRatioStrategy(r3) != getViewportAspectRatioStrategy(this.mViewPort)) goto L11;
        r4 = false;
        goto L12
    }

    public void setImageAnalysisAnalyzer(Executor r3, ImageAnalysis.Analyzer r4) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r0 = this.mAnalysisAnalyzer;
        if (r0 == r4) goto L5;
    L7:
        this.mAnalysisExecutor = r3;
        this.mAnalysisAnalyzer = r4;
        this.mImageAnalysis.setAnalyzer(r3, r4);
        restartCameraIfAnalyzerResolutionChanged(r0, r4);
        return;
    L5:
        if (this.mAnalysisExecutor != r3) goto L7;
    }

    public void takePicture(Executor r3, ImageCapture.OnImageCapturedCallback r4) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        this.mImageCapture.takePicture(r3, r4);
    }

    private void configureResolution(ImageOutputConfig.Builder<?> r1, ResolutionSelector r2, OutputSize r3) {
        if (r2 == null) goto L4;
        r1.setResolutionSelector(r2);
        return;
    L4:
        if (r3 == null) goto L6;
        setTargetOutputSize(r1, r3);
        return;
    L6:
        ViewPort r4 = this.mViewPort;
        if (r4 == null) goto L14;
        AspectRatioStrategy r5 = getViewportAspectRatioStrategy(r4);
        if (r5 == null) goto L15;
        r1.setResolutionSelector(new ResolutionSelector.Builder().setAspectRatioStrategy(r5).build());
        return;
    L15:
        return;
    }

    private ImageAnalysis createImageAnalysis(Integer r2, Integer r3, Integer r4) {
        ImageAnalysis.Builder r0 = new ImageAnalysis.Builder();
        if (r2 == null) goto L5;
        r0.setBackpressureStrategy(r2.intValue());
    L5:
        if (r3 == null) goto L7;
        r0.setImageQueueDepth(r3.intValue());
    L7:
        if (r4 == null) goto L9;
        r0.setOutputImageFormat(r4.intValue());
    L9:
        configureResolution(r0, this.mImageAnalysisResolutionSelector, this.mImageAnalysisTargetSize);
        Executor r5 = this.mAnalysisBackgroundExecutor;
        if (r5 == null) goto L13;
        r0.setBackgroundExecutor(r5);
    L13:
        return r0.build();
    }

    private void unbindImageAnalysisAndRecreate(Integer r5, Integer r6, Integer r7) {
        Threads.checkMainThread();
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
    L5:
        ImageAnalysis r8 = createImageAnalysis(r5, r6, r7);
        this.mImageAnalysis = r8;
        Executor r9 = this.mAnalysisExecutor;
        if (r9 == null) goto L11;
        ImageAnalysis.Analyzer r10 = this.mAnalysisAnalyzer;
        if (r10 == null) goto L12;
        r8.setAnalyzer(r9, r10);
        return;
    L12:
        return;
    }

    public void onTapToFocus(MeteringPointFactory r4, float r5, float r6) {
        if (isCameraAttached() == true) goto L7;
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        if (this.mTapToFocusEnabled == true) goto L10;
        Logger.d(TAG, "Tap to focus disabled. ");
        return;
    L10:
        Logger.d(TAG, "Tap to focus started: " + r5 + ", " + r6);
        this.mTapToFocusState.postValue(1);
        MeteringPoint r0 = r4.createPoint(r5, r6, AF_SIZE);
        Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(r0, 1).addPoint(r4.createPoint(r5, r6, AE_SIZE), 2).build()), new AnonymousClass3(this), CameraXExecutors.directExecutor());
    }

    public void takePicture(ImageCapture.OutputFileOptions r3, Executor r4, ImageCapture.OnImageSavedCallback r5) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        updateMirroringFlagInOutputFileOptions(r3);
        this.mImageCapture.takePicture(r3, r4, r5);
    }

    private Recording startRecordingInternal(OutputOptions r3, AudioConfig r4, Executor r5, Consumer<VideoRecordEvent> r6) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        Preconditions.checkState(!isRecording(), VIDEO_RECORDING_UNFINISHED);
        Consumer<VideoRecordEvent> r7 = wrapListenerToDeactivateRecordingOnFinalized(r6);
        PendingRecording r8 = prepareRecording(r3);
        if (r4.getAudioEnabled() == false) goto L5;
        checkAudioPermissionGranted();
        r8.withAudioEnabled();
    L5:
        Recording r9 = r8.start(r5, r7);
        setActiveRecording(r9, r7);
        return r9;
    }

    public Recording startRecording(FileDescriptorOutputOptions r1, AudioConfig r2, Executor r3, Consumer<VideoRecordEvent> r4) {
        return startRecordingInternal(r1, r2, r3, r4);
    }

    public Recording startRecording(FileOutputOptions r1, AudioConfig r2, Executor r3, Consumer<VideoRecordEvent> r4) {
        return startRecordingInternal(r1, r2, r3, r4);
    }

    public Recording startRecording(MediaStoreOutputOptions r1, AudioConfig r2, Executor r3, Consumer<VideoRecordEvent> r4) {
        return startRecordingInternal(r1, r2, r3, r4);
    }
}
