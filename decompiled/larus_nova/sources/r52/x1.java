package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class x1 extends SettingKey<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f536283a = null;

    static {
        f536283a = new x1();
    }

    public x1() {
        Double r100 = Double.valueOf(0.55d);
        super("live_performance_max_limit", "实时性能max值", r100, r100, true);
    }
}
