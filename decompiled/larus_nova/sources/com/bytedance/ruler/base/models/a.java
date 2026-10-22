package com.bytedance.ruler.base.models;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f267649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f267650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f267651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f267652d;

    public a() {
        Throwable r100 = null;
        this(r100, 0, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f267649a, r101.f267649a) == true) goto L8;
        return false;
    L8:
        if (this.f267650b == r101.f267650b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f267651c, r101.f267651c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f267652d, r101.f267652d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.f267649a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f267650b) * 31;
        String r104 = this.f267651c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f267652d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExprResponse(result=" + this.f267649a + ", code=" + this.f267650b + ", msg=" + this.f267651c + ", throwable=" + this.f267652d + ")";
    }

    public final void setResult(Object r100) {
        this.f267649a = r100;
    }

    public /* synthetic */ a(Object r100, int r101, Throwable r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, null, r102);
    }

    public a(Object r100, int r101, String r102, Throwable r103) {
        this.f267649a = r100;
        this.f267650b = r101;
        this.f267651c = r102;
        this.f267652d = r103;
    }
}
