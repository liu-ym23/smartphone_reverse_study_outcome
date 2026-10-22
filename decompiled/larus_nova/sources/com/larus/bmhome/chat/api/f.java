package com.larus.bmhome.chat.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f297190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f297191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f297193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f297194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f297195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f297196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f297197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f297198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f297199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f297200k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f297190a, r101.f297190a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297191b, r101.f297191b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297192c, r101.f297192c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297193d, r101.f297193d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f297194e, r101.f297194e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f297195f, r101.f297195f) == true) goto L27;
        return false;
    L27:
        if (this.f297196g == r101.f297196g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f297197h, r101.f297197h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f297198i, r101.f297198i) == true) goto L36;
        return false;
    L36:
        if (this.f297199j == r101.f297199j) goto L39;
        return false;
    L39:
        if (this.f297200k == r101.f297200k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f297190a.hashCode() * 31) + this.f297191b.hashCode()) * 31) + this.f297192c.hashCode()) * 31) + this.f297193d.hashCode()) * 31) + this.f297194e.hashCode()) * 31) + this.f297195f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f297196g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f297197h.hashCode()) * 31) + this.f297198i.hashCode()) * 31;
        if (this.f297199j == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f297200k == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CardModel(msgData=" + this.f297190a + ", permissionType=" + this.f297191b + ", icon=" + this.f297192c + ", sourceName=" + this.f297193d + ", title=" + this.f297194e + ", subtitle=" + this.f297195f + ", showOperateButton=" + this.f297196g + ", agreeTitle=" + this.f297197h + ", rejectedTitle=" + this.f297198i + ", agreeLoading=" + this.f297199j + ", rejectedLoading=" + this.f297200k + ')';
    }

    public f(r0 r100, com.bytedance.applet.impl.k r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "msgData");
        Intrinsics.checkNotNullParameter(r101, "permissionType");
        Intrinsics.checkNotNullParameter(r102, "icon");
        Intrinsics.checkNotNullParameter(r103, "sourceName");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "subtitle");
        Intrinsics.checkNotNullParameter(r107, "agreeTitle");
        Intrinsics.checkNotNullParameter(r110, "rejectedTitle");
        this.f297190a = r100;
        this.f297191b = r101;
        this.f297192c = r102;
        this.f297193d = r103;
        this.f297194e = r104;
        this.f297195f = r105;
        this.f297196g = r106;
        this.f297197h = r107;
        this.f297198i = r110;
        this.f297199j = r111;
        this.f297200k = r112;
    }
}
