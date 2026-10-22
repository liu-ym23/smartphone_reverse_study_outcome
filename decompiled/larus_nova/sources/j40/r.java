package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f497289a = null;

    static {
        f497289a = new r();
    }

    public r() {
        Boolean r100 = Boolean.TRUE;
        super("live_douyin_status_bar_config", "抖音直播间状态栏与主端保持一致", r100, r100);
    }
}
