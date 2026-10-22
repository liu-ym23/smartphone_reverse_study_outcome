package com.larus.paging;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w0<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PagingSource.b.c<Key, Value>> f363932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f363933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f363934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f363935d;

    public final int hashCode() {
        int r100 = this.f363932a.hashCode();
        Integer r101 = this.f363933b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) + this.f363934c.hashCode()) + this.f363935d;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PagingState(pages=" + this.f363932a + ", anchorPosition=" + this.f363933b + ", config=" + this.f363934c + ", leadingPlaceholderCount=" + this.f363935d + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof w0) == false) goto L13;
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.f363932a, r101.f363932a) == false) goto L13;
        if (Intrinsics.areEqual(this.f363933b, r101.f363933b) == false) goto L13;
        if (Intrinsics.areEqual(this.f363934c, r101.f363934c) == false) goto L13;
        if (this.f363935d != r101.f363935d) goto L13;
        return true;
    L13:
        return false;
    }

    public w0(List<PagingSource.b.c<Key, Value>> r100, Integer r101, j0 r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "pages");
        Intrinsics.checkNotNullParameter(r102, "config");
        this.f363932a = r100;
        this.f363933b = r101;
        this.f363934c = r102;
        this.f363935d = r103;
    }
}
