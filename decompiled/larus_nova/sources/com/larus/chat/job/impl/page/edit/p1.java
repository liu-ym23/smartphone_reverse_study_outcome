package com.larus.chat.job.impl.page.edit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f325319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f325321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f325322d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (this.f325319a == r101.f325319a) goto L12;
        return false;
    L12:
        if (this.f325320b == r101.f325320b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325321c, r101.f325321c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325322d, r101.f325322d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f325319a * 31) + this.f325320b) * 31;
        Integer r101 = this.f325321c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f325322d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SystemBarsSnapshot(statusBarColor=" + this.f325319a + ", navigationBarColor=" + this.f325320b + ", navigationBarDividerColor=" + this.f325321c + ", navigationBarContrastEnforced=" + this.f325322d + ')';
    }

    public p1(int r100, int r101, Integer r102, Boolean r103) {
        this.f325319a = r100;
        this.f325320b = r101;
        this.f325321c = r102;
        this.f325322d = r103;
    }
}
