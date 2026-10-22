package com.bytedance.assem.jedi_vm.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.assem.arch.viewModel.h;
import com.bytedance.assem.arch.viewModel.i;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<S extends h> implements com.bytedance.assem.arch.viewModel.f<S> {
    public CoroutineScope a;
    public S b;
    public final CompositeDisposable c;
    public final Lazy d;
    public final boolean e;

    @Override // com.bytedance.assem.arch.viewModel.f
    public final S getState() {
        return (S) ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).getState();
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void onClear() {
        this.c.clear();
    }

    public f() {
        this.e = false;
        this.c = new CompositeDisposable();
        this.d = LazyKt.lazy(new RxViewModelDispatcher$store$2(this));
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void a(Function1<? super S, ? extends S> r2) {
        ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).a(r2);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void c(Function1<? super S, Unit> r2) {
        ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).b(r2);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void e(CoroutineScope r1) {
        this.a = r1;
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void f(S r1) {
        this.b = r1;
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void h(Function1<? super S, ? extends S> r2) {
        ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).setImmediate(r2);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void d(LifecycleOwner r10, i r11, Function1 r12, Function1 r13) {
        Observable r0 = ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).getObservable();
        r11.getClass();
        i(r0.distinctUntilChanged(i.a.a), r10, r11.a, com.bytedance.assem.jedi_vm.store.e.b, r12, r13);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void g(KProperty1 r14, final i r15, Function0 r16, final Function1 r17) {
        Observable r0 = ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).getObservable().filter(new e(r16, r15)).map(new d(r14));
        r15.getClass();
        Observable r9 = r0.distinctUntilChanged(i.a.a);
        HostInjector.a();
        final Function1 r4 = null;
        final LifecycleOwner r2 = null;
        i(r9, null, r15.a, com.bytedance.assem.jedi_vm.store.e.b, null, new RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$2(this, r2, r15, r4, r17));
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void b(KProperty1 r16, final i r17, Function0 r18, final Function1 r19, final Function0 r20, final Function1 r21) {
        Observable r0 = ((com.bytedance.assem.jedi_vm.store.f) this.d.getValue()).getObservable().filter(new e(r18, r17)).map(new c(r16));
        r17.getClass();
        Observable r11 = r0.distinctUntilChanged(i.a.a);
        HostInjector.a();
        final Function1 r4 = null;
        final LifecycleOwner r2 = null;
        i(r11, null, r17.a, com.bytedance.assem.jedi_vm.store.e.b, null, new RxViewModelDispatcher$asyncSubscribe$$inlined$selectSubscribeMapped$2(this, r2, r17, r4, r20, r19, r21));
    }

    public final Disposable i(Observable r8, LifecycleOwner r9, boolean r10, com.bytedance.assem.jedi_vm.store.d r11, Function1 r12, Function1 r13) {
        if (r9 != null) goto L8;
        if (r11 == null) goto L6;
        r8 = r8.observeOn(r11);
    L6:
        Disposable r14 = r8.subscribe(new g(r13));
        this.c.add(r14);
        return r14;
    L8:
        if (r11 == null) goto L10;
        r8 = r8.observeOn(r11);
    L10:
        Disposable r15 = r8.subscribeWith(new LifecycleAwareObserver(r9, !r10, false, false, r13, r12));
        this.c.add(r15);
        return r15;
    }
}
