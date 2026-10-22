package com.bytedance.ies.argus.bean;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/argus/bean/s;", "", "", "", "enableTeaReportCidList", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "", "aspectMaxLimit", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "", "teaEventMapping", "f", "reportStrategyList", "e", "", "enableReportAllThirdWeb", "Z", "c", "()Z", "Lcom/bytedance/ies/argus/bean/z;", "webShouldInterceptRequest", "Lcom/bytedance/ies/argus/bean/z;", ce.f26391f, "()Lcom/bytedance/ies/argus/bean/z;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String[]> f246044a = null;

    @SerializedName("aspect_max_limit")
    private final Map<String, Integer> aspectMaxLimit;

    @SerializedName("enable_report_all_third_web")
    private final boolean enableReportAllThirdWeb;

    @SerializedName("enable_tea_cid")
    private final List<String> enableTeaReportCidList;

    @SerializedName("report_strategy")
    private final List<String> reportStrategyList;

    @SerializedName("event_mapping")
    private final Map<String, String[]> teaEventMapping;

    @SerializedName("web_should_intercept_request")
    private final z webShouldInterceptRequest;

    public static final class a {
    }

    public s() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.enableTeaReportCidList, r101.enableTeaReportCidList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aspectMaxLimit, r101.aspectMaxLimit) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.teaEventMapping, r101.teaEventMapping) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reportStrategyList, r101.reportStrategyList) == true) goto L21;
        return false;
    L21:
        if (this.enableReportAllThirdWeb == r101.enableReportAllThirdWeb) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.webShouldInterceptRequest, r101.webShouldInterceptRequest) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.enableTeaReportCidList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Integer> r104 = this.aspectMaxLimit;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String[]> r107 = this.teaEventMapping;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.reportStrategyList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.enableReportAllThirdWeb == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        z r115 = this.webShouldInterceptRequest;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportConfig(enableTeaReportCidList=" + this.enableTeaReportCidList + ", aspectMaxLimit=" + this.aspectMaxLimit + ", teaEventMapping=" + this.teaEventMapping + ", reportStrategyList=" + this.reportStrategyList + ", enableReportAllThirdWeb=" + this.enableReportAllThirdWeb + ", webShouldInterceptRequest=" + this.webShouldInterceptRequest + ')';
    }

    static {
        f246044a = MapsKt.mapOf(TuplesKt.to("argus_web_android", new String[]{ArgusContainerAspect.CONTAINER_CREATED.getStringValue(), ArgusWebViewAspect.LOAD_URL.getStringValue(), ArgusWebViewAspect.WEB_REDIRECT.getStringValue()}));
    }

    public final boolean b() {
        List<String> r100 = this.enableTeaReportCidList;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains("*");
    }

    public final Map<String, Integer> a() {
        return this.aspectMaxLimit;
    }

    public final boolean c() {
        return this.enableReportAllThirdWeb;
    }

    public final List<String> d() {
        return this.enableTeaReportCidList;
    }

    public final List<String> e() {
        return this.reportStrategyList;
    }

    public final Map<String, String[]> f() {
        return this.teaEventMapping;
    }

    public final z g() {
        return this.webShouldInterceptRequest;
    }

    public s(Object r100) {
        Map<String, String[]> r101 = f246044a;
        this.enableTeaReportCidList = null;
        this.aspectMaxLimit = null;
        this.teaEventMapping = r101;
        this.reportStrategyList = null;
        this.enableReportAllThirdWeb = false;
        this.webShouldInterceptRequest = null;
    }
}
