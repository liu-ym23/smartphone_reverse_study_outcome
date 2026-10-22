package id7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f489339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f489340b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f489339a, r101.f489339a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489340b, r101.f489340b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f489339a.hashCode() * 31) + this.f489340b.hashCode();
    }

    public final String toString() {
        return "MethodModelBean(paramMode=" + this.f489339a + ", resultModel=" + this.f489340b + ')';
    }

    public b(Class<?> r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "paramMode");
        Intrinsics.checkNotNullParameter(r101, "resultModel");
        this.f489339a = r100;
        this.f489340b = r101;
    }
}
