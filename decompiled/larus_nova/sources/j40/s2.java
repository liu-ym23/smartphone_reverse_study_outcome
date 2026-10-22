package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.b81;

/* JADX INFO: loaded from: classes45.dex */
public final class s2 extends SettingKey<b81> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f497297a = null;

    static {
        s2 r100 = new s2();
        f497297a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s2() {
        super("live_scroll_switch_item", "直播内流滑动期间切换画面调优", new b81(), new b81());
    }
}
