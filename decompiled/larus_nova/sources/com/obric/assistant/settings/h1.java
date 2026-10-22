package com.obric.assistant.settings;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f392079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f392080b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.f392079a, r101.f392079a) == true) goto L12;
        return false;
    L12:
        if (this.f392080b == r101.f392080b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f392079a.hashCode() * 31;
        if (this.f392080b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SystemSettingsAppListResult(apps=" + this.f392079a + ", isComplete=" + this.f392080b + ')';
    }

    public h1(List<e> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "apps");
        this.f392079a = r100;
        this.f392080b = r101;
    }
}
