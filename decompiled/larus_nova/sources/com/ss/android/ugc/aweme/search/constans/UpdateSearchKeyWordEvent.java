package com.ss.android.ugc.aweme.search.constans;

import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/constans/UpdateSearchKeyWordEvent;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateSearchKeyWordEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchResultParam f452583a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UpdateSearchKeyWordEvent) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f452583a, ((UpdateSearchKeyWordEvent) r100).f452583a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        SearchResultParam r100 = this.f452583a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "UpdateSearchKeyWordEvent(param=" + this.f452583a + ")";
    }

    public UpdateSearchKeyWordEvent(SearchResultParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f452583a = r100;
    }
}
