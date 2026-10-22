package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f568549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f568550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f568551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f568552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f568553h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f568546a, r101.f568546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568547b, r101.f568547b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568548c, r101.f568548c) == true) goto L18;
        return false;
    L18:
        if (this.f568549d == r101.f568549d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f568550e, r101.f568550e) == true) goto L24;
        return false;
    L24:
        if (this.f568551f == r101.f568551f) goto L27;
        return false;
    L27:
        if (this.f568552g == r101.f568552g) goto L30;
        return false;
    L30:
        if (this.f568553h == r101.f568553h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f568546a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f568547b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f568548c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f568549d) * 31;
        String r110 = this.f568550e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (((r109 + r101) * 31) + this.f568551f) * 31;
        if (this.f568552g == false) goto L21;
        int r112 = 1231;
    L23:
        return ((r111 + r112) * 31) + this.f568553h;
    L21:
        r112 = 1237;
        goto L23
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
        return "TemplateBannerReportParams(templateToken=" + this.f568546a + ", name=" + this.f568547b + ", fileId=" + this.f568548c + ", fileType=" + this.f568549d + ", source=" + this.f568550e + ", templateType=" + this.f568551f + ", isWiki=" + this.f568552g + ", createFileTyp=" + this.f568553h + ')';
    }

    public c(String r100, String r101, String r102, int r103, int r104, boolean r105, int r106) {
        this.f568546a = r100;
        this.f568547b = r101;
        this.f568548c = r102;
        this.f568549d = r103;
        this.f568550e = "";
        this.f568551f = r104;
        this.f568552g = r105;
        this.f568553h = r106;
    }
}
