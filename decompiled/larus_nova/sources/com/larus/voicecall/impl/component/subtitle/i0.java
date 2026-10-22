package com.larus.voicecall.impl.component.subtitle;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class i0 implements Observer, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f377686a;

    public i0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f377686a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Observer) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.f377686a;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object r100) {
        this.f377686a.invoke(r100);
    }
}
