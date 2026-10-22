package g81;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdk.config.UserInfoWidgetDebugConfig;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends SSettingKey<UserInfoWidgetDebugConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f480374a = null;

    static {
        f480374a = new g();
    }

    public g() {
        super("live_user_info_widget_debug_config", "左上角主播信息debug配置", new UserInfoWidgetDebugConfig(), new UserInfoWidgetDebugConfig());
    }
}
