package org.koin.core.definition;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f526137a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f526137a, ((b) r100).f526137a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1<T, Unit> r100 = this.f526137a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Callbacks(onClose=" + this.f526137a + ')';
    }

    public b(Object r100) {
        this.f526137a = null;
    }
}
