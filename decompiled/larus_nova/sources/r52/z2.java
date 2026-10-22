package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class z2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z2 f536294a = null;

    static {
        f536294a = new z2();
    }

    public z2() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_ban_request_focus", "公屏屏蔽requestFocus方法开关", r100, r100);
    }
}
