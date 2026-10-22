package com.larus.dora.impl.dynamic.quicknote;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f59.a> f335268a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f335268a, ((k) r100).f335268a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f335268a.hashCode();
    }

    public final String toString() {
        return "QuickNoteUiState(itemUiStates=" + this.f335268a + ')';
    }

    public k(List<f59.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemUiStates");
        this.f335268a = r100;
    }
}
