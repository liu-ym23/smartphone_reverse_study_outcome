package com.ss.android.ugc.aweme.search.dynamic.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/LayoutInfo;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LayoutInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f452648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f452649c;

    public LayoutInfo() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LayoutInfo) == true) goto L8;
        return false;
    L8:
        LayoutInfo r101 = (LayoutInfo) r100;
        if (this.f452647a == r101.f452647a) goto L12;
        return false;
    L12:
        if (this.f452648b == r101.f452648b) goto L15;
        return false;
    L15:
        if (this.f452649c == r101.f452649c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f452647a * 31) + this.f452648b) * 31;
        if (this.f452649c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LayoutInfo(targetWidth=" + this.f452647a + ", targetHeight=" + this.f452648b + ", needSyncToFe=" + this.f452649c + ')';
    }

    public LayoutInfo(int r100) {
        this.f452647a = 0;
        this.f452648b = -1;
        this.f452649c = false;
    }
}
