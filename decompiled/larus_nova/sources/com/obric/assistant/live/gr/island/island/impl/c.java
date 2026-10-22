package com.obric.assistant.live.gr.island.island.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StackTraceElement[] f390086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Continuation<? super Unit>, Object> f390087b;

    public c() {
        throw null;
    }

    public final String toString() {
        return "IslandTask(creationStack=" + Arrays.toString(this.f390086a) + ", block=" + this.f390087b + ')';
    }

    public final int hashCode() {
        return this.f390087b.hashCode();
    }

    public c(Function1 r100) {
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f390086a = r101;
        this.f390087b = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(c.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.impl.IslandTask");
        return Intrinsics.areEqual(this.f390087b, ((c) r100).f390087b);
    L8:
        r101 = null;
        goto L10
    }
}
