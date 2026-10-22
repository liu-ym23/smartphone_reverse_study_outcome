package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f536201a = null;

    static {
        f536201a = new j1();
    }

    public j1() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_camera_extend_enable", "多机位能力", r100, r100);
    }
}
