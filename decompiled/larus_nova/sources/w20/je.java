package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lw20/je;", "", "", "track_label", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTrack_label", "(Ljava/lang/String;)V", "", "track_url_list", "Ljava/util/List;", "d", "()Ljava/util/List;", "setTrack_url_list", "(Ljava/util/List;)V", "creative_id", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCreative_id", "log_extra", "b", "setLog_extra", "ad_id", "getAd_id", "setAd_id", "group_id", "getGroup_id", "setGroup_id", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class je {

    @SerializedName("ad_id")
    private String ad_id;

    @SerializedName("creative_id")
    private String creative_id;

    @SerializedName("group_id")
    private String group_id;

    @SerializedName("log_extra")
    private String log_extra;

    @SerializedName("track_label")
    private String track_label;

    @SerializedName("track_url_list")
    private List<String> track_url_list;

    public je() {
    }

    public final String a() {
        return this.creative_id;
    }

    public final String b() {
        return this.log_extra;
    }

    public final String c() {
        return this.track_label;
    }

    public final List<String> d() {
        return this.track_url_list;
    }
}
