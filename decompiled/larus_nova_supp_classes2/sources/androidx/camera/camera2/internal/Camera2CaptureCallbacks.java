package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CaptureCallbacks {

    public static final class ComboSessionCaptureCallback extends CameraCaptureSession.CaptureCallback {
        private final List<CameraCaptureSession.CaptureCallback> mCallbacks;

        public ComboSessionCaptureCallback(List<CameraCaptureSession.CaptureCallback> r3) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureSession.CaptureCallback> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            CameraCaptureSession.CaptureCallback r0 = r4.next();
            if ((r0 instanceof NoOpSessionCaptureCallback) == true) goto L4;
            this.mCallbacks.add(r0);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r3, int r4) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureSequenceAborted(r3, r4);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r3, CaptureRequest r4, TotalCaptureResult r5) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureCompleted(r3, r4, r5);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r3, CaptureRequest r4, CaptureFailure r5) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureFailed(r3, r4, r5);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession r3, CaptureRequest r4, CaptureResult r5) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureProgressed(r3, r4, r5);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r3, int r4, long r5) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureSequenceCompleted(r3, r4, r5);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession r9, CaptureRequest r10, Surface r11, long r12) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ApiCompat.Api24Impl.onCaptureBufferLost(r0.next(), r9, r10, r11, r12);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r10, CaptureRequest r11, long r12, long r14) {
            Iterator<CameraCaptureSession.CaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureStarted(r10, r11, r12, r14);
            goto L4
        }
    }

    public static final class NoOpSessionCaptureCallback extends CameraCaptureSession.CaptureCallback {
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession r1, CaptureRequest r2, Surface r3, long r4) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r1, CaptureRequest r2, TotalCaptureResult r3) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r1, CaptureRequest r2, CaptureFailure r3) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession r1, CaptureRequest r2, CaptureResult r3) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r1, int r2) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r1, int r2, long r3) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r1, CaptureRequest r2, long r3, long r5) {
        }

        public NoOpSessionCaptureCallback() {
        }
    }

    public static CameraCaptureSession.CaptureCallback createNoOpCallback() {
        return new NoOpSessionCaptureCallback();
    }

    private Camera2CaptureCallbacks() {
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(CameraCaptureSession.CaptureCallback... r0) {
        return createComboCallback(Arrays.asList(r0));
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(List<CameraCaptureSession.CaptureCallback> r1) {
        return new ComboSessionCaptureCallback(r1);
    }
}
