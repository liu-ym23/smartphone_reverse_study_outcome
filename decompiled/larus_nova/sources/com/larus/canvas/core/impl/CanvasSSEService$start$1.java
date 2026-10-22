package com.larus.canvas.core.impl;

import com.larus.canvas.core.impl.sse.CanvasGetInfoCompensator;
import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.d1;
import cy8.c;
import cy8.u;
import cy8.w;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1;
import ouc.d0;
import ouc.e0;
import ouc.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.CanvasSSEService$start$1", f = "CanvasSSEService.kt", i = {0, 0, 0, 0, 1}, l = {82, 136}, m = "invokeSuspend", n = {"$this$flow", "mobEndLock", "mobEndReported", "cancelSignal", "cancelSignal"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
public final class CanvasSSEService$start$1 extends SuspendLambda implements Function2<FlowCollector<? super u>, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $mob;
    final /* synthetic */ w $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CanvasSSEService this$0;

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.CanvasSSEService$start$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.core.impl.CanvasSSEService$start$1$1", f = "CanvasSSEService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<u, Continuation<? super Boolean>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $cancelSignal;
        int label;

        public AnonymousClass1(CompletableDeferred<Unit> r100, Continuation<? super AnonymousClass1> r101) {
            this.$cancelSignal = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$cancelSignal, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(u r100, Continuation<? super Boolean> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Boolean> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            return Boxing.boxBoolean(!this.$cancelSignal.isCompleted());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.CanvasSSEService$start$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Unit> f322939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f322940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CanvasSSEService f322941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w f322942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<u> f322943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f322944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f322945g;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(CompletableDeferred<Unit> r100, a r101, CanvasSSEService r102, w r103, FlowCollector<? super u> r104, Object r105, Ref.BooleanRef r106) {
            this.f322939a = r100;
            this.f322940b = r101;
            this.f322941c = r102;
            this.f322942d = r103;
            this.f322943e = r104;
            this.f322944f = r105;
            this.f322945g = r106;
        }

        public final Object a(u r210, Continuation<? super Unit> r211) {
            if ((r211 instanceof CanvasSSEService$start$1$2$emit$1) == false) goto L7;
            CanvasSSEService$start$1$2$emit$1 r100 = (CanvasSSEService$start$1$2$emit$1) r211;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            String r105 = null;
            if (r104 == 0) goto L18;
            if (r104 == 1) goto L17;
            if (r104 == 2) goto L16;
            if (r104 != 3) goto L15;
            ResultKt.throwOnFailure(r102);
        L31:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r102);
        L68:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r102);
        L48:
            u r106 = (u) r102;
            Object r107 = this.f322944f;
            a r108 = this.f322940b;
            Ref.BooleanRef r109 = this.f322945g;
            CanvasSSEService r110 = this.f322941c;
            w r111 = this.f322942d;
            int r112 = CanvasSSEService.f322934f;
            r110.getClass();
            if ((r106 instanceof u.c) == false) goto L55;
            c r113 = ((u.c) r106).f465915a;
            if (r113 == null) goto L53;
            r105 = r113.f465814c;
        L53:
            a.C4157a r114 = new a.C4157a(0, "", 0, r105, r111.f465935c);
        L64:
            CanvasSSEService$start$1.access$invokeSuspend$reportMobEndOnce(r107, r108, r109, r114);
            FlowCollector<u> r115 = this.f322943e;
            r100.label = 2;
            if (r115.emit(r106, r100) != r103) goto L68;
            return r103;
        L55:
            if ((r106 instanceof u.d) == false) goto L63;
            u.d r116 = (u.d) r106;
            String r117 = r116.f465917b;
            if (r117 != null) goto L59;
            r117 = "";
        L59:
            int r118 = r116.f465916a;
            c r119 = r116.f465918c;
            if (r119 == null) goto L62;
            r105 = r119.f465814c;
        L62:
            r114 = new a.C4157a(1, r117, r118, r105, r111.f465935c);
            goto L64
        L63:
            r114 = new a.C4157a(1, "", 1, null, r111.f465935c);
            goto L64
        L18:
            ResultKt.throwOnFailure(r102);
            if (this.f322939a.isCompleted() == true) goto L21;
            this.f322940b.f322946a++;
            boolean r120 = r210 instanceof u.c;
            if (r120 == false) goto L25;
        L32:
            if (r120 == false) goto L34;
            u.c r121 = (u.c) r210;
        L35:
            if (r121 == null) goto L39;
            c r122 = r121.f465915a;
            if (r122 == null) goto L39;
        L45:
            CanvasGetInfoCompensator r123 = this.f322941c.f322936c;
            w r124 = this.f322942d;
            r100.label = 1;
            r102 = r123.a(r124, r210, r122, r100);
            if (r102 != r103) goto L48;
            return r103;
        L39:
            if ((r210 instanceof u.d) == false) goto L41;
            u.d r125 = (u.d) r210;
        L42:
            if (r125 == null) goto L44;
            r122 = r125.f465918c;
            goto L45
        L44:
            r122 = null;
            goto L45
        L41:
            r125 = null;
            goto L42
        L34:
            r121 = null;
            goto L35
        L25:
            if ((r210 instanceof u.d) == true) goto L32;
            FlowCollector<u> r126 = this.f322943e;
            r100.label = 3;
            if (r126.emit(r210, r100) != r103) goto L31;
            return r103;
        L21:
            return Unit.INSTANCE;
        L7:
            r100 = new CanvasSSEService$start$1$2$emit$1(this, r211);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((u) r100, r101);
        }
    }

    public CanvasSSEService$start$1(CanvasSSEService r100, a r101, w r102, Continuation<? super CanvasSSEService$start$1> r103) {
        this.this$0 = r100;
        this.$mob = r101;
        this.$params = r102;
        super(2, r103);
    }

    public static final /* synthetic */ void access$invokeSuspend$reportMobEndOnce(Object r100, a r101, Ref.BooleanRef r102, a.C4157a r103) {
        a(r100, r101, r102, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CanvasSSEService$start$1 r102 = new CanvasSSEService$start$1(this.this$0, this.$mob, this.$params, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super u> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super u> r100, Continuation<? super Unit> r101) {
        return ((CanvasSSEService$start$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L20;
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L12;
        CompletableDeferred r102 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L9
        Object r103 = r102;
    L68:
        CanvasSSEService r104 = this.this$0;
        Object r105 = r104.f322938e;
        w r106 = this.$params;
        monitor-enter(r105);
    L77:
        th = move-exception;
        throw th;
    L71:
        if (((LinkedHashMap) r104.f322937d).get(r106.f465933a) != r103) goto L73;
        r104.f322937d.remove(r106.f465933a);     // Catch: Throwable -> L77
    L73:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r105);
    L76:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        CompletableDeferred<Unit> r108 = (CompletableDeferred) this.L$3;
        Ref.BooleanRef r109 = (Ref.BooleanRef) this.L$2;
        Object r110 = this.L$1;
        FlowCollector r111 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L16 CancellationException -> L18
        r108 = r108;
    L35:
        if (r108.isCompleted() == false) goto L37;
        a(r110, this.$mob, r109, new a.C4157a(2, "", 0, null, this.$params.f465935c));     // Catch: Throwable -> L16 CancellationException -> L18
    L37:
        CanvasSSEService r112 = this.this$0;
        Object r113 = r112.f322938e;
        w r114 = this.$params;
        monitor-enter(r113);
    L45:
        th = move-exception;
        throw th;
    L40:
        if (((LinkedHashMap) r112.f322937d).get(r114.f465933a) != r108) goto L42;
        r112.f322937d.remove(r114.f465933a);     // Catch: Throwable -> L45
    L42:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r113);
    L18:
        e = e;
        Ref.BooleanRef r116 = r109;
        Object r117 = r110;
    L85:
        a r118 = this.$mob;     // Catch: Throwable -> L9
        String r119 = e.getMessage();     // Catch: Throwable -> L9
        if (r119 != null) goto L88;
        r119 = "";
    L88:
        a(r117, r118, r116, new a.C4157a(2, r119, 0, null, this.$params.f465935c));     // Catch: Throwable -> L9
        throw e;     // Catch: Throwable -> L9
    L16:
        th = th;
        Object r120 = r108;
        Ref.BooleanRef r121 = r109;
        Object r122 = r110;
        FlowCollector r123 = r111;
    L109:
        c0.f348199b.e("SSE_KMP", "start error sessionId=" + this.$params.f465933a + " type=" + Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName() + " msg=" + th.getMessage());     // Catch: Throwable -> L80
        a r124 = this.$mob;     // Catch: Throwable -> L80
        String r125 = th.getMessage();     // Catch: Throwable -> L80
        if (r125 != null) goto L64;
        r125 = "";
    L64:
        a(r122, r124, r121, new a.C4157a(1, r125, 1, null, this.$params.f465935c));     // Catch: Throwable -> L80
        u.d r126 = new u.d(1, th.getMessage(), null);     // Catch: Throwable -> L80
        this.L$0 = r120;     // Catch: Throwable -> L80
        this.L$1 = null;     // Catch: Throwable -> L80
        this.L$2 = null;     // Catch: Throwable -> L80
        this.L$3 = null;     // Catch: Throwable -> L80
        this.label = 2;     // Catch: Throwable -> L80
        if (r123.emit(r126, this) != r100) goto L67;
        return r100;
    L67:
        r103 = r120;
    L80:
        th = th;
    L91:
        CanvasSSEService r127 = this.this$0;
        Object r128 = r127.f322938e;
        w r129 = this.$params;
        monitor-enter(r128);
    L99:
        th = move-exception;
        throw th;
    L94:
        if (((LinkedHashMap) r127.f322937d).get(r129.f465933a) != r120) goto L96;
        r127.f322937d.remove(r129.f465933a);     // Catch: Throwable -> L99
    L96:
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L99
        monitor-exit(r128);
        throw th;
    L20:
        ResultKt.throwOnFailure(r210);
        r123 = (FlowCollector) this.L$0;
        Object r131 = new Object();
        Ref.BooleanRef r132 = new Ref.BooleanRef();
        CompletableDeferred<Unit> r133 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CanvasSSEService r134 = this.this$0;
        Object r135 = r134.f322938e;
        w r136 = this.$params;
        monitor-enter(r135);
        CompletableDeferred<Unit> r137 = r134.f322937d.put(r136.f465933a, r133);     // Catch: Throwable -> L102
        monitor-exit(r135);
        if (r137 == null) goto L120;
        Boxing.boxBoolean(r137.complete(Unit.INSTANCE));
    L120:
        this.$mob.a(this.$params);     // Catch: Throwable -> L58 CancellationException -> L82
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 r138 = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(this.this$0.f322935b.c(this.$params), new AnonymousClass1(r133, null));     // Catch: Throwable -> L58 CancellationException -> L82
        CompletableDeferred<Unit> r139 = r133;
        Object r140 = r131;
        AnonymousClass2 r141 = new AnonymousClass2(r133, this.$mob, this.this$0, this.$params, r123, r131, r132);     // Catch: Throwable -> L54 CancellationException -> L56
        this.L$0 = r123;     // Catch: Throwable -> L54 CancellationException -> L56
        this.L$1 = r140;     // Catch: Throwable -> L54 CancellationException -> L56
        Ref.BooleanRef r142 = r132;
        this.L$2 = r142;     // Catch: Throwable -> L50 CancellationException -> L52
        this.L$3 = r139;     // Catch: Throwable -> L50 CancellationException -> L52
        this.label = 1;     // Catch: Throwable -> L50 CancellationException -> L52
        if (r138.collect(r141, this) != r100) goto L33;
        return r100;
    L33:
        r110 = r140;
        r109 = r142;
        r111 = r123;
        r108 = r139;
        goto L35
    L52:
        e = e;
    L84:
        r117 = r140;
        r116 = r142;
    L50:
        th = th;
    L60:
        r122 = r140;
        r121 = r142;
        r120 = r139;
        goto L109
    L56:
        e = e;
        r142 = r132;
    L54:
        th = th;
        r142 = r132;
        goto L60
    L82:
        e = e;
        r139 = r133;
        r142 = r132;
        r140 = r131;
    L58:
        th = th;
        r139 = r133;
        r142 = r132;
        r140 = r131;
    L102:
        th = move-exception;
        throw th;
    L9:
        th = th;
        r120 = "start error sessionId=";
        goto L91
    }

    public static final void a(Object r100, a r101, Ref.BooleanRef r102, a.C4157a r103) {
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (r102.element == false) goto L6;
        boolean r104 = false;
    L8:
        monitor-exit(r100);
        if (r104 == false) goto L23;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "info");
        e0 r105 = new e0();
        r105.b("status", k.b(Integer.valueOf(r103.f322948a)));
        r105.b("count", k.b(Integer.valueOf(r101.f322946a)));
        r105.b("duration", k.b(Long.valueOf(com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() - r101.f322947b)));
        b.a(r105, "error_description", r103.f322949b);
        r105.b("error_code", k.b(Integer.valueOf(r103.f322950c)));
        b.a(r105, "binary_type", "json");
        b.a(r105, "log_id", r103.f322951d);
        b.a(r105, "request_path", r103.f322952e);
        b.a(r105, "scene", "end");
        d0 r106 = r105.a();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L13
        d1.f348206b.a("flow_canvas_chunk_request", r106);     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L23:
        return;
    L6:
        r102.element = true;     // Catch: Throwable -> L16
        r104 = true;
        goto L8
    }
}
