package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class v1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f561403a = null;

    static {
        f561403a = new v1();
    }

    public v1() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_video_zoom_window_enabled", "短视频播放页缩放是否开启", r100, r100);
    }
}
