package cu6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcu6/c;", "", "", "interceptMovie", "I", "getInterceptMovie", "()I", "", "", "interceptHostUrl", "Ljava/util/List;", "getInterceptHostUrl", "()Ljava/util/List;", "Lcu6/b;", "interceptOrderRule", "b", "interceptLiveHostUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("intercept_host_url")
    private final List<String> interceptHostUrl;

    @SerializedName("intercept_live_host_url")
    private final List<String> interceptLiveHostUrl;

    @SerializedName("intercept_movie")
    private final int interceptMovie;

    @SerializedName("intercept_order_rule")
    private final List<b> interceptOrderRule;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.interceptMovie == r101.interceptMovie) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interceptHostUrl, r101.interceptHostUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interceptOrderRule, r101.interceptOrderRule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.interceptLiveHostUrl, r101.interceptLiveHostUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.interceptMovie * 31;
        List<String> r101 = this.interceptHostUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<b> r105 = this.interceptOrderRule;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<String> r108 = this.interceptLiveHostUrl;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InterceptSettings(interceptMovie=" + this.interceptMovie + ", interceptHostUrl=" + this.interceptHostUrl + ", interceptOrderRule=" + this.interceptOrderRule + ", interceptLiveHostUrl=" + this.interceptLiveHostUrl + ')';
    }

    public c() {
        this.interceptMovie = 1;
        this.interceptHostUrl = null;
        this.interceptOrderRule = null;
        this.interceptLiveHostUrl = null;
    }

    public final List<String> a() {
        return this.interceptLiveHostUrl;
    }

    public final List<b> b() {
        return this.interceptOrderRule;
    }
}
