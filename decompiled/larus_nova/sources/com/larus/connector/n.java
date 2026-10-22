package com.larus.connector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f330213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f330214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f330215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f330216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f330217h;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f330210a, r101.f330210a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330211b, r101.f330211b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330212c, r101.f330212c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330213d, r101.f330213d) == true) goto L21;
        return false;
    L21:
        if (this.f330214e == r101.f330214e) goto L24;
        return false;
    L24:
        if (this.f330215f == r101.f330215f) goto L27;
        return false;
    L27:
        if (this.f330216g == r101.f330216g) goto L30;
        return false;
    L30:
        if (this.f330217h == r101.f330217h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f330210a.hashCode() * 31) + this.f330211b.hashCode()) * 31) + this.f330212c.hashCode()) * 31) + this.f330213d.hashCode()) * 31) + this.f330214e) * 31) + this.f330215f) * 31;
        if (this.f330216g == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f330217h;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ConnectorListEntry(connectorId=" + this.f330210a + ", name=" + this.f330211b + ", description=" + this.f330212c + ", iconUrl=" + this.f330213d + ", installStatus=" + this.f330214e + ", connectStatus=" + this.f330215f + ", enabled=" + this.f330216g + ", skillType=" + this.f330217h + ')';
    }

    public static n a(n r100, boolean r110) {
        String r101 = r100.f330210a;
        String r102 = r100.f330211b;
        String r103 = r100.f330212c;
        String r104 = r100.f330213d;
        int r105 = r100.f330214e;
        int r106 = r100.f330215f;
        int r107 = r100.f330217h;
        Intrinsics.checkNotNullParameter(r101, "connectorId");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "description");
        Intrinsics.checkNotNullParameter(r104, "iconUrl");
        return new n(r101, r102, r103, r104, r105, r106, r110, r107);
    }

    public n(String r100, String r101, String r102, String r103, int r104, int r105, boolean r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "connectorId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r103, "iconUrl");
        this.f330210a = r100;
        this.f330211b = r101;
        this.f330212c = r102;
        this.f330213d = r103;
        this.f330214e = r104;
        this.f330215f = r105;
        this.f330216g = r106;
        this.f330217h = r107;
    }
}
