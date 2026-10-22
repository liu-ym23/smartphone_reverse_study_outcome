package com.skydoves.balloon;

import ac9.x;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Function;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class k implements p, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f406157a;

    public k(x r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f406157a = r100;
    }

    @Override // com.skydoves.balloon.p
    public final /* synthetic */ void a(View r100, MotionEvent r101) {
        this.f406157a.invoke(r100, r101);
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.f406157a;
    }

    public final int hashCode() {
        return this.f406157a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof p) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f406157a, ((FunctionAdapter) r100).getFunctionDelegate());
    }
}
