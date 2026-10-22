package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.settings.config.LiveAnchorTopicConfig;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends SettingKey<LiveAnchorTopicConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f536217a = null;

    static {
        f536217a = new m();
    }

    public m() {
        super("live_anchor_topic_config", "主播侧话题挂载需求开关", new LiveAnchorTopicConfig(), new LiveAnchorTopicConfig(), true);
    }
}
