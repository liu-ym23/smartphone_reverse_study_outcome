package com.obric.assistant.settings;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f392022b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f392021a, r101.f392021a) == true) goto L12;
        return false;
    L12:
        if (this.f392022b == r101.f392022b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f392021a.hashCode() * 31;
        if (this.f392022b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AutoActionBlacklistByUserItem(packageName=" + this.f392021a + ", isAvailable=" + this.f392022b + ')';
    }

    public e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        this.f392021a = r100;
        this.f392022b = r101;
    }
}
