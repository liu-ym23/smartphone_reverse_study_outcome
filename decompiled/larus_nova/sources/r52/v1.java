package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class v1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f536273a = null;

    static {
        f536273a = new v1();
    }

    public v1() {
        Boolean r100 = Boolean.TRUE;
        super("live_new_chat_channel_mention_enable", "边看边聊融合版Mention开关", r100, r100);
    }
}
