package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x2 f497322a = null;

    static {
        f497322a = new x2();
    }

    public x2() {
        Boolean r100 = Boolean.FALSE;
        super("live_strategy_async_log_setting", "策略SDK发送异步log", r100, r100);
    }
}
