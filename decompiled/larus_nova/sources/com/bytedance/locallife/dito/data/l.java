package com.bytedance.locallife.dito.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f258214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DitoPage f258215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f258216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f258217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final lp6.a f258218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f258219f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f258214a, r101.f258214a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f258215b, r101.f258215b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f258216c, r101.f258216c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258217d, r101.f258217d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f258218e, r101.f258218e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f258214a.hashCode() * 31;
        DitoPage r101 = this.f258215b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.f258216c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f258217d.hashCode()) * 31;
        lp6.a r108 = this.f258218e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoRequestProcessData(type=" + this.f258214a + ", ditoPage=" + this.f258215b + ", throwable=" + this.f258216c + ", requestParams=" + this.f258217d + ", originResponse=" + this.f258218e + ')';
    }

    public final boolean a() {
        if (Intrinsics.areEqual(this.f258214a, "API_REQUEST_ERROR") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f258214a, "DATA_PARSE_ERROR") == true) goto L10;
        if (Intrinsics.areEqual(this.f258214a, "REQUEST_ERROR") == true) goto L10;
        return false;
    }

    public final String getType() {
        return this.f258214a;
    }

    public l(String r100, DitoPage r101, Throwable r102, k r103, lp6.a r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = new k(null, 31);
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, "requestParams");
        this.f258214a = r100;
        this.f258215b = r101;
        this.f258216c = r102;
        this.f258217d = r103;
        this.f258218e = r104;
        if (r101 == null) goto L17;
        boolean r106 = r101.hasRoot();
    L18:
        this.f258219f = r106;
        return;
    L17:
        r106 = false;
        goto L18
    }
}
