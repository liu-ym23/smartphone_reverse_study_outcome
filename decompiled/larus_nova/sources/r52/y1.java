package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class y1 extends SettingKey<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f536288a = null;

    static {
        f536288a = new y1();
    }

    public y1() {
        Double r100 = Double.valueOf(0.25d);
        super("live_performance_min_limit", "实时性能min值", r100, r100, true);
    }
}
