package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f472048a = null;

    public q() {
        super("live_interest_kp_max_select_count", "最多可以选择几个兴趣kp", 3, 3);
    }

    static {
        f472048a = new q();
    }
}
