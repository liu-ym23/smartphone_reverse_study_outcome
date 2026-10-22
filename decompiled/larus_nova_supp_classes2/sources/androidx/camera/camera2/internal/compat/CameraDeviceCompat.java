package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraDeviceCompat {
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;
    private final CameraDeviceCompatImpl mImpl;

    public interface CameraDeviceCompatImpl {
        void createCaptureSession(SessionConfigurationCompat r1) throws CameraAccessExceptionCompat;

        CameraDevice unwrap();
    }

    public static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        public static /* synthetic */ void a(StateCallbackExecutorWrapper r0, CameraDevice r1) {
            r0.lambda$onDisconnected$1(r1);
        }

        public static /* synthetic */ void b(StateCallbackExecutorWrapper r0, CameraDevice r1) {
            r0.lambda$onOpened$0(r1);
        }

        public static /* synthetic */ void c(StateCallbackExecutorWrapper r0, CameraDevice r1, int r2) {
            r0.lambda$onError$2(r1, r2);
        }

        public static /* synthetic */ void d(StateCallbackExecutorWrapper r0, CameraDevice r1) {
            r0.lambda$onClosed$3(r1);
        }

        private /* synthetic */ void lambda$onClosed$3(CameraDevice r2) {
            this.mWrappedCallback.onClosed(r2);
        }

        private /* synthetic */ void lambda$onDisconnected$1(CameraDevice r2) {
            this.mWrappedCallback.onDisconnected(r2);
        }

        private /* synthetic */ void lambda$onOpened$0(CameraDevice r2) {
            this.mWrappedCallback.onOpened(r2);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(final CameraDevice r3) {
            this.mExecutor.execute(new o(this, r3));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(final CameraDevice r3) {
            this.mExecutor.execute(new p(this, r3));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice r21) {
            ArrayList r10 = new ArrayList();
            Object[] r11 = {r21};
            f06.b r13 = new f06.b();
            g06.a r0 = (g06.a) ApiHookConfig.b.get(100200);
            if (r0 == null) goto L5;
            f06.a[] r1 = r0.i;
        L6:
            f06.a[] r7 = r1;
            int r6 = r7.length;
            int r5 = 0;
        L8:
            if (r5 >= r6) goto L15;
            f06.a r4 = r7[r5];
            int r17 = r5;
            int r18 = r6;
            f06.a[] r19 = r7;
            f06.d r2 = r4.preInvoke(100200, "androidx/camera/camera2/internal/compat/CameraDeviceCompat$StateCallbackExecutorWrapper", "onOpened", this, r11, "void", r13);     // Catch: Exception -> L21
            if (r2.a == true) goto L17;
            r10.add(r4);     // Catch: Exception -> L21
        L17:
            if (r2.a == false) goto L19;
            return;
        L19:
            this.mExecutor.execute(new q(this, r21));
            return;
        L14:
            r5 = r17 + 1;
            r6 = r18;
            r7 = r19;
            goto L8
        L15:
            r2 = new f06.d(false, null);
            goto L17
        L5:
            r1 = ApiHookConfig.d;
            goto L6
        }

        public StateCallbackExecutorWrapper(Executor r1, CameraDevice.StateCallback r2) {
            this.mExecutor = r1;
            this.mWrappedCallback = r2;
        }

        private /* synthetic */ void lambda$onError$2(CameraDevice r2, int r3) {
            this.mWrappedCallback.onError(r2, r3);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(final CameraDevice r3, final int r4) {
            this.mExecutor.execute(new r(this, r3, r4));
        }
    }

    public CameraDevice toCameraDevice() {
        return this.mImpl.unwrap();
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice r1) {
        return toCameraDeviceCompat(r1, MainThreadAsyncHandler.getInstance());
    }

    public void createCaptureSession(SessionConfigurationCompat r2) throws CameraAccessExceptionCompat {
        this.mImpl.createCaptureSession(r2);
    }

    private CameraDeviceCompat(CameraDevice r3, Handler r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        this.mImpl = new CameraDeviceCompatApi28Impl(r3);
        return;
    L6:
        if (r0 < 24) goto L9;
        this.mImpl = CameraDeviceCompatApi24Impl.create(r3, r4);
        return;
    L9:
        if (r0 < 23) goto L11;
        this.mImpl = CameraDeviceCompatApi23Impl.create(r3, r4);
        return;
    L11:
        this.mImpl = CameraDeviceCompatBaseImpl.create(r3, r4);
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice r1, Handler r2) {
        return new CameraDeviceCompat(r1, r2);
    }
}
