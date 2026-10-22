package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class u2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f561398a = null;

    static {
        f561398a = new u2();
    }

    public u2() {
        Boolean r100 = Boolean.TRUE;
        super("live_gamecp_card_cancel_show_is_clean_mode_enable", "讲解卡在清屏下不触发展示", r100, r100);
    }
}
