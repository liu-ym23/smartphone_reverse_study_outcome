package com.bytedance.assem.jedi_vm.viewModel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.tiktok.proxy.NestedLifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u0003Bj\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\u0016\u0012\b\b\u0002\u0010$\u001a\u00020\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u0016\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070&\u0012'\b\u0002\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010&¢\u0006\u0004\b)\u0010*J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#¨\u0006+"}, d2 = {"Lcom/bytedance/assem/jedi_vm/viewModel/LifecycleAwareObserver;", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/reactivex/disposables/Disposable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lio/reactivex/Observer;", "d", "", "onSubscribe", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "t", "onNext", "(Ljava/lang/Object;)V", "", "e", "onError", "onComplete", "dispose", "", "isDisposed", "owner", "Landroidx/lifecycle/LifecycleOwner;", "sourceObserver", "Lio/reactivex/Observer;", "undeliveredValue", "Ljava/lang/Object;", "lastValue", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isActive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "alwaysDeliverLastValueWhenActivate", "Z", "force", "isUsedInReusedScene", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "<init>", "(Landroidx/lifecycle/LifecycleOwner;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ext_rx_view_model_release"}, k = 1, mv = {1, 4, 0})
public final class LifecycleAwareObserver<T> extends AtomicReference<Disposable> implements LifecycleEventObserver, Observer<T>, Disposable {
    private final boolean alwaysDeliverLastValueWhenActivate;
    private final boolean force;
    private final AtomicBoolean isActive;
    private final boolean isUsedInReusedScene;
    private T lastValue;
    private LifecycleOwner owner;
    private Observer<T> sourceObserver;
    private T undeliveredValue;

    public static final class a implements Runnable {
        public final /* synthetic */ LifecycleAwareObserver a;

        public a(LifecycleAwareObserver r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LifecycleAwareObserver.access$requireOwner(this.a).getLifecycle().addObserver(this.a);     // Catch: Throwable -> L4
            LifecycleAwareObserver.access$requireSourceObserver(this.a).onSubscribe(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer<T> {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Function1 r0 = this.a;
            if (r0 == null) goto L5;
            r0.invoke(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }
    }

    public final Observer<T> b() {
        Observer<T> r0 = this.sourceObserver;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("cannot access observer after destroy".toString());
    }

    public void dispose() {
        Disposable r0 = get();
        com.bytedance.assem.jedi_vm.viewModel.a.C0065a r1 = com.bytedance.assem.jedi_vm.viewModel.a.a;
        if (r0 == r1) goto L9;
        Disposable r2 = getAndSet(r1);
        if (r2 == r1) goto L10;
        if (r2 == null) goto L11;
        r2.dispose();
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean isDisposed() {
        if (get() != com.bytedance.assem.jedi_vm.viewModel.a.a) goto L5;
        return true;
    L5:
        return false;
    }

    public void onComplete() {
        b().onComplete();
    }

    public static final /* synthetic */ LifecycleOwner access$getOwner$p(LifecycleAwareObserver r0) {
        return r0.owner;
    }

    public static final /* synthetic */ Observer access$getSourceObserver$p(LifecycleAwareObserver r0) {
        return r0.sourceObserver;
    }

    public static final LifecycleOwner access$requireOwner(LifecycleAwareObserver r1) {
        LifecycleOwner r2 = r1.owner;
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("cannot access owner after destroy".toString());
    }

    public static final /* synthetic */ Observer access$requireSourceObserver(LifecycleAwareObserver r0) {
        return r0.b();
    }

    public void onError(Throwable r2) {
        if (isDisposed() == true) goto L6;
        lazySet(com.bytedance.assem.jedi_vm.viewModel.a.a);
        b().onError(r2);
        return;
    }

    public void onNext(T r2) {
        if (this.force == false) goto L6;
        b().onNext(r2);
    L9:
        this.lastValue = r2;
        return;
    L6:
        if (this.isActive.get() == false) goto L8;
        b().onNext(r2);
        goto L9
    L8:
        this.undeliveredValue = r2;
        goto L9
    }

    public void onSubscribe(Disposable r2) {
        if (compareAndSet(null, r2) == true) goto L8;
        r2.dispose();
        if (get() == com.bytedance.assem.jedi_vm.viewModel.a.a) goto L7;
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    L7:
        boolean r3 = false;
    L9:
        if (r3 == true) goto L11;
        return;
    L11:
        if (com.bytedance.assem.jedi_vm.store.e.a() == false) goto L13;
        access$requireOwner(this).getLifecycle().addObserver(this);
        access$requireSourceObserver(this).onSubscribe(this);
        return;
    L13:
        com.bytedance.assem.jedi_vm.store.e.a.post(new a(this));
        return;
    L8:
        r3 = true;
        goto L9
    }

    public static final /* synthetic */ void access$setOwner$p(LifecycleAwareObserver r0, LifecycleOwner r1) {
        r0.owner = r1;
    }

    public static final /* synthetic */ void access$setSourceObserver$p(LifecycleAwareObserver r0, Observer r1) {
        r0.sourceObserver = r1;
    }

    public void onStateChanged(LifecycleOwner r4, Lifecycle.Event r5) {
        if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L5;
        this.isActive.set(false);
    L27:
        if (r5 == Lifecycle.Event.ON_DESTROY) goto L29;
        return;
    L29:
        if (com.bytedance.assem.jedi_vm.store.e.a() == false) goto L34;
        access$requireOwner(this).getLifecycle().removeObserver(this);
        if (isDisposed() == true) goto L33;
        dispose();
    L33:
        access$setOwner$p(this, null);
        access$setSourceObserver$p(this, null);
        return;
    L34:
        com.bytedance.assem.jedi_vm.store.e.a.post(new com.bytedance.assem.jedi_vm.viewModel.b(this));
        return;
    L5:
        if ((r4 instanceof NestedLifecycleOwner) == false) goto L7;
        boolean r6 = ((NestedLifecycleOwner) r4).rQ();
    L9:
        if (this.isActive.getAndSet(true) == true) goto L27;
        if (isDisposed() == true) goto L27;
        if (r6 == false) goto L16;
        T r7 = this.undeliveredValue;
    L22:
        this.undeliveredValue = null;
        if (r7 == null) goto L27;
        onNext(r7);
        goto L27
    L16:
        if (this.alwaysDeliverLastValueWhenActivate == false) goto L21;
        r7 = this.undeliveredValue;
        if (r7 != null) goto L22;
        r7 = this.lastValue;
        goto L22
    L21:
        r7 = this.undeliveredValue;
        goto L22
    L7:
        r6 = true;
        goto L9
    }

    public LifecycleAwareObserver(LifecycleOwner r1, boolean r2, boolean r3, boolean r4, Function1<? super T, Unit> r5, Function1<? super Throwable, Unit> r6) {
        this.alwaysDeliverLastValueWhenActivate = r2;
        this.force = r3;
        this.isUsedInReusedScene = r4;
        this.owner = r1;
        this.sourceObserver = new LambdaObserver(new b(r5), new c(r6), Functions.EMPTY_ACTION, Functions.emptyConsumer());
        this.isActive = new AtomicBoolean(false);
    }

    public /* synthetic */ LifecycleAwareObserver(LifecycleOwner r10, boolean r11, boolean r12, boolean r13, Function1 r14, Function1 r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r16 & 4) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r16 & 32) == 0) goto L17;
        Function1 r8 = null;
    L18:
        this(r10, r4, r5, r6, r14, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
