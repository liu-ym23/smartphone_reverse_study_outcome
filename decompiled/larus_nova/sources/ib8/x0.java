package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489139b;

    public x0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f489138a, r101.f489138a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489139b, r101.f489139b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f489138a.hashCode() * 31) + this.f489139b.hashCode();
    }

    public final String toString() {
        return "TopHeadRenderInfo(title=" + this.f489138a + ", icon=" + this.f489139b + ')';
    }

    public /* synthetic */ x0(int r100) {
        this("", "");
    }

    public x0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "icon");
        this.f489138a = r100;
        this.f489139b = r101;
    }
}
