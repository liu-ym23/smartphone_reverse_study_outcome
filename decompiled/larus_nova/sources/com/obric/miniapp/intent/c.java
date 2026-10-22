package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f397692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397694c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f397692a == r101.f397692a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397693b, r101.f397693b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397694c, r101.f397694c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f397692a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f397693b.hashCode()) * 31) + this.f397694c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "IntentCardNativeResult(success=" + this.f397692a + ", errorCode=" + this.f397693b + ", errorMessage=" + this.f397694c + ')';
    }

    public c(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f397692a = r100;
        this.f397693b = r101;
        this.f397694c = r102;
    }
}
