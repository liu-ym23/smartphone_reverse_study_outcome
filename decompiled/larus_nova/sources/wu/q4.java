package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class q4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q4 f561376a = null;

    static {
        f561376a = new q4();
    }

    public q4() {
        super("live_gcp_toolbar_preload_on_room_preload_enable", "直播间预加载下游戏小手柄预加载开关", Boolean.FALSE, Boolean.TRUE);
    }
}
