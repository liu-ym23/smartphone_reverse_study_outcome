package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p2 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f536238a = null;

    static {
        f536238a = new p2();
    }

    public p2() {
        super("live_public_screen_anchor_list_buffer_size", "公屏主播侧平铺消息缓存量", 100, 100);
    }
}
