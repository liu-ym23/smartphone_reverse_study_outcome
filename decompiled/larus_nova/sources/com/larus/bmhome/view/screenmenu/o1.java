package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o1 implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f317367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ot8.a f317368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ot8.a f317369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ot8.a f317370e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.f317366a == r101.f317366a) goto L12;
        return false;
    L12:
        if (this.f317367b == r101.f317367b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f317368c, r101.f317368c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f317369d, r101.f317369d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f317370e, r101.f317370e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f317366a * 31;
        if (this.f317367b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + this.f317368c.hashCode()) * 31) + this.f317369d.hashCode()) * 31) + this.f317370e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TripleTinyMenu(id=" + this.f317366a + ", removeAroundDivider=" + this.f317367b + ", firstMenu=" + this.f317368c + ", middleMenu=" + this.f317369d + ", lastMenu=" + this.f317370e + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f317367b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f317366a;
    }

    public o1(ot8.a r100, ot8.a r101, ot8.a r102) {
        Intrinsics.checkNotNullParameter(r100, "firstMenu");
        Intrinsics.checkNotNullParameter(r101, "middleMenu");
        Intrinsics.checkNotNullParameter(r102, "lastMenu");
        this.f317366a = 0;
        this.f317367b = false;
        this.f317368c = r100;
        this.f317369d = r101;
        this.f317370e = r102;
    }
}
