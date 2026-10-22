package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f345406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f345407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f345408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f345409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f345410e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f345406a, r101.f345406a) == true) goto L12;
        return false;
    L12:
        if (this.f345407b == r101.f345407b) goto L15;
        return false;
    L15:
        if (this.f345408c == r101.f345408c) goto L18;
        return false;
    L18:
        if (this.f345409d == r101.f345409d) goto L21;
        return false;
    L21:
        if (this.f345410e == r101.f345410e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f345406a.hashCode() * 31;
        long r101 = this.f345407b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f345408c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f345409d;
        return ((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f345410e;
    }

    public final String toString() {
        return "HumanFeedItem(id=" + this.f345406a + ", onTopRankTimeSeconds=" + this.f345407b + ", rankTimeSeconds=" + this.f345408c + ", contentVersion=" + this.f345409d + ", badgeCount=" + this.f345410e + ')';
    }

    public final boolean b() {
        if (this.f345407b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long a() {
        if (b() == false) goto L6;
        return this.f345407b;
    L6:
        return this.f345408c;
    }

    public d(String r100, long r101, long r102, long r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f345406a = r100;
        this.f345407b = r101;
        this.f345408c = r102;
        this.f345409d = r103;
        this.f345410e = r104;
    }
}
