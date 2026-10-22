package e48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f470992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f470995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f470996g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f470990a, r101.f470990a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470991b, r101.f470991b) == true) goto L15;
        return false;
    L15:
        if (this.f470992c == r101.f470992c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470993d, r101.f470993d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470994e, r101.f470994e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f470995f, r101.f470995f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f470996g, r101.f470996g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f470990a.hashCode() * 31) + this.f470991b.hashCode()) * 31) + this.f470992c) * 31) + this.f470993d.hashCode()) * 31) + this.f470994e.hashCode()) * 31) + this.f470995f.hashCode()) * 31) + this.f470996g.hashCode();
    }

    public final String toString() {
        return "AccountRiskInfo(title=" + this.f470990a + ", content=" + this.f470991b + ", action=" + this.f470992c + ", h5Url=" + this.f470993d + ", toast=" + this.f470994e + ", successToast=" + this.f470995f + ", failToast=" + this.f470996g + ')';
    }

    public b(String r100, String r101, int r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r103, "h5Url");
        Intrinsics.checkNotNullParameter(r104, "toast");
        Intrinsics.checkNotNullParameter(r105, "successToast");
        Intrinsics.checkNotNullParameter(r106, "failToast");
        this.f470990a = r100;
        this.f470991b = r101;
        this.f470992c = r102;
        this.f470993d = r103;
        this.f470994e = r104;
        this.f470995f = r105;
        this.f470996g = r106;
    }
}
