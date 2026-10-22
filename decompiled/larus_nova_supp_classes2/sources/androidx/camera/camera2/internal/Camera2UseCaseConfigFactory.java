package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {
    final DisplayInfoManager mDisplayInfoManager;

    public Camera2UseCaseConfigFactory(Context r1) {
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public Config getConfig(UseCaseConfigFactory.CaptureType r4, int r5) {
        MutableOptionsBundle r0 = MutableOptionsBundle.create();
        SessionConfig.Builder r1 = new SessionConfig.Builder();
        r1.setTemplateType(TemplateTypeUtil.getSessionConfigTemplateType(r4, r5));
        r0.insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r1.build());
        r0.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder r2 = new CaptureConfig.Builder();
        r2.setTemplateType(TemplateTypeUtil.getCaptureConfigTemplateType(r4, r5));
        r0.insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r2.build());
        Config.Option<CaptureConfig.OptionUnpacker> r6 = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        if (r4 != UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE) goto L5;
        CaptureConfig.OptionUnpacker r3 = ImageCaptureOptionUnpacker.INSTANCE;
    L6:
        r0.insertOption(r6, r3);
        if (r4 != UseCaseConfigFactory.CaptureType.PREVIEW) goto L9;
        Size r7 = this.mDisplayInfoManager.getPreviewSize();
        r0.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r7);
    L9:
        int r8 = this.mDisplayInfoManager.getMaxSizeDisplay(true).getRotation();
        r0.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r8));
        if (r4 != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L12;
    L13:
        r0.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
    L15:
        return OptionsBundle.from(r0);
    L12:
        if (r4 != UseCaseConfigFactory.CaptureType.STREAM_SHARING) goto L15;
    L5:
        r3 = Camera2CaptureOptionUnpacker.INSTANCE;
        goto L6
    }
}
