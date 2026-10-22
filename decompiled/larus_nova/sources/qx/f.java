package qx;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class f {

    @SerializedName("confidence")
    private float confidence;

    @SerializedName("end_time")
    private int endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private int startTime;

    @SerializedName("text")
    private String text;

    public f() {
    }
}
