package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.k0 f464964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f464965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f464966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f464968j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f464961c, r101.f464961c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464962d, r101.f464962d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464963e, r101.f464963e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464964f, r101.f464964f) == true) goto L21;
        return false;
    L21:
        if (this.f464965g == r101.f464965g) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464966h, r101.f464966h) == true) goto L27;
        return false;
    L27:
        if (this.f464967i == r101.f464967i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f464968j, r101.f464968j) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464961c.hashCode() * 31) + this.f464962d.hashCode()) * 31) + this.f464963e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.k0 r101 = this.f464964f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f464965g == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f464966h;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f464967i == true) goto L19;
        r105 = 1237;
    L19:
        return ((r109 + r105) * 31) + this.f464968j.hashCode();
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TextListSelectorDescriptor(widgetId=" + this.f464961c + ", actionChannel=" + this.f464962d + ", version=" + this.f464963e + ", template=" + this.f464964f + ", isMemorized=" + this.f464965g + ", subTitle=" + this.f464966h + ", enableBottomLine=" + this.f464967i + ", trackingContext=" + this.f464968j + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464963e;
    }

    public u0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.k0 r102, boolean r103, String r104, boolean r105, z0 r106) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r106, "trackingContext");
        super("TextListSelectorDescriptor");
        this.f464961c = r100;
        this.f464962d = r101;
        this.f464963e = r107;
        this.f464964f = r102;
        this.f464965g = r103;
        this.f464966h = r104;
        this.f464967i = r105;
        this.f464968j = r106;
    }
}
