package com.bytedance.assem.jedi_vm.store;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Unit r4 = (Unit) r3;
        b r5 = this.a;
    L3:
        b.a<S> r0 = r5.c;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (r0.a.isEmpty() == false) goto L9;
        monitor-exit(r0);
        Function1 r1 = null;
    L12:
        r5.c();
        if (r1 == null) goto L14;
        r1.invoke(r5.getState());
        goto L3
    L14:
        return;
    L9:
        Function1 r2 = (Function1) r0.a.removeFirst();     // Catch: Throwable -> L16
        monitor-exit(r0);
        r1 = r2;
        goto L12
    }
}
