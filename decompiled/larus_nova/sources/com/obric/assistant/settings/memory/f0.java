package com.obric.assistant.settings.memory;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y> f392201a;

    public f0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f392201a, ((f0) r100).f392201a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f392201a.hashCode();
    }

    public final String toString() {
        return "ObricReferenceMemoryUiState(rows=" + this.f392201a + ')';
    }

    public f0(List<y> r100) {
        Intrinsics.checkNotNullParameter(r100, "rows");
        this.f392201a = r100;
    }

    public /* synthetic */ f0(int r100) {
        this(CollectionsKt.emptyList());
    }
}
