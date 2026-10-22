package com.relax.relaxreact;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k1<T> f405548a;

    public l1() {
    }

    public void update(Function1<? super T, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "updater");
        k1<T> r101 = this.f405548a;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        Pair<? extends T, l1<T>> r102 = r101.f405544c;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("value");
        r102 = null;
    L9:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r101.update(r100.invoke(r102.getFirst()));
    }
}
