package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f536163a = null;

    static {
        f536163a = new d();
    }

    public d() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_contour_enable", "主播端人像算法是否开启", r100, r100, true);
    }
}
