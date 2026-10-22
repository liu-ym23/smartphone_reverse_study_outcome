package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class g3 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f536185a = null;

    static {
        f536185a = new g3();
    }

    public g3() {
        super("live_public_screen_history_first_fetch_timeout", "公屏历史评论首刷接口超时", 3000L, 3000L);
    }
}
