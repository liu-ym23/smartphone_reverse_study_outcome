package com.ss.android.lark.conditional.access.auth.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f417791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417792b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f417791a, r101.f417791a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417792b, r101.f417792b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        d r100 = this.f417791a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f417792b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnceValidateResultWrapper(result=" + this.f417791a + ", cacheType=" + this.f417792b + ')';
    }

    public e(d r100, String r101) {
        this.f417791a = r100;
        this.f417792b = r101;
    }
}
