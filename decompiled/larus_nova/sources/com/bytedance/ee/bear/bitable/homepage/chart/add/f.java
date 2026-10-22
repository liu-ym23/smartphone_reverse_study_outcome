package com.bytedance.ee.bear.bitable.homepage.chart.add;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<rs4.b> f212410a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f212410a, ((f) r100).f212410a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f212410a.hashCode();
    }

    public final String toString() {
        return "FetchBitableSuccess(dashboards=" + this.f212410a + ')';
    }

    public f(List<rs4.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dashboards");
        this.f212410a = r100;
    }
}
