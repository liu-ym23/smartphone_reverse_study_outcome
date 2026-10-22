package u00;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class b {

    @SerializedName("latest_ban_record")
    private a mLatestBanRecord;

    public static class a {

        @SerializedName("ban_count")
        private int banCount;

        @SerializedName("ban_duration")
        private int banDuration;

        @SerializedName("ban_reason")
        private String banReason;

        @SerializedName("ban_time")
        private long banTime;

        @SerializedName("is_banned_forever")
        private boolean isBannedForever;

        @SerializedName("log_id")
        private long logId;

        public a() {
        }
    }

    public b() {
    }
}
