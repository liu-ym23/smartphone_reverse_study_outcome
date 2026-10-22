package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class y1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f561421a = null;

    static {
        f561421a = new y1();
    }

    public y1() {
        Boolean r100 = Boolean.TRUE;
        super("game_explain_card_logic_dynamic_data_opt", "讲解卡逻辑动态化，数据透传，不解析", r100, r100);
    }
}
