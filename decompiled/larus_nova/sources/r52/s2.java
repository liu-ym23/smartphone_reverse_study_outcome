package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class s2 extends SettingKey<com.bytedance.android.livesdk.interactivity.api.settings.config.j0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f536256a = null;

    static {
        s2 r100 = new s2();
        f536256a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s2() {
        int r100 = com.bytedance.android.livesdk.interactivity.api.settings.config.j0.f133763a;
        super("live_public_screen_audience_dynamic_speed_config_v2", "公屏观众侧动态速度配置V2", com.bytedance.android.livesdk.interactivity.api.settings.config.j0.a.a(), com.bytedance.android.livesdk.interactivity.api.settings.config.j0.a.a());
    }
}
