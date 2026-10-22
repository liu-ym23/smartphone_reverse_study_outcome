package com.bytedance.ee.bear.contract.route.parcelable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f217165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f217166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f217168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f217169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f217170f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f217165a, r101.f217165a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f217166b, r101.f217166b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217167c, r101.f217167c) == true) goto L18;
        return false;
    L18:
        if (this.f217168d == r101.f217168d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f217169e, r101.f217169e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217170f, r101.f217170f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f217165a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f217166b.hashCode()) * 31) + this.f217167c.hashCode()) * 31) + this.f217168d) * 31;
        String r104 = this.f217169e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f217170f;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WikiCreateInfo(space_id=" + this.f217165a + ", wiki_token=" + this.f217166b + ", obj_token=" + this.f217167c + ", obj_type=" + this.f217168d + ", title=" + this.f217169e + ", url=" + this.f217170f + ')';
    }

    public l(String r100, String r101, String r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "wiki_token");
        Intrinsics.checkNotNullParameter(r102, "obj_token");
        this.f217165a = r100;
        this.f217166b = r101;
        this.f217167c = r102;
        this.f217168d = r103;
        this.f217169e = r104;
        this.f217170f = r105;
    }
}
