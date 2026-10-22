package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f536199a = null;

    static {
        f536199a = new j();
    }

    public j() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_public_screen_ai_message_enable_audio", "电台模式是否开启公屏助手", r100, r100);
    }
}
