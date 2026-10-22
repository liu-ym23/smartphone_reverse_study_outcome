package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f235940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f235942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f235943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeSpaceHeaderAction f235944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f235945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f235946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f235947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f235948i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f235940a, r101.f235940a) == true) goto L12;
        return false;
    L12:
        if (this.f235941b == r101.f235941b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235942c, r101.f235942c) == true) goto L18;
        return false;
    L18:
        if (this.f235943d == r101.f235943d) goto L21;
        return false;
    L21:
        if (this.f235944e == r101.f235944e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235945f, r101.f235945f) == true) goto L27;
        return false;
    L27:
        if (this.f235946g == r101.f235946g) goto L30;
        return false;
    L30:
        if (this.f235947h == r101.f235947h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f235948i, r101.f235948i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f235940a.hashCode() * 31) + this.f235941b) * 31) + this.f235942c.hashCode()) * 31) + this.f235943d) * 31;
        OfficeSpaceHeaderAction r101 = this.f235944e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f235945f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        int r108 = 1231;
        if (this.f235946g == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f235947h == true) goto L18;
        r108 = 1237;
    L18:
        int r111 = (r110 + r108) * 31;
        String r112 = this.f235948i;
        if (r112 == null) goto L23;
        r102 = r112.hashCode();
    L23:
        return r111 + r102;
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
        return "OfficeHeaderMenuConfigEntry(configItem=" + this.f235940a + ", menuId=" + this.f235941b + ", text=" + this.f235942c + ", iconRes=" + this.f235943d + ", action=" + this.f235944e + ", endIconRes=" + this.f235945f + ", isListView=" + this.f235946g + ", isGridView=" + this.f235947h + ", subMenuId=" + this.f235948i + ')';
    }

    public b(g r100, int r101, String r102, int r103, OfficeSpaceHeaderAction r104, Integer r105, boolean r106, boolean r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "configItem");
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f235940a = r100;
        this.f235941b = r101;
        this.f235942c = r102;
        this.f235943d = r103;
        this.f235944e = r104;
        this.f235945f = r105;
        this.f235946g = r106;
        this.f235947h = r107;
        this.f235948i = r110;
    }

    public /* synthetic */ b(g r110, int r111, String r112, int r113, OfficeSpaceHeaderAction r114, Integer r115, boolean r210, boolean r211, String r212, int r213) {
        if ((r213 & 16) == 0) goto L5;
        OfficeSpaceHeaderAction r100 = null;
    L7:
        if ((r213 & 32) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r213 & 64) == 0) goto L13;
        boolean r116 = false;
    L15:
        if ((r213 & 128) == 0) goto L17;
        boolean r117 = false;
    L19:
        if ((r213 & 256) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r113, r100, r101, r116, r117, r118);
        return;
    L21:
        r118 = r212;
        goto L22
    L17:
        r117 = r211;
        goto L19
    L13:
        r116 = r210;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
