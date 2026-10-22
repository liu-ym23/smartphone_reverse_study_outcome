package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    List<CaptureConfig> getCaptureConfigs();

    SessionConfig getSessionConfig();

    boolean isInOpenState();

    void issueCaptureRequests(List<CaptureConfig> r1);

    ListenableFuture<Void> open(SessionConfig r1, CameraDevice r2, SynchronizedCaptureSession.Opener r3);

    ListenableFuture<Void> release(boolean r1);

    void setSessionConfig(SessionConfig r1);

    void setStreamUseCaseMap(Map<DeferrableSurface, Long> r1);
}
