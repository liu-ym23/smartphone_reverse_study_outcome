package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class v2 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f497312a = null;

    public v2() {
        super(LiveInitSettingKeys.LIVE_SKIN_PULL_TIMES_EVERY_DAY, "直播皮肤接口每天拉的次数", 0, 0);
    }

    static {
        f497312a = new v2();
    }
}
