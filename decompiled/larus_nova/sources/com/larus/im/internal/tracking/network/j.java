package com.larus.im.internal.tracking.network;

import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j implements p, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.im.internal.delegate.c f350374a;

    public j(com.larus.im.internal.delegate.c r100) {
        this.f350374a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof p) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(0, this.f350374a, com.larus.im.internal.delegate.c.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.larus.im.internal.tracking.network.p
    public final long elapsedRealtime() {
        return this.f350374a.elapsedRealtime();
    }
}
