package ku1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f506184a = null;

    static {
        f506184a = new f();
    }

    public f() {
        super("live_strategy_fetch_delay_ms", "策略中心策略请求延迟时间", 5000L, 5000L);
    }
}
