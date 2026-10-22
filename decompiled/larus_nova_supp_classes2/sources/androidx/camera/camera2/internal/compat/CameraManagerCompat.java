package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraManagerCompat {
    private final Map<String, CameraCharacteristicsCompat> mCameraCharacteristicsMap;
    private final CameraManagerCompatImpl mImpl;

    public static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private boolean mDisabled;
        private final Executor mExecutor;
        private final Object mLock;
        final CameraManager.AvailabilityCallback mWrappedCallback;

        public static /* synthetic */ void a(AvailabilityCallbackExecutorWrapper r0) {
            r0.lambda$onCameraAccessPrioritiesChanged$0();
        }

        public static /* synthetic */ void b(AvailabilityCallbackExecutorWrapper r0, String r1) {
            r0.lambda$onCameraAvailable$1(r1);
        }

        public static /* synthetic */ void c(AvailabilityCallbackExecutorWrapper r0, String r1) {
            r0.lambda$onCameraUnavailable$2(r1);
        }

        private /* synthetic */ void lambda$onCameraAccessPrioritiesChanged$0() {
            ApiCompat.Api29Impl.onCameraAccessPrioritiesChanged(this.mWrappedCallback);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new s(this));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public void setDisabled() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mDisabled = true;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$onCameraAvailable$1(String r2) {
            this.mWrappedCallback.onCameraAvailable(r2);
        }

        private /* synthetic */ void lambda$onCameraUnavailable$2(String r2) {
            this.mWrappedCallback.onCameraUnavailable(r2);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(final String r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new u(this, r4));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(final String r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new t(this, r4));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public AvailabilityCallbackExecutorWrapper(Executor r2, CameraManager.AvailabilityCallback r3) {
            this.mLock = new Object();
            this.mDisabled = false;
            this.mExecutor = r2;
            this.mWrappedCallback = r3;
        }
    }

    public interface CameraManagerCompatImpl {

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$CameraManagerCompatImpl$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static CameraManagerCompatImpl from(Context r2, Handler r3) {
                int r0 = Build.VERSION.SDK_INT;
                if (r0 < 30) goto L7;
                return new CameraManagerCompatApi30Impl(r2);
            L7:
                if (r0 < 29) goto L11;
                return new CameraManagerCompatApi29Impl(r2);
            L11:
                if (r0 < 28) goto L15;
                return CameraManagerCompatApi28Impl.create(r2);
            L15:
                return CameraManagerCompatBaseImpl.create(r2, r3);
            }
        }

        CameraCharacteristics getCameraCharacteristics(String r1) throws CameraAccessExceptionCompat;

        String[] getCameraIdList() throws CameraAccessExceptionCompat;

        CameraManager getCameraManager();

        Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat;

        void openCamera(String r1, Executor r2, CameraDevice.StateCallback r3) throws CameraAccessExceptionCompat;

        void registerAvailabilityCallback(Executor r1, CameraManager.AvailabilityCallback r2);

        void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r1);
    }

    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mImpl.getCameraIdList();
    }

    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return this.mImpl.getConcurrentCameraIds();
    }

    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }

    private CameraManagerCompat(CameraManagerCompatImpl r3) {
        this.mCameraCharacteristicsMap = new ArrayMap(4);
        this.mImpl = r3;
    }

    public static CameraManagerCompat from(Context r1) {
        return from(r1, MainThreadAsyncHandler.getInstance());
    }

    public CameraCharacteristicsCompat getCameraCharacteristicsCompat(String r5) throws CameraAccessExceptionCompat {
        Map<String, CameraCharacteristicsCompat> r0 = this.mCameraCharacteristicsMap;
        monitor-enter(r0);
        CameraCharacteristicsCompat r1 = this.mCameraCharacteristicsMap.get(r5);     // Catch: Throwable -> L13
        if (r1 == null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L16:
        r1 = CameraCharacteristicsCompat.toCameraCharacteristicsCompat(this.mImpl.getCameraCharacteristics(r5), r5);     // Catch: AssertionError -> L8 Throwable -> L13
        this.mCameraCharacteristicsMap.put(r5, r1);     // Catch: AssertionError -> L8 Throwable -> L13
    L8:
        e = move-exception;
        throw new CameraAccessExceptionCompat(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, e.getMessage(), e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r2) {
        this.mImpl.unregisterAvailabilityCallback(r2);
    }

    public static CameraManagerCompat from(CameraManagerCompatImpl r1) {
        return new CameraManagerCompat(r1);
    }

    public static CameraManagerCompat from(Context r1, Handler r2) {
        return new CameraManagerCompat(CameraManagerCompatImpl.CC.from(r1, r2));
    }

    public void registerAvailabilityCallback(Executor r2, CameraManager.AvailabilityCallback r3) {
        this.mImpl.registerAvailabilityCallback(r2, r3);
    }

    public void openCamera(String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessExceptionCompat {
        this.mImpl.openCamera(r2, r3, r4);
    }
}
