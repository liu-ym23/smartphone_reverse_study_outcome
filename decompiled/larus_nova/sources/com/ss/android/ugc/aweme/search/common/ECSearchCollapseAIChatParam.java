package com.ss.android.ugc.aweme.search.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECSearchCollapseAIChatParam;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCollapseAIChatParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f451387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f451388b;

    public ECSearchCollapseAIChatParam() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchCollapseAIChatParam) == false) goto L10;
        ECSearchCollapseAIChatParam r101 = (ECSearchCollapseAIChatParam) r100;
        if (Intrinsics.areEqual(this.f451387a, r101.f451387a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f451388b, r101.f451388b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f451387a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f451388b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSearchCollapseAIChatParam(source=" + this.f451387a + ", page=" + this.f451388b + ")";
    }

    public ECSearchCollapseAIChatParam(String r100, String r101) {
        this.f451387a = r100;
        this.f451388b = r101;
    }
}
