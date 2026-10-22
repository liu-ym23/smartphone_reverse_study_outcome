package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f536207a = null;

    static {
        f536207a = new k1();
    }

    public k1() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_camera_vr_enable", "VR多机位", r100, r100);
    }
}
