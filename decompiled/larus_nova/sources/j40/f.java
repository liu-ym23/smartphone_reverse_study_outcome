package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends SettingKey<LivePreviewWormholePredictConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f497193a = null;

    static {
        f r100 = new f();
        f497193a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public f() {
        super("live_ai_preview_wormhole_config", "直播端智能外流预拉流配置", new LivePreviewWormholePredictConfig(), new LivePreviewWormholePredictConfig());
    }
}
