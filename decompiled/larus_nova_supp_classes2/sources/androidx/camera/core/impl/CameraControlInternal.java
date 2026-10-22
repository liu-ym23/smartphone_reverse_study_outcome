package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraControlInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$decrementVideoUsage(CameraControlInternal r0) {
        }

        public static CameraControlInternal $default$getImplementation(CameraControlInternal r0) {
            return r0;
        }

        public static void $default$incrementVideoUsage(CameraControlInternal r0) {
        }

        public static boolean $default$isInVideoUsage(CameraControlInternal r0) {
            return false;
        }

        public static void $default$setScreenFlash(CameraControlInternal r0, ImageCapture.ScreenFlash r1) {
        }

        public static ListenableFuture $default$getCameraCapturePipelineAsync(final CameraControlInternal r0, int r1, int r2) {
            return Futures.immediateFuture(new AnonymousClass1(r0));
        }
    }

    public static final class CameraControlException extends Exception {
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(CameraCaptureFailure r1) {
            this.mCameraCaptureFailure = r1;
        }

        public CameraControlException(CameraCaptureFailure r1, Throwable r2) {
            super(r2);
            this.mCameraCaptureFailure = r1;
        }
    }

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(List<CaptureConfig> r1);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(Config r1);

    void addZslConfig(SessionConfig.Builder r1);

    void clearInteropConfig();

    void decrementVideoUsage();

    ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(int r1, int r2);

    int getFlashMode();

    CameraControlInternal getImplementation();

    Config getInteropConfig();

    Rect getSensorRect();

    SessionConfig getSessionConfig();

    void incrementVideoUsage();

    boolean isInVideoUsage();

    boolean isZslDisabledByByUserCaseConfig();

    void setFlashMode(int r1);

    void setScreenFlash(ImageCapture.ScreenFlash r1);

    void setZslDisabledByUserCaseConfig(boolean r1);

    ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> r1, int r2, int r3);

    static {
        DEFAULT_EMPTY_INSTANCE = new AnonymousClass2();
    }
}
