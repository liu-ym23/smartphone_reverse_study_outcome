package com.larus.home.impl.ug;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f346309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f346310b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f346309a, r101.f346309a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f346310b, r101.f346310b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f346309a.hashCode() * 31) + this.f346310b.hashCode();
    }

    public final String toString() {
        return "UGReturnFloatingViewConfig(outerContext=" + this.f346309a + ", text=" + this.f346310b + ')';
    }

    public g(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "outerContext");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f346309a = r100;
        this.f346310b = r101;
    }
}
