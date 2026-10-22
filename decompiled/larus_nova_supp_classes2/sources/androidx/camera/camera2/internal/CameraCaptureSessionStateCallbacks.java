package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraCaptureSessionStateCallbacks {

    public static final class ComboSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final List<CameraCaptureSession.StateCallback> mCallbacks;

        public ComboSessionStateCallback(List<CameraCaptureSession.StateCallback> r3) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureSession.StateCallback> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            CameraCaptureSession.StateCallback r0 = r4.next();
            if ((r0 instanceof NoOpSessionStateCallback) == true) goto L4;
            this.mCallbacks.add(r0);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onActive(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ApiCompat.Api26Impl.onCaptureQueueEmpty(r0.next(), r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onClosed(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onConfigureFailed(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onConfigured(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession r3) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onReady(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession r3, Surface r4) {
            Iterator<CameraCaptureSession.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ApiCompat.Api23Impl.onSurfacePrepared(r0.next(), r3, r4);
            goto L4
        }
    }

    public static final class NoOpSessionStateCallback extends CameraCaptureSession.StateCallback {
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession r1) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession r1, Surface r2) {
        }

        public NoOpSessionStateCallback() {
        }
    }

    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        return new NoOpSessionStateCallback();
    }

    private CameraCaptureSessionStateCallbacks() {
    }

    public static CameraCaptureSession.StateCallback createComboCallback(List<CameraCaptureSession.StateCallback> r2) {
        if (r2.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r2.size() != 1) goto L11;
        return (CameraCaptureSession.StateCallback) ListProtector.get(r2, 0);
    L11:
        return new ComboSessionStateCallback(r2);
    }

    public static CameraCaptureSession.StateCallback createComboCallback(CameraCaptureSession.StateCallback... r0) {
        return createComboCallback(Arrays.asList(r0));
    }
}
