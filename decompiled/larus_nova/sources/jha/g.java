package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g<S extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k<S> f499135b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f499134a, r101.f499134a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499135b, r101.f499135b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f499134a.hashCode() * 31) + this.f499135b.hashCode();
    }

    public final String toString() {
        return this.f499134a + '-' + this.f499135b.getClass().getSimpleName();
    }

    public final k<S> getType() {
        return this.f499135b;
    }

    public g(String r100, k<S> r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f499134a = r100;
        this.f499135b = r101;
    }
}
