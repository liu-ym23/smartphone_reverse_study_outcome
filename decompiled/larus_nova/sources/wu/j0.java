package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class j0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f561330a = null;

    static {
        f561330a = new j0();
    }

    public j0() {
        Boolean r100 = Boolean.FALSE;
        super("live_download_get_install_status_parse_package_info", "下载器判断安装状态是否需要解析packageInfo", r100, r100);
    }
}
