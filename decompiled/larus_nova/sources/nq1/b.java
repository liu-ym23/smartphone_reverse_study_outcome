package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f520090a = null;

    static {
        f520090a = new b();
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        super("live_vs_message_board_is_sync_to_story_enable", "留言墙是否支持投稿", r100, r100);
    }
}
