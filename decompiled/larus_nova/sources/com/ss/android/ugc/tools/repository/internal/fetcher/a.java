package com.ss.android.ugc.tools.repository.internal.fetcher;

import com.bytedance.jedi.model.fetcher.SimpleFetcher;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import thc.b;
import thc.c;

/* JADX INFO: loaded from: classes40.dex */
public abstract class a<DATA, CURSOR, EXTRA> extends SimpleFetcher<Pair<? extends Integer, ? extends CURSOR>, Pair<? extends CURSOR, ? extends Pair<? extends List<? extends DATA>, ? extends EXTRA>>> implements c<DATA, EXTRA> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<CURSOR> f454848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f454849c;

    /* JADX INFO: renamed from: com.ss.android.ugc.tools.repository.internal.fetcher.a$a, reason: collision with other inner class name */
    public static final class C5454a<T, R> implements Function<Pair<? extends CURSOR, ? extends Pair<? extends List<? extends DATA>, ? extends EXTRA>>, Pair<? extends List<? extends DATA>, ? extends EXTRA>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f454850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f454851b;

        public C5454a(a r100, Object r101) {
            this.f454850a = r100;
            this.f454851b = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            Object r102 = this.f454850a.f454849c;
            monitor-enter(r102);
            a r103 = this.f454850a;     // Catch: Throwable -> L12
            if (r103.h(this.f454851b, r103.f454848b.get()) == false) goto L8;
            this.f454850a.f454848b.set((CURSOR) r101.getFirst());     // Catch: Throwable -> L12
        L8:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r102);
            return (Pair) r101.getSecond();
        L12:
            th = move-exception;
            throw th;
        }
    }

    public abstract boolean h(CURSOR r100, CURSOR r101);

    public a(CURSOR r100) {
        this.f454848b = new AtomicReference(r100);
        this.f454849c = new Object();
    }

    @Override // thc.c
    public final Single<Pair<List<DATA>, EXTRA>> c(int r100) {
        Object r101 = this.f454849c;
        monitor-enter(r101);
        CURSOR r102 = this.f454848b.get();     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        return (Single<Pair<List<DATA>, EXTRA>>) g(TuplesKt.to(Integer.valueOf(r100), r102)).firstOrError().map(new C5454a(this, r102));
    L8:
        th = move-exception;
        throw th;
    }

    @Override // thc.c
    public final Single<List<DATA>> next(int r100) {
        return (Single<List<DATA>>) c(r100).map(b.f545989a);
    }
}
