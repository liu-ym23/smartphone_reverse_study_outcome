package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478674d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f478671a, r101.f478671a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478672b, r101.f478672b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478673c, r101.f478673c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f478674d, r101.f478674d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f478671a.hashCode() * 31) + this.f478672b.hashCode()) * 31) + this.f478673c.hashCode()) * 31) + this.f478674d.hashCode();
    }

    public final String toString() {
        return "DoImageEditTrackParams(previousPage=" + this.f478671a + ", currentPage=" + this.f478672b + ", clickFrom=" + this.f478673c + ", enterMethod=" + this.f478674d + ')';
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "previousPage");
        Intrinsics.checkNotNullParameter("creation_detail", "currentPage");
        Intrinsics.checkNotNullParameter("creation_detail", "clickFrom");
        Intrinsics.checkNotNullParameter("ai_edit_picture_detail", "enterMethod");
        this.f478671a = r100;
        this.f478672b = "creation_detail";
        this.f478673c = "creation_detail";
        this.f478674d = "ai_edit_picture_detail";
    }
}
