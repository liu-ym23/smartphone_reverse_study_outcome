package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f536235a = null;

    static {
        f536235a = new p();
    }

    public p() {
        Boolean r100 = Boolean.FALSE;
        super("live_audience_contour_enable", "看播端是否开启绘制人像", r100, r100, true);
    }
}
