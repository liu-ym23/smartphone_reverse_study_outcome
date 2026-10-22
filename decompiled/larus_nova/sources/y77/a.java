package y77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class a {

    @SerializedName("last_report_time")
    public long lastReportTime;

    @SerializedName("last_signal_info")
    public String lastSignalInfo;

    public a() {
    }

    public a(String r100, long r101) {
        this.lastSignalInfo = r100;
        this.lastReportTime = r101;
    }
}
