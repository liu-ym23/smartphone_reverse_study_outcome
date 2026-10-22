package com.larus.video.impl.douyin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f375771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f375772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f375773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f375774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f375775e;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f375771a, r101.f375771a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375772b, r101.f375772b) == true) goto L15;
        return false;
    L15:
        if (this.f375773c == r101.f375773c) goto L18;
        return false;
    L18:
        if (this.f375774d == r101.f375774d) goto L21;
        return false;
    L21:
        if (this.f375775e == r101.f375775e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f375771a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f375772b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f375773c == false) goto L13;
        int r106 = 1231;
    L15:
        return ((((r105 + r106) * 31) + this.f375774d) * 31) + this.f375775e;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoadMoreParamsFromVideoSource(search_id=" + this.f375771a + ", query=" + this.f375772b + ", has_more=" + this.f375773c + ", offset=" + this.f375774d + ", limit=" + this.f375775e + ')';
    }

    public x(int r100) {
        this.f375771a = "";
        this.f375772b = "";
        this.f375773c = false;
        this.f375774d = 0;
        this.f375775e = 1;
    }
}
