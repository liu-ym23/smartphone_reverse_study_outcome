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

/* JADX INFO: loaded from: classes14.dex */
public final class b<S> implements f<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<S> f193091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<Unit> f193092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<S> f193093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Observable<S> f193094d;

    public static final class a<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList<Function1<S, Unit>> f193095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedList<Function1<S, S>> f193096b;

        public a() {
            this.f193095a = new LinkedList();
            this.f193096b = new LinkedList();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c() {
        a<S> r100 = this.f193093c;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r100.f193096b.isEmpty() == false) goto L8;
        monitor-exit(r100);
        LinkedList<Function1<S, S>> r101 = null;
    L11:
        if (r101 == null) goto L24;
        S r102 = getState();
        Iterator<T> r103 = r101.iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        r102 = (S) ((Function1) r103.next()).invoke(r102);
        goto L14
    L16:
        this.f193091a.onNext(r102);
        return;
    L24:
        return;
    L8:
        LinkedList<Function1<S, S>> r104 = r100.f193096b;     // Catch: Throwable -> L18
        r100.f193096b = new LinkedList();     // Catch: Throwable -> L18
        monitor-exit(r100);
        r101 = r104;
        goto L11
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final S getState() {
        S r100 = this.f193091a.getValue();
        if (r100 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r100;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final Observable<S> getObservable() {
        return this.f193094d;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void a(Function1<? super S, ? extends S> r100) {
        a<S> r101 = this.f193093c;
        monitor-enter(r101);
        r101.f193096b.add(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);
        this.f193092b.onNext(Unit.INSTANCE);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void b(Function1<? super S, Unit> r100) {
        a<S> r101 = this.f193093c;
        monitor-enter(r101);
        r101.f193095a.add(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);
        this.f193092b.onNext(Unit.INSTANCE);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.assem.jedi_vm.store.f
    public final void setImmediate(Function1<? super S, ? extends S> r100) {
        this.f193091a.onNext(r100.invoke(getState()));
    }

    public b(h r100, Scheduler r101) {
        BehaviorSubject<S> r102 = BehaviorSubject.createDefault(r100);
        this.f193091a = r102;
        CompositeDisposable r103 = new CompositeDisposable();
        BehaviorSubject<Unit> r104 = BehaviorSubject.create();
        this.f193092b = r104;
        this.f193093c = new a();
        this.f193094d = r102.hide();
        r103.add(r104.observeOn(r101).subscribe(new com.bytedance.assem.jedi_vm.store.a(this), new c(new RxStore$2(this))));
    }
}
