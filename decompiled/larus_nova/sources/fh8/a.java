package fh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f477066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw8.k f477067b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f477066a == r101.f477066a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477067b, r101.f477067b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f477066a * 31) + this.f477067b.hashCode();
    }

    public final String toString() {
        return "ClickedMarkdownLinkInfo(position=" + this.f477066a + ", linkInfo=" + this.f477067b + ')';
    }

    public a(int r100, lw8.k r101) {
        Intrinsics.checkNotNullParameter(r101, "linkInfo");
        this.f477066a = r100;
        this.f477067b = r101;
    }
}
