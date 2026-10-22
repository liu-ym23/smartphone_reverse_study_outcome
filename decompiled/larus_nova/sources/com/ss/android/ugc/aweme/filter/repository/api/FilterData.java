package com.ss.android.ugc.aweme.filter.repository.api;

import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/filter/repository/api/FilterData;", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FilterData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f450844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<EffectCategoryResponse, List<Object>>> f450845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FilterData) == false) goto L10;
        FilterData r101 = (FilterData) r100;
        if (Intrinsics.areEqual(this.f450844a, r101.f450844a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450845b, r101.f450845b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<Object> r100 = this.f450844a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Pair<EffectCategoryResponse, List<Object>>> r104 = this.f450845b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterData(filters=" + this.f450844a + ", filterTable=" + this.f450845b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterData(List<Object> r100, List<? extends Pair<EffectCategoryResponse, ? extends List<Object>>> r101) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        Intrinsics.checkNotNullParameter(r101, "filterTable");
        this.f450844a = r100;
        this.f450845b = r101;
    }
}
