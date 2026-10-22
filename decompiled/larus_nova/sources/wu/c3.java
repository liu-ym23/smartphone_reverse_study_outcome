package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class c3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c3 f561291a = null;

    static {
        f561291a = new c3();
    }

    public c3() {
        Boolean r100 = Boolean.FALSE;
        super("live_gamecp_download_disguised_progress_enable", "是否展示伪装进度条", r100, r100);
    }
}
