package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class j3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f497246a = null;

    static {
        f497246a = new j3();
    }

    public j3() {
        Boolean r100 = Boolean.FALSE;
        super("live_strategy_update_report_enable", "策略平台监听日志上报", r100, r100);
    }
}
