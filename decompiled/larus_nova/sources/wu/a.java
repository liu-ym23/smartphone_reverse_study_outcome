package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f561275a = null;

    static {
        f561275a = new a();
    }

    public a() {
        Boolean r100 = Boolean.TRUE;
        super("live_gamecp_air_compress_and_patch_update_config", "空压+增量总开关", r100, r100);
    }
}
