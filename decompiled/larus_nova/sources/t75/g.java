package t75;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f544892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f544894c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f544892a, r101.f544892a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544893b, r101.f544893b) == true) goto L15;
        return false;
    L15:
        if (this.f544894c == r101.f544894c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f544892a.hashCode() * 31) + this.f544893b.hashCode()) * 31;
        if (this.f544894c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DrivePreviewAiSelection(pageRange=" + this.f544892a + ", text=" + this.f544893b + ", isTruncated=" + this.f544894c + ')';
    }

    public g(d r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "pageRange");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f544892a = r100;
        this.f544893b = r101;
        this.f544894c = r102;
    }
}
