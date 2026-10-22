package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class u2 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f536268a = null;

    static {
        f536268a = new u2();
    }

    public u2() {
        super("live_public_screen_audience_fold_buffer_size", "公屏观众侧折叠消息缓存量", 32, 32);
    }
}
