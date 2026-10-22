package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/l;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "enableShareCookieDomainForceHttps", "b", "", "", "forceHttpsHostList", "Ljava/util/List;", "d", "()Ljava/util/List;", "excludeHostList", "c", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_share_cookie_domain_force_https")
    private final boolean enableShareCookieDomainForceHttps;

    @SerializedName("exclude_host_list")
    private final List<String> excludeHostList;

    @SerializedName("extra_force_https_host_list")
    private final List<String> forceHttpsHostList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.enableShareCookieDomainForceHttps == r101.enableShareCookieDomainForceHttps) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.forceHttpsHostList, r101.forceHttpsHostList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.excludeHostList, r101.excludeHostList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableShareCookieDomainForceHttps == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        List<String> r104 = this.forceHttpsHostList;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        List<String> r108 = this.excludeHostList;
        if (r108 == null) goto L19;
        r105 = r108.hashCode();
    L19:
        return r107 + r105;
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ForceHttpsSetting(enable=" + this.enable + ", enableShareCookieDomainForceHttps=" + this.enableShareCookieDomainForceHttps + ", forceHttpsHostList=" + this.forceHttpsHostList + ", excludeHostList=" + this.excludeHostList + ')';
    }

    public l() {
        this.enable = false;
        this.enableShareCookieDomainForceHttps = false;
        this.forceHttpsHostList = null;
        this.excludeHostList = null;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableShareCookieDomainForceHttps;
    }

    public final List<String> c() {
        return this.excludeHostList;
    }

    public final List<String> d() {
        return this.forceHttpsHostList;
    }
}
