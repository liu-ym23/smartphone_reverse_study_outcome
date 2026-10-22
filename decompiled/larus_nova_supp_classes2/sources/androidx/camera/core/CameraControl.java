package androidx.camera.core;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        public OperationCanceledException(String r1) {
            super(r1);
        }

        public OperationCanceledException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    ListenableFuture<Void> cancelFocusAndMetering();

    ListenableFuture<Void> enableTorch(boolean r1);

    ListenableFuture<Integer> setExposureCompensationIndex(int r1);

    ListenableFuture<Void> setLinearZoom(float r1);

    ListenableFuture<Void> setZoomRatio(float r1);

    ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction r1);
}
