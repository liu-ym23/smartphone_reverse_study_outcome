package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommentTopicConfig;

/* JADX INFO: loaded from: classes9.dex */
public final class f2 extends SettingKey<PSHighlightCommentTopicConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2 f536178a = null;

    static {
        f536178a = new f2();
    }

    public f2() {
        super("live_ps_highlight_comment_topic_config", "公屏强调区话题配置", new PSHighlightCommentTopicConfig(), new PSHighlightCommentTopicConfig(), true);
    }
}
