package oq1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Loq1/b;", "", "", "skipBannerData", "Z", "b", "()Z", "setSkipBannerData", "(Z)V", "releaseWebview", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("release_webview")
    private final boolean releaseWebview;

    @SerializedName("skip_banner_data")
    private boolean skipBannerData;

    public b() {
        this.skipBannerData = true;
        this.releaseWebview = true;
    }

    public final boolean a() {
        return this.releaseWebview;
    }

    public final boolean b() {
        return this.skipBannerData;
    }
}
