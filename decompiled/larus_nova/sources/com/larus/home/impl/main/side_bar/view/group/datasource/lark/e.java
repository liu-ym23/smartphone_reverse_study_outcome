package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f345411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f345412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f345413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f345414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f345415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f345416f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f345411a, r101.f345411a) == true) goto L12;
        return false;
    L12:
        if (this.f345412b == r101.f345412b) goto L15;
        return false;
    L15:
        if (this.f345413c == r101.f345413c) goto L18;
        return false;
    L18:
        if (this.f345414d == r101.f345414d) goto L21;
        return false;
    L21:
        if (this.f345415e == r101.f345415e) goto L24;
        return false;
    L24:
        if (this.f345416f == r101.f345416f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f345411a.hashCode() * 31;
        long r101 = this.f345412b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f345413c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f345414d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.f345415e == false) goto L5;
        int r107 = 1231;
    L7:
        return ((r106 + r107) * 31) + this.f345416f;
    L5:
        r107 = 1237;
        goto L7
    }

    public final String toString() {
        return "HumanFeedMeta(id=" + this.f345411a + ", onTopRankTimeMillis=" + this.f345412b + ", rankTimeMillis=" + this.f345413c + ", contentVersion=" + this.f345414d + ", isRemoved=" + this.f345415e + ", badgeCount=" + this.f345416f + ')';
    }

    public e(String r100, long r101, long r102, long r103, boolean r104, int r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f345411a = r100;
        this.f345412b = r101;
        this.f345413c = r102;
        this.f345414d = r103;
        this.f345415e = r104;
        this.f345416f = r110;
    }
}
