package androidx.camera.core.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraCaptureCallbacks {

    public static final class ComboCameraCaptureCallback extends CameraCaptureCallback {
        private final List<CameraCaptureCallback> mCallbacks;

        public List<CameraCaptureCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public ComboCameraCaptureCallback(List<CameraCaptureCallback> r3) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureCallback> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            CameraCaptureCallback r0 = r4.next();
            if ((r0 instanceof NoOpCameraCaptureCallback) == true) goto L4;
            this.mCallbacks.add(r0);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled(int r3) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureCancelled(r3);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r3) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureStarted(r3);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int r3, CameraCaptureResult r4) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureCompleted(r3, r4);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(int r3, CameraCaptureFailure r4) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureFailed(r3, r4);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureProcessProgressed(int r3, int r4) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureProcessProgressed(r3, r4);
            goto L4
        }
    }

    public static final class NoOpCameraCaptureCallback extends CameraCaptureCallback {
        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int r1, CameraCaptureResult r2) {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(int r1, CameraCaptureFailure r2) {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r1) {
        }

        public NoOpCameraCaptureCallback() {
        }
    }

    public static CameraCaptureCallback createNoOpCallback() {
        return new NoOpCameraCaptureCallback();
    }

    private CameraCaptureCallbacks() {
    }

    public static CameraCaptureCallback createComboCallback(List<CameraCaptureCallback> r2) {
        if (r2.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r2.size() != 1) goto L11;
        return (CameraCaptureCallback) ListProtector.get(r2, 0);
    L11:
        return new ComboCameraCaptureCallback(r2);
    }

    public static CameraCaptureCallback createComboCallback(CameraCaptureCallback... r0) {
        return createComboCallback(Arrays.asList(r0));
    }
}
