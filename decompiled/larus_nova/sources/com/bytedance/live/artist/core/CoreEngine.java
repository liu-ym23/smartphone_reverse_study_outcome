package com.bytedance.live.artist.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.SemaphoreImpl;
import lf6.d;

/* JADX INFO: loaded from: classes45.dex */
public final class CoreEngine {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f254793u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f254794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableJob f254795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f254796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f254797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f254798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f254799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f254800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Channel<Runnable> f254801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f254802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Channel<Float> f254803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f254804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Runnable> f254805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Runnable> f254806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SemaphoreImpl f254807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f254808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.live.artist.core.b f254809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f254810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f254811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final kf6.a f254812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.live.artist.render.c f254813t;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoreEngine f254814a;

        public a(CoroutineExceptionHandler.Key r100, CoreEngine r101) {
            this.f254814a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            this.f254814a.f254812s.error("core coroutine exception", r101);
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoreEngine f254815a;

        public b(CoroutineExceptionHandler.Key r100, CoreEngine r101) {
            this.f254815a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            this.f254815a.f254812s.error("main coroutine exception", r101);
        }
    }

    public static final class c {
    }

    /* JADX INFO: renamed from: com.bytedance.live.artist.core.CoreEngine$update$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$update$1", f = "CoreEngine.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C106301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $deltaTimeInMs;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoreEngine this$0;

        public C106301(CoreEngine r100, float r101, Continuation r102) {
            this.this$0 = r100;
            this.$deltaTimeInMs = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C106301 r102 = new C106301(this.this$0, this.$deltaTimeInMs, r101);
            r102.p$ = (CoroutineScope) r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C106301) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r104 = this.p$;
            Channel<Float> r105 = this.this$0.f254803j;
            Float r106 = Boxing.boxFloat(this.$deltaTimeInMs);
            this.L$0 = r104;
            this.label = 1;
            if (r105.send(r106, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public final void e() {
        BuildersKt.launch$default(this.f254798e, null, null, new CoreEngine$release$1(this, null), 3, null);
    }

    public final void f() {
        BuildersKt.launch$default(this.f254798e, null, null, new CoreEngine$start$1(this, null), 3, null);
    }

    public final void g() {
        BuildersKt.launch$default(this.f254798e, null, null, new CoreEngine$stop$1(this, null), 3, null);
    }

    public static final void a(CoreEngine r100) {
        r100.f254799f = false;
        r100.f254813t.b();
        Job r101 = r100.f254804k;
        if (r101 == null) goto L5;
        JobKt.cancel$default(r101, "stop", null, 2, null);
    L5:
        r100.f254804k = null;
        Job r102 = r100.f254802i;
        if (r102 == null) goto L8;
        JobKt.cancel$default(r102, "stop", null, 2, null);
    L8:
        r100.f254802i = null;
        Channel<Runnable> r103 = r100.f254801h;
        if (r103 == null) goto L11;
        r103.close(null);
    L11:
        r100.f254801h = null;
    }

    private final void update(float r100) {
        if (this.f254799f == true) goto L6;
        return;
    L6:
        if (r100 > 0) goto L9;
        r100 = 1000.0f / this.f254810q;
    L9:
        BuildersKt.launch$default(this.f254797d, null, null, new C106301(this, r100, null), 3, null);
    }

    public final void d(Runnable r100) {
        BuildersKt.launch$default(this.f254797d, null, null, new CoreEngine$postRunnable$1(this, r100, null), 3, null);
    }

    public static final /* synthetic */ void b(CoreEngine r100, float r101) {
        r100.update(r101);
    }

    public final /* synthetic */ Object c(Runnable r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof CoreEngine$post$1) == false) goto L7;
        CoreEngine$post$1 r102 = (CoreEngine$post$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        kotlinx.coroutines.sync.c r107 = (kotlinx.coroutines.sync.c) r102.L$2;
        Runnable r108 = (Runnable) r102.L$1;
        CoreEngine r109 = (CoreEngine) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.c r110 = r107;
        r100 = r108;
    L24:
        Boxing.boxBoolean(((ArrayList) r109.f254805l).add(r100));     // Catch: Throwable -> L21
        r110.release();
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r110.release();
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        SemaphoreImpl r111 = this.f254807n;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r111;
        r102.label = 1;
        if (r111.c(r102) != r105) goto L17;
        return r105;
    L17:
        r109 = this;
        r110 = r111;
    L7:
        r102 = new CoreEngine$post$1(this, r101);
        goto L8
    }

    public CoreEngine(kf6.a r100, com.bytedance.live.artist.render.c r101, d r102, Executor r103) {
        this.f254812s = r100;
        this.f254813t = r101;
        if (r103 != null) goto L6;
        r103 = PThreadExecutorsUtils.newScheduledThreadPool(2, new com.bytedance.live.artist.core.a());
    L6:
        this.f254794a = r103;
        CoroutineDispatcher r104 = ExecutorsKt.from(r103);
        CompletableJob r105 = JobKt.Job$default(null, 1, null);
        this.f254795b = r105;
        CoroutineExceptionHandler.Key r106 = CoroutineExceptionHandler.Key;
        a r107 = new a(r106, this);
        CoroutineContext r108 = r105.plus(r104).plus(r107);
        this.f254796c = r108;
        this.f254797d = CoroutineScopeKt.CoroutineScope(r108);
        b r109 = new b(r106, this);
        this.f254798e = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()).plus(r109));
        this.f254803j = ChannelKt.Channel(-1);
        this.f254805l = new ArrayList();
        this.f254806m = new ArrayList();
        int r110 = kotlinx.coroutines.sync.d.f505140a;
        this.f254807n = new SemaphoreImpl(1, 0);
        this.f254808o = new CoreEngine$executePendingRunnablesAction$1(this);
        this.f254809p = new com.bytedance.live.artist.core.b(this);
        this.f254810q = 60;
        int r111 = d.f509064b;
        d.a r112 = new d.a();
        lf6.b r113 = new lf6.b();
        ((ArrayList) r112.f509066a).add(r113);
        List<lf6.c> r114 = r112.f509066a;
        ArrayList r115 = (ArrayList) r114;
        r115.addAll(r102.f509065a);
        lf6.a r116 = new lf6.a();
        ((ArrayList) r112.f509066a).add(r116);
        d r117 = new d(r112.f509066a);
        this.f254811r = r117;
        r117.a(new AnonymousClass1(this));
    }
}
