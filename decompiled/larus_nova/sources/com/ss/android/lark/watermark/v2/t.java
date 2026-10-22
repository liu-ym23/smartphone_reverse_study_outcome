package com.ss.android.lark.watermark.v2;

import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Observer<v>> f445554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q<?> f445555b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f445554a, r101.f445554a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f445555b, r101.f445555b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f445554a.hashCode() * 31) + this.f445555b.hashCode();
    }

    public final String toString() {
        return "WatermarkBundle(observer=" + this.f445554a + ", binder=" + this.f445555b + ')';
    }

    public t(WeakReference<Observer<v>> r100, q<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Intrinsics.checkNotNullParameter(r101, "binder");
        this.f445554a = r100;
        this.f445555b = r101;
    }
}
