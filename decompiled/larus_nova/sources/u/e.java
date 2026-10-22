package u;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f548094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f548095b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f548094a, r101.f548094a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548095b, r101.f548095b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f548094a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        T r104 = this.f548095b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Size(width=" + this.f548094a + ", height=" + this.f548095b + ')';
    }

    public e(T r100, T r101) {
        this.f548094a = r100;
        this.f548095b = r101;
    }
}
