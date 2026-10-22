package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class i3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f561327a = null;

    static {
        f561327a = new i3();
    }

    public i3() {
        Boolean r100 = Boolean.TRUE;
        super("gamecp_single_room_data_fix_config", "解决单例直播间数据的问题，通过uniqueKey获取准确的直播间数据", r100, r100);
    }
}
