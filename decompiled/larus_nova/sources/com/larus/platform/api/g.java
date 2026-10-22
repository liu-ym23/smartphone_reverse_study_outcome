package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365133e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f365129a, r101.f365129a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365130b, r101.f365130b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365131c, r101.f365131c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365132d, r101.f365132d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365133e, r101.f365133e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365129a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365130b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f365131c.hashCode()) * 31;
        String r107 = this.f365132d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f365133e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AuthInputInfo(answerId=" + this.f365129a + ", popupText=" + this.f365130b + ", pluginId=" + this.f365131c + ", botId=" + this.f365132d + ", jumpUrl=" + this.f365133e + ')';
    }

    public g(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "pluginId");
        this.f365129a = r100;
        this.f365130b = r101;
        this.f365131c = r102;
        this.f365132d = r103;
        this.f365133e = r104;
    }
}
