package com.ss.android.ugc.aweme.search.common.topsection;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerVHWithIdentifier;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketBannerVHWithIdentifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.ViewHolder f452234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f452235b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MarketBannerVHWithIdentifier) == false) goto L10;
        MarketBannerVHWithIdentifier r101 = (MarketBannerVHWithIdentifier) r100;
        if (Intrinsics.areEqual(this.f452234a, r101.f452234a) == true) goto L8;
        return false;
    L8:
        if (this.f452235b == r101.f452235b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        RecyclerView.ViewHolder r100 = this.f452234a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f452235b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "MarketBannerVHWithIdentifier(viewHolder=" + this.f452234a + ", viewType=" + this.f452235b + ")";
    }

    public MarketBannerVHWithIdentifier(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        this.f452234a = r100;
        this.f452235b = r101;
    }
}
