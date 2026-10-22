package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class Camera2SessionOptionUnpacker implements SessionConfig.OptionUnpacker {
    static final Camera2SessionOptionUnpacker INSTANCE = null;

    public Camera2SessionOptionUnpacker() {
    }

    static {
        INSTANCE = new Camera2SessionOptionUnpacker();
    }

    @Override // androidx.camera.core.impl.SessionConfig.OptionUnpacker
    public void unpack(Size r5, UseCaseConfig<?> r6, SessionConfig.Builder r7) {
        SessionConfig r1 = r6.getDefaultSessionConfig(null);
        Config r2 = OptionsBundle.emptyBundle();
        int r3 = SessionConfig.defaultEmptySessionConfig().getTemplateType();
        if (r1 == null) goto L5;
        r3 = r1.getTemplateType();
        r7.addAllDeviceStateCallbacks(r1.getDeviceStateCallbacks());
        r7.addAllSessionStateCallbacks(r1.getSessionStateCallbacks());
        r7.addAllRepeatingCameraCaptureCallbacks(r1.getRepeatingCameraCaptureCallbacks());
        r2 = r1.getImplementationOptions();
    L5:
        r7.setImplementationOptions(r2);
        if ((r6 instanceof PreviewConfig) == false) goto L8;
        PreviewPixelHDRnet.setHDRnet(r5, r7);
    L8:
        Camera2ImplConfig r8 = new Camera2ImplConfig(r6);
        r7.setTemplateType(r8.getCaptureRequestTemplate(r3));
        r7.addDeviceStateCallback(r8.getDeviceStateCallback(CameraDeviceStateCallbacks.createNoOpCallback()));
        r7.addSessionStateCallback(r8.getSessionStateCallback(CameraCaptureSessionStateCallbacks.createNoOpCallback()));
        r7.addCameraCaptureCallback(CaptureCallbackContainer.create(r8.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        r7.setVideoStabilization(r6.getVideoStabilizationMode());
        r7.setPreviewStabilization(r6.getPreviewStabilizationMode());
        MutableOptionsBundle r9 = MutableOptionsBundle.create();
        r9.insertOption(Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION, r8.getPhysicalCameraId(null));
        r9.insertOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION, Long.valueOf(r8.getStreamUseCase(-1)));
        r7.addImplementationOptions(r9);
        r7.addImplementationOptions(r8.getCaptureRequestOptions());
    }
}
