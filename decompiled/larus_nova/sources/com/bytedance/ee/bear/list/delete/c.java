package com.bytedance.ee.bear.list.delete;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeleteExecutor f227853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f227854b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(DeleteExecutor r100, Function1<? super Throwable, Unit> r101) {
        this.f227853a = r100;
        this.f227854b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e(this.f227853a.f227814b, " create task error", r101, false);
        Function1<Throwable, Unit> r102 = this.f227854b;
        Intrinsics.checkNotNull(r101);
        r102.invoke(r101);
    }
}
