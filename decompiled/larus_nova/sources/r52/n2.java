package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class n2 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f536226a = null;

    static {
        f536226a = new n2();
    }

    public n2() {
        super("live_public_screen_anchor_fold_buffer_size", "公屏主播侧折叠消息缓存量", 32, 32);
    }
}
