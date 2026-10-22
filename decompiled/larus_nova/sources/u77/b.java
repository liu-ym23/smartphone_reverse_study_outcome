package u77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class b {

    @SerializedName("clear_all_notification_after_launch")
    public boolean clearAllNotificationAfterLaunch;

    @SerializedName("enable_notification_clear")
    public boolean enableNotificationClear;

    public b() {
        this.enableNotificationClear = false;
        this.clearAllNotificationAfterLaunch = false;
    }
}
