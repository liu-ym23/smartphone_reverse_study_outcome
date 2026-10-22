package com.bytedance.locallife.host.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f258972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QrCodeShareInfo f258973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f258974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f258975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f258976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImExtraParams f258977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f258978g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f258972a, r101.f258972a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f258973b, r101.f258973b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f258974c, r101.f258974c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258975d, r101.f258975d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f258976e, r101.f258976e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f258977f, r101.f258977f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f258978g, r101.f258978g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f258972a.hashCode() * 31;
        QrCodeShareInfo r101 = this.f258973b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f258974c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f258975d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f258976e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ImExtraParams r114 = this.f258977f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        t r117 = this.f258978g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareInfoWrapper(shareInfo=" + this.f258972a + ", qrCodeShareInfo=" + this.f258973b + ", aweType=" + this.f258974c + ", reportUrl=" + this.f258975d + ", commandShareParams=" + this.f258976e + ", imExtraParams=" + this.f258977f + ", listener=" + this.f258978g + ')';
    }

    public w(v r100, QrCodeShareInfo r101, String r102, String r103, String r104, ImExtraParams r105, t r106) {
        Intrinsics.checkNotNullParameter(r100, "shareInfo");
        this.f258972a = r100;
        this.f258973b = r101;
        this.f258974c = r102;
        this.f258975d = r103;
        this.f258976e = r104;
        this.f258977f = r105;
        this.f258978g = r106;
    }
}
