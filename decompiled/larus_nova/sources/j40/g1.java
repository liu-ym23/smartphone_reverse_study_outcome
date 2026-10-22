package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f497226a = null;

    static {
        f497226a = new g1();
    }

    public g1() {
        super("live_landscape_sensor_enable", "直播间横屏状态下是否适配重力感应", Boolean.FALSE, Boolean.TRUE, true);
    }
}
