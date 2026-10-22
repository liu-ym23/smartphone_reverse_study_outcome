package ec2;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.s51;

/* JADX INFO: loaded from: classes9.dex */
public final class u0 extends SettingKey<s51> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f472061a = null;

    static {
        f472061a = new u0();
    }

    public u0() {
        super("live_match_message_config", "节目聚合、对抗消息降级配置", new s51(), new s51());
    }
}
