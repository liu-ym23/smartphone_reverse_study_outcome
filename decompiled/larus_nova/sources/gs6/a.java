package gs6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lgs6/a;", "", "", "redDotStr", "Ljava/lang/String;", "getRedDotStr", "()Ljava/lang/String;", "setRedDotStr", "(Ljava/lang/String;)V", "grouponSchema", "getGrouponSchema", "setGrouponSchema", "", "freqDays", "I", "getFreqDays", "()I", "setFreqDays", "(I)V", "cacheDurationSeconds", "getCacheDurationSeconds", "setCacheDurationSeconds", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("cache_duration_seconds")
    private int cacheDurationSeconds;

    @SerializedName("freq_days")
    private int freqDays;

    @SerializedName("groupon_schema")
    private String grouponSchema;

    @SerializedName("red_dot_str")
    private String redDotStr;

    @SerializedName("track_params")
    private Map<String, String> trackParams;

    public final String toString() {
        return "GrouponDeskTopGuideBizData(redDotStr=" + this.redDotStr + ", grouponSchema=" + this.grouponSchema + ", freqDays=" + this.freqDays + ", cacheDurationSeconds=" + this.cacheDurationSeconds + ", trackParams=" + this.trackParams + ")";
    }

    public a() {
        this.freqDays = 3;
        this.cacheDurationSeconds = 300;
    }
}
