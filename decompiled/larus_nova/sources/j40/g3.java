package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f497228a = null;

    static {
        f497228a = new g3();
    }

    public g3() {
        Boolean r100 = Boolean.TRUE;
        super("live_strategy_sdk_enable", "策略SDK是否可用", r100, r100);
    }
}
