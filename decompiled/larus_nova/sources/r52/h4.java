package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class h4 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h4 f536192a = null;

    static {
        f536192a = new h4();
    }

    public h4() {
        super("live_toolbar_mask_view_interval", "当toolbar加载方式为2时，挤占超时时间，单位毫秒", 1000L, 1000L);
    }
}
