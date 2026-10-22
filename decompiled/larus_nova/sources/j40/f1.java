package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class f1 extends SettingKey<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f497195a = null;

    static {
        f497195a = new f1();
    }

    public f1() {
        Double r100 = Double.valueOf(-1.0d);
        super("live_landscape_scroll_angle", "直播横屏内流滑动角度调整", r100, r100);
    }
}
