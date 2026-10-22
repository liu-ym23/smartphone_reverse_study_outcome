package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.MeteringRegionCorrection;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.compose.material3.MenuKt;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class FocusMeteringControl {
    static final long AUTO_FOCUS_TIMEOUT_DURATION = 5000;
    private static final MeteringRectangle[] EMPTY_RECTANGLES = null;
    private static final String TAG = "FocusMeteringControl";
    private MeteringRectangle[] mAeRects;
    private MeteringRectangle[] mAfRects;
    private ScheduledFuture<?> mAutoCancelHandle;
    private ScheduledFuture<?> mAutoFocusTimeoutHandle;
    private MeteringRectangle[] mAwbRects;
    private final Camera2CameraControlImpl mCameraControl;
    Integer mCurrentAfState;
    final Executor mExecutor;
    long mFocusTimeoutCounter;
    private volatile boolean mIsActive;
    boolean mIsAutoFocusCompleted;
    private boolean mIsExternalFlashAeModeEnabled;
    boolean mIsFocusSuccessful;
    private boolean mIsInAfAutoMode;
    private final MeteringRegionCorrection mMeteringRegionCorrection;
    private volatile Rational mPreviewAspectRatio;
    CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter;
    CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter;
    private final ScheduledExecutorService mScheduler;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForAeMode;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForCancel;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForFocus;
    private int mTemplate;

    static {
        EMPTY_RECTANGLES = new MeteringRectangle[0];
    }

    public static /* synthetic */ boolean a(FocusMeteringControl r0, long r1, CallbackToFutureAdapter.Completer r3, TotalCaptureResult r4) {
        return r0.lambda$enableExternalFlashAeMode$6(r1, r3, r4);
    }

    public static /* synthetic */ void b(FocusMeteringControl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$triggerAePrecapture$2(r1);
    }

    public static /* synthetic */ Object c(FocusMeteringControl r0, FocusMeteringAction r1, long r2, CallbackToFutureAdapter.Completer r4) {
        return r0.lambda$startFocusAndMetering$1(r1, r2, r4);
    }

    public static /* synthetic */ boolean d(FocusMeteringControl r0, boolean r1, long r2, TotalCaptureResult r4) {
        return r0.lambda$executeMeteringAction$7(r1, r2, r4);
    }

    public static /* synthetic */ void e(FocusMeteringControl r0, boolean r1, CallbackToFutureAdapter.Completer r2) {
        r0.lambda$enableExternalFlashAeMode$4(r1, r2);
    }

    public static /* synthetic */ void f(FocusMeteringControl r0, long r1) {
        r0.lambda$executeMeteringAction$11(r1);
    }

    public static /* synthetic */ void g(FocusMeteringControl r0, CallbackToFutureAdapter.Completer r1, FocusMeteringAction r2, long r3) {
        r0.lambda$startFocusAndMetering$0(r1, r2, r3);
    }

    public static /* synthetic */ Object h(FocusMeteringControl r0, boolean r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$enableExternalFlashAeMode$5(r1, r2);
    }

    public static /* synthetic */ boolean i(FocusMeteringControl r0, int r1, long r2, TotalCaptureResult r4) {
        return r0.lambda$cancelFocusAndMeteringInternal$14(r1, r2, r4);
    }

    public static /* synthetic */ void j(FocusMeteringControl r0, long r1) {
        r0.lambda$executeMeteringAction$8(r1);
    }

    public static /* synthetic */ void k(FocusMeteringControl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$cancelFocusAndMetering$12(r1);
    }

    public static /* synthetic */ Object l(FocusMeteringControl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$cancelFocusAndMetering$13(r1);
    }

    public static /* synthetic */ void m(FocusMeteringControl r0, long r1) {
        r0.lambda$executeMeteringAction$10(r1);
    }

    public static /* synthetic */ void n(FocusMeteringControl r0, long r1) {
        r0.lambda$executeMeteringAction$9(r1);
    }

    public static /* synthetic */ Object o(FocusMeteringControl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$triggerAePrecapture$3(r1);
    }

    public void cancelFocusAndMeteringWithoutAsyncResult() {
        cancelFocusAndMeteringInternal(null);
    }

    private void clearAutoFocusTimeoutHandle() {
        ScheduledFuture<?> r0 = this.mAutoFocusTimeoutHandle;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mAutoFocusTimeoutHandle = null;
        return;
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> r0 = this.mRunningCancelCompleter;
        if (r0 == null) goto L6;
        r0.set(null);
        this.mRunningCancelCompleter = null;
        return;
    }

    private void disableAutoCancel() {
        ScheduledFuture<?> r0 = this.mAutoCancelHandle;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mAutoCancelHandle = null;
        return;
    }

    private Rational getDefaultAspectRatio() {
        if (this.mPreviewAspectRatio != null) goto L5;
        Rect r0 = this.mCameraControl.getCropSensorRegion();
        return new Rational(r0.width(), r0.height());
    L5:
        return this.mPreviewAspectRatio;
    }

    private boolean isAfModeSupported() {
        if (this.mCameraControl.getSupportedAfMode(1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean shouldTriggerAF() {
        if (this.mAfRects.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new r2(this));
    }

    public int getDefaultAfMode() {
        if (this.mTemplate == 3) goto L6;
        return 4;
    L6:
        return 3;
    }

    public ListenableFuture<Void> triggerAePrecapture() {
        return CallbackToFutureAdapter.getFuture(new n2(this));
    }

    public boolean isExternalFlashAeModeEnabled() {
        return this.mIsExternalFlashAeModeEnabled;
    }

    private void failActionFuture(String r3) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> r0 = this.mRunningActionCompleter;
        if (r0 == null) goto L6;
        r0.setException(new CameraControl.OperationCanceledException(r3));
        this.mRunningActionCompleter = null;
        return;
    }

    private void failCancelFuture(String r3) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> r0 = this.mRunningCancelCompleter;
        if (r0 == null) goto L6;
        r0.setException(new CameraControl.OperationCanceledException(r3));
        this.mRunningCancelCompleter = null;
        return;
    }

    private static boolean isValid(MeteringPoint r3) {
        if (r3.getX() >= MenuKt.ClosedAlphaTarget) goto L5;
    L11:
        return false;
    L5:
        if (r3.getX() > 1.0f) goto L11;
        if (r3.getY() < MenuKt.ClosedAlphaTarget) goto L11;
        if (r3.getY() > 1.0f) goto L11;
        return true;
    }

    private /* synthetic */ void lambda$cancelFocusAndMetering$12(CallbackToFutureAdapter.Completer r1) {
        cancelFocusAndMeteringInternal(r1);
    }

    private /* synthetic */ Object lambda$cancelFocusAndMetering$13(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new t2(this, r3));
        return "cancelFocusAndMetering";
    }

    private /* synthetic */ void lambda$executeMeteringAction$10(long r4) {
        if (r4 != this.mFocusTimeoutCounter) goto L6;
        cancelFocusAndMeteringWithoutAsyncResult();
        return;
    }

    private /* synthetic */ void lambda$executeMeteringAction$11(final long r3) {
        this.mExecutor.execute(new m2(this, r3));
    }

    private /* synthetic */ void lambda$executeMeteringAction$8(long r4) {
        if (r4 != this.mFocusTimeoutCounter) goto L6;
        this.mIsFocusSuccessful = false;
        completeActionFuture(false);
        return;
    }

    private /* synthetic */ void lambda$executeMeteringAction$9(final long r3) {
        this.mExecutor.execute(new l2(this, r3));
    }

    private /* synthetic */ void lambda$triggerAePrecapture$2(CallbackToFutureAdapter.Completer r1) {
        triggerAePrecapture(r1);
    }

    private /* synthetic */ Object lambda$triggerAePrecapture$3(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new s2(this, r3));
        return "triggerAePrecapture";
    }

    public void addFocusMeteringOptions(Camera2ImplConfig.Builder r4) {
        if (this.mIsInAfAutoMode == false) goto L5;
        int r0 = 1;
    L6:
        CaptureRequest.Key r1 = CaptureRequest.CONTROL_AF_MODE;
        Integer r2 = Integer.valueOf(this.mCameraControl.getSupportedAfMode(r0));
        Config.OptionPriority r3 = Config.OptionPriority.REQUIRED;
        r4.setCaptureRequestOptionWithPriority(r1, r2, r3);
        MeteringRectangle[] r5 = this.mAfRects;
        if (r5.length == 0) goto L9;
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AF_REGIONS, r5, r3);
    L9:
        MeteringRectangle[] r6 = this.mAeRects;
        if (r6.length == 0) goto L12;
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_REGIONS, r6, r3);
    L12:
        MeteringRectangle[] r7 = this.mAwbRects;
        if (r7.length == 0) goto L16;
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AWB_REGIONS, r7, r3);
        return;
    L16:
        return;
    L5:
        r0 = getDefaultAfMode();
        goto L6
    }

    public void cancelFocusAndMeteringInternal(CallbackToFutureAdapter.Completer<Void> r4) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = r4;
        disableAutoCancel();
        clearAutoFocusTimeoutHandle();
        if (shouldTriggerAF() == false) goto L5;
        cancelAfAeTrigger(true, false);
    L5:
        MeteringRectangle[] r5 = EMPTY_RECTANGLES;
        this.mAfRects = r5;
        this.mAeRects = r5;
        this.mAwbRects = r5;
        this.mIsInAfAutoMode = false;
        final long r0 = this.mCameraControl.updateSessionConfigSynchronous();
        if (this.mRunningCancelCompleter == null) goto L9;
        final int r6 = this.mCameraControl.getSupportedAfMode(getDefaultAfMode());
        Camera2CameraControlImpl.CaptureResultListener r2 = new k2(this, r6, r0);
        this.mSessionListenerForCancel = r2;
        this.mCameraControl.addCaptureResultListener(r2);
        return;
    }

    public void completeActionFuture(boolean r2) {
        clearAutoFocusTimeoutHandle();
        CallbackToFutureAdapter.Completer<FocusMeteringResult> r0 = this.mRunningActionCompleter;
        if (r0 == null) goto L6;
        r0.set(FocusMeteringResult.create(r2));
        this.mRunningActionCompleter = null;
        return;
    }

    public ListenableFuture<Void> enableExternalFlashAeMode(final boolean r4) {
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return Futures.immediateFuture(null);
    L7:
        if (this.mCameraControl.getSupportedAeMode(5) == 5) goto L11;
        return Futures.immediateFuture(null);
    L11:
        return CallbackToFutureAdapter.getFuture(new q2(this, r4));
    }

    public boolean isFocusMeteringSupported(FocusMeteringAction r11) {
        Rect r0 = this.mCameraControl.getCropSensorRegion();
        Rational r7 = getDefaultAspectRatio();
        List<MeteringRectangle> r8 = getMeteringRectangles(r11.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), r7, r0, 1);
        List<MeteringRectangle> r9 = getMeteringRectangles(r11.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), r7, r0, 2);
        List<MeteringRectangle> r12 = getMeteringRectangles(r11.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), r7, r0, 4);
        if (r8.isEmpty() == true) goto L5;
    L10:
        return true;
    L5:
        if (r9.isEmpty() == false) goto L10;
        if (r12.isEmpty() == false) goto L10;
        return false;
    }

    public void setActive(boolean r2) {
        if (r2 != this.mIsActive) goto L5;
        return;
    L5:
        this.mIsActive = r2;
        if (this.mIsActive == true) goto L9;
        cancelFocusAndMeteringWithoutAsyncResult();
        return;
    }

    public void setPreviewAspectRatio(Rational r1) {
        this.mPreviewAspectRatio = r1;
    }

    public void setTemplate(int r1) {
        this.mTemplate = r1;
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction r3) {
        return startFocusAndMetering(r3, AUTO_FOCUS_TIMEOUT_DURATION);
    }

    public void triggerAePrecapture(final CallbackToFutureAdapter.Completer<Void> r5) {
        Logger.d(TAG, "triggerAePrecapture");
        if (this.mIsActive == true) goto L7;
        if (r5 == null) goto L9;
        r5.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L9:
        return;
    L7:
        CaptureConfig.Builder r0 = new CaptureConfig.Builder();
        r0.setTemplateType(this.mTemplate);
        r0.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder r2 = new Camera2ImplConfig.Builder();
        r2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        r0.addImplementationOptions(r2.build());
        r0.addCameraCaptureCallback(new AnonymousClass2(this, r5));
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(r0.build()));
    }

    private void enableExternalFlashAeMode(final CallbackToFutureAdapter.Completer<Void> r4) {
        if (this.mIsActive == true) goto L7;
        if (r4 == null) goto L9;
        r4.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L9:
        return;
    L7:
        final long r0 = this.mCameraControl.updateSessionConfigSynchronous();
        Camera2CameraControlImpl.CaptureResultListener r2 = new u2(this, r0, r4);
        this.mSessionListenerForAeMode = r2;
        this.mCameraControl.addCaptureResultListener(r2);
    }

    private /* synthetic */ void lambda$enableExternalFlashAeMode$4(boolean r3, CallbackToFutureAdapter.Completer r4) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForAeMode);
        this.mIsExternalFlashAeModeEnabled = r3;
        enableExternalFlashAeMode(r4);
    }

    private /* synthetic */ Object lambda$enableExternalFlashAeMode$5(final boolean r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new g2(this, r3, r4));
        return "enableExternalFlashAeMode";
    }

    public void cancelAfAeTrigger(boolean r5, boolean r6) {
        if (this.mIsActive == true) goto L5;
        return;
    L5:
        CaptureConfig.Builder r0 = new CaptureConfig.Builder();
        r0.setUseRepeatingSurface(true);
        r0.setTemplateType(this.mTemplate);
        Camera2ImplConfig.Builder r1 = new Camera2ImplConfig.Builder();
        if (r5 == false) goto L9;
        r1.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (r6 == false) goto L12;
        r1.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
    L12:
        r0.addImplementationOptions(r1.build());
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(r0.build()));
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(final FocusMeteringAction r2, final long r3) {
        return CallbackToFutureAdapter.getFuture(new o2(this, r2, r3));
    }

    public void triggerAf(final CallbackToFutureAdapter.Completer<CameraCaptureResult> r6, boolean r7) {
        if (this.mIsActive == true) goto L7;
        if (r6 == null) goto L12;
        r6.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L12:
        return;
    L7:
        CaptureConfig.Builder r0 = new CaptureConfig.Builder();
        r0.setTemplateType(this.mTemplate);
        r0.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder r2 = new Camera2ImplConfig.Builder();
        r2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        if (r7 == false) goto L10;
        r2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.mCameraControl.getSupportedAeMode(1)), Config.OptionPriority.HIGH_PRIORITY_REQUIRED);
    L10:
        r0.addImplementationOptions(r2.build());
        r0.addCameraCaptureCallback(new AnonymousClass1(this, r6));
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(r0.build()));
    }

    private static MeteringRectangle getMeteringRect(MeteringPoint r5, PointF r6, Rect r7) {
        int r0 = (int) (r7.left + (r6.x * r7.width()));
        int r8 = (int) (r7.top + (r6.y * r7.height()));
        int r1 = ((int) (r5.getSize() * r7.width())) / 2;
        int r9 = ((int) (r5.getSize() * r7.height())) / 2;
        Rect r2 = new Rect(r0 - r1, r8 - r9, r0 + r1, r8 + r9);
        r2.left = rangeLimit(r2.left, r7.right, r7.left);
        r2.right = rangeLimit(r2.right, r7.right, r7.left);
        r2.top = rangeLimit(r2.top, r7.bottom, r7.top);
        r2.bottom = rangeLimit(r2.bottom, r7.bottom, r7.top);
        return new MeteringRectangle(r2, 1000);
    }

    private /* synthetic */ boolean lambda$cancelFocusAndMeteringInternal$14(int r2, long r3, TotalCaptureResult r5) {
        if (((Integer) r5.get(CaptureResult.CONTROL_AF_MODE)).intValue() == r2) goto L5;
        return false;
    L5:
        if (Camera2CameraControlImpl.isSessionUpdated(r5, r3) == false) goto L10;
        completeCancelFuture();
        return true;
    L10:
        return false;
    }

    private /* synthetic */ boolean lambda$enableExternalFlashAeMode$6(long r6, CallbackToFutureAdapter.Completer r8, TotalCaptureResult r9) {
        if (((Integer) r9.get(CaptureResult.CONTROL_AE_MODE)).intValue() != 5) goto L5;
        boolean r0 = true;
    L6:
        Logger.d(TAG, "enableExternalFlashAeMode: isAeModeExternalFlash = " + r0);
        if (r0 == this.mIsExternalFlashAeModeEnabled) goto L9;
    L14:
        return false;
    L9:
        if (Camera2CameraControlImpl.isSessionUpdated(r9, r6) == false) goto L14;
        Logger.d(TAG, "enableExternalFlashAeMode: session updated with isAeModeExternalFlash = " + r0);
        if (r8 == null) goto L13;
        r8.set(null);
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ boolean lambda$executeMeteringAction$7(boolean r5, long r6, TotalCaptureResult r8) {
        Integer r0 = (Integer) r8.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF() == false) goto L17;
        if (r5 == false) goto L15;
        if (r0 == null) goto L15;
        if (this.mCurrentAfState.intValue() != 3) goto L17;
        if (r0.intValue() != 4) goto L13;
        this.mIsFocusSuccessful = true;
        this.mIsAutoFocusCompleted = true;
        goto L17
    L13:
        if (r0.intValue() != 5) goto L17;
        this.mIsFocusSuccessful = false;
        this.mIsAutoFocusCompleted = true;
    L15:
        this.mIsFocusSuccessful = true;
        this.mIsAutoFocusCompleted = true;
    L17:
        if (this.mIsAutoFocusCompleted == false) goto L23;
        if (Camera2CameraControlImpl.isSessionUpdated(r8, r6) == false) goto L23;
        completeActionFuture(this.mIsFocusSuccessful);
        return true;
    L23:
        if (this.mCurrentAfState.equals(r0) == true) goto L26;
        if (r0 == null) goto L26;
        this.mCurrentAfState = r0;
    L26:
        return false;
    }

    private /* synthetic */ void lambda$startFocusAndMetering$0(CallbackToFutureAdapter.Completer r1, FocusMeteringAction r2, long r3) {
        startFocusAndMeteringInternal(r1, r2, r3);
    }

    private /* synthetic */ Object lambda$startFocusAndMetering$1(final FocusMeteringAction r9, final long r10, final CallbackToFutureAdapter.Completer r12) throws Exception {
        this.mExecutor.execute(new p2(this, r12, r9, r10));
        return "startFocusAndMetering";
    }

    private static int rangeLimit(int r0, int r1, int r2) {
        return Math.min(Math.max(r0, r2), r1);
    }

    public void startFocusAndMeteringInternal(CallbackToFutureAdapter.Completer<FocusMeteringResult> r11, FocusMeteringAction r12, long r13) {
        if (this.mIsActive == true) goto L6;
        r11.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L6:
        Rect r0 = this.mCameraControl.getCropSensorRegion();
        Rational r7 = getDefaultAspectRatio();
        List<MeteringRectangle> r8 = getMeteringRectangles(r12.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), r7, r0, 1);
        List<MeteringRectangle> r9 = getMeteringRectangles(r12.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), r7, r0, 2);
        List<MeteringRectangle> r1 = getMeteringRectangles(r12.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), r7, r0, 4);
        if (r8.isEmpty() == true) goto L9;
    L14:
        failActionFuture("Cancelled by another startFocusAndMetering()");
        failCancelFuture("Cancelled by another startFocusAndMetering()");
        disableAutoCancel();
        this.mRunningActionCompleter = r11;
        MeteringRectangle[] r14 = EMPTY_RECTANGLES;
        executeMeteringAction((MeteringRectangle[]) r8.toArray(r14), (MeteringRectangle[]) r9.toArray(r14), (MeteringRectangle[]) r1.toArray(r14), r12, r13);
        return;
    L9:
        if (r9.isEmpty() == false) goto L14;
        if (r1.isEmpty() == false) goto L14;
        r11.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
    }

    public FocusMeteringControl(Camera2CameraControlImpl r5, ScheduledExecutorService r6, Executor r7, Quirks r8) {
        this.mIsActive = false;
        this.mPreviewAspectRatio = null;
        this.mIsInAfAutoMode = false;
        this.mCurrentAfState = 0;
        this.mFocusTimeoutCounter = 0;
        this.mIsAutoFocusCompleted = false;
        this.mIsFocusSuccessful = false;
        this.mTemplate = 1;
        this.mSessionListenerForFocus = null;
        this.mSessionListenerForCancel = null;
        MeteringRectangle[] r2 = EMPTY_RECTANGLES;
        this.mAfRects = r2;
        this.mAeRects = r2;
        this.mAwbRects = r2;
        this.mRunningActionCompleter = null;
        this.mRunningCancelCompleter = null;
        this.mIsExternalFlashAeModeEnabled = false;
        this.mSessionListenerForAeMode = null;
        this.mCameraControl = r5;
        this.mExecutor = r7;
        this.mScheduler = r6;
        this.mMeteringRegionCorrection = new MeteringRegionCorrection(r8);
    }

    private void executeMeteringAction(MeteringRectangle[] r3, MeteringRectangle[] r4, MeteringRectangle[] r5, FocusMeteringAction r6, long r7) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        clearAutoFocusTimeoutHandle();
        this.mAfRects = r3;
        this.mAeRects = r4;
        this.mAwbRects = r5;
        if (shouldTriggerAF() == false) goto L5;
        this.mIsInAfAutoMode = true;
        this.mIsAutoFocusCompleted = false;
        this.mIsFocusSuccessful = false;
        final long r0 = this.mCameraControl.updateSessionConfigSynchronous();
        triggerAf(null, true);
    L6:
        this.mCurrentAfState = 0;
        final boolean r8 = isAfModeSupported();
        Camera2CameraControlImpl.CaptureResultListener r9 = new h2(this, r8, r0);
        this.mSessionListenerForFocus = r9;
        this.mCameraControl.addCaptureResultListener(r9);
        final long r10 = this.mFocusTimeoutCounter + 1;
        this.mFocusTimeoutCounter = r10;
        Runnable r11 = new i2(this, r10);
        ScheduledExecutorService r1 = this.mScheduler;
        TimeUnit r2 = TimeUnit.MILLISECONDS;
        this.mAutoFocusTimeoutHandle = r1.schedule(r11, r7, r2);
        if (r6.isAutoCancelEnabled() == false) goto L10;
        Runnable r12 = new j2(this, r10);
        this.mAutoCancelHandle = this.mScheduler.schedule(r12, r6.getAutoCancelDurationInMillis(), r2);
        return;
    L10:
        return;
    L5:
        this.mIsInAfAutoMode = false;
        this.mIsAutoFocusCompleted = true;
        this.mIsFocusSuccessful = false;
        r0 = this.mCameraControl.updateSessionConfigSynchronous();
        goto L6
    }

    private static PointF getFovAdjustedPoint(MeteringPoint r6, Rational r7, Rational r8, int r9, MeteringRegionCorrection r10) {
        if (r6.getSurfaceAspectRatio() == null) goto L5;
        r8 = r6.getSurfaceAspectRatio();
    L5:
        PointF r11 = r10.getCorrectedPoint(r6, r9);
        if (r8.equals(r7) == false) goto L8;
    L11:
        return r11;
    L8:
        if (r8.compareTo(r7) <= 0) goto L10;
        float r12 = (float) (r8.doubleValue() / r7.doubleValue());
        r11.y = (((float) ((((double) r12) - 1.0d) / 2.0d)) + r11.y) * (1.0f / r12);
        goto L11
    L10:
        float r13 = (float) (r7.doubleValue() / r8.doubleValue());
        r11.x = (((float) ((((double) r13) - 1.0d) / 2.0d)) + r11.x) * (1.0f / r13);
        goto L11
    }

    private List<MeteringRectangle> getMeteringRectangles(List<MeteringPoint> r5, int r6, Rational r7, Rect r8, int r9) {
        if (r5.isEmpty() == true) goto L24;
        if (r6 == 0) goto L24;
        ArrayList r0 = new ArrayList();
        Rational r1 = new Rational(r8.width(), r8.height());
        Iterator<MeteringPoint> r10 = r5.iterator();
    L8:
        if (r10.hasNext() == false) goto L22;
        MeteringPoint r2 = r10.next();
        if (r0.size() == r6) goto L22;
        if (isValid(r2) == false) goto L8;
        MeteringRectangle r3 = getMeteringRect(r2, getFovAdjustedPoint(r2, r1, r7, r9, this.mMeteringRegionCorrection), r8);
        if (r3.getWidth() == 0) goto L8;
        if (r3.getHeight() == 0) goto L8;
        r0.add(r3);
    L22:
        return Collections.unmodifiableList(r0);
    L24:
        return Collections.emptyList();
    }
}
