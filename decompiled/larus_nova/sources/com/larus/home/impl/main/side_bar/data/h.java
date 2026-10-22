package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f344500b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f344499a, r101.f344499a) == true) goto L12;
        return false;
    L12:
        if (this.f344500b == r101.f344500b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f344499a.hashCode() * 31;
        if (this.f344500b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HasProjectState(userId=" + this.f344499a + ", hasProject=" + this.f344500b + ')';
    }

    public h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f344499a = r100;
        this.f344500b = r101;
    }
}
