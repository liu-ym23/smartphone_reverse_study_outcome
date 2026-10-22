package com.larus.dora.obric.device_management.setting.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f340603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraObricGSettingsAction f340604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f340605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f340606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f340607e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f340603a, r101.f340603a) == true) goto L12;
        return false;
    L12:
        if (this.f340604b == r101.f340604b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f340605c, r101.f340605c) == true) goto L18;
        return false;
    L18:
        if (this.f340606d == r101.f340606d) goto L21;
        return false;
    L21:
        if (this.f340607e == r101.f340607e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f340603a.hashCode() * 31) + this.f340604b.hashCode()) * 31;
        String r101 = this.f340605c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f340606d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f340607e == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricGSettingsItem(title=" + this.f340603a + ", action=" + this.f340604b + ", endText=" + this.f340605c + ", showRedDot=" + this.f340606d + ", showArrow=" + this.f340607e + ')';
    }

    public r(String r100, DoraObricGSettingsAction r101, String r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r102 = null;
    L5:
        boolean r105 = false;
        if ((r104 & 8) == 0) goto L9;
        r103 = false;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r105 = true;
    L11:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f340603a = r100;
        this.f340604b = r101;
        this.f340605c = r102;
        this.f340606d = r103;
        this.f340607e = r105;
    }
}
