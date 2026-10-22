package com.larksuite.component.universe_design.button;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f284594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable.Callback f284595b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f284594a, r101.f284594a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f284595b, r101.f284595b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f284594a.hashCode() * 31) + this.f284595b.hashCode();
    }

    public final String toString() {
        return "DrawableViewData(drawable=" + this.f284594a + ", callback=" + this.f284595b + ')';
    }

    public c(Drawable r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f284594a = r100;
        this.f284595b = r101;
    }
}
