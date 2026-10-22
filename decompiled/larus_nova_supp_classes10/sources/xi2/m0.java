package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0014"}, d2 = {"Lxi2/m0;", "", "", "trackEvent", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTrackEvent", "(Ljava/lang/String;)V", "", "trackParams", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "bcmTrackParams", "a", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("bcm_track_params")
    private final Map<String, String> bcmTrackParams;

    @SerializedName("track_event")
    private String trackEvent;

    @SerializedName("track_params")
    private Map<String, String> trackParams;

    public m0() {
    }

    public final Map<String, String> a() {
        return this.bcmTrackParams;
    }

    public final String b() {
        return this.trackEvent;
    }

    public final Map<String, String> c() {
        return this.trackParams;
    }
}
