package com.larus.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f321324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ErrorCode f321325b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f321324a, r101.f321324a) == true) goto L12;
        return false;
    L12:
        if (this.f321325b == r101.f321325b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f321324a.hashCode() * 31) + this.f321325b.hashCode();
    }

    public final String toString() {
        return "ErrorMsg(errorMsg=" + this.f321324a + ", errorCode=" + this.f321325b + ')';
    }

    public a(String r100, ErrorCode r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        this.f321324a = r100;
        this.f321325b = r101;
    }
}
