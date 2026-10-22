package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f271251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f271252b;

    public a() {
    }

    public abstract boolean b();

    public abstract String d();

    public abstract void f(c r100);

    public void g() {
    }

    public void e() {
        Function1<? super Integer, Unit> r100 = this.f271251a;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(100);
    L5:
        Function0<Unit> r102 = this.f271252b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("doWhenReady");
    L8:
        r102.invoke();
    }

    public final void c(String r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c(d() + "WaitTask", r100);
    }
}
