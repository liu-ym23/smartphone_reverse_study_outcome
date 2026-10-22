package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class x extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f472068a = null;

    static {
        f472068a = new x();
    }

    public x() {
        Boolean r100 = Boolean.TRUE;
        super("live_enter_anim_text_v2_support_aggregate", "进场动画text_v2支持聚合", r100, r100);
    }
}
