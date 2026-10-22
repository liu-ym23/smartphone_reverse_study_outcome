package o72;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class b {

    @SerializedName("cold_room_interval_max_message_size")
    public int intervalMaxMessageSize;

    @SerializedName("cold_room_interval_time")
    public int intervalTime;

    public b() {
        this.intervalTime = 30;
        this.intervalMaxMessageSize = 60;
    }
}
