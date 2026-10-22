package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {
    private final List<SynchronizedCaptureSession.StateCallback> mCallbacks;

    public static class Adapter extends SynchronizedCaptureSession.StateCallback {
        private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(SynchronizedCaptureSession r1) {
        }

        public Adapter(List<CameraCaptureSession.StateCallback> r1) {
            this(CameraCaptureSessionStateCallbacks.createComboCallback(r1));
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onActive(SynchronizedCaptureSession r2) {
            this.mCameraCaptureSessionStateCallback.onActive(r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onCaptureQueueEmpty(SynchronizedCaptureSession r2) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mCameraCaptureSessionStateCallback, r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onClosed(SynchronizedCaptureSession r2) {
            this.mCameraCaptureSessionStateCallback.onClosed(r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(SynchronizedCaptureSession r2) {
            this.mCameraCaptureSessionStateCallback.onConfigureFailed(r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(SynchronizedCaptureSession r2) {
            this.mCameraCaptureSessionStateCallback.onConfigured(r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(SynchronizedCaptureSession r2) {
            this.mCameraCaptureSessionStateCallback.onReady(r2.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public Adapter(CameraCaptureSession.StateCallback r1) {
            this.mCameraCaptureSessionStateCallback = r1;
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSurfacePrepared(SynchronizedCaptureSession r2, Surface r3) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mCameraCaptureSessionStateCallback, r2.toCameraCaptureSessionCompat().toCameraCaptureSession(), r3);
        }
    }

    public SynchronizedCaptureSessionStateCallbacks(List<SynchronizedCaptureSession.StateCallback> r2) {
        ArrayList r0 = new ArrayList();
        this.mCallbacks = r0;
        r0.addAll(r2);
    }

    public static SynchronizedCaptureSession.StateCallback createComboCallback(SynchronizedCaptureSession.StateCallback... r1) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(r1));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onActive(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onActive(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onCaptureQueueEmpty(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureQueueEmpty(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onClosed(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigureFailed(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onConfigureFailed(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onConfigured(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onReady(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReady(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSessionFinished(SynchronizedCaptureSession r3) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onSessionFinished(r3);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSurfacePrepared(SynchronizedCaptureSession r3, Surface r4) {
        Iterator<SynchronizedCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onSurfacePrepared(r3, r4);
        goto L4
    }
}
