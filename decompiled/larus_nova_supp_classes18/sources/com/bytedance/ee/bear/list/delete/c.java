package com.bytedance.ee.bear.list.delete;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ DeleteExecutor a;
    public final /* synthetic */ Function1<Throwable, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(DeleteExecutor r1, Function1<? super Throwable, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e(this.a.b, " create task error", r5, false);
        Function1<Throwable, Unit> r0 = this.b;
        Intrinsics.checkNotNull(r5);
        r0.invoke(r5);
    }
}
