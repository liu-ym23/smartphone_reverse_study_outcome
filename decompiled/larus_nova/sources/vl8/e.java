package vl8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f555693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f555694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f555695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f555696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f555697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f555698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f555699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f555700i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f555692a, r101.f555692a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f555693b, r101.f555693b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f555694c, r101.f555694c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f555695d, r101.f555695d) == true) goto L21;
        return false;
    L21:
        if (this.f555696e == r101.f555696e) goto L24;
        return false;
    L24:
        if (this.f555697f == r101.f555697f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f555698g, r101.f555698g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f555699h, r101.f555699h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f555700i, r101.f555700i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f555692a.hashCode() * 31) + this.f555693b.hashCode()) * 31) + this.f555694c.hashCode()) * 31) + this.f555695d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f555696e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f555697f == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((r103 + r101) * 31) + this.f555698g.hashCode()) * 31) + this.f555699h.hashCode()) * 31;
        Integer r105 = this.f555700i;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocalFileCardViewInput(darkIcon=" + this.f555692a + ", lightIcon=" + this.f555693b + ", fileName=" + this.f555694c + ", fileType=" + this.f555695d + ", showFileType=" + this.f555696e + ", showPlayAudioButton=" + this.f555697f + ", path=" + this.f555698g + ", playbackState=" + this.f555699h + ", rootBackgroundRes=" + this.f555700i + ')';
    }

    public e(String r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106, g r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "darkIcon");
        Intrinsics.checkNotNullParameter(r101, "lightIcon");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r106, "path");
        Intrinsics.checkNotNullParameter(r107, "playbackState");
        this.f555692a = r100;
        this.f555693b = r101;
        this.f555694c = r102;
        this.f555695d = r103;
        this.f555696e = r104;
        this.f555697f = r105;
        this.f555698g = r106;
        this.f555699h = r107;
        this.f555700i = r110;
    }
}
