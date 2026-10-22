package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class z0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f472073a = null;

    static {
        f472073a = new z0();
    }

    public z0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_mode_contour_enable", "PK模式下是否绘制人像", r100, r100, true);
    }
}
