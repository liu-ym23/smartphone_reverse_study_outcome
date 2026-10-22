package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class x0 extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f472069a = null;

    static {
        f472069a = new x0();
    }

    public x0() {
        Float r100 = Float.valueOf(450.0f);
        super("live_open_asset_max_width_dp", "开通特效/入场Type9播放时的最大宽度", r100, r100);
    }
}
