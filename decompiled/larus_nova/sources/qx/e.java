package qx;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class e {

    @SerializedName("confidence")
    private float confidence;

    @SerializedName("definite")
    private boolean definite;

    @SerializedName("end_time")
    private int endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private int startTime;

    @SerializedName("text")
    private String text;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private List<f> words;

    public e() {
    }
}
