package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f271245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f271246b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f271245a, r101.f271245a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f271246b, r101.f271246b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Activity r100 = this.f271245a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f271246b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StrongPage(activity=" + this.f271245a + ", container=" + this.f271246b + ")";
    }

    public final Activity getActivity() {
        return this.f271245a;
    }

    public p(Activity r100, c r101) {
        this.f271245a = r100;
        this.f271246b = r101;
    }
}
