package com.relax.relaxframework;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class CustomEventListener<T> extends z0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super o0, ? extends T> f404706c;

    @Override // com.relax.relaxframework.z0
    public final Object b(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        o0 r101 = (o0) r100;
        Function1<? super o0, ? extends T> r102 = this.f404706c;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("eventObjectCreator");
        r102 = null;
    L6:
        return r102.invoke(r101);
    }

    public CustomEventListener(final Function1<? super T, Unit> r100, EventBindType r101, Function1<? super o0, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "eventObjectCreator");
        super(new AnonymousClass1(r100), r101);
        this.f404706c = r102;
    }
}
