package com.larus.bmhome.social.page.datasource;

import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public abstract class FlowPagingManager<T, Key, Event extends com.larus.bmhome.social.page.datasource.event.a<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f313983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f313984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.larus.bmhome.social.page.datasource.event.e> f313985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConflatedFlow<Boolean> f313986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConflatedFlow<Unit> f313987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f313988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutexImpl f313989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableSharedFlow<Event> f313990h;

    public abstract com.larus.bmhome.social.page.datasource.event.a b();

    public abstract a<T, Key> c();

    public abstract f<T, Key> d();

    public FlowPagingManager() {
        this.f313983a = LazyKt.lazy(new b(this));
        this.f313984b = LazyKt.lazy(new c(this));
        this.f313985c = new ConcurrentLinkedQueue();
        this.f313986d = new ConflatedFlow(null);
        this.f313987e = new ConflatedFlow(null);
        this.f313988f = LazyKt.lazy(new d(this));
        this.f313989g = kotlinx.coroutines.sync.b.a();
        this.f313990h = SharedFlowKt.MutableSharedFlow$default(0, Integer.MAX_VALUE, null, 5, null);
        new FlowPagingManager$flow$1(this, null);
    }

    public static final Object a(FlowPagingManager r100, com.larus.bmhome.social.page.datasource.event.e r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof FlowPagingManager$executeOperation$1) == false) goto L7;
        FlowPagingManager$executeOperation$1 r103 = (FlowPagingManager$executeOperation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        com.larus.bmhome.social.page.datasource.event.e r108 = (com.larus.bmhome.social.page.datasource.event.e) r103.L$1;
        r100 = (FlowPagingManager) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L23:
        g r109 = (g) r105;
        return r100.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if ((r101 instanceof com.larus.bmhome.social.page.datasource.event.e.b) == false) goto L19;
        Object r110 = ((LoadStateHolder) r100.f313988f.getValue()).b(((com.larus.bmhome.social.page.datasource.event.e.b) r101).f314040a, r103);
    L17:
        r105 = r110;
        if (r105 != r106) goto L23;
        return r106;
    L19:
        if ((r101 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L26;
        r110 = ((LoadStateHolder) r100.f313988f.getValue()).a((com.larus.bmhome.social.page.datasource.event.e.a) r101, r103);
        goto L17
    L26:
        throw new NoWhenBranchMatchedException();
    L7:
        r103 = new FlowPagingManager$executeOperation$1(r100, r102);
        goto L8
    }
}
