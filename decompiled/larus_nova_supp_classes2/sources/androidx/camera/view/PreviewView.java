package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.impl.ZoomGestureDetector;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class PreviewView extends FrameLayout {
    static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final ImplementationMode DEFAULT_IMPL_MODE = null;
    private static final String TAG = "PreviewView";
    final AtomicReference<PreviewStreamStateObserver> mActiveStreamStateObserver;
    CameraController mCameraController;
    CameraInfoInternal mCameraInfoInternal;
    private final DisplayRotationListener mDisplayRotationListener;
    PreviewViewImplementation mImplementation;
    ImplementationMode mImplementationMode;
    OnFrameUpdateListener mOnFrameUpdateListener;
    Executor mOnFrameUpdateListenerExecutor;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;
    final MutableLiveData<StreamState> mPreviewStreamStateLiveData;
    final PreviewTransformation mPreviewTransform;
    PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    final ScreenFlashView mScreenFlashView;
    final Preview.SurfaceProvider mSurfaceProvider;
    private MotionEvent mTouchUpEvent;
    boolean mUseDisplayRotation;
    private final ZoomGestureDetector mZoomGestureDetector;

    /* JADX INFO: renamed from: androidx.camera.view.PreviewView$1, reason: invalid class name */
    public class AnonymousClass1 implements Preview.SurfaceProvider {
        final /* synthetic */ PreviewView this$0;

        public static /* synthetic */ void a(AnonymousClass1 r0, PreviewStreamStateObserver r1, CameraInternal r2) {
            r0.lambda$onSurfaceRequested$2(r1, r2);
        }

        public static /* synthetic */ void b(AnonymousClass1 r0, CameraInternal r1, SurfaceRequest r2, SurfaceRequest.TransformationInfo r3) {
            r0.lambda$onSurfaceRequested$1(r1, r2, r3);
        }

        public static /* synthetic */ void c(AnonymousClass1 r0, SurfaceRequest r1) {
            r0.lambda$onSurfaceRequested$0(r1);
        }

        public AnonymousClass1(PreviewView r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest r2) {
            this.this$0.mSurfaceProvider.onSurfaceRequested(r2);
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void onSurfaceRequested(final SurfaceRequest r6) {
            if (Threads.isMainThread() == true) goto L6;
            ContextCompat.getMainExecutor(this.this$0.getContext()).execute(new q(this, r6));
            return;
        L6:
            Logger.d(PreviewView.TAG, "Surface requested by Preview.");
            final CameraInternal r0 = r6.getCamera();
            PreviewView r1 = this.this$0;
            r1.mCameraInfoInternal = r0.getCameraInfoInternal();
            this.this$0.mPreviewViewMeteringPointFactory.setSensorRect(r0.getCameraControlInternal().getSensorRect());
            r6.setTransformationInfoListener(ContextCompat.getMainExecutor(this.this$0.getContext()), new s(this, r0, r6));
            PreviewView r2 = this.this$0;
            if (PreviewView.shouldReuseImplementation(r2.mImplementation, r6, r2.mImplementationMode) == true) goto L13;
            PreviewView r3 = this.this$0;
            if (PreviewView.shouldUseTextureView(r6, r3.mImplementationMode) == false) goto L11;
            PreviewView r4 = this.this$0;
            PreviewViewImplementation r5 = new TextureViewImplementation(r4, r4.mPreviewTransform);
        L12:
            r3.mImplementation = r5;
            goto L13
        L11:
            PreviewView r7 = this.this$0;
            r5 = new SurfaceViewImplementation(r7, r7.mPreviewTransform);
        L13:
            CameraInfoInternal r8 = r0.getCameraInfoInternal();
            PreviewView r9 = this.this$0;
            final PreviewStreamStateObserver r10 = new PreviewStreamStateObserver(r8, r9.mPreviewStreamStateLiveData, r9.mImplementation);
            this.this$0.mActiveStreamStateObserver.set(r10);
            r0.getCameraState().addObserver(ContextCompat.getMainExecutor(this.this$0.getContext()), r10);
            this.this$0.mImplementation.onSurfaceRequested(r6, new t(this, r10, r0));
            PreviewView r11 = this.this$0;
            if (r11.indexOfChild(r11.mScreenFlashView) != (-1)) goto L16;
            PreviewView r12 = this.this$0;
            r12.addView(r12.mScreenFlashView);
        L16:
            PreviewView r13 = this.this$0;
            OnFrameUpdateListener r14 = r13.mOnFrameUpdateListener;
            if (r14 == null) goto L22;
            Executor r15 = r13.mOnFrameUpdateListenerExecutor;
            if (r15 == null) goto L23;
            r13.mImplementation.setFrameUpdateListener(r15, r14);
            return;
        L23:
            return;
        }

        private /* synthetic */ void lambda$onSurfaceRequested$2(PreviewStreamStateObserver r3, CameraInternal r4) {
            AtomicReference<PreviewStreamStateObserver> r0 = this.this$0.mActiveStreamStateObserver;
        L4:
            if (r0.compareAndSet(r3, null) == true) goto L5;
            if (r0.get() == r3) goto L4;
            boolean r1 = false;
        L9:
            if (r1 == false) goto L11;
            r3.updatePreviewStreamState(StreamState.IDLE);
        L11:
            r3.clear();
            r4.getCameraState().removeObserver(r3);
            return;
        L5:
            r1 = true;
            goto L9
        }

        private /* synthetic */ void lambda$onSurfaceRequested$1(CameraInternal r4, SurfaceRequest r5, SurfaceRequest.TransformationInfo r6) {
            Logger.d(PreviewView.TAG, "Preview transformation info updated. " + r6);
            Integer r7 = Integer.valueOf(r4.getCameraInfoInternal().getLensFacing());
            if (r7 != null) goto L7;
            Logger.w(PreviewView.TAG, "The lens facing is null, probably an external.");
        L5:
            boolean r8 = true;
        L10:
            this.this$0.mPreviewTransform.setTransformationInfo(r6, r5.getResolution(), r8);
            if (r6.getTargetRotation() == (-1)) goto L18;
            PreviewView r9 = this.this$0;
            PreviewViewImplementation r10 = r9.mImplementation;
            if (r10 != null) goto L15;
        L17:
            r9.mUseDisplayRotation = false;
        L19:
            this.this$0.redrawPreview();
            return;
        L15:
            if ((r10 instanceof SurfaceViewImplementation) == false) goto L17;
        L18:
            this.this$0.mUseDisplayRotation = true;
            goto L19
        L7:
            if (r7.intValue() == 0) goto L5;
            r8 = false;
            goto L10
        }
    }

    public class DisplayRotationListener implements DisplayManager.DisplayListener {
        final /* synthetic */ PreviewView this$0;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int r1) {
        }

        public DisplayRotationListener(PreviewView r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int r2) {
            Display r0 = this.this$0.getDisplay();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getDisplayId() != r2) goto L9;
            this.this$0.redrawPreview();
            return;
        }
    }

    public static final enum ImplementationMode extends Enum<ImplementationMode> {
        private static final /* synthetic */ ImplementationMode[] $VALUES = null;
        public static final ImplementationMode COMPATIBLE = null;
        public static final ImplementationMode PERFORMANCE = null;
        private final int mId;

        private static /* synthetic */ ImplementationMode[] $values() {
            return new ImplementationMode[]{PERFORMANCE, COMPATIBLE};
        }

        static {
            PERFORMANCE = new ImplementationMode("PERFORMANCE", 0, 0);
            COMPATIBLE = new ImplementationMode("COMPATIBLE", 1, 1);
            $VALUES = $values();
        }

        public static ImplementationMode[] values() {
            return (ImplementationMode[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ImplementationMode fromId(int r5) {
            ImplementationMode[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            ImplementationMode r3 = r0[r2];
            if (r3.mId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Unknown implementation mode id " + r5);
        }

        public static ImplementationMode valueOf(String r1) {
            return (ImplementationMode) r27.a.a(ImplementationMode.class, r1);
        }

        private ImplementationMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.mId = r3;
        }
    }

    public interface OnFrameUpdateListener {
        void onFrameUpdate(long r1);
    }

    public static final enum ScaleType extends Enum<ScaleType> {
        private static final /* synthetic */ ScaleType[] $VALUES = null;
        public static final ScaleType FILL_CENTER = null;
        public static final ScaleType FILL_END = null;
        public static final ScaleType FILL_START = null;
        public static final ScaleType FIT_CENTER = null;
        public static final ScaleType FIT_END = null;
        public static final ScaleType FIT_START = null;
        private final int mId;

        private static /* synthetic */ ScaleType[] $values() {
            return new ScaleType[]{FILL_START, FILL_CENTER, FILL_END, FIT_START, FIT_CENTER, FIT_END};
        }

        static {
            FILL_START = new ScaleType("FILL_START", 0, 0);
            FILL_CENTER = new ScaleType("FILL_CENTER", 1, 1);
            FILL_END = new ScaleType("FILL_END", 2, 2);
            FIT_START = new ScaleType("FIT_START", 3, 3);
            FIT_CENTER = new ScaleType("FIT_CENTER", 4, 4);
            FIT_END = new ScaleType("FIT_END", 5, 5);
            $VALUES = $values();
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ScaleType fromId(int r5) {
            ScaleType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            ScaleType r3 = r0[r2];
            if (r3.mId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Unknown scale type id " + r5);
        }

        public static ScaleType valueOf(String r1) {
            return (ScaleType) r27.a.a(ScaleType.class, r1);
        }

        private ScaleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.mId = r3;
        }
    }

    public static final enum StreamState extends Enum<StreamState> {
        private static final /* synthetic */ StreamState[] $VALUES = null;
        public static final StreamState IDLE = null;
        public static final StreamState STREAMING = null;

        private static /* synthetic */ StreamState[] $values() {
            return new StreamState[]{IDLE, STREAMING};
        }

        static {
            IDLE = new StreamState("IDLE", 0);
            STREAMING = new StreamState("STREAMING", 1);
            $VALUES = $values();
        }

        public static StreamState[] values() {
            return (StreamState[]) $VALUES.clone();
        }

        public static StreamState valueOf(String r1) {
            return (StreamState) r27.a.a(StreamState.class, r1);
        }

        private StreamState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ boolean a(PreviewView r0, ZoomGestureDetector.ZoomEvent r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void b(PreviewView r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.lambda$new$0(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        DEFAULT_IMPL_MODE = ImplementationMode.PERFORMANCE;
    }

    private ImageCapture.ScreenFlash getScreenFlashInternal() {
        return this.mScreenFlashView.getScreenFlash();
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mCameraController == null) goto L13;
        MotionEvent r0 = this.mTouchUpEvent;
        if (r0 == null) goto L7;
        float r1 = r0.getX();
    L8:
        MotionEvent r2 = this.mTouchUpEvent;
        if (r2 == null) goto L11;
        float r3 = r2.getY();
    L12:
        this.mCameraController.onTapToFocus(this.mPreviewViewMeteringPointFactory, r1, r3);
        goto L13
    L11:
        r3 = getHeight() / 2.0f;
        goto L12
    L7:
        r1 = getWidth() / 2.0f;
    L13:
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    public void updateDisplayRotationIfNeeded() {
        if (this.mUseDisplayRotation == false) goto L10;
        Display r0 = getDisplay();
        if (r0 == null) goto L11;
        CameraInfoInternal r1 = this.mCameraInfoInternal;
        if (r1 == null) goto L12;
        this.mPreviewTransform.overrideWithDisplayRotation(r1.getSensorRotationDegrees(r0.getRotation()), r0.getRotation());
        return;
    L12:
        return;
    L11:
        return;
    }

    private DisplayManager getDisplayManager() {
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (DisplayManager) r0.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        int r0 = getScaleType().ordinal();
        if (r0 == 0) goto L18;
        int r1 = 1;
        if (r0 == 1) goto L17;
        r1 = 2;
        if (r0 == 2) goto L17;
        r1 = 3;
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L17;
        throw new IllegalStateException("Unexpected scale type: " + getScaleType());
    L17:
        return r1;
    L18:
        return 0;
    }

    private void startListeningToDisplayChange() {
        DisplayManager r0 = getDisplayManager();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
    }

    private void stopListeningToDisplayChange() {
        DisplayManager r0 = getDisplayManager();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterDisplayListener(this.mDisplayRotationListener);
    }

    public Bitmap getBitmap() {
        Threads.checkMainThread();
        PreviewViewImplementation r0 = this.mImplementation;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getBitmap();
    }

    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    public OutputTransform getOutputTransform() {
        Threads.checkMainThread();
        Matrix r1 = this.mPreviewTransform.getSurfaceToPreviewViewMatrix(new Size(getWidth(), getHeight()), getLayoutDirection());     // Catch: IllegalStateException -> L5
    L6:
        Rect r2 = this.mPreviewTransform.getSurfaceCropRect();
        if (r1 == null) goto L18;
        if (r2 == null) goto L18;
        r1.preConcat(TransformUtils.getNormalizedToBuffer(r2));
        if ((this.mImplementation instanceof TextureViewImplementation) == false) goto L14;
        r1.postConcat(getMatrix());
    L17:
        return new OutputTransform(r1, new Size(r2.width(), r2.height()));
    L14:
        if (getMatrix().isIdentity() == true) goto L17;
        Logger.w(TAG, "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
    L18:
        Logger.d(TAG, "Transform info is not ready");
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        Threads.checkMainThread();
        if (getWidth() != 0) goto L5;
        return null;
    L5:
        if (getHeight() != 0) goto L8;
        return null;
    L8:
        return this.mPreviewTransform.getSensorToViewTransform(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (getDisplay() != null) goto L7;
        return null;
    L7:
        return getViewPort(getDisplay().getRotation());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startListeningToDisplayChange();
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation r0 = this.mImplementation;
        if (r0 == null) goto L5;
        r0.onAttachedToWindow();
    L5:
        attachToControllerIfReady(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation r0 = this.mImplementation;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        CameraController r1 = this.mCameraController;
        if (r1 == null) goto L8;
        r1.clearPreviewSurface();
    L8:
        stopListeningToDisplayChange();
    }

    public void redrawPreview() {
        Threads.checkMainThread();
        if (this.mImplementation == null) goto L5;
        updateDisplayRotationIfNeeded();
        this.mImplementation.redrawPreview();
    L5:
        this.mPreviewViewMeteringPointFactory.recalculate(new Size(getWidth(), getHeight()), getLayoutDirection());
        CameraController r0 = this.mCameraController;
        if (r0 == null) goto L9;
        r0.updatePreviewViewTransform(getSensorToViewTransform());
        return;
    }

    public LiveData<StreamState> getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    public PreviewView(Context r2) {
        this(r2, null);
    }

    private void attachToControllerIfReady(boolean r4) {
        Threads.checkMainThread();
        ViewPort r0 = getViewPort();
        if (this.mCameraController == null) goto L13;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == false) goto L17;
        this.mCameraController.attachPreviewSurface(getSurfaceProvider(), r0);     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        if (r4 == false) goto L12;
        Logger.e(TAG, e.toString(), e);
        return;
    L12:
        throw e;
    L17:
        return;
    }

    private /* synthetic */ boolean lambda$new$1(ZoomGestureDetector.ZoomEvent r2) {
        if ((r2 instanceof ZoomGestureDetector.ZoomEvent.Move) == false) goto L9;
        CameraController r0 = this.mCameraController;
        if (r0 == null) goto L10;
        r0.onPinchToZoom(((ZoomGestureDetector.ZoomEvent.Move) r2).getIncrementalScaleFactor());
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash r4) {
        CameraController r0 = this.mCameraController;
        if (r0 != null) goto L6;
        Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        return;
    L6:
        r0.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW, r4));
    }

    public ViewPort getViewPort(int r5) {
        Threads.checkMainThread();
        if (getWidth() != 0) goto L5;
        return null;
    L5:
        if (getHeight() != 0) goto L8;
        return null;
    L8:
        return new ViewPort.Builder(new Rational(getWidth(), getHeight()), r5).setScaleType(getViewPortScaleType()).setLayoutDirection(getLayoutDirection()).build();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mCameraController != null) goto L7;
        return super.onTouchEvent(r10);
    L7:
        if (r10.getPointerCount() != 1) goto L9;
        boolean r0 = true;
    L11:
        if (r10.getAction() != 1) goto L13;
        boolean r3 = true;
    L15:
        if ((r10.getEventTime() - r10.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L17;
        boolean r4 = true;
    L18:
        if (r0 == false) goto L24;
        if (r3 == false) goto L24;
        if (r4 == false) goto L24;
        this.mTouchUpEvent = r10;
        performClick();
        return true;
    L24:
        if (this.mZoomGestureDetector.onTouchEvent(r10) == false) goto L26;
    L27:
        return true;
    L26:
        if (super.onTouchEvent(r10) == true) goto L27;
        return false;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L15
    L9:
        r0 = false;
        goto L11
    }

    public void setController(CameraController r2) {
        Threads.checkMainThread();
        CameraController r0 = this.mCameraController;
        if (r0 == null) goto L6;
        if (r0 == r2) goto L6;
        r0.clearPreviewSurface();
        setScreenFlashUiInfo(null);
    L6:
        this.mCameraController = r2;
        attachToControllerIfReady(false);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(ImplementationMode r2) {
        Threads.checkMainThread();
        this.mImplementationMode = r2;
        if (r2 == ImplementationMode.PERFORMANCE) goto L5;
        return;
    L5:
        if (this.mOnFrameUpdateListener != null) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
    }

    public void setScaleType(ScaleType r2) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(r2);
        redrawPreview();
        attachToControllerIfReady(false);
    }

    public void setScreenFlashOverlayColor(int r2) {
        this.mScreenFlashView.setBackgroundColor(r2);
    }

    public void setScreenFlashWindow(Window r2) {
        Threads.checkMainThread();
        this.mScreenFlashView.setScreenFlashWindow(r2);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public PreviewView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static boolean shouldUseTextureView(SurfaceRequest r5, ImplementationMode r6) {
        boolean r7 = r5.getCamera().getCameraInfoInternal().getImplementationType().equals(CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY);
        if (DeviceQuirks.get(SurfaceViewStretchedQuirk.class) == null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (Build.VERSION.SDK_INT <= 24) goto L21;
        if (r7 == true) goto L21;
        if (r0 == true) goto L21;
        int r8 = r6.ordinal();
        if (r8 == 0) goto L20;
        if (r8 != 1) goto L19;
        return true;
    L19:
        throw new IllegalArgumentException("Invalid implementation mode: " + r6);
    L20:
        return false;
    L21:
        return true;
    L5:
        if (DeviceQuirks.get(SurfaceViewNotCroppedByParentQuirk.class) != null) goto L8;
        r0 = false;
        goto L10
    }

    public void setFrameUpdateListener(Executor r3, OnFrameUpdateListener r4) {
        if (this.mImplementationMode == ImplementationMode.PERFORMANCE) goto L9;
        this.mOnFrameUpdateListener = r4;
        this.mOnFrameUpdateListenerExecutor = r3;
        PreviewViewImplementation r0 = this.mImplementation;
        if (r0 == null) goto L10;
        r0.setFrameUpdateListener(r3, r4);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
    }

    public PreviewView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public static boolean shouldReuseImplementation(PreviewViewImplementation r0, SurfaceRequest r1, ImplementationMode r2) {
        if ((r0 instanceof SurfaceViewImplementation) == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldUseTextureView(r1, r2) == true) goto L7;
        return true;
    }

    public PreviewView(Context r14, AttributeSet r15, int r16, int r17) {
        super(r14, r15, r16, r17);
        ImplementationMode r9 = DEFAULT_IMPL_MODE;
        this.mImplementationMode = r9;
        PreviewTransformation r10 = new PreviewTransformation();
        this.mPreviewTransform = r10;
        this.mUseDisplayRotation = true;
        this.mPreviewStreamStateLiveData = new MutableLiveData(StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(r10);
        this.mDisplayRotationListener = new DisplayRotationListener(this);
        this.mOnLayoutChangeListener = new o(this);
        this.mSurfaceProvider = new AnonymousClass1(this);
        Threads.checkMainThread();
        TypedArray r12 = r14.getTheme().obtainStyledAttributes(r15, new int[]{2130970330, 2130973926}, r16, r17);
        ViewCompat.saveAttributeDataForStyleable(this, r14, new int[]{2130970330, 2130973926}, r15, r12, r16, r17);
        setScaleType(ScaleType.fromId(r12.getInteger(1, r10.getScaleType().getId())));     // Catch: Throwable -> L9
        setImplementationMode(ImplementationMode.fromId(r12.getInteger(0, r9.getId())));     // Catch: Throwable -> L9
        r12.recycle();
        this.mZoomGestureDetector = new ZoomGestureDetector(r14, new p(this));
        if (getBackground() != null) goto L7;
        setBackgroundColor(ContextCompat.getColor(getContext(), 17170444));
    L7:
        ScreenFlashView r1 = new ScreenFlashView(r14);
        this.mScreenFlashView = r1;
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return;
    L9:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    private /* synthetic */ void lambda$new$0(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r4 - r2) == (r8 - r6)) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        redrawPreview();
        attachToControllerIfReady(true);
        return;
    L12:
        return;
    L5:
        if ((r5 - r3) != (r9 - r7)) goto L8;
        r10 = false;
        goto L9
    }
}
