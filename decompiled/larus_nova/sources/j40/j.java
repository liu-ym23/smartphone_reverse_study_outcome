package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveAudioTagConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends SettingKey<LiveAudioTagConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f497242a = null;

    static {
        f497242a = new j();
    }

    public j() {
        super("live_audiotag_config", "直播audiotag配置", new LiveAudioTagConfig(), new LiveAudioTagConfig());
    }
}
