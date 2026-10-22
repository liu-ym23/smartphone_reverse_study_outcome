package com.bytedance.assem.jedi_vm.store;

import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface f<S> {
    void a(Function1<? super S, ? extends S> r1);

    void b(Function1<? super S, Unit> r1);

    Observable<S> getObservable();

    S getState();

    void setImmediate(Function1<? super S, ? extends S> r1);
}
