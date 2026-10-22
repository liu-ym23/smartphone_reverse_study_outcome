package org.jetbrains.compose.resources;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f525879a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f525879a, ((w) r100).f525879a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f525879a.hashCode();
    }

    public final String toString() {
        return "Array(items=" + this.f525879a + ")";
    }

    public w(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f525879a = r100;
    }
}
