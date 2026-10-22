package com.bytedance.ug.sdk.luckycat.impl.settings;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f271486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f271487b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f271486a, r101.f271486a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f271487b, r101.f271487b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        d r100 = this.f271486a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f271487b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Settings(dogSettings=" + this.f271486a + ", dogSettingsStr=" + this.f271487b + ")";
    }

    public i(d r100, String r101) {
        this.f271486a = r100;
        this.f271487b = r101;
    }
}
