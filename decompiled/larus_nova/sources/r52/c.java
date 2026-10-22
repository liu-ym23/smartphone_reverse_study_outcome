package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f536157a = null;

    static {
        f536157a = new c();
    }

    public c() {
        Boolean r100 = Boolean.FALSE;
        super("live_ai_auto_reply_msg_show_single_line", "AI回复的消息展示单行的开关", r100, r100);
    }
}
