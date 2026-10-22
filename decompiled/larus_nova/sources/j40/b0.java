package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f497170a = null;

    static {
        f497170a = new b0();
    }

    public b0() {
        Boolean r100 = Boolean.TRUE;
        super("live_external_force_remove_container", "强制移除容器", r100, r100, true);
    }
}
