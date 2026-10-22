package i60;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f488350a = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f488350a = new SettingKey("live_cold_start_widget_load_opt", "冷启widget加载优化", r100, r100).setPreloadCache(true);
    }
}
