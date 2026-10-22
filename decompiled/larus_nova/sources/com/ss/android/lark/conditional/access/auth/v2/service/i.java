package com.ss.android.lark.conditional.access.auth.v2.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f417909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f417910b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f417909a == r101.f417909a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417910b, r101.f417910b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f417909a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Long r102 = this.f417910b;
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
        return "IPClearInfo(controlByIp=" + this.f417909a + ", initialTime=" + this.f417910b + ')';
    }

    public i(boolean r100, Long r101) {
        this.f417909a = r100;
        this.f417910b = r101;
    }
}
