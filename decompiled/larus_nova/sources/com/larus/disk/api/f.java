package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f330528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f330529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f330530c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f330528a, r101.f330528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330529b, r101.f330529b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330530c, r101.f330530c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        e r100 = this.f330528a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        e r104 = this.f330529b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.f330530c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiskCacheBreakdownSnapshot(automatic=" + this.f330528a + ", manual=" + this.f330529b + ", registeredUsage=" + this.f330530c + ')';
    }

    public f(e r100, e r101, i r102) {
        this.f330528a = r100;
        this.f330529b = r101;
        this.f330530c = r102;
    }
}
