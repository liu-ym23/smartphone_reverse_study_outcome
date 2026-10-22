package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f271243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<c> f271244b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f271243a, r101.f271243a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f271244b, r101.f271244b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        WeakReference<Activity> r100 = this.f271243a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        WeakReference<c> r104 = this.f271244b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Page(activityRef=" + this.f271243a + ", containerRef=" + this.f271244b + ")";
    }

    public o(WeakReference<Activity> r100, WeakReference<c> r101) {
        this.f271243a = r100;
        this.f271244b = r101;
    }
}
