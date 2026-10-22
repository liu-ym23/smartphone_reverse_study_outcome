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

/* JADX INFO: loaded from: classes14.dex */
public final class f<S extends h> implements com.bytedance.assem.arch.viewModel.f<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoroutineScope f193132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S f193133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f193134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f193135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f193136e;

    @Override // com.bytedance.assem.arch.viewModel.f
    public final S getState() {
        return (S) ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).getState();
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void onClear() {
        this.f193134c.clear();
    }

    public f() {
        this.f193136e = false;
        this.f193134c = new CompositeDisposable();
        this.f193135d = LazyKt.lazy(new RxViewModelDispatcher$store$2(this));
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void a(Function1<? super S, ? extends S> r100) {
        ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).a(r100);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void c(Function1<? super S, Unit> r100) {
        ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).b(r100);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void e(CoroutineScope r100) {
        this.f193132a = r100;
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void f(S r100) {
        this.f193133b = r100;
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void h(Function1<? super S, ? extends S> r100) {
        ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).setImmediate(r100);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void d(LifecycleOwner r110, i r111, Function1 r112, Function1 r113) {
        Observable r100 = ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).getObservable();
        r111.getClass();
        i(r100.distinctUntilChanged(i.a.f193089a), r110, r111.f193087a, com.bytedance.assem.jedi_vm.store.e.f193108b, r112, r113);
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void g(KProperty1 r110, final i r111, Function0 r112, final Function1 r113) {
        Observable r100 = ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).getObservable().filter(new e(r112, r111)).map(new d(r110));
        r111.getClass();
        Observable r101 = r100.distinctUntilChanged(i.a.f193089a);
        HostInjector.a();
        final Function1 r102 = null;
        final LifecycleOwner r103 = null;
        i(r101, null, r111.f193087a, com.bytedance.assem.jedi_vm.store.e.f193108b, null, new RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$2(this, r103, r111, r102, r113));
    }

    @Override // com.bytedance.assem.arch.viewModel.f
    public final void b(KProperty1 r110, final i r111, Function0 r112, final Function1 r113, final Function0 r210, final Function1 r211) {
        Observable r100 = ((com.bytedance.assem.jedi_vm.store.f) this.f193135d.getValue()).getObservable().filter(new e(r112, r111)).map(new c(r110));
        r111.getClass();
        Observable r114 = r100.distinctUntilChanged(i.a.f193089a);
        HostInjector.a();
        final Function1 r101 = null;
        final LifecycleOwner r102 = null;
        i(r114, null, r111.f193087a, com.bytedance.assem.jedi_vm.store.e.f193108b, null, new RxViewModelDispatcher$asyncSubscribe$$inlined$selectSubscribeMapped$2(this, r102, r111, r101, r210, r113, r211));
    }

    public final Disposable i(Observable r100, LifecycleOwner r101, boolean r110, com.bytedance.assem.jedi_vm.store.d r111, Function1 r112, Function1 r113) {
        if (r101 != null) goto L8;
        if (r111 == null) goto L6;
        r100 = r100.observeOn(r111);
    L6:
        Disposable r102 = r100.subscribe(new g(r113));
        this.f193134c.add(r102);
        return r102;
    L8:
        if (r111 == null) goto L10;
        r100 = r100.observeOn(r111);
    L10:
        Disposable r103 = (Disposable) r100.subscribeWith(new LifecycleAwareObserver(r101, !r110, false, false, r113, r112));
        this.f193134c.add(r103);
        return r103;
    }
}
