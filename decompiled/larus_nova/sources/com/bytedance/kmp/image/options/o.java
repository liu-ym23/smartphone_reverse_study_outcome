package com.bytedance.kmp.image.options;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f252164a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f252164a, ((o) r100).f252164a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.bytedance.kmp.image.options.k
    public int getType() {
        return 1;
    }

    public final int hashCode() {
        return this.f252164a.hashCode();
    }

    public final String toString() {
        return "UrlSource(urlSourceUrls=" + this.f252164a + ')';
    }

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f252164a = new p(CollectionsKt.listOf(r100));
    }
}
