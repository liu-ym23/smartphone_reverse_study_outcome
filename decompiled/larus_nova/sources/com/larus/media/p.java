package com.larus.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f359138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359139b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f359138a == r101.f359138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359139b, r101.f359139b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f359138a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f359139b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "Result(succ=" + this.f359138a + ", message=" + this.f359139b + ')';
    }

    public p(boolean r100, String r101) {
        this.f359138a = r100;
        this.f359139b = r101;
    }
}
