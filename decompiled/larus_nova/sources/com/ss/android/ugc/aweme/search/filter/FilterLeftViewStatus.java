package com.ss.android.ugc.aweme.search.filter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/FilterLeftViewStatus;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterLeftViewStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f452890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f452891b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FilterLeftViewStatus) == false) goto L10;
        FilterLeftViewStatus r101 = (FilterLeftViewStatus) r100;
        if (this.f452890a == r101.f452890a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f452891b, r101.f452891b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f452890a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.f452891b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "FilterLeftViewStatus(visible=" + this.f452890a + ", width=" + this.f452891b + ")";
    }

    public FilterLeftViewStatus(boolean r100, Integer r101) {
        this.f452890a = r100;
        this.f452891b = r101;
    }
}
