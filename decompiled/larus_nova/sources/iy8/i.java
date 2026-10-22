package iy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f496584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496585b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f496584a, r101.f496584a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496585b, r101.f496585b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f496584a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f496585b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "FeatureSelectorOptionItem(id=" + this.f496584a + ", optionText=" + this.f496585b + ')';
    }

    public i() {
        this(-1L, "");
    }

    public i(Long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "optionText");
        this.f496584a = r100;
        this.f496585b = r101;
    }
}
