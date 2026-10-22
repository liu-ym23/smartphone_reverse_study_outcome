package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f368901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f368902b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f368901a == r101.f368901a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368902b, r101.f368902b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f368901a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f368902b;
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
        return "AppletSharePanelResult(success=" + this.f368901a + ", errorMsg=" + this.f368902b + ')';
    }

    public b(boolean r100, String r101) {
        this.f368901a = r100;
        this.f368902b = r101;
    }
}
