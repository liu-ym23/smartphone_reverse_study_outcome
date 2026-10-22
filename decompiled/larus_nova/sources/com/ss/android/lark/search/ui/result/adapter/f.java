package com.ss.android.lark.search.ui.result.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends T> f440292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<? super T, ?> f440293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<T> f440294c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f440292a, r101.f440292a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f440293b, r101.f440293b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f440294c, r101.f440294c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f440292a.hashCode() * 31) + this.f440293b.hashCode()) * 31) + this.f440294c.hashCode();
    }

    public final String toString() {
        return "Type(clazz=" + this.f440292a + ", delegate=" + this.f440293b + ", linker=" + this.f440294c + ')';
    }

    public f(Class r100, b r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        Intrinsics.checkNotNullParameter(r102, "linker");
        this.f440292a = r100;
        this.f440293b = r101;
        this.f440294c = r102;
    }
}
