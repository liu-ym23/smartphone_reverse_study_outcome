package com.larus.minor.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f359159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f359161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f359162d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f359159a == r101.f359159a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359160b, r101.f359160b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359161c, r101.f359161c) == true) goto L18;
        return false;
    L18:
        if (this.f359162d == r101.f359162d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f359159a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f359160b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Long r107 = this.f359161c;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (r106 + r104) * 31;
        if (this.f359162d == true) goto L19;
        r100 = 1237;
    L19:
        return r108 + r100;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MinorModePasswordResult(success=" + this.f359159a + ", message=" + this.f359160b + ", upstreamCode=" + this.f359161c + ", transportSucceeded=" + this.f359162d + ')';
    }

    public /* synthetic */ d(boolean r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 8) == 0) goto L8;
        boolean r103 = true;
    L9:
        this(r100, r101, null, r103);
        return;
    L8:
        r103 = false;
        goto L9
    }

    public d(boolean r100, String r101, Long r102, boolean r103) {
        this.f359159a = r100;
        this.f359160b = r101;
        this.f359161c = r102;
        this.f359162d = r103;
    }
}
