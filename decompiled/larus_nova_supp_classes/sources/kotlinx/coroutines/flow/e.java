package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.flow.internal.d;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.flow.internal.k;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.flow.internal.n;
import kotlinx.coroutines.flow.internal.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static final b A(Channel r2) {
        return new b(r2, false);
    }

    public static final k C(StateFlowImpl r4) {
        return new k(new FlowKt__DelayKt.sample.2(300, r4, null));
    }

    public static final a1 a(MutableSharedFlow r2) {
        return new a1(r2, null);
    }

    public static final b1 b(z0 r2) {
        return new b1(r2, null);
    }

    public static final CallbackFlowBuilder e(Function2 r4) {
        return new CallbackFlowBuilder(r4, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static final c g(Function2 r4) {
        return new c(r4, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static final b l(Channel r2) {
        return new b(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> n(Flow<? extends T> r2) {
        Function1 r0 = FlowKt__DistinctKt.a;
        if ((r2 instanceof i1) == false) goto L6;
        return r2;
    L6:
        return FlowKt__DistinctKt.a(r2, FlowKt__DistinctKt.a, FlowKt__DistinctKt.b);
    }

    public static final ChannelLimitedFlowMerge y(Flow... r4) {
        int r0 = b0.a;
        return new ChannelLimitedFlowMerge(ArraysKt.asIterable(r4), EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static final FlowKt__ErrorsKt$retryWhen$.inlined.unsafeFlow.1 B(FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r4, Function2 r5) {
        return new FlowKt__ErrorsKt$retryWhen$.inlined.unsafeFlow.1(r4, new FlowKt__ErrorsKt.retry.3(3, r5, null));
    }

    public static final ChannelFlowTransformLatest G(Flow r7, Function3 r8) {
        int r0 = b0.a;
        return new ChannelFlowTransformLatest(r8, r7, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static final Object h(Flow<?> r1, Continuation<? super Unit> r2) {
        Object r3 = r1.collect(n.a, r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> m(Flow<? extends T> r3, long r4) {
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        if (r4 != 0) goto L10;
        return r3;
    L10:
        return new k(new FlowKt__DelayKt.debounceInternal.1(new FlowKt__DelayKt.debounce.2(r4), r3, null));
    L12:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Flow<T> o(Flow<? extends T> r2, Function2<? super T, ? super T, Boolean> r3) {
        Function1 r0 = FlowKt__DistinctKt.a;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return FlowKt__DistinctKt.a(r2, r0, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 2));
    }

    public static final v p(Flow r1, int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return new v(r1, r2);
    L9:
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + r2).toString());
    L4:
        r0 = false;
        goto L5
    }

    public static final <T> Object s(Flow<? extends T> r4, Continuation<? super T> r5) {
        if ((r5 instanceof FlowKt__ReduceKt.first.1) == false) goto L7;
        FlowKt__ReduceKt.first.1 r0 = (FlowKt__ReduceKt.first.1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        c0 r7 = (c0) r0.L$1;
        Ref$ObjectRef r8 = (Ref$ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: AbortFlowException -> L14
    L27:
        r2 = r8.element;
        if (r2 == o.a) goto L31;
    L29:
        return r2;
    L31:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e = e;
    L26:
        if (e.owner == r7) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r6);
        Ref$ObjectRef r9 = new Ref$ObjectRef();
        r9.element = (T) o.a;
        c0 r10 = new c0(r9);
        r0.L$0 = r9;     // Catch: AbortFlowException -> L23
        r0.L$1 = r10;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r4.collect(r10, r0) == r2) goto L29;
        r8 = r9;
    L23:
        e = move-exception;
        r8 = r9;
        e = e;
        r7 = r10;
    L7:
        r0 = new FlowKt__ReduceKt.first.1(r5);
        goto L8
    }

    public static final Object v(n r4, Continuation r5) {
        if ((r5 instanceof FlowKt__ReduceKt.firstOrNull.1) == false) goto L7;
        FlowKt__ReduceKt.firstOrNull.1 r0 = (FlowKt__ReduceKt.firstOrNull.1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        d0 r7 = (d0) r0.L$1;
        Ref$ObjectRef r8 = (Ref$ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: AbortFlowException -> L14
    L28:
        return r8.element;
    L14:
        AbortFlowException e = e;
    L26:
        if (e.owner == r7) goto L28;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r6);
        Ref$ObjectRef r9 = new Ref$ObjectRef();
        d0 r10 = new d0(r9);
        r0.L$0 = r9;     // Catch: AbortFlowException -> L23
        r0.L$1 = r10;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r4.collect(r10, r0) == r2) goto L34;
        r8 = r9;
        goto L28
    L34:
        return r2;
    L23:
        e = move-exception;
        r8 = r9;
        e = e;
        r7 = r10;
    L7:
        r0 = new FlowKt__ReduceKt.firstOrNull.1(r5);
        goto L8
    }

    public static final Flow w(Flow r7, CoroutineDispatcher r8) {
        if (r8.get(Job.Key) != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        if (Intrinsics.areEqual(r8, EmptyCoroutineContext.INSTANCE) == false) goto L11;
        return r7;
    L11:
        if ((r7 instanceof l) == false) goto L14;
        return l.a.a((l) r7, r8, 0, null, 6);
    L14:
        return new h(r7, r8, 0, null, 12);
    L16:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Job x(Flow<? extends T> r6, CoroutineScope r7) {
        return BuildersKt.launch$default(r7, null, null, new FlowKt__CollectKt.launchIn.1(r6, null), 3, null);
    }

    public static final <T> ReceiveChannel<T> z(Flow<? extends T> r7, CoroutineScope r8) {
        if ((r7 instanceof d) == false) goto L5;
        d r0 = (d) r7;
    L6:
        if (r0 != null) goto L9;
        r0 = new h(r7, null, 0, null, 14);
    L9:
        return r0.f(r8);
    L5:
        r0 = null;
        goto L6
    }

    public static final <T> Object E(Flow<? extends T> r8, CoroutineScope r9, Continuation<? super i1<? extends T>> r10) {
        f1 r11 = FlowKt__ShareKt.a(r8, 1);
        CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(r9, r11.d, null, new FlowKt__ShareKt.launchSharingDeferred.1(r11.a, r0, null), 2, null);
        return r0.await(r10);
    }

    public static final <T> Flow<T> c(Flow<? extends T> r8, int r9, BufferOverflow r10) {
        if (r9 < 0) goto L5;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L29;
        if (r9 == (-1)) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L27;
        if (r9 != (-1)) goto L20;
        BufferOverflow r6 = BufferOverflow.DROP_OLDEST;
        int r5 = 0;
    L22:
        if ((r8 instanceof l) == false) goto L25;
        return l.a.a((l) r8, null, r5, r6, 1);
    L25:
        return new h(r8, null, r5, r6, 2);
    L20:
        r5 = r9;
        r6 = r10;
        goto L22
    L27:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L13:
        if (r10 == BufferOverflow.SUSPEND) goto L16;
        r4 = false;
        goto L17
    L29:
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r9).toString());
    L5:
        if (r9 == (-2)) goto L9;
        if (r9 == (-1)) goto L9;
        r3 = false;
        goto L10
    }

    public static /* synthetic */ Flow d(Flow r1, int r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = -2;
    L6:
        if ((r3 & 2) == 0) goto L8;
        BufferOverflow r4 = BufferOverflow.SUSPEND;
    L10:
        return c(r1, r2, r4);
    L8:
        r4 = null;
        goto L10
    }

    public static final <T> Object f(Flow<? extends T> r4, FlowCollector<? super T> r5, Continuation<? super Throwable> r6) {
        if ((r6 instanceof FlowKt__ErrorsKt.catchImpl.1) == false) goto L7;
        FlowKt__ErrorsKt.catchImpl.1 r0 = (FlowKt__ErrorsKt.catchImpl.1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r8 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref$ObjectRef r9 = (Ref$ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L22:
        return null;
    L14:
        th = move-exception;
        Throwable r10 = th;
    L25:
        Throwable r11 = (Throwable) r9.element;
        boolean r12 = false;
        if (r11 != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L53;
        Job r14 = (Job) r0.getContext().get(Job.Key);
        if (r14 != null) goto L35;
    L44:
        if (r12 == true) goto L60;
        if (r11 != null) goto L48;
        return r10;
    L48:
        if ((r10 instanceof CancellationException) == false) goto L51;
        ExceptionsKt.addSuppressed(r11, r10);
        throw r11;
    L51:
        ExceptionsKt.addSuppressed(r10, r11);
        throw r10;
    L60:
        throw r10;
    L35:
        if (r14.isCancelled() == false) goto L44;
        CancellationException r15 = r14.getCancellationException();
        if (r15 != null) goto L40;
    L42:
        r8 = false;
    L43:
        r12 = r8;
        goto L44
    L40:
        if (Intrinsics.areEqual(r15, r10) == false) goto L42;
    L53:
        throw r10;
    L28:
        if (Intrinsics.areEqual(r11, r10) == false) goto L30;
        r13 = true;
        goto L31
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        Ref$ObjectRef r16 = new Ref$ObjectRef();
        FlowKt__ErrorsKt.catchImpl.2 r17 = new FlowKt__ErrorsKt.catchImpl.2(r5, r16);     // Catch: Throwable -> L23
        r0.L$0 = r16;     // Catch: Throwable -> L23
        r0.label = 1;     // Catch: Throwable -> L23
        if (r4.collect(r17, r0) != r2) goto L22;
        return r2;
    L23:
        th = move-exception;
        r10 = th;
        r9 = r16;
    L7:
        r0 = new FlowKt__ErrorsKt.catchImpl.1(r6);
        goto L8
    }

    public static final <T> Object i(Flow<? extends T> r2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Unit> r4) {
        int r0 = b0.a;
        Object r5 = h(d(G(r2, new FlowKt__MergeKt.mapLatest.1(r3, null)), 0, 2), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object q(FlowCollector<? super T> r1, ReceiveChannel<? extends T> r2, Continuation<? super Unit> r3) {
        Object r4 = FlowKt__ChannelsKt.a(r1, r2, true, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object r(FlowCollector<? super T> r1, Flow<? extends T> r2, Continuation<? super Unit> r3) {
        if ((r1 instanceof l1) == true) goto L10;
        Object r4 = r2.collect(r1, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        throw ((l1) r1).a;
    }

    public static final <T> Object t(Flow<? extends T> r5, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r6, Continuation<? super T> r7) {
        if ((r7 instanceof FlowKt__ReduceKt$first$3) == false) goto L7;
        FlowKt__ReduceKt$first$3 r0 = (FlowKt__ReduceKt$first$3) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        FlowCollector<? super Object> r9 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r0.L$2;
        Ref$ObjectRef r10 = (Ref$ObjectRef) r0.L$1;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r4 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: AbortFlowException -> L14
    L27:
        r2 = r10.element;
        if (r2 == o.a) goto L31;
    L29:
        return r2;
    L31:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r4);
    L14:
        e = move-exception;
        Ref$ObjectRef r11 = r10;
        r6 = r4;
        AbortFlowException r12 = e;
    L25:
        if (r12.owner != r9) goto L32;
    L26:
        r4 = r6;
        r10 = r11;
        goto L27
    L32:
        throw r12;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        r11 = new Ref$ObjectRef();
        r11.element = (T) o.a;
        FlowCollector<? super Object> r13 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(r6, r11);
        r0.L$0 = r6;     // Catch: AbortFlowException -> L22
        r0.L$1 = r11;     // Catch: AbortFlowException -> L22
        r0.L$2 = r13;     // Catch: AbortFlowException -> L22
        r0.label = 1;     // Catch: AbortFlowException -> L22
        if (r5.collect(r13, r0) != r2) goto L26;
    L22:
        e = move-exception;
        r12 = e;
        r9 = r13;
    L7:
        r0 = new FlowKt__ReduceKt$first$3(r7);
        goto L8
    }

    public static final <T> Object u(Flow<? extends T> r4, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r5, Continuation<? super T> r6) {
        if ((r6 instanceof FlowKt__ReduceKt.firstOrNull.3) == false) goto L7;
        FlowKt__ReduceKt.firstOrNull.3 r0 = (FlowKt__ReduceKt.firstOrNull.3) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        FlowKt__ReduceKt$firstOrNull$.inlined.collectWhile.2 r8 = (FlowKt__ReduceKt$firstOrNull$.inlined.collectWhile.2) r0.L$1;
        Ref$ObjectRef r9 = (Ref$ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L14
    L28:
        return r9.element;
    L14:
        AbortFlowException e = e;
    L26:
        if (e.owner == r8) goto L28;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        Ref$ObjectRef r10 = new Ref$ObjectRef();
        FlowKt__ReduceKt$firstOrNull$.inlined.collectWhile.2 r11 = new FlowKt__ReduceKt$firstOrNull$.inlined.collectWhile.2(r5, r10);
        r0.L$0 = r10;     // Catch: AbortFlowException -> L23
        r0.L$1 = r11;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r4.collect(r11, r0) == r2) goto L34;
        r9 = r10;
        goto L28
    L34:
        return r2;
    L23:
        e = move-exception;
        r9 = r10;
        e = e;
        r8 = r11;
    L7:
        r0 = new FlowKt__ReduceKt.firstOrNull.3(r6);
        goto L8
    }

    public static final a1 D(Flow r8, CoroutineScope r9, g1 r10, int r11) {
        f1 r12 = FlowKt__ShareKt.a(r8, r11);
        MutableSharedFlow r13 = SharedFlowKt.MutableSharedFlow(r11, r12.b, r12.c);
        return new a1(r13, FlowKt__ShareKt.b(r9, r12.d, r12.a, r13, r10, SharedFlowKt.NO_VALUE));
    }

    public static final b1 F(Flow r7, CoroutineScope r8, g1 r9, Object r10) {
        f1 r11 = FlowKt__ShareKt.a(r7, 1);
        StateFlowImpl r6 = j1.a(r10);
        return new b1(r6, FlowKt__ShareKt.b(r8, r11.d, r11.a, r6, r9, r10));
    }

    public static final FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.1 j(i1 r2, i1 r3, Flow r4, Function4 r5) {
        return new FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.1(new Flow[]{r2, r3, r4}, r5);
    }

    public static final FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.2 k(i1 r2, i1 r3, i1 r4, i1 r5, Function5 r6) {
        return new FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.2(new Flow[]{r2, r3, r4, r5}, r6);
    }
}
