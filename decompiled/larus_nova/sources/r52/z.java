package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class z extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f536291a = null;

    static {
        f536291a = new z();
    }

    public z() {
        Boolean r100 = Boolean.TRUE;
        super("live_contour_can_draw_edge", "人脸是否开启描边绘制(部分机型不支持描边，兜底策略)", r100, r100, true);
    }
}
