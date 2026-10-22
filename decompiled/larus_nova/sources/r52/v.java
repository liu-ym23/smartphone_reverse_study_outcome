package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class v extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f536271a = null;

    static {
        f536271a = new v();
    }

    public v() {
        super("live_comment_action_factor_update_interval", "发评因子更新间隔", 10000L, 10000L);
    }
}
