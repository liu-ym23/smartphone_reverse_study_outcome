package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/d;", "", "", "configUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setConfigUrl", "(Ljava/lang/String;)V", "", "pollInterval", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setPollInterval", "(Ljava/lang/Long;)V", "Lorg/json/JSONArray;", "redirectInCurRouteWhiteList", "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "setRedirectInCurRouteWhiteList", "(Lorg/json/JSONArray;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("config_url")
    private String configUrl;

    @SerializedName("poll_interval")
    private Long pollInterval;

    @SerializedName("android_redirect_in_cur_route_white_list")
    private JSONArray redirectInCurRouteWhiteList;

    public d() {
        this.pollInterval = 0L;
    }

    public final String a() {
        return this.configUrl;
    }

    public final Long b() {
        return this.pollInterval;
    }

    public final JSONArray c() {
        return this.redirectInCurRouteWhiteList;
    }
}
