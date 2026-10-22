package com.ss.android.ugc.aweme.poi.perf;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/perf/PoiLynxPreloadRule;", "", "", b.f276366p, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/ss/android/ugc/aweme/poi/perf/PoiLynxPreloadUrlConfig;", "urls", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "preCreateCount", "I", "b", "()I", "", "preCreateAsync", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiLynxPreloadRule {

    @SerializedName("pre_create_async")
    private final boolean preCreateAsync;

    @SerializedName("pre_create_count")
    private final int preCreateCount;

    @SerializedName(b.f276366p)
    private final String rule;

    @SerializedName("pre_load_config")
    private final List<PoiLynxPreloadUrlConfig> urls;

    public PoiLynxPreloadRule() {
        this(null, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiLynxPreloadRule) == true) goto L8;
        return false;
    L8:
        PoiLynxPreloadRule r101 = (PoiLynxPreloadRule) r100;
        if (Intrinsics.areEqual(this.rule, r101.rule) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urls, r101.urls) == true) goto L15;
        return false;
    L15:
        if (this.preCreateCount == r101.preCreateCount) goto L18;
        return false;
    L18:
        if (this.preCreateAsync == r101.preCreateAsync) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.rule;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<PoiLynxPreloadUrlConfig> r104 = this.urls;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.preCreateCount) * 31;
        if (this.preCreateAsync == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiLynxPreloadRule(rule=" + this.rule + ", urls=" + this.urls + ", preCreateCount=" + this.preCreateCount + ", preCreateAsync=" + this.preCreateAsync + ')';
    }

    public final boolean a() {
        return this.preCreateAsync;
    }

    public final int b() {
        return this.preCreateCount;
    }

    public final String c() {
        return this.rule;
    }

    public final List<PoiLynxPreloadUrlConfig> d() {
        return this.urls;
    }

    public PoiLynxPreloadRule(List r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = 3;
    L8:
        this.rule = null;
        this.urls = r100;
        this.preCreateCount = r101;
        this.preCreateAsync = false;
    }
}
