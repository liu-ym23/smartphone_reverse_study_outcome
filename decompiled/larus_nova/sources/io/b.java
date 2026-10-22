package io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490651c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f490649a, r101.f490649a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f490650b, r101.f490650b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f490651c, r101.f490651c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f490649a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490650b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f490651c;
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
        return "WindowDynamicLayoutCacheEntity(layoutName=" + this.f490649a + ", version=" + this.f490650b + ", layout=" + this.f490651c + ")";
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutName");
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "layout");
        this.f490649a = r100;
        this.f490650b = r101;
        this.f490651c = r102;
    }
}
