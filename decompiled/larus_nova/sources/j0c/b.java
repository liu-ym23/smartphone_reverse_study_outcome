package j0c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496844a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f496844a, ((b) r100).f496844a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f496844a.hashCode();
    }

    public final String toString() {
        return this.f496844a;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f496844a = r100;
    }
}
