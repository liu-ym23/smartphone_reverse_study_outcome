package com.larus.office.base.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficePreviewType f361035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f361036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f361037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f361038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f361039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f361040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f361041g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f361035a == r101.f361035a) goto L12;
        return false;
    L12:
        if (this.f361036b == r101.f361036b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361037c, r101.f361037c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f361038d, r101.f361038d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f361039e, r101.f361039e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f361040f, r101.f361040f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f361041g, r101.f361041g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f361035a.hashCode() * 31) + this.f361036b) * 31) + this.f361037c.hashCode()) * 31;
        String r101 = this.f361038d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f361039e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f361040f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f361041g.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficePreviewTarget(previewType=" + this.f361035a + ", previewTypeValue=" + this.f361036b + ", token=" + this.f361037c + ", url=" + this.f361038d + ", originalUrl=" + this.f361039e + ", sourceUrlForParams=" + this.f361040f + ", resolvedBy=" + this.f361041g + ')';
    }

    public e(OfficePreviewType r100, int r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "previewType");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r106, "resolvedBy");
        this.f361035a = r100;
        this.f361036b = r101;
        this.f361037c = r102;
        this.f361038d = r103;
        this.f361039e = r104;
        this.f361040f = r105;
        this.f361041g = r106;
    }
}
