package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class r3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r3 f561381a = null;

    static {
        f561381a = new r3();
    }

    public r3() {
        Boolean r100 = Boolean.TRUE;
        super("gamecp_explain_card_disable_when_user_closed", "游戏联运讲解卡预约卡 用户主动关闭，单次进房不重复展示", r100, r100);
    }
}
