package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.d0 f464916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final bq8.a f464920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z0 f464921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f464922l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f464913c, r101.f464913c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464914d, r101.f464914d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464915e, r101.f464915e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464916f, r101.f464916f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464917g, r101.f464917g) == true) goto L24;
        return false;
    L24:
        if (this.f464918h == r101.f464918h) goto L27;
        return false;
    L27:
        if (this.f464919i == r101.f464919i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f464920j, r101.f464920j) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f464921k, r101.f464921k) == true) goto L36;
        return false;
    L36:
        if (this.f464922l == r101.f464922l) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464913c.hashCode() * 31) + this.f464914d.hashCode()) * 31) + this.f464915e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.d0 r101 = this.f464916f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464917g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        int r108 = 1231;
        if (this.f464918h == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f464919i == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        bq8.a r113 = this.f464920j;
        if (r113 == null) goto L22;
        r102 = r113.hashCode();
    L22:
        int r114 = (((r112 + r102) * 31) + this.f464921k.hashCode()) * 31;
        if (this.f464922l == true) goto L27;
        r108 = 1237;
    L27:
        return r114 + r108;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicTemplateSelectorDescriptor(widgetId=" + this.f464913c + ", actionChannel=" + this.f464914d + ", version=" + this.f464915e + ", template=" + this.f464916f + ", subTitle=" + this.f464917g + ", enableBottomLine=" + this.f464918h + ", showCover=" + this.f464919i + ", selectedTemplate=" + this.f464920j + ", trackingContext=" + this.f464921k + ", needScroll=" + this.f464922l + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464915e;
    }

    public o0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.d0 r102, String r103, boolean r104, boolean r105, bq8.a r106, z0 r110, boolean r111) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r110, "trackingContext");
        super("MusicTemplateSelectorDescriptor");
        this.f464913c = r100;
        this.f464914d = r101;
        this.f464915e = r107;
        this.f464916f = r102;
        this.f464917g = r103;
        this.f464918h = r104;
        this.f464919i = r105;
        this.f464920j = r106;
        this.f464921k = r110;
        this.f464922l = r111;
    }
}
