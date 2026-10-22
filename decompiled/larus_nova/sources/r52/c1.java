package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f536159a = null;

    static {
        f536159a = new c1();
    }

    public c1() {
        super("live_mention_msg_show_factor_update_interval", "mention消息展示因子更新间隔，单位ms", 3000L, 3000L);
    }
}
