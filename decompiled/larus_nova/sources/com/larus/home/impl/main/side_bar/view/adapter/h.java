package com.larus.home.impl.main.side_bar.view.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344983a;

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f344983a, ((h) r100).f344983a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344983a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SideBarActionParams(previousPage=" + this.f344983a + ')';
    }

    public h(String r100) {
        this.f344983a = r100;
    }
}
