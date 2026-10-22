package com.bytedance.ies.bullet.base.settings;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b#\u0010\u0004\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/n;", "", "", "enableSafeWebJSBAuth", "Z", "d", "()Z", "setEnableSafeWebJSBAuth", "(Z)V", "", "", "", "privateDomains", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "setPrivateDomains", "(Ljava/util/Map;)V", "enableJSBAuthV3", "c", "setEnableJSBAuthV3", "enableAutoMatchUrl", "b", "setEnableAutoMatchUrl", "Lcom/bytedance/ies/bullet/base/settings/q;", "customMethodAuthTypeSetting", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCustomMethodAuthTypeSetting", "Lcom/bytedance/ies/bullet/base/settings/o;", "jsbRequestCheck", "Lcom/bytedance/ies/bullet/base/settings/o;", "f", "()Lcom/bytedance/ies/bullet/base/settings/o;", "setJsbRequestCheck", "(Lcom/bytedance/ies/bullet/base/settings/o;)V", "jsbAuthOnlyUseHostNamespace", "e", "setJsbAuthOnlyUseHostNamespace", "getJsbAuthOnlyUseHostNamespace$annotations", "()V", "<init>", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("custom_method_auth_type_setting")
    private Map<String, q> customMethodAuthTypeSetting;

    @SerializedName("enable_auto_match_url")
    private boolean enableAutoMatchUrl;

    @SerializedName("enable_jsb_auth_v3")
    private boolean enableJSBAuthV3;

    @SerializedName("enable_safe_web_jsb_auth")
    private boolean enableSafeWebJSBAuth;

    @SerializedName("jsb_auth_only_use_host_namespace")
    private boolean jsbAuthOnlyUseHostNamespace;

    @SerializedName("jsb_request_check")
    private o jsbRequestCheck;

    @SerializedName("private_domains")
    private Map<String, String[]> privateDomains;

    public n() {
        this.enableSafeWebJSBAuth = true;
        this.privateDomains = MapsKt.emptyMap();
        this.customMethodAuthTypeSetting = MapsKt.emptyMap();
        this.jsbRequestCheck = new o();
        this.jsbAuthOnlyUseHostNamespace = true;
    }

    public final Map<String, q> a() {
        return this.customMethodAuthTypeSetting;
    }

    public final boolean b() {
        return this.enableAutoMatchUrl;
    }

    public final boolean c() {
        return this.enableJSBAuthV3;
    }

    public final boolean d() {
        return this.enableSafeWebJSBAuth;
    }

    public final boolean e() {
        return this.jsbAuthOnlyUseHostNamespace;
    }

    public final o f() {
        return this.jsbRequestCheck;
    }

    public final Map<String, String[]> g() {
        return this.privateDomains;
    }
}
