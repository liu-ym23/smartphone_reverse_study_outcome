package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q2 f497287a = null;

    static {
        f497287a = new q2();
    }

    public q2() {
        Boolean r100 = Boolean.TRUE;
        super("live_scrollable_angle_offset", "直播内流滑动角度热区调整开关", r100, r100);
    }
}
