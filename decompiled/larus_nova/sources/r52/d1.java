package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class d1 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f536165a = null;

    static {
        f536165a = new d1();
    }

    public d1() {
        super("live_comment_mention_list_req_time_rate", "mention请求频控时间，单位ms", 200L, 200L);
    }
}
