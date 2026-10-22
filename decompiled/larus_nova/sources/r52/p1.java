package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f536237a = null;

    static {
        f536237a = new p1();
    }

    public p1() {
        Boolean r100 = Boolean.TRUE;
        super("live_new_chat_channel_enable_greeting_anim", "聊天频道打招呼动画开关", r100, r100);
    }
}
