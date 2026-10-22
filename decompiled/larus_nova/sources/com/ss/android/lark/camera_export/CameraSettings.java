package com.ss.android.lark.camera_export;

import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0007H\u0007J\b\u0010\u001f\u001a\u00020\u0015H\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0015H\u0007J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0014\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001d\u0010\u001a¨\u0006%"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraSettings;", "", "<init>", "()V", "TAG", "", "DEFAULT_VIDEO_MAX_DURATION", "", "videoMaxDuration", "Ljava/lang/Integer;", "cameraSetting", "Lorg/json/JSONObject;", "getCameraSetting", "()Lorg/json/JSONObject;", "cameraSetting$delegate", "Lkotlin/Lazy;", "cameraConfig", "getCameraConfig", "cameraConfig$delegate", "getCameraVideoMaxDuration", "isSupport1080P", "", "()Z", "isSupport1080P$delegate", "hdShootWidth", "getHdShootWidth", "()I", "hdShootWidth$delegate", "hdShootHeight", "getHdShootHeight", "hdShootHeight$delegate", "isSupportHDShoot", "getCameraResolution", "Lcom/ss/android/lark/camera_export/CameraResolution;", "useHDShoot", "use1080P", "useNewVECamera", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSettings {
    public static final int DEFAULT_VIDEO_MAX_DURATION = 30000;
    public static final CameraSettings INSTANCE = null;
    private static final String TAG = "CameraSettings";
    private static final Lazy cameraConfig$delegate = null;
    private static final Lazy cameraSetting$delegate = null;
    private static final Lazy hdShootHeight$delegate = null;
    private static final Lazy hdShootWidth$delegate = null;
    private static final Lazy isSupport1080P$delegate = null;
    private static Integer videoMaxDuration;

    private CameraSettings() {
    }

    static {
        INSTANCE = new CameraSettings();
        cameraSetting$delegate = LazyKt.lazy(CameraSettings$cameraSetting$2.INSTANCE);
        cameraConfig$delegate = LazyKt.lazy(CameraSettings$cameraConfig$2.INSTANCE);
        isSupport1080P$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        hdShootWidth$delegate = LazyKt.lazy(CameraSettings$hdShootWidth$2.INSTANCE);
        hdShootHeight$delegate = LazyKt.lazy(CameraSettings$hdShootHeight$2.INSTANCE);
    }

    private final JSONObject getCameraConfig() {
        return (JSONObject) cameraConfig$delegate.getValue();
    }

    private final JSONObject getCameraSetting() {
        return (JSONObject) cameraSetting$delegate.getValue();
    }

    @JvmStatic
    public static final int getCameraVideoMaxDuration() {
        Integer r100 = videoMaxDuration;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        return 30000;
    L6:
        return r100.intValue();
    L7:
        Integer r101 = Integer.valueOf(INSTANCE.getCameraConfig().optInt("video_max_duration", 30000));
        videoMaxDuration = r101;
        if (r101 != null) goto L10;
        return 30000;
    L10:
        return r101.intValue();
    }

    private final int getHdShootHeight() {
        return ((Number) hdShootHeight$delegate.getValue()).intValue();
    }

    private final int getHdShootWidth() {
        return ((Number) hdShootWidth$delegate.getValue()).intValue();
    }

    private final boolean isSupport1080P() {
        return ((Boolean) isSupport1080P$delegate.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean isSupportHDShoot() {
        CameraSettings r100 = INSTANCE;
        if (r100.getHdShootWidth() > 0) goto L5;
        return false;
    L5:
        if (r100.getHdShootHeight() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static final /* synthetic */ JSONObject access$getCameraConfig(CameraSettings r100) {
        return r100.getCameraConfig();
    }

    public static final /* synthetic */ JSONObject access$getCameraSetting(CameraSettings r100) {
        return r100.getCameraSetting();
    }

    @JvmStatic
    public static final CameraResolution getCameraResolution(boolean r100, boolean r101) {
        return getCameraResolution(r100, r101, false);
    }

    @JvmStatic
    public static final CameraResolution getCameraResolution(boolean r100, boolean r101, boolean r102) {
        CameraResolution.Companion r103 = CameraResolution.Companion;
        CameraResolution r104 = r103.getCR720P();
        if (r100 == true) goto L5;
        if (r101 == true) goto L12;
    L14:
        if (r102 == true) goto L16;
    L31:
        Log.i(TAG, "getCameraResolution, useHDShoot:" + r100 + ", use1080P:" + r101 + ", resolution:" + r104);
        return r104;
    L16:
        if (DeviceUtils.isPad() == false) goto L31;
        r104 = r103.getCR720P_PAD();
        if (r100 == true) goto L20;
        if (r101 == false) goto L31;
        if (INSTANCE.isSupport1080P() == false) goto L31;
        r104 = r103.getCR1080P_PAD();
        goto L31
    L20:
        if (isSupportHDShoot() == false) goto L24;
        CameraSettings r105 = INSTANCE;
        CameraResolution r106 = new CameraResolution(r105.getHdShootWidth(), r105.getHdShootHeight());
    L22:
        r104 = r106;
        goto L31
    L24:
        if (INSTANCE.isSupport1080P() == false) goto L26;
        r106 = r103.getCR1080P_PAD();
        goto L22
    L26:
        r106 = r103.getCR720P_PAD();
        goto L22
    L12:
        if (INSTANCE.isSupport1080P() == false) goto L14;
        r104 = r103.getCR1080P();
        goto L14
    L5:
        if (isSupportHDShoot() == false) goto L8;
        CameraSettings r107 = INSTANCE;
        r104 = new CameraResolution(r107.getHdShootWidth(), r107.getHdShootHeight());
        goto L14
    L8:
        if (INSTANCE.isSupport1080P() == false) goto L14;
        r104 = r103.getCR1080P();
        goto L14
    }

    public static /* synthetic */ CameraResolution getCameraResolution$default(boolean r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = false;
    L6:
        return getCameraResolution(r100, r101, r102);
    }
}
