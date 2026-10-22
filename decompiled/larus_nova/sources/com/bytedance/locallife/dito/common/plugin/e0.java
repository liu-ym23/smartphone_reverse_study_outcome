package com.bytedance.locallife.dito.common.plugin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f257569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f257570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f257571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f257572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f257573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f257574g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f257568a, r101.f257568a) == true) goto L12;
        return false;
    L12:
        if (this.f257569b == r101.f257569b) goto L15;
        return false;
    L15:
        if (this.f257570c == r101.f257570c) goto L18;
        return false;
    L18:
        if (this.f257571d == r101.f257571d) goto L21;
        return false;
    L21:
        if (this.f257572e == r101.f257572e) goto L24;
        return false;
    L24:
        if (this.f257573f == r101.f257573f) goto L27;
        return false;
    L27:
        if (this.f257574g == r101.f257574g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f257568a.hashCode() * 31;
        int r101 = 1231;
        if (this.f257569b == false) goto L5;
        int r102 = 1231;
    L6:
        long r103 = this.f257570c;
        int r104 = (((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.f257571d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        if (this.f257572e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f257573f == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f257574g == true) goto L23;
        r101 = 1237;
    L23:
        return r110 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VirtualRefreshParam(schema=" + this.f257568a + ", showLoading=" + this.f257569b + ", timeoutMill=" + this.f257570c + ", refreshPageWhenTimeout=" + this.f257571d + ", finishCurrentPageOnBackPress=" + this.f257572e + ", cancellableOnBackPressed=" + this.f257573f + ", cancellableOnTouch=" + this.f257574g + ')';
    }

    public e0(String r100, boolean r101, long r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f257568a = r100;
        this.f257569b = r101;
        this.f257570c = r102;
        this.f257571d = r103;
        this.f257572e = r104;
        this.f257573f = r105;
        this.f257574g = r106;
    }
}
