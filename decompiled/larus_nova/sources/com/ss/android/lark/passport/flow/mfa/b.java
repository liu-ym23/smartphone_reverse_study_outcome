package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f437890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f437892c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f437890a, r101.f437890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437891b, r101.f437891b) == true) goto L15;
        return false;
    L15:
        if (this.f437892c == r101.f437892c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f437890a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f437891b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f437892c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowCodeApplyResult(expireSeconds=" + this.f437890a + ", message=" + this.f437891b + ", throttled=" + this.f437892c + ')';
    }

    public b(Integer r100, String r101, boolean r102) {
        this.f437890a = r100;
        this.f437891b = r101;
        this.f437892c = r102;
    }
}
