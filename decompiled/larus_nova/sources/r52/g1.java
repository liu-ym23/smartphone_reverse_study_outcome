package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class g1 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f536183a = null;

    static {
        f536183a = new g1();
    }

    public g1() {
        super("live_message_replay_max_duration", "直播消息支持replay的最长时间", 0L, 0L);
    }
}
