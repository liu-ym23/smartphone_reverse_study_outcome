package com.ss.android.lark.camera_export;

import com.ss.android.lark.log.Log;
import idb.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R!\u0010\f\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\f\u0010\u000fR!\u0010\u0012\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000fR!\u0010\u0016\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u000fR!\u0010\u001a\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u000fR!\u0010\u001e\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0011\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u000fR!\u0010\"\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\u000f¨\u0006("}, d2 = {"Lcom/ss/android/lark/camera_export/CameraFG;", "", "<init>", "()V", "TAG", "", "FEATURE_CAMERA_AUDIO_DECOUPLE", "KEY_BIG_SCREEN_COMPAT", "KEY_CAMERA_FG", "KEY_VECAMERA_POTRAIT_FG", "KEY_FRONT_CAMERA_WITHOUT_FLASH", "KEY_ROLLBACK_FOLD_ADAPTION", "isCameraAudioDecouple", "", "isCameraAudioDecouple$annotations", "()Z", "isCameraAudioDecouple$delegate", "Lkotlin/Lazy;", "enableBigScreenCompat", "getEnableBigScreenCompat$annotations", "getEnableBigScreenCompat", "enableBigScreenCompat$delegate", "enableUseNewCamera", "getEnableUseNewCamera$annotations", "getEnableUseNewCamera", "enableUseNewCamera$delegate", "enableVECameraPortrait", "getEnableVECameraPortrait$annotations", "getEnableVECameraPortrait", "enableVECameraPortrait$delegate", "enableFrontCameraWithoutFlash", "getEnableFrontCameraWithoutFlash$annotations", "getEnableFrontCameraWithoutFlash", "enableFrontCameraWithoutFlash$delegate", "enableAdaptPadAndFoldable", "getEnableAdaptPadAndFoldable$annotations", "getEnableAdaptPadAndFoldable", "enableAdaptPadAndFoldable$delegate", "isEnableWithLog", "key", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraFG {
    private static final String FEATURE_CAMERA_AUDIO_DECOUPLE = "base_camera_video_audio_decouple";
    public static final CameraFG INSTANCE = null;
    private static final String KEY_BIG_SCREEN_COMPAT = "messenger.media.big.screen";
    private static final String KEY_CAMERA_FG = "performance.camera.use_new_camera";
    private static final String KEY_FRONT_CAMERA_WITHOUT_FLASH = "performance.camera.without_front_flash";
    private static final String KEY_ROLLBACK_FOLD_ADAPTION = "performance.camera.camera_rollback_fold_adaption";
    private static final String KEY_VECAMERA_POTRAIT_FG = "forseti.vecamera.potrait";
    private static final String TAG = "CameraFG";
    private static final Lazy enableAdaptPadAndFoldable$delegate = null;
    private static final Lazy enableBigScreenCompat$delegate = null;
    private static final Lazy enableFrontCameraWithoutFlash$delegate = null;
    private static final Lazy enableUseNewCamera$delegate = null;
    private static final Lazy enableVECameraPortrait$delegate = null;
    private static final Lazy isCameraAudioDecouple$delegate = null;

    private CameraFG() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableAdaptPadAndFoldable$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableBigScreenCompat$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableFrontCameraWithoutFlash$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableUseNewCamera$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableVECameraPortrait$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isCameraAudioDecouple$annotations() {
    }

    static {
        INSTANCE = new CameraFG();
        isCameraAudioDecouple$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        enableBigScreenCompat$delegate = LazyKt.lazy(CameraFG$enableBigScreenCompat$2.INSTANCE);
        enableUseNewCamera$delegate = LazyKt.lazy(CameraFG$enableUseNewCamera$2.INSTANCE);
        enableVECameraPortrait$delegate = LazyKt.lazy(CameraFG$enableVECameraPortrait$2.INSTANCE);
        enableFrontCameraWithoutFlash$delegate = LazyKt.lazy(CameraFG$enableFrontCameraWithoutFlash$2.INSTANCE);
        enableAdaptPadAndFoldable$delegate = LazyKt.lazy(CameraFG$enableAdaptPadAndFoldable$2.INSTANCE);
    }

    public static final boolean getEnableAdaptPadAndFoldable() {
        return ((Boolean) enableAdaptPadAndFoldable$delegate.getValue()).booleanValue();
    }

    public static final boolean getEnableBigScreenCompat() {
        return ((Boolean) enableBigScreenCompat$delegate.getValue()).booleanValue();
    }

    public static final boolean getEnableFrontCameraWithoutFlash() {
        return ((Boolean) enableFrontCameraWithoutFlash$delegate.getValue()).booleanValue();
    }

    public static final boolean getEnableUseNewCamera() {
        return ((Boolean) enableUseNewCamera$delegate.getValue()).booleanValue();
    }

    public static final boolean getEnableVECameraPortrait() {
        return ((Boolean) enableVECameraPortrait$delegate.getValue()).booleanValue();
    }

    public static final boolean isCameraAudioDecouple() {
        return ((Boolean) isCameraAudioDecouple$delegate.getValue()).booleanValue();
    }

    private final boolean isEnableWithLog(String r100) {
        boolean r101 = f.a().isEnable(r100);
        Log.i(TAG, "FG " + r100 + ": " + r101);
        return r101;
    }

    public static final /* synthetic */ boolean access$isEnableWithLog(CameraFG r100, String r101) {
        return r100.isEnableWithLog(r101);
    }
}
