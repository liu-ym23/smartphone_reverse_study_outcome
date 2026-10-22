package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q3 f497288a = null;

    static {
        f497288a = new q3();
    }

    public q3() {
        Boolean r100 = Boolean.TRUE;
        super("live_touch_conflict", "直播内流滑动冲突", r100, r100);
    }
}
