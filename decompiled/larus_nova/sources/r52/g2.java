package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;

/* JADX INFO: loaded from: classes9.dex */
public final class g2 extends SettingKey<PSHighlightCommonConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f536184a = null;

    static {
        f536184a = new g2();
    }

    public g2() {
        super("live_ps_highlight_common_config", "公屏强调区通用配置", new PSHighlightCommonConfig(), new PSHighlightCommonConfig(), true);
    }
}
