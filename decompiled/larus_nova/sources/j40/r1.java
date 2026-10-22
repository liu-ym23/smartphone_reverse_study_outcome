package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class r1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f497291a = null;

    static {
        f497291a = new r1();
    }

    public r1() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PAD_BACKUP_DISABLE_OPT, "兜底关掉直播pad优化的开关，默认关着的，打开了就回滚", r100, r100);
    }
}
