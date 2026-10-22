package com.bytedance.kmp.performance.api;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<D, Unit>> f252616a;

    public b() {
        this.f252616a = new CopyOnWriteArrayList();
    }

    public final void a(D r100) {
        ListIterator<Function1<D, Unit>> r101 = this.f252616a.listIterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().invoke(r100);
        goto L4
    }

    public final a b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f252616a.add(r100);
        return new a(this, r100);
    }
}
