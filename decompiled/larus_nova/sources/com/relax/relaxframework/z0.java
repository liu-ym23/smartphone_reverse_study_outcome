package com.relax.relaxframework;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class z0 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Object, Unit> f405369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventBindType f405370b;

    @Override // com.relax.relaxframework.q1
    public final void a(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = b(r100);
        Function1<Object, Unit> r102 = this.f405369a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_action");
        r102 = null;
    L5:
        r102.invoke(r101);
    }

    public Object b(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return new Object();
    }

    public z0(Function1<Object, Unit> r100, EventBindType r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        this.f405369a = r100;
        this.f405370b = r101;
    }
}
