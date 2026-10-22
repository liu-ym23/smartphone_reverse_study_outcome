package ll7;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    @SerializedName("cold_popups")
    private ArrayList<a> coldPopups;

    public static class a {

        @SerializedName("activity_id")
        private String activityId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_URL)
        private String activityUrl;

        public a() {
        }

        public final String toString() {
            return "ColdDataInfo{activityUrl='" + this.activityUrl + "', activityId='" + this.activityId + "'}";
        }

        public final String a() {
            return this.activityId;
        }

        public final String b() {
            return this.activityUrl;
        }
    }

    public b() {
    }

    public final ArrayList<a> a() {
        return this.coldPopups;
    }
}
