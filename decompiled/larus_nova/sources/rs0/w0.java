package rs0;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.profile.api.setting.models.ProfileLoginGuideConfig;

/* JADX INFO: loaded from: classes47.dex */
public final class w0 extends SettingKey<ProfileLoginGuideConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f539087a = null;

    static {
        f539087a = new w0();
    }

    public w0() {
        super("login_guide_config", "登录配置", new ProfileLoginGuideConfig(), new ProfileLoginGuideConfig());
    }
}
