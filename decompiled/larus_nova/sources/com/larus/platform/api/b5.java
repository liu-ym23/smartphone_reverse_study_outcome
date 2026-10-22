package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SdkCalendarErrorCode f364874b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r101 = (b5) r100;
        if (Intrinsics.areEqual(this.f364873a, r101.f364873a) == true) goto L12;
        return false;
    L12:
        if (this.f364874b == r101.f364874b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f364873a.hashCode() * 31) + this.f364874b.hashCode();
    }

    public final String toString() {
        return "SdkCalendarResult(errorMsg=" + this.f364873a + ", errorCode=" + this.f364874b + ')';
    }

    public b5(String r100, SdkCalendarErrorCode r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        this.f364873a = r100;
        this.f364874b = r101;
    }
}
