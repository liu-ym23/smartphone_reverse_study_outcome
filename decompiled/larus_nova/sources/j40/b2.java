package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f497172a = null;

    static {
        f497172a = new b2();
    }

    public b2() {
        Boolean r100 = Boolean.TRUE;
        super("live_preview_paid_scope_enable_multi_camera", "预览流付费Scope服务支持子机位", r100, r100);
    }
}
