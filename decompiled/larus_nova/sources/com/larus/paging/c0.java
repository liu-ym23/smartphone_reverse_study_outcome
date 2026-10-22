package com.larus.paging;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes29.dex */
public final class c0<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Continuation<? super PagingSource<Key, Value>>, Object> f363787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Key f363788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f363789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j<Boolean> f363790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j<Unit> f363791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Flow<k0<Value>> f363792f;

    public static final class a<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PageFetcherSnapshot<Key, Value> f363793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w0<Key, Value> f363794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Job f363795c;

        public a(PageFetcherSnapshot r100, w0 r101, CompletableJob r102) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r102, "job");
            this.f363793a = r100;
            this.f363794b = r101;
            this.f363795c = r102;
        }
    }

    public final class b<Key, Value> implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PageFetcherSnapshot<Key, Value> f363796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j<Unit> f363797b;

        @Override // com.larus.paging.e1
        public final void retry() {
            this.f363797b.a(Unit.INSTANCE);
        }

        @Override // com.larus.paging.e1
        public final void a(final f1 r100) {
            Intrinsics.checkNotNullParameter(r100, "viewportHint");
            PageFetcherSnapshot<Key, Value> r101 = this.f363796a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "viewportHint");
            p r102 = r101.f363696i;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "viewportHint");
            p.b r103 = r102.f363903a;
            if ((r100 instanceof f1.a) == false) goto L5;
            f1.a r104 = (f1.a) r100;
        L6:
            r103.a(r104, new HintHandler$processHint$1(r100));
            return;
        L5:
            r104 = null;
            goto L6
        }

        public b(c0 r100, PageFetcherSnapshot<Key, Value> r101, j<Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "pageFetcherSnapshot");
            Intrinsics.checkNotNullParameter(r102, "retryEventBus");
            this.f363796a = r101;
            this.f363797b = r102;
        }
    }

    public c0(Function1 r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f363787a = r100;
        this.f363788b = null;
        this.f363789c = r101;
        this.f363790d = new j(0);
        this.f363791e = new j(0);
        this.f363792f = SimpleChannelFlowKt.a(new PageFetcher$flow$1(null, this, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.paging.PagingSource, java.lang.Object] */
    public static final Object a(c0 r100, PagingSource r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof PageFetcher$generateNewPagingSource$1) == false) goto L7;
        PageFetcher$generateNewPagingSource$1 r103 = (PageFetcher$generateNewPagingSource$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (PagingSource) r103.L$1;
        r100 = (c0) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r106 = (PagingSource) r105;
        if ((r106 instanceof LegacyPagingSource) == false) goto L29;
        LegacyPagingSource r109 = (LegacyPagingSource) r106;
        int r110 = r100.f363789c.f363865a;
        int r111 = r109.f363661b;
        if (r111 == Integer.MIN_VALUE) goto L24;
        if (r110 == r111) goto L24;
        boolean r112 = false;
    L25:
        if (r112 == false) goto L28;
        r109.f363661b = r110;
        goto L29
    L28:
        throw new IllegalStateException(("Page size is already set to " + r109.f363661b + '.').toString());
    L24:
        r112 = true;
    L29:
        if (r106 != r101) goto L32;
        r108 = false;
    L32:
        if (r108 == false) goto L45;
        PageFetcher$generateNewPagingSource$3 r113 = new PageFetcher$generateNewPagingSource$3(r100);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r113, "onInvalidatedCallback");
        r106.f363720a.b(r113);
        if (r101 == null) goto L41;
        PageFetcher$generateNewPagingSource$4 r114 = new PageFetcher$generateNewPagingSource$4(r100);
        Intrinsics.checkNotNullParameter(r114, "onInvalidatedCallback");
        r<Function0<Unit>> r115 = r101.f363720a;
        ReentrantLock r116 = r115.f363913c;
        r116.lock();
        ((ArrayList) r115.f363914d).remove(r114);     // Catch: Throwable -> L38
        r116.unlock();
    L38:
        th = move-exception;
        r116.unlock();
        throw th;
    L41:
        if (r101 == null) goto L43;
        r101.f363720a.a();
    L43:
        return r106;
    L45:
        throw new IllegalStateException(StringsKt.trimIndent("\n            An instance of PagingSource was re-used when Pager expected to create a new\n            instance. Ensure that the pagingSourceFactory passed to Pager always returns a\n            new instance of PagingSource.\n            ").toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Function1<Continuation<? super PagingSource<Key, Value>>, Object> r117 = r100.f363787a;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = r117.invoke(r103);
        if (r105 != r106) goto L17;
    L7:
        r103 = new PageFetcher$generateNewPagingSource$1(r100, r102);
        goto L8
    }
}
