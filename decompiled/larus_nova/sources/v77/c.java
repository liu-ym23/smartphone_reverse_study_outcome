package v77;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class c {

    @SerializedName("auto_back_after_user_open_switch")
    public boolean autoBackAfterUserOpenSwitch;

    @SerializedName("auto_dismiss_after_user_open_switch")
    public boolean autoDismissAfterUserOpenSwitch;

    @SerializedName("auto_dismiss_after_user_touch_screen")
    public boolean autoDismissAfterUserTouchScreen;

    @SerializedName("detect_switch_status_interval")
    public long detectSwitchStatusInterval;

    @SerializedName("disable_window_touchable_mode")
    public int disableWindowTouchableMode;

    @SerializedName("enable_gif_permission_page")
    public int enableGifPermissionPage;

    @SerializedName("enable_in_landscape_mode")
    public boolean enableInLandscapeMode;

    @SerializedName("gif_mode")
    public int gifMode;

    @SerializedName("max_display_duration")
    public long maxDisplayDuration;

    @SerializedName("miui_config")
    public h miuiGifConfig;

    @SerializedName("settings_page_open_mode")
    public int notificationSettingsPageOpenMode;

    @SerializedName("notification_settings_uri")
    public List<String> notificationSettingsUri;

    @SerializedName("override_pending_transition")
    public boolean overridePendingTransition;

    @SerializedName("verify_window_size")
    public boolean verifyWindowSize;

    @SerializedName("wait_system_settings_resume")
    public long waitSystemSettingsResume;

    @SerializedName("window_size_mode")
    public int windowSizeMode;

    public c() {
        this.enableGifPermissionPage = 0;
        this.waitSystemSettingsResume = 200;
        this.maxDisplayDuration = 2000;
        this.autoDismissAfterUserTouchScreen = true;
        this.disableWindowTouchableMode = 1;
        this.gifMode = 1;
        this.windowSizeMode = 1;
        this.enableInLandscapeMode = false;
        this.autoBackAfterUserOpenSwitch = false;
        this.autoDismissAfterUserOpenSwitch = false;
        this.detectSwitchStatusInterval = 300;
        this.overridePendingTransition = false;
        this.verifyWindowSize = false;
        this.notificationSettingsPageOpenMode = 1;
    }
}
