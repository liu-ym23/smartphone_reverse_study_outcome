package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import com.bytedance.gamecenter.base.multicdn.GDownloadMultiCDNConfig;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends SettingKey<GDownloadMultiCDNConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f561335a = null;

    static {
        f561335a = new k();
    }

    public k() {
        super("live_gamecp_download_sup_multi_cdn_abtest", "下载链路支持多cdn竞速下载", new GDownloadMultiCDNConfig(0, null, 3, null), new GDownloadMultiCDNConfig(0, null, 3, null));
    }
}
