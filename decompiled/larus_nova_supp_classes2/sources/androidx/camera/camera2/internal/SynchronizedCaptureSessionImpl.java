package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.camera2.internal.compat.workaround.SessionResetPolicy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.compose.foundation.BasicTooltipDefaults;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final ForceCloseDeferrableSurface mCloseSurfaceQuirk;
    private final AtomicBoolean mClosed;
    private List<DeferrableSurface> mDeferrableSurfaces;
    private final ForceCloseCaptureSession mForceCloseSessionQuirk;
    private final Object mObjectLock;
    ListenableFuture<List<Void>> mOpenSessionBlockerFuture;
    private final RequestMonitor mRequestMonitor;
    private final ScheduledExecutorService mScheduledExecutorService;
    private final SessionResetPolicy mSessionResetPolicy;

    public static /* synthetic */ void f(SynchronizedCaptureSessionImpl r0, SynchronizedCaptureSession r1) {
        r0.lambda$onConfigured$1(r1);
    }

    public static /* synthetic */ ListenableFuture g(SynchronizedCaptureSessionImpl r0, CameraDevice r1, SessionConfigurationCompat r2, List r3, List r4) {
        return r0.lambda$openCaptureSession$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ void h(SynchronizedCaptureSessionImpl r0) {
        r0.lambda$close$2();
    }

    private void closeCreatedSession() {
        Iterator<SynchronizedCaptureSession> r0 = this.mCaptureSessionRepository.getCaptureSessions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().close();
        goto L4
    }

    private /* synthetic */ void lambda$close$2() {
        debugLog("Session call super.close()");
        super.close();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        if (this.mClosed.compareAndSet(false, true) == true) goto L7;
        debugLog("close() has been called. Skip this invocation.");
        return;
    L7:
        if (this.mSessionResetPolicy.needAbortCapture() == true) goto L14;
    L12:
        debugLog("Session call close()");
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new h3(this), getExecutor());
        return;
    L14:
        debugLog("Call abortCaptures() before closing session.");     // Catch: Exception -> L10
        abortCaptures();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        debugLog("Exception when calling abortCaptures()" + e);
        goto L12
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public ListenableFuture<Void> getOpeningBlocker() {
        return Futures.makeTimeoutFuture(BasicTooltipDefaults.TooltipDuration, this.mScheduledExecutorService, this.mRequestMonitor.getRequestsProcessedFuture());
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public boolean stop() {
        Object r0 = this.mObjectLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isCameraCaptureSessionOpen() == false) goto L7;
        this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);     // Catch: Throwable -> L13
    L10:
        boolean r1 = super.stop();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L7:
        ListenableFuture<List<Void>> r2 = this.mOpenSessionBlockerFuture;     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        r2.cancel(true);     // Catch: Throwable -> L13
        goto L10
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void finishClose() {
        super.finishClose();
        this.mRequestMonitor.stop();
    }

    private /* synthetic */ void lambda$onConfigured$1(SynchronizedCaptureSession r1) {
        super.onConfigured(r1);
    }

    public void debugLog(String r3) {
        Logger.d(TAG, "[" + this + "] " + r3);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void onCameraDeviceError(int r3) {
        super.onCameraDeviceError(r3);
        if (r3 != 5) goto L19;
        Object r4 = this.mObjectLock;
        monitor-enter(r4);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (isCameraCaptureSessionOpen() == true) goto L9;
    L14:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return;
    L9:
        if (this.mDeferrableSurfaces == null) goto L14;
        debugLog("Close DeferrableSurfaces for CameraDevice error.");     // Catch: Throwable -> L16
        Iterator<DeferrableSurface> r0 = this.mDeferrableSurfaces.iterator();     // Catch: Throwable -> L16
    L12:
        if (r0.hasNext() == false) goto L14;
        r0.next().close();     // Catch: Throwable -> L16
        goto L12
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(SynchronizedCaptureSession r4) {
        Object r0 = this.mObjectLock;
        monitor-enter(r0);
        this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        debugLog("onClosed()");
        super.onClosed(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession r5) {
        debugLog("Session onConfigured()");
        this.mForceCloseSessionQuirk.onSessionConfigured(r5, this.mCaptureSessionRepository.getCreatingCaptureSessions(), this.mCaptureSessionRepository.getCaptureSessions(), new j3(this));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(List<CaptureRequest> r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException {
        return super.captureBurstRequests(r2, this.mRequestMonitor.createMonitorListener(r3));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(CaptureRequest r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException {
        return super.setSingleRepeatingRequest(r2, this.mRequestMonitor.createMonitorListener(r3));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public ListenableFuture<List<Surface>> startWithDeferrableSurface(List<DeferrableSurface> r2, long r3) {
        Object r0 = this.mObjectLock;
        monitor-enter(r0);
        this.mDeferrableSurfaces = r2;     // Catch: Throwable -> L7
        ListenableFuture<List<Surface>> r4 = super.startWithDeferrableSurface(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public ListenableFuture<Void> openCaptureSession(final CameraDevice r5, final SessionConfigurationCompat r6, final List<DeferrableSurface> r7) {
        Object r0 = this.mObjectLock;
        monitor-enter(r0);
        List<SynchronizedCaptureSession> r1 = this.mCaptureSessionRepository.getCaptureSessions();     // Catch: Throwable -> L11
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L11
        Iterator<SynchronizedCaptureSession> r3 = r1.iterator();     // Catch: Throwable -> L11
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(r3.next().getOpeningBlocker());     // Catch: Throwable -> L11
        goto L6
    L8:
        ListenableFuture<List<Void>> r4 = Futures.successfulAsList(r2);     // Catch: Throwable -> L11
        this.mOpenSessionBlockerFuture = r4;     // Catch: Throwable -> L11
        ListenableFuture<Void> r8 = Futures.nonCancellationPropagating(FutureChain.from(r4).transformAsync(new i3(this, r5, r6, r7), getExecutor()));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r8;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ ListenableFuture lambda$openCaptureSession$0(CameraDevice r1, SessionConfigurationCompat r2, List r3, List r4) throws Exception {
        if (this.mSessionResetPolicy.needAbortCapture() == false) goto L5;
        closeCreatedSession();
    L5:
        debugLog("start openCaptureSession");
        return super.openCaptureSession(r1, r2, r3);
    }

    public SynchronizedCaptureSessionImpl(Quirks r1, Quirks r2, CaptureSessionRepository r3, Executor r4, ScheduledExecutorService r5, Handler r6) {
        super(r3, r4, r5, r6);
        this.mObjectLock = new Object();
        boolean r7 = false;
        this.mClosed = new AtomicBoolean(false);
        this.mCloseSurfaceQuirk = new ForceCloseDeferrableSurface(r1, r2);
        if (r1.contains(CaptureSessionStuckQuirk.class) == false) goto L5;
    L6:
        r7 = true;
    L7:
        this.mRequestMonitor = new RequestMonitor(r7);
        this.mForceCloseSessionQuirk = new ForceCloseCaptureSession(r2);
        this.mSessionResetPolicy = new SessionResetPolicy(r2);
        this.mScheduledExecutorService = r5;
        return;
    L5:
        if (r1.contains(IncorrectCaptureStateQuirk.class) == false) goto L7;
        goto L6
    }
}
