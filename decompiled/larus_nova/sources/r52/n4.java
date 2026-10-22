package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class n4 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f536228a = null;

    static {
        f536228a = new n4();
    }

    public n4() {
        super("live_batch_action_factor_update_interval", "批量刷新消息因子更新间隔", 3000L, 3000L);
    }
}
