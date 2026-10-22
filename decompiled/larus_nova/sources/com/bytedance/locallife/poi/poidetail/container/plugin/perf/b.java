package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f264143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.locallife.dito.performance.l f264144b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f264143a, r101.f264143a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f264144b, r101.f264144b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f264143a.hashCode() * 31) + this.f264144b.hashCode();
    }

    public final String toString() {
        return "PoiCardFmpInfoRecord(nodeTag=" + this.f264143a + ", fmpCardInfo=" + this.f264144b + ')';
    }

    public b(String r100, com.bytedance.locallife.dito.performance.l r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        Intrinsics.checkNotNullParameter(r101, "fmpCardInfo");
        this.f264143a = r100;
        this.f264144b = r101;
    }
}
