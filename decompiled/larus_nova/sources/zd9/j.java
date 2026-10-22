package zd9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R f571483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f571484b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f571483a, ((j) r100).f571483a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        R r100 = this.f571483a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SelectorKey(key=" + this.f571483a + ')';
    }

    public j(R r100) {
        this.f571483a = r100;
    }
}
