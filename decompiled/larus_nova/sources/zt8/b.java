package zt8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f573635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f573636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f573637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f573638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f573639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f573640g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f573634a, r101.f573634a) == true) goto L12;
        return false;
    L12:
        if (this.f573635b == r101.f573635b) goto L15;
        return false;
    L15:
        if (this.f573636c == r101.f573636c) goto L18;
        return false;
    L18:
        if (this.f573637d == r101.f573637d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573638e, r101.f573638e) == true) goto L24;
        return false;
    L24:
        if (this.f573639f == r101.f573639f) goto L27;
        return false;
    L27:
        if (this.f573640g == r101.f573640g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573634a.hashCode() * 31;
        int r101 = 1231;
        if (this.f573635b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f573636c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f573637d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        Integer r108 = this.f573638e;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        if (this.f573639f == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f573640g == true) goto L27;
        r101 = 1237;
    L27:
        return r112 + r101;
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "HostWebFragmentConfig(url=" + this.f573634a + ", hideTitleBar=" + this.f573635b + ", isNotFullPage=" + this.f573636c + ", isShowProgressBar=" + this.f573637d + ", webViewBgColor=" + this.f573638e + ", hideGoForwardAndBack=" + this.f573639f + ", offscreenPreRaster=" + this.f573640g + ')';
    }

    public b(String r100, boolean r101, boolean r102, Integer r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r101 = true;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r102 = true;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 64) == 0) goto L14;
        r104 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f573634a = r100;
        this.f573635b = true;
        this.f573636c = r101;
        this.f573637d = r102;
        this.f573638e = r103;
        this.f573639f = false;
        this.f573640g = r104;
    }
}
