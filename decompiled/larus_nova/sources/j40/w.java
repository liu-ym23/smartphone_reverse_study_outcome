package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f497314a = null;

    static {
        f497314a = new w();
    }

    public w() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_perform_accessibility", "在非无障碍模式下，关注按钮被点击了的日志上报兜底开关", r100, r100, true);
    }
}
