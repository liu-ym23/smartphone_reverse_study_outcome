package sh6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f541971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f541972b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f541971a, ((d) r100).f541971a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f541971a.hashCode();
    }

    public final String toString() {
        return "Some(value=" + this.f541971a + ')';
    }

    @Override // sh6.b
    public final boolean a() {
        return this.f541972b;
    }

    public d(T r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f541971a = r100;
        this.f541972b = true;
    }
}
