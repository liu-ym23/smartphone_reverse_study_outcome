package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class l extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f472033a = null;

    static {
        f472033a = new l();
    }

    public l() {
        Boolean r100 = Boolean.FALSE;
        super("live_carnival_message_frequncy_debug", "狂欢消息和弹幕频率调试开关", r100, r100);
    }
}
