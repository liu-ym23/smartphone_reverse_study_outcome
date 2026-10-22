package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f317407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ot8.a f317408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ot8.a f317409d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f317406a == r101.f317406a) goto L12;
        return false;
    L12:
        if (this.f317407b == r101.f317407b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f317408c, r101.f317408c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f317409d, r101.f317409d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f317406a * 31;
        if (this.f317407b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f317408c.hashCode()) * 31) + this.f317409d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubleTinyMenu(id=" + this.f317406a + ", removeAroundDivider=" + this.f317407b + ", leftMenu=" + this.f317408c + ", rightMenu=" + this.f317409d + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f317407b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f317406a;
    }

    public y(ot8.a r100, ot8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "leftMenu");
        Intrinsics.checkNotNullParameter(r101, "rightMenu");
        this.f317406a = 0;
        this.f317407b = false;
        this.f317408c = r100;
        this.f317409d = r101;
    }
}
