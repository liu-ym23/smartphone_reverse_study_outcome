package com.bytedance.ies.argus.bean.config;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/e;", "", "", "riskInfoPageUrl", "Ljava/lang/String;", "getRiskInfoPageUrl", "()Ljava/lang/String;", "", "containerIdentityMap", "Ljava/util/Map;", "getContainerIdentityMap", "()Ljava/util/Map;", "", "enableFetchFeConfig", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "whitDomainList", "Ljava/util/List;", "c", "()Ljava/util/List;", "reportStrategyList", "getReportStrategyList", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("container_identity")
    @JsonAdapter(ContainerIdentityDeserializer.class)
    private final Map<String, String> containerIdentityMap;

    @SerializedName("enable_fetch_fe_config")
    private final boolean enableFetchFeConfig;

    @SerializedName("report_strategy_list")
    private final List<String> reportStrategyList;

    @SerializedName("risk_info_page_url")
    private final String riskInfoPageUrl;

    @SerializedName("white_domain")
    private final List<String> whitDomainList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.riskInfoPageUrl, r101.riskInfoPageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.containerIdentityMap, r101.containerIdentityMap) == true) goto L15;
        return false;
    L15:
        if (this.enableFetchFeConfig == r101.enableFetchFeConfig) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.whitDomainList, r101.whitDomainList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reportStrategyList, r101.reportStrategyList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.riskInfoPageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.containerIdentityMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.enableFetchFeConfig == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        List<String> r109 = this.whitDomainList;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.reportStrategyList;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerGlobalConstConfig(riskInfoPageUrl=" + this.riskInfoPageUrl + ", containerIdentityMap=" + this.containerIdentityMap + ", enableFetchFeConfig=" + this.enableFetchFeConfig + ", whitDomainList=" + this.whitDomainList + ", reportStrategyList=" + this.reportStrategyList + ')';
    }

    public e() {
        this.riskInfoPageUrl = null;
        this.containerIdentityMap = null;
        this.enableFetchFeConfig = false;
        this.whitDomainList = null;
        this.reportStrategyList = null;
    }

    public final boolean a() {
        return this.enableFetchFeConfig;
    }

    public final List<String> c() {
        return this.whitDomainList;
    }

    public final String b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return null;
    L12:
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L20;
        String r102 = this.riskInfoPageUrl;
        if (r102 != null) goto L17;
        return null;
    L17:
        return r102 + "?targetUrl=" + r100;
    L20:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }
}
