package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class a2 extends SettingKey<LivePostClientSequenceConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f497166a = null;

    static {
        f497166a = new a2();
    }

    public a2() {
        super("live_post_client_sequence_config", "客户端实时特征序列上报配置", new LivePostClientSequenceConfig(), new LivePostClientSequenceConfig());
    }
}
