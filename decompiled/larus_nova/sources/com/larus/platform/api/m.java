package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f365206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f365213h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f365206a, r101.f365206a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365207b, r101.f365207b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365208c, r101.f365208c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365209d, r101.f365209d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365210e, r101.f365210e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365211f, r101.f365211f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365212g, r101.f365212g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365213h, r101.f365213h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f365206a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365207b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.f365208c.hashCode()) * 31) + this.f365209d.hashCode()) * 31) + this.f365210e.hashCode()) * 31) + this.f365211f.hashCode()) * 31) + this.f365212g.hashCode()) * 31;
        String r107 = this.f365213h;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonApplicationDialogConfig(iconRes=" + this.f365206a + ", iconResUrl=" + this.f365207b + ", applicationName=" + this.f365208c + ", mainTitle=" + this.f365209d + ", subtitle=" + this.f365210e + ", cancelText=" + this.f365211f + ", confirmText=" + this.f365212g + ", confirmSubText=" + this.f365213h + ')';
    }

    public m(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "applicationName");
        Intrinsics.checkNotNullParameter(r103, "mainTitle");
        Intrinsics.checkNotNullParameter(r104, "subtitle");
        Intrinsics.checkNotNullParameter(r105, "cancelText");
        Intrinsics.checkNotNullParameter(r106, "confirmText");
        this.f365206a = r100;
        this.f365207b = r101;
        this.f365208c = r102;
        this.f365209d = r103;
        this.f365210e = r104;
        this.f365211f = r105;
        this.f365212g = r106;
        this.f365213h = r107;
    }
}
