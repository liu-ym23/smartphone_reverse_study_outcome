package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureEventFilterConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 extends SettingKey<LiveFeatureEventFilterConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f497182a = null;

    static {
        f497182a = new d0();
    }

    public d0() {
        super("live_feature_event_filter_config", "直播特征包埋点过滤配置", new LiveFeatureEventFilterConfig(), new LiveFeatureEventFilterConfig());
    }
}
