package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class f3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f3 f561309a = null;

    static {
        f561309a = new f3();
    }

    public f3() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_should_lynx_card_url_add_report_params", "LynxUrl是否拼接report_params", r100, r100);
    }
}
