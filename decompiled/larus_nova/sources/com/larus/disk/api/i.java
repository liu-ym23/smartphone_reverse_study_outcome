package com.larus.disk.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f330537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f330538b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f330537a, r101.f330537a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330538b, r101.f330538b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f330537a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f330538b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DiskRegisteredCacheUsage(totalBytes=" + this.f330537a + ", entries=" + this.f330538b + ')';
    }

    public i(Long r100, List<h> r101) {
        Intrinsics.checkNotNullParameter(r101, "entries");
        this.f330537a = r100;
        this.f330538b = r101;
    }
}
