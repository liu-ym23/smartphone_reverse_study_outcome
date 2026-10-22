package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class g1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f472020a = null;

    static {
        f472020a = new g1();
    }

    public g1() {
        Boolean r100 = Boolean.FALSE;
        super("public_screen_heat_print_test_log", "公屏热度打印测试日志（仅在localtest生效）", r100, r100);
    }
}
