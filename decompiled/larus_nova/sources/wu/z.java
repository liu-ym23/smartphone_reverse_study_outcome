package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class z extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f561424a = null;

    static {
        f561424a = new z();
    }

    public z() {
        Boolean r100 = Boolean.TRUE;
        super("live_gamecp_opt_strategy_image_flash", "是否fix攻略模块图片闪烁问题", r100, r100);
    }
}
