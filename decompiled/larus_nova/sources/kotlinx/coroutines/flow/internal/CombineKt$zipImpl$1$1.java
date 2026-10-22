package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ Flow<Object> $flow2;
    final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ CompletableJob $collectJob;
        final /* synthetic */ Flow<Object> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
        final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoroutineContext f504866a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f504867b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ReceiveChannel<Object> f504868c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ FlowCollector<Object> f504869d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> f504870e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ CompletableJob f504871f;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {126, 129, 129}, m = "invokeSuspend", n = {}, s = {})
            public static final class C65891 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ CompletableJob $collectJob;
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
                final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
                final /* synthetic */ Object $value;
                Object L$0;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C65891(ReceiveChannel<? extends Object> r100, FlowCollector<Object> r101, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r102, Object r103, CompletableJob r104, Continuation<? super C65891> r105) {
                    this.$second = r100;
                    this.$this_unsafeFlow = r101;
                    this.$transform = r102;
                    this.$value = r103;
                    this.$collectJob = r104;
                    super(2, r105);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C65891(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, this.$collectJob, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Unit r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit r100, Continuation<? super Unit> r101) {
                    return ((C65891) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L12;
                    if (r102 == 1) goto L11;
                    if (r102 == 2) goto L10;
                    if (r102 != 3) goto L9;
                    ResultKt.throwOnFailure(r100);
                L31:
                    return Unit.INSTANCE;
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    FlowCollector<Object> r103 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(r100);
                L27:
                    this.L$0 = null;
                    this.label = 3;
                    if (r103.emit(r100, this) != r101) goto L31;
                    return r101;
                L11:
                    ResultKt.throwOnFailure(r100);
                    Object r104 = ((kotlinx.coroutines.channels.g) r100).f504697a;
                L15:
                    CompletableJob r105 = this.$collectJob;
                    if ((r104 instanceof kotlinx.coroutines.channels.g.c) == false) goto L21;
                    Throwable r106 = kotlinx.coroutines.channels.g.a(r104);
                    if (r106 == null) goto L20;
                    throw r106;
                L20:
                    throw new AbortFlowException(r105);
                L21:
                    r103 = this.$this_unsafeFlow;
                    Function3<Object, Object, Continuation<Object>, Object> r107 = this.$transform;
                    Object r108 = this.$value;
                    if (r104 != o.f504892a) goto L24;
                    r104 = null;
                L24:
                    this.L$0 = r103;
                    this.label = 2;
                    r100 = r107.invoke(r108, r104, this);
                    if (r100 != r101) goto L27;
                    return r101;
                L12:
                    ResultKt.throwOnFailure(r100);
                    ReceiveChannel<Object> r109 = this.$second;
                    this.label = 1;
                    r104 = r109.mo10963receiveCatchingJP2dKIU(this);
                    if (r104 != r101) goto L15;
                    return r101;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext r100, Object r101, ReceiveChannel<? extends Object> r102, FlowCollector<Object> r103, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r104, CompletableJob r105) {
                this.f504866a = r100;
                this.f504867b = r101;
                this.f504868c = r102;
                this.f504869d = r103;
                this.f504870e = r104;
                this.f504871f = r105;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation<? super Unit> r111) {
                if ((r111 instanceof CombineKt$zipImpl$1$1$2$1$emit$1) == false) goto L7;
                CombineKt$zipImpl$1$1$2$1$emit$1 r100 = (CombineKt$zipImpl$1$1$2$1$emit$1) r111;
                int r101 = r100.label;
                if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
                r100.label = r101 - Integer.MIN_VALUE;
            L8:
                Object r112 = r100.result;
                Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r103 = r100.label;
                if (r103 == 0) goto L14;
                if (r103 != 1) goto L13;
                ResultKt.throwOnFailure(r112);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r112);
                CoroutineContext r113 = this.f504866a;
                Unit r104 = Unit.INSTANCE;
                Object r105 = this.f504867b;
                C65891 r114 = new C65891(this.f504868c, this.f504869d, this.f504870e, r110, this.f504871f, null);
                r100.label = 1;
                if (e.a(r113, r104, r105, r114, r100) != r102) goto L18;
                return r102;
            L7:
                r100 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r111);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Flow<Object> r100, CoroutineContext r101, Object r102, ReceiveChannel<? extends Object> r103, FlowCollector<Object> r104, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r105, CompletableJob r106, Continuation<? super AnonymousClass2> r107) {
            this.$flow = r100;
            this.$scopeContext = r101;
            this.$cnt = r102;
            this.$second = r103;
            this.$this_unsafeFlow = r104;
            this.$transform = r105;
            this.$collectJob = r106;
            super(2, r107);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, r111);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            Flow<Object> r111 = this.$flow;
            AnonymousClass1 r102 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob);
            this.label = 1;
            if (r111.collect(r102, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(Flow<Object> r100, Flow<Object> r101, FlowCollector<Object> r102, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r103, Continuation<? super CombineKt$zipImpl$1$1> r104) {
        this.$flow2 = r100;
        this.$flow = r101;
        this.$this_unsafeFlow = r102;
        this.$transform = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CombineKt$zipImpl$1$1 r102 = new CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CombineKt$zipImpl$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r3v8, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlinx.coroutines.channels.j] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L13;
        CompletableJob r102 = (CompletableJob) this.L$1;
        ?? r103 = (ReceiveChannel) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L8 AbortFlowException -> L10
        ?? r104 = r103;
    L25:
        r104.cancel(null);
        return Unit.INSTANCE;
    L10:
        e = e;
    L23:
        r104 = r103;
        if (e.owner == r102) goto L25;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = th;
        ?? r105 = r103;
    L29:
        r105.cancel(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        r105 = ProduceKt.c(r106, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3);
        final CompletableJob r107 = JobKt.Job$default(null, 1, null);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
        r105.invokeOnClose(new AnonymousClass1(r107));
        CoroutineContext r111 = r106.getCoroutineContext();     // Catch: Throwable -> L19 AbortFlowException -> L21
        Object r112 = ThreadContextKt.b(r111);     // Catch: Throwable -> L19 AbortFlowException -> L21
        CoroutineContext r108 = r106.getCoroutineContext().plus(r107);     // Catch: Throwable -> L19 AbortFlowException -> L21
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19 AbortFlowException -> L21
        AnonymousClass2 r113 = new AnonymousClass2(this.$flow, r111, r112, r105, this.$this_unsafeFlow, this.$transform, r107, null);     // Catch: Throwable -> L19 AbortFlowException -> L21
        this.L$0 = r105;     // Catch: Throwable -> L19 AbortFlowException -> L21
        this.L$1 = r107;     // Catch: Throwable -> L19 AbortFlowException -> L21
        this.label = 1;     // Catch: Throwable -> L19 AbortFlowException -> L21
        if (e.a(r108, r109, ThreadContextKt.b(r108), r113, this) != r100) goto L18;
        return r100;
    L18:
        r104 = r105;
        goto L25
    L21:
        e = e;
        r103 = r105;
        r102 = r107;
    L19:
        th = th;
        goto L29
    }
}
