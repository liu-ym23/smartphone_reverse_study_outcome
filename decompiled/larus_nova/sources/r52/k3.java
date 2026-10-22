package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k3 f536209a = null;

    static {
        f536209a = new k3();
    }

    public k3() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_lite_interaction_enable", "公屏轻交互框架开关", r100, r100);
    }
}
