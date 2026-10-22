package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class PreviewStreamStateObserver implements Observable.Observer<CameraInternal.State> {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    ListenableFuture<Void> mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow;
    private PreviewView.StreamState mPreviewStreamState;
    private final MutableLiveData<PreviewView.StreamState> mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    public static /* synthetic */ Void a(PreviewStreamStateObserver r0, Void r1) {
        return r0.lambda$startPreviewStreamStateFlow$1(r1);
    }

    public static /* synthetic */ Object b(PreviewStreamStateObserver r0, CameraInfo r1, List r2, CallbackToFutureAdapter.Completer r3) {
        return r0.lambda$waitForCaptureResult$2(r1, r2, r3);
    }

    public static /* synthetic */ ListenableFuture c(PreviewStreamStateObserver r0, Void r1) {
        return r0.lambda$startPreviewStreamStateFlow$0(r1);
    }

    private void cancelFlow() {
        ListenableFuture<Void> r0 = this.mFlowFuture;
        if (r0 == null) goto L6;
        r0.cancel(false);
        this.mFlowFuture = null;
        return;
    }

    public void clear() {
        cancelFlow();
    }

    private /* synthetic */ ListenableFuture lambda$startPreviewStreamStateFlow$0(Void r1) throws Exception {
        return this.mPreviewViewImplementation.waitForNextFrame();
    }

    private /* synthetic */ Void lambda$startPreviewStreamStateFlow$1(Void r1) {
        updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }

    private void startPreviewStreamStateFlow(final CameraInfo r5) {
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        final ArrayList r0 = new ArrayList();
        FutureChain r1 = FutureChain.from(waitForCaptureResult(r5, r0)).transformAsync(new l(this), CameraXExecutors.directExecutor()).transform(new m(this), CameraXExecutors.directExecutor());
        this.mFlowFuture = r1;
        Futures.addCallback(r1, new AnonymousClass1(this, r0, r5), CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    public void onError(Throwable r1) {
        clear();
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }

    /* JADX INFO: renamed from: onNewData, reason: avoid collision after fix types in other method */
    public void onNewData2(CameraInternal.State r2) {
        if (r2 != CameraInternal.State.CLOSING) goto L5;
    L20:
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        if (this.mHasStartedPreviewStreamFlow == false) goto L27;
        this.mHasStartedPreviewStreamFlow = false;
        cancelFlow();
        return;
    L27:
        return;
    L5:
        if (r2 == CameraInternal.State.CLOSED) goto L20;
        if (r2 == CameraInternal.State.RELEASING) goto L20;
        if (r2 == CameraInternal.State.RELEASED) goto L20;
        if (r2 == CameraInternal.State.OPENING) goto L18;
        if (r2 == CameraInternal.State.OPEN) goto L18;
        if (r2 == CameraInternal.State.PENDING_OPEN) goto L18;
        return;
    L18:
        if (this.mHasStartedPreviewStreamFlow == true) goto L25;
        startPreviewStreamStateFlow(this.mCameraInfoInternal);
        this.mHasStartedPreviewStreamFlow = true;
        return;
    }

    public void updatePreviewStreamState(PreviewView.StreamState r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mPreviewStreamState.equals(r4) == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.mPreviewStreamState = r4;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        Logger.d(TAG, "Update Preview stream state to " + r4);
        this.mPreviewStreamStateLiveData.postValue(r4);
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    public /* bridge */ /* synthetic */ void onNewData(CameraInternal.State r1) {
        onNewData2(r1);
    }

    private ListenableFuture<Void> waitForCaptureResult(final CameraInfo r2, final List<CameraCaptureCallback> r3) {
        return CallbackToFutureAdapter.getFuture(new n(this, r2, r3));
    }

    public PreviewStreamStateObserver(CameraInfoInternal r2, MutableLiveData<PreviewView.StreamState> r3, PreviewViewImplementation r4) {
        this.mHasStartedPreviewStreamFlow = false;
        this.mCameraInfoInternal = r2;
        this.mPreviewStreamStateLiveData = r3;
        this.mPreviewViewImplementation = r4;
        monitor-enter(this);
        this.mPreviewStreamState = (PreviewView.StreamState) r3.getValue();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Object lambda$waitForCaptureResult$2(final CameraInfo r2, List r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        CameraCaptureCallback r0 = new AnonymousClass2(this, r4, r2);
        r3.add(r0);
        ((CameraInfoInternal) r2).addSessionCaptureCallback(CameraXExecutors.directExecutor(), r0);
        return "waitForCaptureResult";
    }
}
