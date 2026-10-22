package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class g4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g4 f561316a = null;

    static {
        f561316a = new g4();
    }

    public g4() {
        Boolean r100 = Boolean.TRUE;
        super("live_cooperation_partner_preview_interact_enable", "游戏组件是否支持预览流外显", r100, r100);
    }
}
