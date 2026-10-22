package com.bytedance.bdnavigationsdk.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200111c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f200109a, r101.f200109a) == true) goto L12;
        return false;
    L12:
        if (this.f200110b == r101.f200110b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200111c, r101.f200111c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f200109a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f200110b) * 31;
        String r104 = this.f200111c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RouteUpdateRequestResult(routeUpdateId=" + this.f200109a + ", code=" + this.f200110b + ", message=" + this.f200111c + ")";
    }

    public w(String r100, int r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this.f200109a = r100;
        this.f200110b = r101;
        this.f200111c = r102;
    }
}
