package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class l1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f472035a = null;

    static {
        f472035a = new l1();
    }

    public l1() {
        Boolean r100 = Boolean.FALSE;
        super("live_user_enter_debug_log", "飘屏消息新排队逻辑调试日志开关", r100, r100);
    }
}
