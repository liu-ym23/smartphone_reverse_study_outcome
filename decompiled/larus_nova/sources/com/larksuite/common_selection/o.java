package com.larksuite.common_selection;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f282908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f282909b;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f282908a, r101.f282908a) == true) goto L12;
        return false;
    L12:
        if (this.f282909b == r101.f282909b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f282908a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f282909b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectionPoint(view=" + this.f282908a + ", index=" + this.f282909b + ')';
    }

    public /* synthetic */ o(int r100) {
        this(null, 0);
    }

    public o(View r100, int r101) {
        this.f282908a = r100;
        this.f282909b = r101;
    }
}
