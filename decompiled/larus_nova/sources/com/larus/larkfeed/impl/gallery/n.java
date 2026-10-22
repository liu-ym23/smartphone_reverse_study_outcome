package com.larus.larkfeed.impl.gallery;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<kza.m> f355254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f355255b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f355254a, r101.f355254a) == true) goto L12;
        return false;
    L12:
        if (this.f355255b == r101.f355255b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f355254a.hashCode() * 31) + this.f355255b;
    }

    public final String toString() {
        return "OpenFeishuGalleryPreviewItemWrapper(items=" + this.f355254a + ", enterIndex=" + this.f355255b + ')';
    }

    public n() {
        this(CollectionsKt.emptyList(), -1);
    }

    public n(List<kza.m> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f355254a = r100;
        this.f355255b = r101;
    }
}
