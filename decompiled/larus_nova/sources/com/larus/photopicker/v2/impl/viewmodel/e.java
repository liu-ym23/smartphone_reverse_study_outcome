package com.larus.photopicker.v2.impl.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnSelectableToastType f364712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364713b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f364712a == r101.f364712a) goto L12;
        return false;
    L12:
        if (this.f364713b == r101.f364713b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f364712a.hashCode() * 31) + this.f364713b;
    }

    public final String toString() {
        return "UnSelectableToast(type=" + this.f364712a + ", limit=" + this.f364713b + ')';
    }

    public final UnSelectableToastType getType() {
        return this.f364712a;
    }

    public e(UnSelectableToastType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f364712a = r100;
        this.f364713b = r101;
    }
}
