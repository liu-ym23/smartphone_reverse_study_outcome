package com.larus.navigation.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f359691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f359692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f359693c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f359691a, r101.f359691a) == true) goto L12;
        return false;
    L12:
        if (this.f359692b == r101.f359692b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359693c, r101.f359693c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f359691a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f359692b) * 31;
        String r104 = this.f359693c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationRouteUpdateRequestResult(routeUpdateId=" + this.f359691a + ", code=" + this.f359692b + ", message=" + this.f359693c + ')';
    }

    public r(String r100, int r101, String r102) {
        this.f359691a = r100;
        this.f359692b = r101;
        this.f359693c = r102;
    }
}
