package com.bytedance.kmp.ec.yata.store.core;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f251733a;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f251733a, ((d) r100).f251733a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f251733a.hashCode();
    }

    public final String toString() {
        return "ProtocolMergeRulers(dataAsyncFieldKeys=" + this.f251733a + ')';
    }

    public d(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "dataAsyncFieldKeys");
        this.f251733a = r101;
    }
}
