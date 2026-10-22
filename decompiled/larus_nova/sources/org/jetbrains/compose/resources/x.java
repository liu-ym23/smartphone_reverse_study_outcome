package org.jetbrains.compose.resources;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.plural.PluralCategory;

/* JADX INFO: loaded from: classes42.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<PluralCategory, String> f525880a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f525880a, ((x) r100).f525880a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f525880a.hashCode();
    }

    public final String toString() {
        return "Plurals(items=" + this.f525880a + ")";
    }

    public x(Map<PluralCategory, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f525880a = r100;
    }
}
