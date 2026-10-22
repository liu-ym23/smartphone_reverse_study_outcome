package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class p2 extends SettingKey<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f497281a = null;

    static {
        f497281a = new p2();
    }

    public p2() {
        Double r100 = Double.valueOf(-1.0d);
        super("live_scrollable_angle", "直播内流滑动角度调整", r100, r100);
    }
}
