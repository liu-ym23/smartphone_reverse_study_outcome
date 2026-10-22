package ps1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lps1/a;", "", "", "pushDelay", "J", "getPushDelay", "()J", "feedInterval", "getFeedInterval", "", "fixRtcMediaPlayerAnr", "Z", "getFixRtcMediaPlayerAnr", "()Z", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("feed_interval")
    private final long feedInterval;

    @SerializedName("fix_rtc_media_player_anr")
    private final boolean fixRtcMediaPlayerAnr;

    @SerializedName("push_delay")
    private final long pushDelay;

    public a() {
        this.feedInterval = 20;
        this.fixRtcMediaPlayerAnr = true;
    }
}
