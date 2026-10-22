package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class w1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w1 f497316a = null;

    static {
        f497316a = new w1();
    }

    public w1() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PLAYER_LAYOUT_FIX_STATUSBAR, "播放器布局修复statusbar的高度问题", r100, r100);
    }
}
