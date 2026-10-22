package com.larus.navigation.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f359695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359696b;

    public v() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f359695a, r101.f359695a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359696b, r101.f359696b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f359695a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f359696b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationStartHostContext(locationPrewarmIdentifier=" + this.f359695a + ", preloadedRouteDataJson=" + this.f359696b + ')';
    }

    public /* synthetic */ v(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public v(String r100, String r101) {
        this.f359695a = r100;
        this.f359696b = r101;
    }
}
