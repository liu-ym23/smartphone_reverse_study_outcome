package du0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Ldu0/a;", "", "", "enabled", "Z", "e", "()Z", "setEnabled", "(Z)V", "", "beforeUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setBeforeUrl", "(Ljava/lang/String;)V", "afterUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAfterUrl", "joinClubEnabled", "getJoinClubEnabled", "setJoinClubEnabled", "joinClubUrl", "getJoinClubUrl", "setJoinClubUrl", "anchorEnabled", "b", "setAnchorEnabled", "anchorUrl", "c", "setAnchorUrl", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("after_url")
    private String afterUrl;

    @SerializedName("anchor_enabled")
    private boolean anchorEnabled;

    @SerializedName("anchor_url")
    private String anchorUrl;

    @SerializedName("before_url")
    private String beforeUrl;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("join_club_enabled")
    private boolean joinClubEnabled;

    @SerializedName("join_club_url")
    private String joinClubUrl;

    public a() {
    }

    public final String a() {
        return this.afterUrl;
    }

    public final boolean b() {
        return this.anchorEnabled;
    }

    public final String c() {
        return this.anchorUrl;
    }

    public final String d() {
        return this.beforeUrl;
    }

    public final boolean e() {
        return this.enabled;
    }
}
