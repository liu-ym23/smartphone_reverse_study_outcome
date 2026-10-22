package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class e1 extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f561301a = null;

    static {
        f561301a = new e1();
    }

    public e1() {
        super("gmcp_interactive_play_auth_schema", "互动玩法实名认证链接", "aweme://aweme/cert/verify?scene=interactive_play&flow=webcast_common&use_new_api=true", "aweme://aweme/cert/verify?scene=interactive_play&flow=webcast_common&use_new_api=true");
    }
}
