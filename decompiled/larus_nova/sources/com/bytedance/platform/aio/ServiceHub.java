package com.bytedance.platform.aio;

import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class ServiceHub implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<com.bytedance.platform.aio.a> f266546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.platform.aio.a> f266547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<Pair<String, com.bytedance.platform.aio.a>> f266548c;

    public static final class a<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f266549a;

        public a(String r100) {
            this.f266549a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Intrinsics.areEqual((String) r101.getFirst(), this.f266549a);
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f266550a = null;

        static {
            f266550a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (com.bytedance.platform.aio.a) r101.getSecond();
        }
    }

    public ServiceHub() {
        this.f266546a = new LinkedHashSet();
        this.f266547b = new ConcurrentHashMap();
        int r100 = o.f267521a;
        this.f266548c = PublishSubject.create();
    }

    @Override // com.bytedance.platform.aio.c
    public final com.bytedance.platform.aio.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        com.bytedance.platform.aio.a r101 = this.f266547b.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Iterator<T> r102 = this.f266546a.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.platform.aio.a) r103).d(r100) == false) goto L7;
    L13:
        return (com.bytedance.platform.aio.a) r103;
    L11:
        r103 = null;
        goto L13
    }

    public final void c(final com.bytedance.platform.aio.a r100) {
        Intrinsics.checkNotNullParameter(r100, "driver");
        if (this.f266546a.remove(r100) == false) goto L6;
        r100.i(this);
        CollectionsKt.removeAll(this.f266547b.entrySet(), new ServiceHub$unloadDriver$1(r100));
        return;
    }

    public final Single<com.bytedance.platform.aio.a> d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        l r101 = l.f267516a;
        PublishSubject<Pair<String, com.bytedance.platform.aio.a>> r102 = this.f266548c;
        final Function0<Observable<Pair<? extends String, ? extends com.bytedance.platform.aio.a>>> r103 = new ServiceHub$waitForService$1(this, r100);
        return Observable.merge(r102, Observable.defer(new e(r103))).filter(new a(r100)).firstOrError().map(b.f266550a);
    }

    @Override // com.bytedance.platform.aio.c
    public final void a(String r100, com.bytedance.platform.aio.a r101) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        Intrinsics.checkNotNullParameter(r101, "driver");
        if (this.f266546a.contains(r101) == false) goto L6;
        this.f266547b.put(r100, r101);
        this.f266548c.onNext(TuplesKt.to(r100, r101));
        return;
    }
}
