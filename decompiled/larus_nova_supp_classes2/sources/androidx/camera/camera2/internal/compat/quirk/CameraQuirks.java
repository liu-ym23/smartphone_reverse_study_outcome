package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraQuirks {
    private static final String TAG = "CameraQuirks";

    private CameraQuirks() {
    }

    public static Quirks get(String r3, CameraCharacteristicsCompat r4) {
        QuirkSettings r5 = QuirkSettingsHolder.instance().get();
        ArrayList r0 = new ArrayList();
        if (r5.shouldEnableQuirk(AeFpsRangeLegacyQuirk.class, AeFpsRangeLegacyQuirk.load(r4)) == false) goto L6;
        r0.add(new AeFpsRangeLegacyQuirk(r4));
    L6:
        if (r5.shouldEnableQuirk(AspectRatioLegacyApi21Quirk.class, AspectRatioLegacyApi21Quirk.load(r4)) == false) goto L9;
        r0.add(new AspectRatioLegacyApi21Quirk());
    L9:
        if (r5.shouldEnableQuirk(JpegHalCorruptImageQuirk.class, JpegHalCorruptImageQuirk.load(r4)) == false) goto L12;
        r0.add(new JpegHalCorruptImageQuirk());
    L12:
        if (r5.shouldEnableQuirk(JpegCaptureDownsizingQuirk.class, JpegCaptureDownsizingQuirk.load(r4)) == false) goto L15;
        r0.add(new JpegCaptureDownsizingQuirk());
    L15:
        if (r5.shouldEnableQuirk(CamcorderProfileResolutionQuirk.class, CamcorderProfileResolutionQuirk.load(r4)) == false) goto L18;
        r0.add(new CamcorderProfileResolutionQuirk(r4));
    L18:
        if (r5.shouldEnableQuirk(CaptureNoResponseQuirk.class, CaptureNoResponseQuirk.load(r4)) == false) goto L21;
        r0.add(new CaptureNoResponseQuirk());
    L21:
        if (r5.shouldEnableQuirk(LegacyCameraOutputConfigNullPointerQuirk.class, LegacyCameraOutputConfigNullPointerQuirk.load(r4)) == false) goto L24;
        r0.add(new LegacyCameraOutputConfigNullPointerQuirk());
    L24:
        if (r5.shouldEnableQuirk(LegacyCameraSurfaceCleanupQuirk.class, LegacyCameraSurfaceCleanupQuirk.load(r4)) == false) goto L27;
        r0.add(new LegacyCameraSurfaceCleanupQuirk());
    L27:
        if (r5.shouldEnableQuirk(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.load(r4)) == false) goto L30;
        r0.add(new ImageCaptureWashedOutImageQuirk());
    L30:
        if (r5.shouldEnableQuirk(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.load(r4)) == false) goto L33;
        r0.add(new CameraNoResponseWhenEnablingFlashQuirk());
    L33:
        if (r5.shouldEnableQuirk(YuvImageOnePixelShiftQuirk.class, YuvImageOnePixelShiftQuirk.load(r4)) == false) goto L36;
        r0.add(new YuvImageOnePixelShiftQuirk());
    L36:
        if (r5.shouldEnableQuirk(FlashTooSlowQuirk.class, FlashTooSlowQuirk.load(r4)) == false) goto L39;
        r0.add(new FlashTooSlowQuirk());
    L39:
        if (r5.shouldEnableQuirk(AfRegionFlipHorizontallyQuirk.class, AfRegionFlipHorizontallyQuirk.load(r4)) == false) goto L42;
        r0.add(new AfRegionFlipHorizontallyQuirk());
    L42:
        if (r5.shouldEnableQuirk(ConfigureSurfaceToSecondarySessionFailQuirk.class, ConfigureSurfaceToSecondarySessionFailQuirk.load(r4)) == false) goto L45;
        r0.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
    L45:
        if (r5.shouldEnableQuirk(PreviewOrientationIncorrectQuirk.class, PreviewOrientationIncorrectQuirk.load(r4)) == false) goto L48;
        r0.add(new PreviewOrientationIncorrectQuirk());
    L48:
        if (r5.shouldEnableQuirk(CaptureSessionStuckQuirk.class, CaptureSessionStuckQuirk.load(r4)) == false) goto L51;
        r0.add(new CaptureSessionStuckQuirk());
    L51:
        if (r5.shouldEnableQuirk(ImageCaptureFlashNotFireQuirk.class, ImageCaptureFlashNotFireQuirk.load(r4)) == false) goto L54;
        r0.add(new ImageCaptureFlashNotFireQuirk());
    L54:
        if (r5.shouldEnableQuirk(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.load(r4)) == false) goto L57;
        r0.add(new ImageCaptureWithFlashUnderexposureQuirk());
    L57:
        if (r5.shouldEnableQuirk(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.load(r4)) == false) goto L60;
        r0.add(new ImageCaptureFailWithAutoFlashQuirk());
    L60:
        if (r5.shouldEnableQuirk(IncorrectCaptureStateQuirk.class, IncorrectCaptureStateQuirk.load(r4)) == false) goto L63;
        r0.add(new IncorrectCaptureStateQuirk());
    L63:
        if (r5.shouldEnableQuirk(TorchFlashRequiredFor3aUpdateQuirk.class, TorchFlashRequiredFor3aUpdateQuirk.load(r4)) == false) goto L66;
        r0.add(new TorchFlashRequiredFor3aUpdateQuirk(r4));
    L66:
        if (r5.shouldEnableQuirk(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, PreviewStretchWhenVideoCaptureIsBoundQuirk.load()) == false) goto L69;
        r0.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
    L69:
        if (r5.shouldEnableQuirk(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, PreviewDelayWhenVideoCaptureIsBoundQuirk.load()) == false) goto L72;
        r0.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
    L72:
        if (r5.shouldEnableQuirk(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.load()) == false) goto L75;
        r0.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
    L75:
        if (r5.shouldEnableQuirk(TemporalNoiseQuirk.class, TemporalNoiseQuirk.load(r4)) == false) goto L78;
        r0.add(new TemporalNoiseQuirk());
    L78:
        if (r5.shouldEnableQuirk(ImageCaptureFailedForVideoSnapshotQuirk.class, ImageCaptureFailedForVideoSnapshotQuirk.load()) == false) goto L80;
        r0.add(new ImageCaptureFailedForVideoSnapshotQuirk());
    L80:
        Quirks r6 = new Quirks(r0);
        Logger.d(TAG, "camera2 CameraQuirks = " + Quirks.toString(r6));
        return r6;
    }
}
