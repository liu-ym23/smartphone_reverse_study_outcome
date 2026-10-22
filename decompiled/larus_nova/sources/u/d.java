package u;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f548090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f548091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f548092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f548093d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f548090a, r101.f548090a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548091b, r101.f548091b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548092c, r101.f548092c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548093d, r101.f548093d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f548090a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        T r104 = this.f548091b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        T r107 = this.f548092c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        T r110 = this.f548093d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Rect(start=" + this.f548090a + ", end=" + this.f548091b + ", top=" + this.f548092c + ", bottom=" + this.f548093d + ')';
    }

    public d(T r100, T r101, T r102, T r103) {
        this.f548090a = r100;
        this.f548091b = r101;
        this.f548092c = r102;
        this.f548093d = r103;
    }
}
