package uk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f550562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f550563c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f550561a, r101.f550561a) == true) goto L12;
        return false;
    L12:
        if (this.f550562b == r101.f550562b) goto L15;
        return false;
    L15:
        if (this.f550563c == r101.f550563c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f550561a.hashCode() * 31;
        int r101 = 1231;
        if (this.f550562b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f550563c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ElapsedBlockHeaderModel(title=" + this.f550561a + ", isCollapsible=" + this.f550562b + ", initiallyCollapsed=" + this.f550563c + ')';
    }

    public b(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f550561a = r100;
        this.f550562b = r101;
        this.f550563c = r102;
    }
}
