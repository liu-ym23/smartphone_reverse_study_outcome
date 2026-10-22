package com.larus.disk.api;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f330527b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f330526a == r101.f330526a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330527b, r101.f330527b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330526a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f330527b.hashCode();
    }

    public final String toString() {
        return "DiskCacheBreakdownMetric(totalBytes=" + this.f330526a + ", categories=" + this.f330527b + ')';
    }

    public e(long r100, List<g> r101) {
        Intrinsics.checkNotNullParameter(r101, ReportCardMonitorPlugin.CATEGORIES);
        this.f330526a = r100;
        this.f330527b = r101;
    }
}
