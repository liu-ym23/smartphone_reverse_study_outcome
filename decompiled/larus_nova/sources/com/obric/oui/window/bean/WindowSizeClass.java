package com.obric.oui.window.bean;

import ana.b;
import ana.c;
import ana.d;
import ana.e;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeClass;", "", "", "dpSize", "I", "getDpSize", "()I", "Lana/c;", "baseGridConfig", "Lana/c;", "getBaseGridConfig", "()Lana/c;", "MINUS_ERROR_SIZE", "FLOATING_WINDOW", "SMALL_SPLIT_SCREEN", "SMALLER_ANDROID_SCREEN", "SMALL", "STANDARD", EffectConstants.NORMAL, "LARGE", "OVERSIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    public static final WindowSizeClass FLOATING_WINDOW = null;
    public static final WindowSizeClass LARGE = null;
    public static final WindowSizeClass MINUS_ERROR_SIZE = null;
    public static final WindowSizeClass NORMAL = null;
    public static final WindowSizeClass OVERSIZE = null;
    public static final WindowSizeClass SMALL = null;
    public static final WindowSizeClass SMALLER_ANDROID_SCREEN = null;
    public static final WindowSizeClass SMALL_SPLIT_SCREEN = null;
    public static final WindowSizeClass STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowSizeClass[] f403746a = null;
    private final c baseGridConfig;
    private final int dpSize;

    public static WindowSizeClass valueOf(String r100) {
        return (WindowSizeClass) a.a(WindowSizeClass.class, r100);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) f403746a.clone();
    }

    static {
        WindowSizeClass r100 = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new c("MINUS_ERROR_SIZE", new b(), new d(), new e()));
        MINUS_ERROR_SIZE = r100;
        WindowSizeClass r101 = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new c("FLOATING_WINDOW", new b(), new d(), new e()));
        FLOATING_WINDOW = r101;
        WindowSizeClass r102 = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, new c("SMALL_SPLIT_SCREEN", new b(), new d(), new e()));
        SMALL_SPLIT_SCREEN = r102;
        WindowSizeClass r103 = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new c("SMALLER_ANDROID_SCREEN", new b(), new d(), new e()));
        SMALLER_ANDROID_SCREEN = r103;
        WindowSizeClass r104 = new WindowSizeClass("SMALL", 4, 640, new c("SMALL", new b(), new d(), new e()));
        SMALL = r104;
        WindowSizeClass r105 = new WindowSizeClass("STANDARD", 5, ISmModel.VERSION_0300, new c("STANDARD", new b(), new d(), new e()));
        STANDARD = r105;
        WindowSizeClass r110 = new WindowSizeClass(EffectConstants.NORMAL, 6, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ICE_CONNECTED_TIME, new c(EffectConstants.NORMAL, new b(), new d(), new e()));
        NORMAL = r110;
        WindowSizeClass r111 = new WindowSizeClass("LARGE", 7, 1024, new c("LARGE", new b(), new d(), new e()));
        LARGE = r111;
        WindowSizeClass r106 = new WindowSizeClass("OVERSIZE", 8, 1366, new c("OVERSIZE", new b(), new d(), new e()));
        OVERSIZE = r106;
        f403746a = new WindowSizeClass[]{r100, r101, r102, r103, r104, r105, r110, r111, r106};
    }

    public final c getBaseGridConfig() {
        return this.baseGridConfig;
    }

    public final int getDpSize() {
        return this.dpSize;
    }

    public WindowSizeClass(String r100, int r101, int r102, c r103) {
        super(r100, r101);
        this.dpSize = r102;
        this.baseGridConfig = r103;
    }
}
