package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class TorchControl {
    static final int DEFAULT_TORCH_STATE = 0;
    private static final String TAG = "TorchControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;

    public static /* synthetic */ void a(TorchControl r0, CallbackToFutureAdapter.Completer r1, boolean r2) {
        r0.lambda$enableTorch$1(r1, r2);
    }

    public static /* synthetic */ boolean b(TorchControl r0, TotalCaptureResult r1) {
        return r0.lambda$new$0(r1);
    }

    public static /* synthetic */ Object c(TorchControl r0, boolean r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$enableTorch$2(r1, r2);
    }

    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    private /* synthetic */ boolean lambda$new$0(TotalCaptureResult r3) {
        if (this.mEnableTorchCompleter == null) goto L13;
        Integer r4 = (Integer) r3.getRequest().get(CaptureRequest.FLASH_MODE);
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L11:
        if (r5 != this.mTargetTorchEnabled) goto L13;
        this.mEnableTorchCompleter.set(null);
        this.mEnableTorchCompleter = null;
        goto L13
    L7:
        if (r4.intValue() != 2) goto L9;
        r5 = true;
    L13:
        return false;
    }

    public ListenableFuture<Void> enableTorch(final boolean r3) {
        if (this.mHasFlashUnit == true) goto L6;
        Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
        return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
    L6:
        setLiveDataValue(this.mTorchState, Integer.valueOf(r3 ? 1 : 0));
        return CallbackToFutureAdapter.getFuture(new l3(this, r3));
    }

    public void setActive(boolean r3) {
        if (this.mIsActive != r3) goto L5;
        return;
    L5:
        this.mIsActive = r3;
        if (r3 == false) goto L8;
        return;
    L8:
        if (this.mTargetTorchEnabled == false) goto L10;
        this.mTargetTorchEnabled = false;
        this.mCamera2CameraControlImpl.enableTorchInternal(false);
        setLiveDataValue(this.mTorchState, 0);
    L10:
        CallbackToFutureAdapter.Completer<Void> r4 = this.mEnableTorchCompleter;
        if (r4 == null) goto L15;
        r4.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        this.mEnableTorchCompleter = null;
        return;
    }

    private /* synthetic */ void lambda$enableTorch$1(CallbackToFutureAdapter.Completer r1, boolean r2) {
        enableTorchInternal(r1, r2);
    }

    private /* synthetic */ Object lambda$enableTorch$2(final boolean r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new k3(this, r4, r3));
        return "enableTorch: " + r3;
    }

    private <T> void setLiveDataValue(MutableLiveData<T> r2, T r3) {
        if (Threads.isMainThread() == false) goto L5;
        r2.setValue(r3);
        return;
    L5:
        r2.postValue(r3);
    }

    public void enableTorchInternal(CallbackToFutureAdapter.Completer<Void> r3, boolean r4) {
        if (this.mHasFlashUnit == true) goto L8;
        if (r3 == null) goto L18;
        r3.setException(new IllegalStateException("No flash unit"));
        return;
    L18:
        return;
    L8:
        if (this.mIsActive == true) goto L13;
        setLiveDataValue(this.mTorchState, 0);
        if (r3 == null) goto L19;
        r3.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L19:
        return;
    L13:
        this.mTargetTorchEnabled = r4;
        this.mCamera2CameraControlImpl.enableTorchInternal(r4);
        setLiveDataValue(this.mTorchState, Integer.valueOf(r4 ? 1 : 0));
        CallbackToFutureAdapter.Completer<Void> r5 = this.mEnableTorchCompleter;
        if (r5 == null) goto L16;
        r5.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
    L16:
        this.mEnableTorchCompleter = r3;
    }

    public TorchControl(Camera2CameraControlImpl r1, CameraCharacteristicsCompat r2, Executor r3) {
        this.mCamera2CameraControlImpl = r1;
        this.mExecutor = r3;
        Objects.requireNonNull(r2);
        this.mHasFlashUnit = FlashAvailabilityChecker.isFlashAvailable(new p0(r2));
        this.mTorchState = new MutableLiveData(0);
        r1.addCaptureResultListener(new m3(this));
    }
}
