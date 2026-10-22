package com.larus.dora.obric.device_management.setting.g;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f340610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<r> f340611b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f340610a, r101.f340610a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f340611b, r101.f340611b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f340610a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f340611b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricGSettingsSection(title=" + this.f340610a + ", items=" + this.f340611b + ')';
    }

    public t(String r100, List<r> r101) {
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f340610a = r100;
        this.f340611b = r101;
    }
}
