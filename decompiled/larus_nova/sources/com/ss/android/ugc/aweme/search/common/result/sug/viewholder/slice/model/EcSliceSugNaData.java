package com.ss.android.ugc.aweme.search.common.result.sug.viewholder.slice.model;

import com.ss.android.ugc.aweme.search.common.result.sug.model.SearchSugEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/viewholder/slice/model/EcSliceSugNaData;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcSliceSugNaData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchSugEntity f451952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f451953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f451954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f451955d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EcSliceSugNaData) == false) goto L14;
        EcSliceSugNaData r101 = (EcSliceSugNaData) r100;
        if (Intrinsics.areEqual(this.f451952a, r101.f451952a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f451953b, r101.f451953b) == true) goto L10;
        return false;
    L10:
        if (this.f451954c == r101.f451954c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f451955d, r101.f451955d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        SearchSugEntity r100 = this.f451952a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f451953b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f451954c) * 31;
        String r107 = this.f451955d;
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
        return "EcSliceSugNaData(entity=" + this.f451952a + ", requestId=" + this.f451953b + ", position=" + this.f451954c + ", keyword=" + this.f451955d + ")";
    }

    public EcSliceSugNaData(SearchSugEntity r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r103, "keyword");
        this.f451952a = r100;
        this.f451953b = r101;
        this.f451954c = r102;
        this.f451955d = r103;
    }
}
