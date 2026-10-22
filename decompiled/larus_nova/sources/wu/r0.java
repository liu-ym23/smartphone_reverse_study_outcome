package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class r0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f561378a = null;

    static {
        f561378a = new r0();
    }

    public r0() {
        Boolean r100 = Boolean.FALSE;
        super("cloud_game_interaction_real_game_reentry", "互动玩法实名，是否允许重复", r100, r100);
    }
}
