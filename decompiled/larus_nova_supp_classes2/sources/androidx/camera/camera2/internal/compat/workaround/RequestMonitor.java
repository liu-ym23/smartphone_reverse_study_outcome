package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class RequestMonitor {
    private static final String TAG = "RequestMonitor";
    private final boolean mQuirkEnabled;
    private final List<ListenableFuture<Void>> mRequestTasks;

    public static class RequestCompleteListener extends CameraCaptureSession.CaptureCallback {
        CallbackToFutureAdapter.Completer<Void> mStartRequestCompleter;
        final ListenableFuture<Void> mStartRequestFuture;

        public static /* synthetic */ Object a(RequestCompleteListener r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$new$0(r1);
        }

        private void completeFuture() {
            CallbackToFutureAdapter.Completer<Void> r0 = this.mStartRequestCompleter;
            if (r0 == null) goto L6;
            r0.set(null);
            this.mStartRequestCompleter = null;
            return;
        }

        public RequestCompleteListener() {
            this.mStartRequestFuture = CallbackToFutureAdapter.getFuture(new c(this));
        }

        private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r2) throws Exception {
            this.mStartRequestCompleter = r2;
            return "RequestCompleteListener[" + this + "]";
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r1, int r2) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r1, CaptureRequest r2, TotalCaptureResult r3) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r1, CaptureRequest r2, CaptureFailure r3) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r1, int r2, long r3) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r1, CaptureRequest r2, long r3, long r5) {
            completeFuture();
        }
    }

    public static /* synthetic */ Void a(List r0) {
        return lambda$getRequestsProcessedFuture$0(r0);
    }

    public static /* synthetic */ void b(RequestMonitor r0, RequestCompleteListener r1, ListenableFuture r2) {
        r0.lambda$createMonitorListener$1(r1, r2);
    }

    private static /* synthetic */ Void lambda$getRequestsProcessedFuture$0(List r0) {
        return null;
    }

    private CameraCaptureSession.CaptureCallback createMonitorListener() {
        final RequestCompleteListener r0 = new RequestCompleteListener();
        final ListenableFuture<Void> r1 = r0.mStartRequestFuture;
        this.mRequestTasks.add(r1);
        toString();
        r1.addListener(new a(this, r0, r1), CameraXExecutors.directExecutor());
        return r0;
    }

    public ListenableFuture<Void> getRequestsProcessedFuture() {
        if (this.mRequestTasks.isEmpty() == false) goto L7;
        return Futures.immediateFuture(null);
    L7:
        return Futures.nonCancellationPropagating(Futures.transform(Futures.successfulAsList(new ArrayList(this.mRequestTasks)), new b(), CameraXExecutors.directExecutor()));
    }

    public void stop() {
        LinkedList r0 = new LinkedList(this.mRequestTasks);
    L4:
        if (r0.isEmpty() == true) goto L6;
        ListenableFuture r1 = (ListenableFuture) r0.poll();
        Objects.requireNonNull(r1);
        r1.cancel(true);
        goto L4
    }

    public boolean shouldMonitorRequest() {
        return this.mQuirkEnabled;
    }

    public RequestMonitor(boolean r2) {
        this.mRequestTasks = Collections.synchronizedList(new ArrayList());
        this.mQuirkEnabled = r2;
    }

    public CameraCaptureSession.CaptureCallback createMonitorListener(CameraCaptureSession.CaptureCallback r4) {
        if (shouldMonitorRequest() == true) goto L5;
        return r4;
    L5:
        return Camera2CaptureCallbacks.createComboCallback(new CameraCaptureSession.CaptureCallback[]{createMonitorListener(), r4});
    }

    private /* synthetic */ void lambda$createMonitorListener$1(RequestCompleteListener r2, ListenableFuture r3) {
        Objects.toString(r2);
        toString();
        this.mRequestTasks.remove(r3);
    }
}
