package com.bytedance.ee.bear.imageviewer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f227014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f227015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f227016c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t3) == true) goto L8;
        return false;
    L8:
        t3 r101 = (t3) r100;
        if (this.f227014a == r101.f227014a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f227015b, r101.f227015b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f227016c, r101.f227016c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f227014a * 31) + this.f227015b.hashCode()) * 31) + this.f227016c.hashCode();
    }

    public final String toString() {
        return "PolicyParams(type=" + this.f227014a + ", token=" + this.f227015b + ", operate=" + this.f227016c + ')';
    }

    public final int getType() {
        return this.f227014a;
    }

    public t3(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "operate");
        this.f227014a = r100;
        this.f227015b = r101;
        this.f227016c = r102;
    }
}
