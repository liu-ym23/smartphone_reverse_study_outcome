package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    static final ImageCaptureOptionUnpacker INSTANCE = null;
    private final ImageCapturePixelHDRPlus mImageCapturePixelHDRPlus;

    static {
        INSTANCE = new ImageCaptureOptionUnpacker(new ImageCapturePixelHDRPlus());
    }

    private ImageCaptureOptionUnpacker(ImageCapturePixelHDRPlus r1) {
        this.mImageCapturePixelHDRPlus = r1;
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker, androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(UseCaseConfig<?> r3, CaptureConfig.Builder r4) {
        super.unpack(r3, r4);
        if ((r3 instanceof ImageCaptureConfig) == false) goto L10;
        ImageCaptureConfig r5 = (ImageCaptureConfig) r3;
        Camera2ImplConfig.Builder r0 = new Camera2ImplConfig.Builder();
        if (r5.hasCaptureMode() == false) goto L7;
        this.mImageCapturePixelHDRPlus.toggleHDRPlus(r5.getCaptureMode(), r0);
    L7:
        r4.addImplementationOptions(r0.build());
        return;
    L10:
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }
}
