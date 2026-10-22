package com.ss.android.ugc.aweme.search.common.list.config;

import com.ss.android.ugc.aweme.search.common.saas.autoplay.AutoPlayConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/config/ESSaasCommonListConfig;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ESSaasCommonListConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoPlayConfig f451688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PreLoadMoreConfig f451689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TopSectionConfig f451690c;

    public ESSaasCommonListConfig() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ESSaasCommonListConfig) == false) goto L12;
        ESSaasCommonListConfig r101 = (ESSaasCommonListConfig) r100;
        if (Intrinsics.areEqual(this.f451688a, r101.f451688a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f451689b, r101.f451689b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f451690c, r101.f451690c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AutoPlayConfig r100 = this.f451688a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PreLoadMoreConfig r104 = this.f451689b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TopSectionConfig r107 = this.f451690c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ESSaasCommonListConfig(autoPlayConfig=" + this.f451688a + ", preloadMoreConfig=" + this.f451689b + ", topSectionConfig=" + this.f451690c + ")";
    }

    public ESSaasCommonListConfig(AutoPlayConfig r100, PreLoadMoreConfig r101, TopSectionConfig r102) {
        this.f451688a = r100;
        this.f451689b = r101;
        this.f451690c = r102;
    }
}
