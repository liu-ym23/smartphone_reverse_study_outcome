package com.larus.settings.ivy;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/ivy/HybridCommonConfig;", "", "<init>", "()V", "enableJSBAuth", "", "getEnableJSBAuth", "()Z", "authHostWhiteList", "", "", "getAuthHostWhiteList", "()Ljava/util/List;", "websiteHostWhiteList", "getWebsiteHostWhiteList", "uriIntentPackageWhiteList", "getUriIntentPackageWhiteList", "enableAddingFragmentQueryCompact", "getEnableAddingFragmentQueryCompact", "displayZoomControls", "getDisplayZoomControls", "appendCommonParamsHostAllowList", "getAppendCommonParamsHostAllowList", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("append_common_params_host_allow_list")
    private final List<String> appendCommonParamsHostAllowList;

    @SerializedName("jsb_auth_host_white_list")
    private final List<String> authHostWhiteList;

    @SerializedName("display_zoom_controls")
    private final boolean displayZoomControls;

    @SerializedName("enable_adding_fragment_query_compact")
    private final boolean enableAddingFragmentQueryCompact;

    @SerializedName("jsb_auth_enabled")
    private final boolean enableJSBAuth;

    @SerializedName("uri_intent_package_white_list")
    private final List<String> uriIntentPackageWhiteList;

    @SerializedName("website_host_white_list")
    private final List<String> websiteHostWhiteList;

    public a() {
        this.enableJSBAuth = true;
        ArrayList<String> r100 = e.f368543a;
        this.authHostWhiteList = e.f368544b;
        this.websiteHostWhiteList = e.f368545c;
        this.uriIntentPackageWhiteList = new ArrayList();
        this.enableAddingFragmentQueryCompact = true;
        Map<String, String> r101 = ft9.d.f478795a;
        this.appendCommonParamsHostAllowList = ft9.d.f478796b;
    }

    public final List<String> a() {
        return this.appendCommonParamsHostAllowList;
    }

    public final List<String> b() {
        return this.authHostWhiteList;
    }

    public final boolean c() {
        return this.displayZoomControls;
    }

    public final boolean d() {
        return this.enableAddingFragmentQueryCompact;
    }

    public final boolean e() {
        return this.enableJSBAuth;
    }

    public final List<String> f() {
        return this.uriIntentPackageWhiteList;
    }

    public final List<String> g() {
        return this.websiteHostWhiteList;
    }
}
