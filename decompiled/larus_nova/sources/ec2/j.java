package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f472027a = null;

    static {
        f472027a = new j();
    }

    public j() {
        Boolean r100 = Boolean.FALSE;
        super("live_carnival_danmaku_debug", "狂欢弹幕调试开关", r100, r100);
    }
}
