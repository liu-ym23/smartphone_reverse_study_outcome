package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 extends SettingKey<LiveFeatureConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f497176a = null;

    static {
        f497176a = new c0();
    }

    public c0() {
        super(LiveInitSettingKeys.LIVE_FEATURE_CONFIG, "直播特征包配置", new LiveFeatureConfig(), new LiveFeatureConfig());
    }
}
