package u77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    @SerializedName("enable_alliance_report")
    public boolean enableAllianceReport;

    @SerializedName("enable_back_to_fore_notification_report")
    public boolean enableBackToForeNotificationReport;

    @SerializedName("enable_original_reporting")
    public boolean enableOriginalReporting;

    @SerializedName("enable_polling")
    public boolean enablePolling;

    @SerializedName("enable_reporting_timing")
    public boolean enableReportingTiming;

    @SerializedName("polling_interval")
    public int pollingInterval;

    public l() {
        this.enableOriginalReporting = true;
    }
}
