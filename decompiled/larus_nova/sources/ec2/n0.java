package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class n0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f472040a = null;

    static {
        f472040a = new n0();
    }

    public n0() {
        Boolean r100 = Boolean.FALSE;
        super("live_interaction_msg_enable_click", "是否开启点击交互", r100, r100);
    }
}
