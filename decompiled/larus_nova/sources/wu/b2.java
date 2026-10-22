package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class b2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f561284a = null;

    static {
        f561284a = new b2();
    }

    public b2() {
        Boolean r100 = Boolean.TRUE;
        super("gmcp_jump_game_cancel_package_name", "schema跳转游戏时是否取消包名校验", r100, r100);
    }
}
