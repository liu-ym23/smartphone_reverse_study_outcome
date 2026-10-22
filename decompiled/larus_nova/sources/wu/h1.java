package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class h1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f561319a = null;

    static {
        f561319a = new h1();
    }

    public h1() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_live_float_window_enabled", "直播小窗是否开启", r100, r100);
    }
}
