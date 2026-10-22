package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f368917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f368918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f368919c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f368917a == r101.f368917a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368918b, r101.f368918b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368919c, r101.f368919c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f368917a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        e r102 = this.f368918b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f368919c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SaasSharePanelResolveResult(success=" + this.f368917a + ", context=" + this.f368918b + ", errorMsg=" + this.f368919c + ')';
    }

    public final e getContext() {
        return this.f368918b;
    }

    public g(boolean r100, e r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this.f368917a = r100;
        this.f368918b = r101;
        this.f368919c = r102;
    }
}
