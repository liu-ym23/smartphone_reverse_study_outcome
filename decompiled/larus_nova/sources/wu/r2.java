package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class r2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2 f561380a = null;

    static {
        f561380a = new r2();
    }

    public r2() {
        Boolean r100 = Boolean.TRUE;
        super("live_cooperation_partner_rule_card_enable", "是否支持展示讲解卡规则卡", r100, r100);
    }
}
