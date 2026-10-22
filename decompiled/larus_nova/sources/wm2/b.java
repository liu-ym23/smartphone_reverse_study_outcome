package wm2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class b {

    @SerializedName("anchor_rate_limit")
    public int anchorRateLimit;

    @SerializedName("audience_rate_limit")
    public int audienceRateLimit;

    @SerializedName("repeat_count")
    public int repeatCount;

    public b() {
        this.repeatCount = 10;
        this.anchorRateLimit = 60;
        this.audienceRateLimit = 60;
    }
}
