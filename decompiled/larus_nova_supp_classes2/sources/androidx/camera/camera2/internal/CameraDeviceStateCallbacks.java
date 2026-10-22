package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraDeviceStateCallbacks {

    public static final class ComboDeviceStateCallback extends CameraDevice.StateCallback {
        private final List<CameraDevice.StateCallback> mCallbacks;

        public ComboDeviceStateCallback(List<CameraDevice.StateCallback> r3) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraDevice.StateCallback> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            CameraDevice.StateCallback r0 = r4.next();
            if ((r0 instanceof NoOpDeviceStateCallback) == true) goto L4;
            this.mCallbacks.add(r0);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r3) {
            Iterator<CameraDevice.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onClosed(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r3) {
            Iterator<CameraDevice.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onDisconnected(r3);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r20) {
            ArrayList r1 = new ArrayList();
            Object[] r2 = {r20};
            f06.b r12 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(100200);
            if (r3 == null) goto L5;
            f06.a[] r4 = r3.i;
        L6:
            f06.a[] r10 = r4;
            int r9 = r10.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r10[r8];
            int r16 = r8;
            int r17 = r9;
            f06.a[] r18 = r10;
            f06.d r5 = r7.preInvoke(100200, "androidx/camera/camera2/internal/CameraDeviceStateCallbacks$ComboDeviceStateCallback", "onOpened", this, r2, "void", r12);     // Catch: Exception -> L24
            if (r5.a == true) goto L17;
            r1.add(r7);     // Catch: Exception -> L24
        L17:
            if (r5.a == false) goto L19;
            return;
        L19:
            Iterator<CameraDevice.StateCallback> r6 = this.mCallbacks.iterator();
        L21:
            if (r6.hasNext() == false) goto L23;
            r6.next().onOpened(r20);
            goto L21
        L23:
            return;
        L14:
            r8 = r16 + 1;
            r9 = r17;
            r10 = r18;
            goto L8
        L15:
            r5 = new f06.d(false, null);
            goto L17
        L5:
            r4 = ApiHookConfig.d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r3, int r4) {
            Iterator<CameraDevice.StateCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onError(r3, r4);
            goto L4
        }
    }

    public static final class NoOpDeviceStateCallback extends CameraDevice.StateCallback {
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r1) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r1) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r1, int r2) {
        }

        public NoOpDeviceStateCallback() {
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
            if (r8.preInvoke(100200, "androidx/camera/camera2/internal/CameraDeviceStateCallbacks$NoOpDeviceStateCallback", "onOpened", this, r1, "void", r10).a == true) goto L15;
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
    }

    public static CameraDevice.StateCallback createNoOpCallback() {
        return new NoOpDeviceStateCallback();
    }

    private CameraDeviceStateCallbacks() {
    }

    public static CameraDevice.StateCallback createComboCallback(List<CameraDevice.StateCallback> r2) {
        if (r2.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r2.size() != 1) goto L11;
        return (CameraDevice.StateCallback) ListProtector.get(r2, 0);
    L11:
        return new ComboDeviceStateCallback(r2);
    }

    public static CameraDevice.StateCallback createComboCallback(CameraDevice.StateCallback... r0) {
        return createComboCallback(Arrays.asList(r0));
    }
}
