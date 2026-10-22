package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopoverOptionMode f398046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f398047b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b6) == true) goto L8;
        return false;
    L8:
        b6 r101 = (b6) r100;
        if (this.f398046a == r101.f398046a) goto L12;
        return false;
    L12:
        if (this.f398047b == r101.f398047b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f398046a.hashCode() * 31;
        if (this.f398047b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PopoverOptionConfig(mode=" + this.f398046a + ", isExplicit=" + this.f398047b + ')';
    }

    public b6(PopoverOptionMode r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f398046a = r100;
        this.f398047b = r101;
    }
}
