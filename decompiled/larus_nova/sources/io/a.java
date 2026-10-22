package io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f490642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f490645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f490646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f490647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f490648g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f490642a == r101.f490642a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f490643b, r101.f490643b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f490644c, r101.f490644c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f490645d, r101.f490645d) == true) goto L14;
        return false;
    L14:
        if (this.f490646e == r101.f490646e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f490647f, r101.f490647f) == true) goto L18;
        return false;
    L18:
        if (this.f490648g == r101.f490648g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f490642a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f490643b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f490644c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f490645d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f490646e) * 31;
        String r112 = this.f490647f;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return ((r111 + r103) * 31) + this.f490648g;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreFloatLayoutEntity(id=" + this.f490642a + ", componentName=" + this.f490643b + ", userId=" + this.f490644c + ", scopeKey=" + this.f490645d + ", action=" + this.f490646e + ", time=" + this.f490647f + ", count=" + this.f490648g + ")";
    }

    public a(long r100, String r101, String r102, String r103, int r104, String r105, int r106) {
        Intrinsics.checkNotNullParameter(r101, "componentName");
        this.f490642a = r100;
        this.f490643b = r101;
        this.f490644c = r102;
        this.f490645d = r103;
        this.f490646e = r104;
        this.f490647f = r105;
        this.f490648g = r106;
    }
}
