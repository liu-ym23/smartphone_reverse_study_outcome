package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class Camera2CaptureOptionUnpacker implements CaptureConfig.OptionUnpacker {
    static final Camera2CaptureOptionUnpacker INSTANCE = null;

    public Camera2CaptureOptionUnpacker() {
    }

    static {
        INSTANCE = new Camera2CaptureOptionUnpacker();
    }

    @Override // androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(UseCaseConfig<?> r4, CaptureConfig.Builder r5) {
        CaptureConfig r0 = r4.getDefaultCaptureConfig(null);
        Config r1 = OptionsBundle.emptyBundle();
        int r2 = CaptureConfig.defaultEmptyCaptureConfig().getTemplateType();
        if (r0 == null) goto L5;
        r2 = r0.getTemplateType();
        r5.addAllCameraCaptureCallbacks(r0.getCameraCaptureCallbacks());
        r1 = r0.getImplementationOptions();
    L5:
        r5.setImplementationOptions(r1);
        Camera2ImplConfig r3 = new Camera2ImplConfig(r4);
        r5.setTemplateType(r3.getCaptureRequestTemplate(r2));
        r5.addCameraCaptureCallback(CaptureCallbackContainer.create(r3.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        r5.addImplementationOptions(r3.getCaptureRequestOptions());
    }
}
