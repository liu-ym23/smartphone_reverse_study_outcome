package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class d4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d4 f561298a = null;

    static {
        f561298a = new d4();
    }

    public d4() {
        Boolean r100 = Boolean.TRUE;
        super("live_gcp_im_common_params_config", "im消息不刷新公参问题修复开关", r100, r100);
    }
}
