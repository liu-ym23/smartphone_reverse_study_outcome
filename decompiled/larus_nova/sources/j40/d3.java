package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class d3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f497185a = null;

    static {
        f497185a = new d3();
    }

    public d3() {
        super("live_strategy_handle_room_async", "handle room 异步", Boolean.FALSE, Boolean.TRUE);
    }
}
