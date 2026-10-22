package com.bytedance.creativex.mediaimport.repository.internal.publisher;

import com.bytedance.creativex.mediaimport.repository.api.PublisherResult;
import com.bytedance.creativex.mediaimport.repository.internal.main.DefaultMaterialRepositoryReleaser;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ki4.j;
import ki4.u;
import ki4.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ni4.o;

/* JADX INFO: loaded from: classes15.dex */
public final class DefaultMaterialPublisher<DATA, REGROUP_PARAM> implements v<DATA, REGROUP_PARAM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<j<DATA, REGROUP_PARAM>> f203657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f203658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f203659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j<DATA, REGROUP_PARAM> f203660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f203661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BehaviorSubject<PublisherResult<DATA>> f203662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Subject<PublisherResult<DATA>> f203663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f203664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f203665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f203666j;

    public final void d() {
        e(false);
        o r100 = this.f203661e;
        o r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fixedIterator");
        r100 = null;
    L6:
        if (r100.f519314b.hasNext() == true) goto L9;
        f();
        return;
    L9:
        o r102 = this.f203661e;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("fixedIterator");
    L14:
        if (r101.f519314b.hasNext() == false) goto L17;
        h(new DefaultMaterialPublisher$actualIterate$1(this));
        return;
    L17:
        return;
    L12:
        r101 = r102;
        goto L14
    }

    @Override // ki4.v
    public final Observable<PublisherResult<DATA>> a() {
        if (this.f203664h.compareAndSet(false, true) == false) goto L10;
        if (this.f203666j.compareAndSet(false, true) == false) goto L10;
        d();
    L10:
        return this.f203663g.hide();
    }

    @Override // ki4.v
    public final void c() {
        if (this.f203666j.get() == false) goto L7;
        this.f203665i.compareAndSet(false, true);
        return;
    L7:
        if (this.f203666j.compareAndSet(false, true) == false) goto L11;
        d();
        return;
    }

    public final void f() {
        this.f203666j.compareAndSet(true, false);
        if (this.f203665i.compareAndSet(true, false) == false) goto L9;
        e(true);
        if (this.f203666j.compareAndSet(false, true) == false) goto L10;
        d();
        return;
    L10:
        return;
    }

    public final j<DATA, REGROUP_PARAM> g() {
        j<DATA, REGROUP_PARAM> r100 = this.f203660d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("actualIterator");
        return null;
    }

    @Override // ki4.v
    public final void b(REGROUP_PARAM r100) {
        if (this.f203660d != null) goto L5;
        return;
    L5:
        o r101 = this.f203661e;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("fixedIterator");
        r101 = null;
    L8:
        r101.f519314b.b(r100);
        h(new e());
    }

    public final void e(boolean r100) {
        if (this.f203660d == null) goto L5;
        if (r100 == true) goto L5;
        return;
    L5:
        j<DATA, REGROUP_PARAM> r101 = this.f203657a.invoke();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f203660d = r101;
        j<DATA, REGROUP_PARAM> r102 = g();
        u r103 = this.f203658b;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "indexer");
        this.f203661e = new o(r103, r102);
        if (r100 == false) goto L10;
        g();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.creativex.mediaimport.repository.internal.publisher.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.creativex.mediaimport.repository.internal.publisher.a] */
    public final void h(final Function0<Unit> r100) {
        final long r101 = System.currentTimeMillis();
        o r102 = this.f203661e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fixedIterator");
        r102 = null;
    L5:
        Single r103 = r102.a().map(thc.a.f545988a).subscribeOn(Schedulers.io());
        final ?? r104 = new a(r101, this, r100);
        Consumer r105 = new b(r104);
        final ?? r106 = new c(this);
        Disposable r107 = r103.subscribe(r105, new d(r106));
        this.f203659c.add(r107);
    }

    public DefaultMaterialPublisher(h r100, u r101, DefaultMaterialRepositoryReleaser r102) {
        Intrinsics.checkNotNullParameter(r100, "iteratorProvider");
        Intrinsics.checkNotNullParameter(r101, "iteratorIndexer");
        Intrinsics.checkNotNullParameter(r102, "releaser");
        this.f203657a = r100;
        this.f203658b = r101;
        this.f203659c = new CompositeDisposable();
        f r103 = new f(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "releaser");
        ((List) r102.f203632b.getValue()).add(r103);
        BehaviorSubject<PublisherResult<DATA>> r104 = BehaviorSubject.create();
        this.f203662f = r104;
        this.f203663g = r104.toSerialized();
        this.f203664h = new AtomicBoolean(false);
        this.f203665i = new AtomicBoolean(false);
        this.f203666j = new AtomicBoolean(false);
    }
}
