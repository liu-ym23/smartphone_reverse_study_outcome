package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class r0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f472052a = null;

    static {
        f472052a = new r0();
    }

    public r0() {
        Boolean r100 = Boolean.TRUE;
        super("live_interactivity_performance_enable", "互动性能埋点上报", r100, r100);
    }
}
