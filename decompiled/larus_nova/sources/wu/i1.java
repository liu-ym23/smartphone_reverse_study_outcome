package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class i1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f561325a = null;

    static {
        f561325a = new i1();
    }

    public i1() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_live_land_zoom_window_enabled", "直播横屏缩流是否开启", r100, r100);
    }
}
