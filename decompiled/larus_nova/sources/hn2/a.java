package hn2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    @SerializedName("open_delay_time")
    public long openDelayTime;

    @SerializedName("open_status")
    public boolean openStatus;

    @SerializedName("open_url")
    public String openUrl;

    public a() {
    }

    public final String toString() {
        return "QueryRpOpenTimeData{openStatus=" + this.openStatus + ", openDelayTime=" + this.openDelayTime + ", openUrl='" + this.openUrl + "'}";
    }
}
