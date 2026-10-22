package com.ss.android.ugc.aweme.search.optimize;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeRequestContext;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchOptimizeRequestContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f453362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f453363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f453364e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchOptimizeRequestContext) == true) goto L8;
        return false;
    L8:
        SearchOptimizeRequestContext r101 = (SearchOptimizeRequestContext) r100;
        if (Intrinsics.areEqual(this.f453360a, r101.f453360a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f453361b, r101.f453361b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f453362c, r101.f453362c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f453363d, r101.f453363d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f453364e, r101.f453364e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f453360a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f453361b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f453362c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f453363d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f453364e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "SearchOptimizeRequestContext(keyword=" + this.f453360a + ", searchSource=" + this.f453361b + ", scene=" + this.f453362c + ", searchId=" + this.f453363d + ", subScene=" + this.f453364e + ')';
    }

    public SearchOptimizeRequestContext(String r100) {
        this.f453360a = null;
        this.f453361b = null;
        this.f453362c = r100;
        this.f453363d = null;
        this.f453364e = null;
    }
}
