package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f345417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f345418b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f345417a, r101.f345417a) == true) goto L12;
        return false;
    L12:
        if (this.f345418b == r101.f345418b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f345417a.hashCode() * 31;
        if (this.f345418b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HumanFeedPage(items=" + this.f345417a + ", hasMore=" + this.f345418b + ')';
    }

    public f(List<e> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f345417a = r100;
        this.f345418b = r101;
    }
}
