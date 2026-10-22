package com.larus.network.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f360199d;

    public w() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f360199d, ((w) r100).f360199d) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f360199d;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Loading(value=" + this.f360199d + ')';
    }

    public w(T r100) {
        super(false, r100, null);
        this.f360199d = r100;
    }
}
