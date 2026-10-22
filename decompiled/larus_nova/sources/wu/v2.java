package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class v2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f561404a = null;

    static {
        f561404a = new v2();
    }

    public v2() {
        Boolean r100 = Boolean.TRUE;
        super("live_gamecp_card_cancel_show_not_in_the_foreground_enable", "讲解卡在后台不触发展示", r100, r100);
    }
}
