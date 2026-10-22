package com.skydoves.balloon;

import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class i implements n, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f406153a;

    public i(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f406153a = r100;
    }

    @Override // com.skydoves.balloon.n
    public final /* synthetic */ void a() {
        this.f406153a.invoke();
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.f406153a;
    }

    public final int hashCode() {
        return this.f406153a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof n) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f406153a, ((FunctionAdapter) r100).getFunctionDelegate());
    }
}
