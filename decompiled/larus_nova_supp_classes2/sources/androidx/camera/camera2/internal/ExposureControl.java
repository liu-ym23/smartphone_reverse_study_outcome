package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExposureState;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExposureControl {
    private static final int DEFAULT_EXPOSURE_COMPENSATION = 0;
    private final Camera2CameraControlImpl mCameraControl;
    private final Executor mExecutor;
    private final ExposureStateImpl mExposureStateImpl;
    private boolean mIsActive;
    private Camera2CameraControlImpl.CaptureResultListener mRunningCaptureResultListener;
    private CallbackToFutureAdapter.Completer<Integer> mRunningCompleter;

    public static /* synthetic */ Object a(ExposureControl r0, int r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$setExposureCompensationIndex$2(r1, r2);
    }

    public static /* synthetic */ void b(ExposureControl r0, CallbackToFutureAdapter.Completer r1, int r2) {
        r0.lambda$setExposureCompensationIndex$1(r1, r2);
    }

    public static /* synthetic */ boolean c(int r0, CallbackToFutureAdapter.Completer r1, TotalCaptureResult r2) {
        return lambda$setExposureCompensationIndex$0(r0, r1, r2);
    }

    private void clearRunningTask() {
        CallbackToFutureAdapter.Completer<Integer> r0 = this.mRunningCompleter;
        if (r0 == null) goto L5;
        r0.setException(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
        this.mRunningCompleter = null;
    L5:
        Camera2CameraControlImpl.CaptureResultListener r1 = this.mRunningCaptureResultListener;
        if (r1 == null) goto L9;
        this.mCameraControl.removeCaptureResultListener(r1);
        this.mRunningCaptureResultListener = null;
        return;
    }

    public ExposureState getExposureState() {
        return this.mExposureStateImpl;
    }

    public static ExposureState getDefaultExposureState(CameraCharacteristicsCompat r2) {
        return new ExposureStateImpl(r2, 0);
    }

    public void setActive(boolean r2) {
        if (r2 != this.mIsActive) goto L5;
        return;
    L5:
        this.mIsActive = r2;
        if (r2 == true) goto L9;
        this.mExposureStateImpl.setExposureCompensationIndex(0);
        clearRunningTask();
        return;
    }

    public void setCaptureRequestOption(Camera2ImplConfig.Builder r4) {
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureStateImpl.getExposureCompensationIndex()), Config.OptionPriority.REQUIRED);
    }

    public ListenableFuture<Integer> setExposureCompensationIndex(final int r5) {
        if (this.mExposureStateImpl.isExposureCompensationSupported() == false) goto L5;
        Range<Integer> r0 = this.mExposureStateImpl.getExposureCompensationRange();
        if (r0.contains(Integer.valueOf(r5)) == false) goto L9;
        this.mExposureStateImpl.setExposureCompensationIndex(r5);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new e2(this, r5)));
    L9:
        return Futures.immediateFailedFuture(new IllegalArgumentException("Requested ExposureCompensation " + r5 + " is not within valid range [" + r0.getUpper() + ".." + r0.getLower() + "]"));
    L5:
        return Futures.immediateFailedFuture(new IllegalArgumentException("ExposureCompensation is not supported"));
    }

    private /* synthetic */ void lambda$setExposureCompensationIndex$1(final CallbackToFutureAdapter.Completer r5, final int r6) {
        boolean r1 = false;
        if (this.mIsActive == true) goto L6;
        this.mExposureStateImpl.setExposureCompensationIndex(0);
        r5.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L6:
        clearRunningTask();
        if (this.mRunningCompleter != null) goto L9;
        boolean r0 = true;
    L10:
        Preconditions.checkState(r0, "mRunningCompleter should be null when starting set a new exposure compensation value");
        if (this.mRunningCaptureResultListener != null) goto L13;
        r1 = true;
    L13:
        Preconditions.checkState(r1, "mRunningCaptureResultListener should be null when starting set a new exposure compensation value");
        Camera2CameraControlImpl.CaptureResultListener r2 = new f2(r6, r5);
        this.mRunningCaptureResultListener = r2;
        this.mRunningCompleter = r5;
        this.mCameraControl.addCaptureResultListener(r2);
        this.mCameraControl.updateSessionConfigSynchronous();
        return;
    L9:
        r0 = false;
        goto L10
    }

    private /* synthetic */ Object lambda$setExposureCompensationIndex$2(final int r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new d2(this, r4, r3));
        return "setExposureCompensationIndex[" + r3 + "]";
    }

    public ExposureControl(Camera2CameraControlImpl r2, CameraCharacteristicsCompat r3, Executor r4) {
        this.mIsActive = false;
        this.mCameraControl = r2;
        this.mExposureStateImpl = new ExposureStateImpl(r3, 0);
        this.mExecutor = r4;
    }

    private static /* synthetic */ boolean lambda$setExposureCompensationIndex$0(int r3, CallbackToFutureAdapter.Completer r4, TotalCaptureResult r5) {
        Integer r0 = (Integer) r5.get(CaptureResult.CONTROL_AE_STATE);
        Integer r6 = (Integer) r5.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (r0 == null) goto L16;
        if (r6 == null) goto L16;
        int r1 = r0.intValue();
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L13;
        return false;
    L13:
        if (r6.intValue() != r3) goto L21;
        r4.set(Integer.valueOf(r3));
        return true;
    L21:
        return false;
    L16:
        if (r6 != null) goto L18;
        return false;
    L18:
        if (r6.intValue() != r3) goto L24;
        r4.set(Integer.valueOf(r3));
        return true;
    L24:
        return false;
    }
}
