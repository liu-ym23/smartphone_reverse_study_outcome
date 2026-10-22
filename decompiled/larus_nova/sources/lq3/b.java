package lq3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f510292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f510293b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f510292a, r101.f510292a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f510293b, r101.f510293b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a<T> r100 = this.f510292a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f510293b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentSceneParam(scene=" + this.f510292a + ", data=" + this.f510293b + ")";
    }

    public b(a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f510292a = r100;
        this.f510293b = r101;
    }
}
