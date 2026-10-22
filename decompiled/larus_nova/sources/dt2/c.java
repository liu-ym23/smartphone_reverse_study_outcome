package dt2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f469997a = null;

    static {
        f469997a = new c();
    }

    public c() {
        Boolean r100 = Boolean.TRUE;
        super("live_dsl_lynx_air_enable_partonlayout", "直播LynxAir是否开启part_on_layout", r100, r100, false);
    }
}
