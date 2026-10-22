package com.bytedance.live.datacontext;

import com.baidu.platform.comapi.map.MapBundleKey;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class EventMember<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<T> f255063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f255064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f255065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterceptorSet<T> f255066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject f255067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f255068f;

    public static final class InterceptorSet<T> implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<a> f255069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f255070b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f255071a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f255072b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f255071a, r101.f255071a) == true) goto L12;
                return false;
            L12:
                if (this.f255072b == r101.f255072b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f255071a.hashCode() * 31;
                if (this.f255072b == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "InterceptorData(obj=" + this.f255071a + ", isAsync=" + this.f255072b + ')';
            }

            public a(Object r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                this.f255071a = r100;
                this.f255072b = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f255069a.clear();
            this.f255070b = true;
        }

        public InterceptorSet() {
            this.f255069a = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f255070b;
        }

        public final void b(Function1<? super T, Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            if (this.f255070b == false) goto L5;
            return;
        L5:
            this.f255069a.addLast(new a(r100, false));
        }

        public final void d(Function1<? super T, ? extends Single<Boolean>> r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            if (this.f255070b == false) goto L5;
            return;
        L5:
            this.f255069a.addLast(new a(r100, true));
        }

        public final Observable<T> e(final T r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (this.f255069a.isEmpty() == false) goto L6;
            com.bytedance.revenue.platform.api.core.rx.l r101 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            return Observable.just(r100);
        L6:
            ArrayDeque<a> r102 = this.f255069a;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<a> r104 = r102.iterator();
        L8:
            if (r104.hasNext() == false) goto L14;
            final a r105 = r104.next();
            if (r105.f255072b == false) goto L12;
            Object r106 = r105.f255071a;
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Function1<T of com.bytedance.live.datacontext.EventMember.InterceptorSet.filterEventAsync$lambda$1, io.reactivex.Single<kotlin.Boolean>{ com.bytedance.revenue.platform.api.core.rx.Single_jvmAndroidSharedKt.Single<kotlin.Boolean> }>{ com.bytedance.live.datacontext.EventKt.AsyncInterceptor<T of com.bytedance.live.datacontext.EventMember.InterceptorSet.filterEventAsync$lambda$1> }");
            Function1<T, Single<Boolean>> r107 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r106, 1);
        L13:
            r103.add(r107);
            goto L8
        L12:
            r107 = new EventMember$InterceptorSet$filterEventAsync$interceptorIterable$1$1(r105);
            goto L13
        L14:
            com.bytedance.revenue.platform.api.core.rx.l r108 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            return (Observable<T>) Observable.fromIterable(r103).concatMap(new e.a(new EventMember$InterceptorSet$filterEventAsync$1(r100))).onErrorReturnItem(Boolean.FALSE).all(new e.b(EventMember$InterceptorSet$filterEventAsync$2.INSTANCE)).flatMapObservable(new e.a(new EventMember$InterceptorSet$filterEventAsync$3(r100)));
        }

        public final void j(Function1<? super T, ?> r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            if (this.f255070b == false) goto L5;
            return;
        L5:
            Iterator r101 = CollectionsKt.asReversedMutable(this.f255069a).iterator();
        L7:
            if (r101.hasNext() == false) goto L15;
            if (((a) r101.next()).f255071a != r100) goto L7;
            r101.remove();
            return;
        }
    }

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventMember<T> f255073a;

        public a(EventMember<T> r100) {
            this.f255073a = r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.functions.Action
        public final void run() {
            EventMember<T> r100 = this.f255073a;
            r100.f255063a.f255086b.invoke(r100);
            r100.f255064b.onComplete();
            r100.f255065c.dispose();
            r100.f255066d.dispose();
        }
    }

    public static final class b implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventMember<T> f255074a;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        public b(EventMember<T> r100) {
            this.f255074a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            this.f255074a.f255064b.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f255074a.f255064b.onSubscribe(r100);
            this.f255074a.f255065c.add(r100);
        }
    }

    @Override // com.bytedance.live.datacontext.k
    public final b a() {
        return this.f255068f;
    }

    @Override // com.bytedance.live.datacontext.k
    public final InterceptorSet b() {
        return this.f255066d;
    }

    @Override // com.bytedance.live.datacontext.k
    public final PublishSubject onEvent() {
        return this.f255067e;
    }

    public EventMember(f<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f255063a = r100;
        int r101 = com.bytedance.revenue.platform.api.core.rx.o.f267521a;
        PublishSubject r102 = PublishSubject.create();
        this.f255064b = r102;
        this.f255065c = new CompositeDisposable();
        InterceptorSet<T> r103 = new InterceptorSet();
        this.f255066d = r103;
        if (r100.f255083d == false) goto L5;
        Observable r104 = r102.concatMap(new e.a(new EventMember$eventObservable$1$1(r103)));
    L6:
        Scheduler r105 = r100.f255087c;
        if (r105 == null) goto L9;
        r104 = r104.observeOn(r105);
    L9:
        PublishSubject r106 = PublishSubject.create();
        r104.subscribe(r106);
        r100.f255085a.subscribe(new a(this));
        this.f255067e = r106;
        this.f255068f = new b(this);
        return;
    L5:
        r104 = r102.flatMap(new e.a(new EventMember$eventObservable$1$2(r103)));
        goto L6
    }

    @Override // com.bytedance.live.datacontext.k
    public final void post(T r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f255064b.onNext(r100);
    }
}
