package com.bytedance.assem.jedi_vm.store;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements Consumer<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f193090a;

    public a(b r100) {
        this.f193090a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Unit r100) {
        b r101 = this.f193090a;
    L3:
        b.a<S> r102 = r101.f193093c;
        monitor-enter(r102);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (r102.f193095a.isEmpty() == false) goto L9;
        monitor-exit(r102);
        Function1 r103 = null;
    L12:
        r101.c();
        if (r103 == null) goto L14;
        r103.invoke(r101.getState());
        goto L3
    L14:
        return;
    L9:
        Function1 r104 = (Function1) r102.f193095a.removeFirst();     // Catch: Throwable -> L16
        monitor-exit(r102);
        r103 = r104;
        goto L12
    }
}
