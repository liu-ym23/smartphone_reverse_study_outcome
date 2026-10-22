package v77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class n {

    @SerializedName("jump_notification_settings_page_timeout")
    public final long jumpNotificationSettingsPageTimeout;

    @SerializedName("return_app_page_from_notification_settings_page_timeout")
    public final long returnAppPageFromNotificationSettingsPageTimeout;

    @SerializedName("sys_dialog_show_timeout")
    public final long sysDialogShowTimeout;

    @SerializedName("sys_open_notification_max_time_cost")
    public final long sysOpenNotificationMaxTimeCost;

    public n() {
        this.sysOpenNotificationMaxTimeCost = 2000;
        this.sysDialogShowTimeout = 2000;
        this.jumpNotificationSettingsPageTimeout = 2000;
        this.returnAppPageFromNotificationSettingsPageTimeout = 10000;
    }
}
