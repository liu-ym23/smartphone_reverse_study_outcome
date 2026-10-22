package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.l f464940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f464944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f464945k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f464937c, r101.f464937c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464938d, r101.f464938d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464939e, r101.f464939e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464940f, r101.f464940f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464941g, r101.f464941g) == true) goto L24;
        return false;
    L24:
        if (this.f464942h == r101.f464942h) goto L27;
        return false;
    L27:
        if (this.f464943i == r101.f464943i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f464944j, r101.f464944j) == true) goto L33;
        return false;
    L33:
        if (this.f464945k == r101.f464945k) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464937c.hashCode() * 31) + this.f464938d.hashCode()) * 31) + this.f464939e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.l r101 = this.f464940f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464941g;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.f464942h == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f464943i == true) goto L19;
        r107 = 1237;
    L19:
        return ((((r109 + r107) * 31) + this.f464944j.hashCode()) * 31) + this.f464945k;
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageListSelectorDescriptor(widgetId=" + this.f464937c + ", actionChannel=" + this.f464938d + ", version=" + this.f464939e + ", template=" + this.f464940f + ", subTitle=" + this.f464941g + ", enableBottomLine=" + this.f464942h + ", isStyleRadio=" + this.f464943i + ", trackingContext=" + this.f464944j + ", scrollToPosition=" + this.f464945k + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464939e;
    }

    public r(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.l r102, String r103, boolean r104, boolean r105, z0 r106, int r110) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r106, "trackingContext");
        super("ImageListSelectorDescriptor");
        this.f464937c = r100;
        this.f464938d = r101;
        this.f464939e = r107;
        this.f464940f = r102;
        this.f464941g = r103;
        this.f464942h = r104;
        this.f464943i = r105;
        this.f464944j = r106;
        this.f464945k = r110;
    }
}
