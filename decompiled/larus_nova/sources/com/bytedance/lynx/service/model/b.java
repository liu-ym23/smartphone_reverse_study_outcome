package com.bytedance.lynx.service.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f264891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f264892b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f264891a == r101.f264891a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f264892b, r101.f264892b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f264891a * 31;
        String r101 = this.f264892b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "LynxServiceError(errorCode=" + this.f264891a + ", errorMessage=" + this.f264892b + ")";
    }

    public b(int r100, String r101) {
        this.f264891a = r100;
        this.f264892b = r101;
    }
}
