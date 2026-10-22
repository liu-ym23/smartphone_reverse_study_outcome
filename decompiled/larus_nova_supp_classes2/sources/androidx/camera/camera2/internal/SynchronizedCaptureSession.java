package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface SynchronizedCaptureSession {

    public interface Opener {
        SessionConfigurationCompat createSessionConfigurationCompat(int r1, List<OutputConfigurationCompat> r2, StateCallback r3);

        Executor getExecutor();

        ListenableFuture<Void> openCaptureSession(CameraDevice r1, SessionConfigurationCompat r2, List<DeferrableSurface> r3);

        ListenableFuture<List<Surface>> startWithDeferrableSurface(List<DeferrableSurface> r1, long r2);

        boolean stop();
    }

    public static class OpenerBuilder {
        private final Quirks mCameraQuirks;
        private final CaptureSessionRepository mCaptureSessionRepository;
        private final Handler mCompatHandler;
        private final Quirks mDeviceQuirks;
        private final Executor mExecutor;
        private final ScheduledExecutorService mScheduledExecutorService;

        public Opener build() {
            return new SynchronizedCaptureSessionImpl(this.mCameraQuirks, this.mDeviceQuirks, this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler);
        }

        public OpenerBuilder(Executor r1, ScheduledExecutorService r2, Handler r3, CaptureSessionRepository r4, Quirks r5, Quirks r6) {
            this.mExecutor = r1;
            this.mScheduledExecutorService = r2;
            this.mCompatHandler = r3;
            this.mCaptureSessionRepository = r4;
            this.mCameraQuirks = r5;
            this.mDeviceQuirks = r6;
        }
    }

    public static abstract class StateCallback {
        public StateCallback() {
        }

        public void onActive(SynchronizedCaptureSession r1) {
        }

        public void onCaptureQueueEmpty(SynchronizedCaptureSession r1) {
        }

        public void onClosed(SynchronizedCaptureSession r1) {
        }

        public void onConfigureFailed(SynchronizedCaptureSession r1) {
        }

        public void onConfigured(SynchronizedCaptureSession r1) {
        }

        public void onReady(SynchronizedCaptureSession r1) {
        }

        public void onSessionFinished(SynchronizedCaptureSession r1) {
        }

        public void onSurfacePrepared(SynchronizedCaptureSession r1, Surface r2) {
        }
    }

    void abortCaptures() throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> r1, CameraCaptureSession.CaptureCallback r2) throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest r1, CameraCaptureSession.CaptureCallback r2) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

    void close();

    void finishClose();

    CameraDevice getDevice();

    Surface getInputSurface();

    ListenableFuture<Void> getOpeningBlocker();

    StateCallback getStateCallback();

    void onCameraDeviceError(int r1);

    int setRepeatingBurstRequests(List<CaptureRequest> r1, CameraCaptureSession.CaptureCallback r2) throws CameraAccessException;

    int setRepeatingBurstRequests(List<CaptureRequest> r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest r1, CameraCaptureSession.CaptureCallback r2) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

    void stopRepeating() throws CameraAccessException;

    CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}
