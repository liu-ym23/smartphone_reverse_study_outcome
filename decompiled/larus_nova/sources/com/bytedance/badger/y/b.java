package com.bytedance.badger.y;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f199435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f199436c;

    public b(String r100, Object r101, long r102) {
        this.f199434a = r100;
        this.f199435b = r101;
        this.f199436c = r102;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f199434a, r101.f199434a) == false) goto L16;
        if (Intrinsics.areEqual(this.f199435b, r101.f199435b) == false) goto L16;
        if (this.f199436c != r101.f199436c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
    L13:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f199434a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f199435b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f199436c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KeyEntry(key=" + this.f199434a + ", value=" + this.f199435b + ", createTimeMs=" + this.f199436c + ")";
    }
}
