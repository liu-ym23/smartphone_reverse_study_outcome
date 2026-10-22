package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CaptureSessionRepository {
    private final CameraDevice.StateCallback mCameraStateCallback;
    final Set<SynchronizedCaptureSession> mCaptureSessions;
    final Set<SynchronizedCaptureSession> mClosingCaptureSession;
    final Set<SynchronizedCaptureSession> mCreatingCaptureSessions;
    final Executor mExecutor;
    final Object mLock;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1, reason: invalid class name */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        final /* synthetic */ CaptureSessionRepository this$0;

        public static /* synthetic */ void a(LinkedHashSet r0, int r1) {
            lambda$dispatchOnError$1(r0, r1);
        }

        public static /* synthetic */ void b(LinkedHashSet r0) {
            lambda$forceOnClosedCaptureSessions$0(r0);
        }

        private void cameraClosed() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            List<SynchronizedCaptureSession> r1 = this.this$0.getSessionsInOrder();     // Catch: Throwable -> L11
            this.this$0.mCreatingCaptureSessions.clear();     // Catch: Throwable -> L11
            this.this$0.mCaptureSessions.clear();     // Catch: Throwable -> L11
            this.this$0.mClosingCaptureSession.clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            Iterator<SynchronizedCaptureSession> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            r2.next().finishClose();
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void forceOnClosedCaptureSessions() {
            final LinkedHashSet r0 = new LinkedHashSet();
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            r0.addAll(this.this$0.mCreatingCaptureSessions);     // Catch: Throwable -> L8
            r0.addAll(this.this$0.mCaptureSessions);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            this.this$0.mExecutor.execute(new c2(r0));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public AnonymousClass1(CaptureSessionRepository r1) {
            this.this$0 = r1;
        }

        private void dispatchOnError(final int r4) {
            final LinkedHashSet r0 = new LinkedHashSet();
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            r0.addAll(this.this$0.mCreatingCaptureSessions);     // Catch: Throwable -> L8
            r0.addAll(this.this$0.mCaptureSessions);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            this.this$0.mExecutor.execute(new b2(r0, r4));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$forceOnClosedCaptureSessions$0(LinkedHashSet r0) {
            CaptureSessionRepository.forceOnClosed(r0);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r1) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r1) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r19) {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19};
            f06.b r10 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(100200);
            if (r3 == null) goto L5;
            f06.a[] r4 = r3.i;
        L6:
            f06.a[] r14 = r4;
            int r15 = r14.length;
            int r9 = 0;
        L8:
            if (r9 >= r15) goto L22;
            f06.a r8 = r14[r9];
            int r17 = r9;
            if (r8.preInvoke(100200, "androidx/camera/camera2/internal/CaptureSessionRepository$1", "onOpened", this, r1, "void", r10).a == true) goto L15;
            r0.add(r8);     // Catch: Exception -> L16
            goto L14
        L15:
            return;
        L14:
            r9 = r17 + 1;
            goto L8
        L22:
            return;
        L5:
            r4 = ApiHookConfig.d;
            goto L6
        }

        private static /* synthetic */ void lambda$dispatchOnError$1(LinkedHashSet r1, int r2) {
            Iterator r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((SynchronizedCaptureSession) r3.next()).onCameraDeviceError(r2);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r1, int r2) {
            forceOnClosedCaptureSessions();
            dispatchOnError(r2);
            cameraClosed();
        }
    }

    public List<SynchronizedCaptureSession> getCaptureSessions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mCaptureSessions);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getClosingCaptureSession() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mClosingCaptureSession);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getCreatingCaptureSessions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mCreatingCaptureSessions);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getSessionsInOrder() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L7
        r1.addAll(getCaptureSessions());     // Catch: Throwable -> L7
        r1.addAll(getCreatingCaptureSessions());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    public CaptureSessionRepository(Executor r2) {
        this.mLock = new Object();
        this.mCaptureSessions = new LinkedHashSet();
        this.mClosingCaptureSession = new LinkedHashSet();
        this.mCreatingCaptureSessions = new LinkedHashSet();
        this.mCameraStateCallback = new AnonymousClass1(this);
        this.mExecutor = r2;
    }

    private void forceFinishCloseStaleSessions(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession> r0 = getSessionsInOrder().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        SynchronizedCaptureSession r1 = r0.next();
        if (r1 == r3) goto L12;
        r1.finishClose();
        goto L4
    L12:
        return;
    }

    public static void forceOnClosed(Set<SynchronizedCaptureSession> r2) {
        Iterator<SynchronizedCaptureSession> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        SynchronizedCaptureSession r0 = r3.next();
        r0.getStateCallback().onClosed(r0);
        goto L4
    }

    public void onCaptureSessionClosed(SynchronizedCaptureSession r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCaptureSessions.remove(r3);     // Catch: Throwable -> L7
        this.mClosingCaptureSession.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionClosing(SynchronizedCaptureSession r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClosingCaptureSession.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionConfigureFail(SynchronizedCaptureSession r3) {
        forceFinishCloseStaleSessions(r3);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCreatingCaptureSessions.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionCreated(SynchronizedCaptureSession r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCaptureSessions.add(r3);     // Catch: Throwable -> L8
        this.mCreatingCaptureSessions.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        forceFinishCloseStaleSessions(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onCreateCaptureSession(SynchronizedCaptureSession r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCreatingCaptureSessions.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
