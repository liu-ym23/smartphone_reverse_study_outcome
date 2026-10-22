package yk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f568254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f568255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f568257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f568258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f568259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f568260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f568261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f568262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vl8.g f568263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f568264k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f568254a, r101.f568254a) == true) goto L12;
        return false;
    L12:
        if (this.f568255b == r101.f568255b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568256c, r101.f568256c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f568257d, r101.f568257d) == true) goto L21;
        return false;
    L21:
        if (this.f568258e == r101.f568258e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f568259f, r101.f568259f) == true) goto L27;
        return false;
    L27:
        if (this.f568260g == r101.f568260g) goto L30;
        return false;
    L30:
        if (this.f568261h == r101.f568261h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f568262i, r101.f568262i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f568263j, r101.f568263j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f568264k, r101.f568264k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f568254a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f568255b) * 31) + this.f568256c.hashCode()) * 31) + this.f568257d.hashCode()) * 31;
        int r104 = 1231;
        if (this.f568258e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f568259f.hashCode()) * 31;
        if (this.f568260g == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f568261h == true) goto L18;
        r104 = 1237;
    L18:
        int r109 = (((((r108 + r104) * 31) + this.f568262i.hashCode()) * 31) + this.f568263j.hashCode()) * 31;
        Integer r110 = this.f568264k;
        if (r110 == null) goto L23;
        r101 = r110.hashCode();
    L23:
        return r109 + r101;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FileCardViewInput(iconRes=" + this.f568254a + ", fallbackIconRes=" + this.f568255b + ", fileName=" + this.f568256c + ", fileType=" + this.f568257d + ", showFileType=" + this.f568258e + ", fileSizeText=" + this.f568259f + ", showFileActions=" + this.f568260g + ", showPlayAudioButton=" + this.f568261h + ", url=" + this.f568262i + ", playbackState=" + this.f568263j + ", rootBackgroundRes=" + this.f568264k + ')';
    }

    public g(Integer r100, int r101, String r102, String r103, boolean r104, String r105, boolean r106, boolean r107, String r110, vl8.g r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r105, "fileSizeText");
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "playbackState");
        this.f568254a = r100;
        this.f568255b = r101;
        this.f568256c = r102;
        this.f568257d = r103;
        this.f568258e = r104;
        this.f568259f = r105;
        this.f568260g = r106;
        this.f568261h = r107;
        this.f568262i = r110;
        this.f568263j = r111;
        this.f568264k = r112;
    }
}
