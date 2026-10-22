package com.skydoves.balloon;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class j implements o, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f406156a;

    public j(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f406156a = r100;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.f406156a;
    }

    public final int hashCode() {
        return this.f406156a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof o) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f406156a, ((FunctionAdapter) r100).getFunctionDelegate());
    }
}
