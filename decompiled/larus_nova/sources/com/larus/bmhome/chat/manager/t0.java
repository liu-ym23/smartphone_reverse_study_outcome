package com.larus.bmhome.chat.manager;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f306842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f306843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f306844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f306845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f306846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final by7.e f306847f;

    public t0() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f306842a, r101.f306842a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f306843b, r101.f306843b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f306844c, r101.f306844c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f306845d, r101.f306845d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f306846e, r101.f306846e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f306847f, r101.f306847f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f306842a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f306843b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f306844c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f306845d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f306846e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        by7.e r116 = this.f306847f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ScreenMenuMobConfig(clickFrom=" + this.f306842a + ", currentPage=" + this.f306843b + ", previousPage=" + this.f306844c + ", recommendFrom=" + this.f306845d + ", isNavigationSideBar=" + this.f306846e + ", trackNode=" + this.f306847f + ')';
    }

    public t0(String r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.f306842a = r100;
        this.f306843b = r101;
        this.f306844c = r102;
        this.f306845d = r103;
        this.f306846e = r104;
        this.f306847f = null;
    }
}
