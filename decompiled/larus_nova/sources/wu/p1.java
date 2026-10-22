package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class p1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f561367a = null;

    static {
        f561367a = new p1();
    }

    public p1() {
        Boolean r100 = Boolean.TRUE;
        super("gamecp_opt_download_track_init_enable", "下载按钮埋点2.0框架初始化优化开关", r100, r100);
    }
}
