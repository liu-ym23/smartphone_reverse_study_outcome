package f7;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class d {

    @SerializedName("results")
    public List<a> result;

    public static class a {

        @SerializedName("end_time")
        public float endTime;

        @SerializedName("index")
        public int index;

        @SerializedName("is_interim")
        public boolean isInterim;

        @SerializedName(ILoadStallMonitor.START_TIME)
        public float startTime;

        @SerializedName("text")
        public String text;

        public a() {
        }
    }

    public d() {
    }
}
