package ifa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f489651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f489652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f489653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f489654h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f489647a, r101.f489647a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489648b, r101.f489648b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489649c, r101.f489649c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489650d, r101.f489650d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489651e, r101.f489651e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489652f, r101.f489652f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489653g, r101.f489653g) == true) goto L30;
        return false;
    L30:
        if (this.f489654h == r101.f489654h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f489647a.hashCode() * 31) + this.f489648b.hashCode()) * 31) + this.f489649c.hashCode()) * 31) + this.f489650d.hashCode()) * 31) + this.f489651e.hashCode()) * 31) + this.f489652f.hashCode()) * 31) + this.f489653g.hashCode()) * 31;
        if (this.f489654h == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LocalFileResult(id=" + this.f489647a + ", fileName=" + this.f489648b + ", fileType=" + this.f489649c + ", path=" + this.f489650d + ", fileUri=" + this.f489651e + ", lightIcon=" + this.f489652f + ", darkIcon=" + this.f489653g + ", showPlayAudioButton=" + this.f489654h + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "fileType");
        Intrinsics.checkNotNullParameter(r103, "path");
        Intrinsics.checkNotNullParameter(r104, "fileUri");
        Intrinsics.checkNotNullParameter(r105, "lightIcon");
        Intrinsics.checkNotNullParameter(r106, "darkIcon");
        this.f489647a = r100;
        this.f489648b = r101;
        this.f489649c = r102;
        this.f489650d = r103;
        this.f489651e = r104;
        this.f489652f = r105;
        this.f489653g = r106;
        this.f489654h = r107;
    }
}
