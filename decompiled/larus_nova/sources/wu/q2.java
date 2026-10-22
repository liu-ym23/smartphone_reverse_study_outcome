package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class q2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q2 f561374a = null;

    static {
        f561374a = new q2();
    }

    public q2() {
        Boolean r100 = Boolean.TRUE;
        super("live_cooperation_partner_rule_card_downloading_enable", "是否支持展示下载中讲解卡", r100, r100);
    }
}
