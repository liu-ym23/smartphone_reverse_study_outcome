package com.larus.search.impl.combine;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f367590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f367591c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f367589a, r101.f367589a) == true) goto L12;
        return false;
    L12:
        if (this.f367590b == r101.f367590b) goto L15;
        return false;
    L15:
        if (this.f367591c == r101.f367591c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f367589a.hashCode() * 31;
        int r101 = 1231;
        if (this.f367590b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f367591c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SectionTitleItem(title=" + this.f367589a + ", showAll=" + this.f367590b + ", showTopDivider=" + this.f367591c + ')';
    }

    public i0(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f367589a = r100;
        this.f367590b = r101;
        this.f367591c = r102;
    }
}
