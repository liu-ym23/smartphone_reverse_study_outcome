package com.obric.assistant.settings;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q0> f392085b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f392084a, r101.f392084a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392085b, r101.f392085b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f392084a.hashCode() * 31) + this.f392085b.hashCode();
    }

    public final String toString() {
        return "GroupUiModel(id=" + this.f392084a + ", items=" + this.f392085b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r100, List<? extends q0> r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f392084a = r100;
        this.f392085b = r101;
    }
}
