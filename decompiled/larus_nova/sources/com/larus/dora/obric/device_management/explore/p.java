package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o> f339550b;

    public p() {
        boolean r100 = false;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f339549a == r101.f339549a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339550b, r101.f339550b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f339549a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f339550b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricExploreState(loading=" + this.f339549a + ", sections=" + this.f339550b + ')';
    }

    public /* synthetic */ p(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r101 & 2) == 0) goto L8;
        List r102 = CollectionsKt.emptyList();
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public p(boolean r100, List<o> r101) {
        Intrinsics.checkNotNullParameter(r101, "sections");
        this.f339549a = r100;
        this.f339550b = r101;
    }
}
