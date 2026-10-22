package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class s1 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f497296a = null;

    public s1() {
        super(LiveInitSettingKeys.LIVE_PAD_SETTING_MOCK, "pad 的setting 模拟", 0, 0);
    }

    static {
        f497296a = new s1();
    }
}
