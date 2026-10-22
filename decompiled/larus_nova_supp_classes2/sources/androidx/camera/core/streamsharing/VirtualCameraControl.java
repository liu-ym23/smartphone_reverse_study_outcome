package androidx.camera.core.streamsharing;

import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ForwardingCameraControl;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VirtualCameraControl extends ForwardingCameraControl {
    private static final int DEFAULT_JPEG_QUALITY = 100;
    private static final int DEFAULT_ROTATION_DEGREES = 0;
    private final StreamSharing.Control mStreamSharingControl;

    public static /* synthetic */ ListenableFuture a(ListenableFuture r0, CameraCapturePipeline r1) {
        return lambda$submitStillCaptureRequests$0(r0, r1);
    }

    public static /* synthetic */ ListenableFuture b(VirtualCameraControl r0, List r1, Void r2) {
        return r0.lambda$submitStillCaptureRequests$1(r1, r2);
    }

    public static /* synthetic */ ListenableFuture c(ListenableFuture r0, Void r1) {
        return lambda$submitStillCaptureRequests$2(r0, r1);
    }

    private int getJpegQuality(CaptureConfig r3) {
        Integer r4 = (Integer) r3.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_JPEG_QUALITY, 100);
        Objects.requireNonNull(r4);
        return r4.intValue();
    }

    private int getRotationDegrees(CaptureConfig r3) {
        Integer r4 = (Integer) r3.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_ROTATION, 0);
        Objects.requireNonNull(r4);
        return r4.intValue();
    }

    public VirtualCameraControl(CameraControlInternal r1, StreamSharing.Control r2) {
        super(r1);
        this.mStreamSharingControl = r2;
    }

    private static /* synthetic */ ListenableFuture lambda$submitStillCaptureRequests$0(ListenableFuture r0, CameraCapturePipeline r1) throws Exception {
        return ((CameraCapturePipeline) r0.get()).invokePreCapture();
    }

    private /* synthetic */ ListenableFuture lambda$submitStillCaptureRequests$1(List r3, Void r4) throws Exception {
        return this.mStreamSharingControl.jpegSnapshot(getJpegQuality((CaptureConfig) ListProtector.get(r3, 0)), getRotationDegrees((CaptureConfig) ListProtector.get(r3, 0)));
    }

    private static /* synthetic */ ListenableFuture lambda$submitStillCaptureRequests$2(ListenableFuture r0, Void r1) throws Exception {
        return ((CameraCapturePipeline) r0.get()).invokePostCapture();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture<List<Void>> submitStillCaptureRequests(final List<CaptureConfig> r3, int r4, int r5) {
        boolean r1 = true;
        if (r3.size() == 1) goto L6;
        r1 = false;
    L6:
        Preconditions.checkArgument(r1, "Only support one capture config.");
        final ListenableFuture<CameraCapturePipeline> r6 = getCameraCapturePipelineAsync(r4, r5);
        return Futures.allAsList(Collections.singletonList(FutureChain.from(r6).transformAsync(new c(r6), CameraXExecutors.directExecutor()).transformAsync(new d(this, r3), CameraXExecutors.directExecutor()).transformAsync(new e(r6), CameraXExecutors.directExecutor())));
    }
}
