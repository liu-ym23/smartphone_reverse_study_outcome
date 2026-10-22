package x77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class b {

    @SerializedName("max_delay_time_in_mill")
    public long maxDelayTimeInMill;

    @SerializedName("min_delay_time_in_mill")
    public long minDelayTimeInMill;

    @SerializedName("opt_push_click_session_id")
    public boolean optPushClickSessionId;

    public b() {
        this.optPushClickSessionId = false;
        this.minDelayTimeInMill = 3000;
        this.maxDelayTimeInMill = 10000;
    }
}
