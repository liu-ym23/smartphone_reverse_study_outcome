package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.i f464892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.larus.bmhome.actionbar.model.h> f464893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f464894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f464895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f464896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z0 f464897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f464898l;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f464889c, r101.f464889c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464890d, r101.f464890d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464891e, r101.f464891e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464892f, r101.f464892f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464893g, r101.f464893g) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464894h, r101.f464894h) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f464895i, r101.f464895i) == true) goto L30;
        return false;
    L30:
        if (this.f464896j == r101.f464896j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f464897k, r101.f464897k) == true) goto L36;
        return false;
    L36:
        if (this.f464898l == r101.f464898l) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464889c.hashCode() * 31) + this.f464890d.hashCode()) * 31) + this.f464891e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.i r101 = this.f464892f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<com.larus.bmhome.actionbar.model.h> r105 = this.f464893g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f464894h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f464895i;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        int r113 = 1231;
        if (this.f464896j == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f464897k.hashCode()) * 31;
        if (this.f464898l == true) goto L27;
        r113 = 1237;
    L27:
        return r115 + r113;
    L21:
        r114 = 1237;
        goto L22
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
        return "DropdownListSelectorDescriptor(widgetId=" + this.f464889c + ", actionChannel=" + this.f464890d + ", version=" + this.f464891e + ", template=" + this.f464892f + ", allDropdownBoxList=" + this.f464893g + ", marginTop=" + this.f464894h + ", subTitle=" + this.f464895i + ", enableBottomLine=" + this.f464896j + ", trackingContext=" + this.f464897k + ", isMemorized=" + this.f464898l + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464891e;
    }

    public m(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.i r102, List r103, Integer r104, String r105, boolean r106, z0 r110, boolean r111) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r110, "trackingContext");
        super("DropdownListSelectorDescriptor");
        this.f464889c = r100;
        this.f464890d = r101;
        this.f464891e = r107;
        this.f464892f = r102;
        this.f464893g = r103;
        this.f464894h = r104;
        this.f464895i = r105;
        this.f464896j = r106;
        this.f464897k = r110;
        this.f464898l = r111;
    }
}
