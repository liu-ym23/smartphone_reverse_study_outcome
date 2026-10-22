package com.bytedance.assem.jedi_vm.store;

import com.bytedance.assem.arch.viewModel.h;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<S> implements f<S> {
    public final BehaviorSubject<S> a;
    public final BehaviorSubject<Unit> b;
    public final a<S> c;
    public final Observable<S> d;

    public static final class a<S> {
        public final LinkedList<Function1<S, Unit>> a;
        public LinkedList<Function1<S, S>> b;

        public a() {
            this.a = new LinkedList();
            this.b = new LinkedList();
        }
    }

    public final void c() {
        a<S> r0 = this.c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r0.b.isEmpty() == false) goto L8;
        monitor-exit(r0);
        LinkedList<Function1<S, S>> r1 = null;
    L11:
        if (r1 == null) goto L24;
        Object r2 = getState();
        Iterator<T> r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r2 = ((Function1) r3.next()).invoke(r2);
        goto L14
    L16:
        this.a.onNext(r2);
        return;
    L24:
        return;
    L8:
        LinkedList<Function1<S, S>> r4 = r0.b;     // Catch: Throwable -> L18
        r0.b = new LinkedList();     // Catch: Throwable -> L18
        monitor-exit(r0);
        r1 = r4;
        goto L11
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final S getState() {
        S r0 = (S) this.a.getValue();
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r0;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final Observable<S> getObservable() {
        return this.d;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void a(Function1<? super S, ? extends S> r3) {
        a<S> r0 = this.c;
        monitor-enter(r0);
        r0.b.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);
        this.b.onNext(Unit.INSTANCE);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void b(Function1<? super S, Unit> r3) {
        a<S> r0 = this.c;
        monitor-enter(r0);
        r0.a.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);
        this.b.onNext(Unit.INSTANCE);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void setImmediate(Function1<? super S, ? extends S> r3) {
        this.a.onNext(r3.invoke(getState()));
    }

    public b(h r4, Scheduler r5) {
        BehaviorSubject<S> r6 = BehaviorSubject.createDefault(r4);
        this.a = r6;
        CompositeDisposable r0 = new CompositeDisposable();
        BehaviorSubject<Unit> r1 = BehaviorSubject.create();
        this.b = r1;
        this.c = new a();
        this.d = r6.hide();
        r0.add(r1.observeOn(r5).subscribe(new com.bytedance.assem.jedi_vm.store.a(this), new c(new RxStore$2(this))));
    }
}
