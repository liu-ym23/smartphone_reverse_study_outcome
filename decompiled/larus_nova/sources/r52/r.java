package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f536247a = null;

    static {
        f536247a = new r();
    }

    public r() {
        Boolean r100 = Boolean.TRUE;
        super("live_carnival_auto_test_enable", "活动功能自动化测试开关", r100, r100);
    }
}
