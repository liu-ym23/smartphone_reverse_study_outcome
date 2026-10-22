package iga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489757a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f489757a, ((d) r100).f489757a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f489757a.hashCode();
    }

    public final String toString() {
        return "ObricWindowInboxBackgroundStyle(colorToken=" + this.f489757a + ')';
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorToken");
        this.f489757a = r100;
    }
}
