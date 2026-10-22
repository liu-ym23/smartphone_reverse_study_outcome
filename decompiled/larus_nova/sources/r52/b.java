package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f536151a = null;

    static {
        f536151a = new b();
    }

    public b() {
        super("live_ai_action_factor_update_interval", "ai回复因子更新间隔", 3000L, 3000L);
    }
}
