package com.ss.android.ugc.aweme.search.common.topsection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerRenderIntent;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketBannerRenderIntent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MarketBannerStatus f452228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MarketBannerStatus f452229b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MarketBannerRenderIntent) == false) goto L10;
        MarketBannerRenderIntent r101 = (MarketBannerRenderIntent) r100;
        if (Intrinsics.areEqual(this.f452228a, r101.f452228a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f452229b, r101.f452229b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MarketBannerStatus r100 = this.f452228a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        MarketBannerStatus r104 = this.f452229b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MarketBannerRenderIntent(newStatus=" + this.f452228a + ", lastStatus=" + this.f452229b + ")";
    }

    public MarketBannerRenderIntent(MarketBannerStatus r100, MarketBannerStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "newStatus");
        this.f452228a = r100;
        this.f452229b = r101;
    }
}
