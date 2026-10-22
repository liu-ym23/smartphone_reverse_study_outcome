package com.obric.assistant.settings.memory;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f392219a;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f392219a, ((x) r100).f392219a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f392219a.hashCode();
    }

    public final String toString() {
        return "ObricPersonalContextUiState(rows=" + this.f392219a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "rows");
        this.f392219a = r100;
    }

    public /* synthetic */ x(int r100) {
        this(CollectionsKt.emptyList());
    }
}
