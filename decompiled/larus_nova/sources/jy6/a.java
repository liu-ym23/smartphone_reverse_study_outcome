package jy6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500948a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f500948a, ((a) r100).f500948a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f500948a.hashCode();
    }

    public final String toString() {
        return "PoiFeedLynxCardSyncDataEvent(param=" + this.f500948a + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f500948a = r100;
    }
}
