package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a2 extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f536148a = null;

    static {
        f536148a = new a2();
    }

    public a2() {
        Float r100 = Float.valueOf(0.85f);
        super("live_popup_perf_optimize_hide_percent", "面板对比公屏高度百分比", r100, r100);
    }
}
