package com.larus.bmhome.social.page.datasource;

import com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow$special$$inlined$mapNotNull$1;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: Add missing generic type declarations: [Event] */
/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Event", "Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1", f = "FlowPagingManager.kt", i = {0, 1}, l = {97, 111, 126, 134}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
public final class FlowPagingManager$flow$1<Event> extends SuspendLambda implements Function2<FlowCollector<? super Event>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1", f = "FlowPagingManager.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Event> $$this$flow;
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1$1", f = "FlowPagingManager.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 104, 104}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
        public static final class C41001 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Event> $$this$flow;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C41001(FlowPagingManager<T, Key, Event> r100, FlowCollector<? super Event> r101, Continuation<? super C41001> r102) {
                this.this$0 = r100;
                this.$$this$flow = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C41001(this.this$0, this.$$this$flow, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Unit r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Unit r100, Continuation<? super Unit> r101) {
                return ((C41001) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L16;
                if (r101 == 1) goto L15;
                if (r101 == 2) goto L12;
                if (r101 != 3) goto L11;
                FlowCollector<Event> r102 = (FlowCollector) this.L$2;
                FlowPagingManager r103 = (FlowPagingManager) this.L$1;
                kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L39
            L19:
                C41001 r111 = this;
            L21:
                if ((!r103.f313985c.isEmpty()) == false) goto L36;
                com.larus.bmhome.social.page.datasource.event.e r105 = r103.f313985c.poll();     // Catch: Throwable -> L39
                if (r105 == null) goto L21;
                r111.L$0 = r104;     // Catch: Throwable -> L39
                r111.L$1 = r103;     // Catch: Throwable -> L39
                r111.L$2 = r102;     // Catch: Throwable -> L39
                r111.label = 2;     // Catch: Throwable -> L39
                Object r106 = FlowPagingManager.a(r103, r105, r111);     // Catch: Throwable -> L39
                if (r106 != r100) goto L27;
                return r100;
            L27:
                Object r107 = r100;
                C41001 r108 = r111;
                r110 = r106;
                kotlinx.coroutines.sync.a r109 = r104;
                FlowPagingManager r112 = r103;
                FlowCollector<Event> r113 = r102;
                Object r114 = r107;
            L45:
                com.larus.bmhome.social.page.datasource.event.a r115 = (com.larus.bmhome.social.page.datasource.event.a) r110;     // Catch: Throwable -> L34
                if (r115 == null) goto L33;
                r108.L$0 = r109;     // Catch: Throwable -> L34
                r108.L$1 = r112;     // Catch: Throwable -> L34
                r108.L$2 = r113;     // Catch: Throwable -> L34
                r108.label = 3;     // Catch: Throwable -> L34
                if (r113.emit(r115, r108) != r114) goto L33;
                return r114;
            L33:
                r111 = r108;
                r100 = r114;
                r102 = r113;
                r103 = r112;
                r104 = r109;
                goto L21
            L47:
                r111 = r108;
                r100 = r114;
                r102 = r113;
                r103 = r112;
                r104 = r109;
            L34:
                th = th;
            L41:
                r109.unlock(null);
                throw th;
            L36:
                Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L39
                r104.unlock(null);
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                FlowCollector<Event> r117 = (FlowCollector) this.L$2;
                FlowPagingManager r118 = (FlowPagingManager) this.L$1;
                kotlinx.coroutines.sync.a r119 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L39
                r109 = r119;
                r112 = r118;
                r113 = r117;
                r114 = r100;
                r108 = this;
                goto L45
            L15:
                r102 = (FlowCollector) this.L$2;
                r103 = (FlowPagingManager) this.L$1;
                r104 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r110);
                goto L19
            L16:
                ResultKt.throwOnFailure(r110);
                r103 = this.this$0;
                r104 = r103.f313989g;
                r102 = this.$$this$flow;
                this.L$0 = r104;
                this.L$1 = r103;
                this.L$2 = r102;
                this.label = 1;
                if (r104.a(null, this) != r100) goto L19;
                return r100;
            L39:
                th = th;
                r109 = r104;
                goto L41
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(FlowPagingManager<T, Key, Event> r100, FlowCollector<? super Event> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$$this$flow = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$$this$flow, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FlowPagingManager<T, Key, Event> r103 = this.this$0;
            ConflatedFlow$special$$inlined$mapNotNull$1 r104 = r103.f313987e.f314027c;
            C41001 r105 = new C41001(r103, this.$$this$flow, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2", f = "FlowPagingManager.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowPagingManager<T, Key, Event> f313991a;

            public AnonymousClass1(FlowPagingManager<T, Key, Event> r100) {
                this.f313991a = r100;
            }

            public final Object a(boolean r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof FlowPagingManager$flow$1$2$1$emit$1) == false) goto L7;
                FlowPagingManager$flow$1$2$1$emit$1 r102 = (FlowPagingManager$flow$1$2$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                boolean r107 = true;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L13;
                r100 = r102.Z$0;
                FlowPagingManager r108 = (FlowPagingManager) r102.L$1;
                kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r102.L$0;
                ResultKt.throwOnFailure(r104);
            L31:
                r108.f313985c.clear();     // Catch: Throwable -> L28
                ConcurrentLinkedQueue<com.larus.bmhome.social.page.datasource.event.e> r110 = r108.f313985c;     // Catch: Throwable -> L28
                if (r100 == false) goto L22;
                r107 = false;
            L22:
                r110.add(new com.larus.bmhome.social.page.datasource.event.e.b(r107));     // Catch: Throwable -> L28
                if (r100 == false) goto L25;
                r108.f313985c.add(com.larus.bmhome.social.page.datasource.event.e.a.C4103a.f314038a);     // Catch: Throwable -> L28
                r108.f313985c.add(com.larus.bmhome.social.page.datasource.event.e.a.b.f314039a);     // Catch: Throwable -> L28
            L25:
                Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L28
                r109.unlock(null);
                ConflatedFlow<Unit> r112 = this.f313991a.f313987e;
                Unit r113 = Unit.INSTANCE;
                r112.b(r113);
                return r113;
            L28:
                th = move-exception;
                r109.unlock(null);
                throw th;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                FlowPagingManager r114 = this.f313991a;
                MutexImpl r115 = r114.f313989g;
                r102.L$0 = r115;
                r102.L$1 = r114;
                r102.Z$0 = r100;
                r102.label = 1;
                if (r115.a(null, r102) != r105) goto L17;
                return r105;
            L17:
                r108 = r114;
                r109 = r115;
            L7:
                r102 = new FlowPagingManager$flow$1$2$1$emit$1(this, r101);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a(((Boolean) r100).booleanValue(), r101);
            }
        }

        public AnonymousClass2(FlowPagingManager<T, Key, Event> r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FlowPagingManager<T, Key, Event> r103 = this.this$0;
            ConflatedFlow$special$$inlined$mapNotNull$1 r104 = r103.f313986d.f314027c;
            AnonymousClass1 r105 = new AnonymousClass1(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3", f = "FlowPagingManager.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Event> $$this$flow;
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector<Event> f313992a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(FlowCollector<? super Event> r100) {
                this.f313992a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                FlowCollector<Event> r102 = this.f313992a;
                Object r103 = r102.emit((com.larus.bmhome.social.page.datasource.event.a) r100, r101);
                if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r103;
            L6:
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(FlowPagingManager<T, Key, Event> r100, FlowCollector<? super Event> r101, Continuation<? super AnonymousClass3> r102) {
            this.this$0 = r100;
            this.$$this$flow = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, this.$$this$flow, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3 for r4v1 'this'  kotlin.coroutines.Continuation
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r4.label;
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L7;
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L7:
            kotlin.ResultKt.throwOnFailure(r5);
        L11:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException();
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r5);
            com.larus.bmhome.social.page.datasource.FlowPagingManager<T, Key, Event> r5 = r4.this$0;
            kotlinx.coroutines.flow.MutableSharedFlow<Event> r5 = r5.f313990h;
            kotlinx.coroutines.flow.FlowCollector<Event> r3 = r4.$$this$flow;
            com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1.AnonymousClass3.a r1 = new com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1.AnonymousClass3.a(r3);
            r4.label = 1;
            com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1.AnonymousClass3.a r1 = r1;
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation<?>) r4;
            java.lang.Object r5 = r5.collect(r1, r4);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public FlowPagingManager$flow$1(FlowPagingManager<T, Key, Event> r100, Continuation<? super FlowPagingManager$flow$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowPagingManager$flow$1 r102 = new FlowPagingManager$flow$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((FlowCollector) r100, r101);
    }

    public final Object invoke(FlowCollector<? super Event> r100, Continuation<? super Unit> r101) {
        return ((FlowPagingManager$flow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L15;
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L13;
        if (r102 != 3) goto L8;
        ResultKt.throwOnFailure(r100);
    L25:
        ((a) this.this$0.f313983a.getValue()).getClass();
    L26:
        ((a) this.this$0.f313983a.getValue()).getClass();
        return Unit.INSTANCE;
    L8:
        if (r102 != 4) goto L11;
        ResultKt.throwOnFailure(r100);
        goto L26
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L22:
        AnonymousClass3 r104 = new AnonymousClass3(this.this$0, r103, null);
        this.L$0 = null;
        this.label = 3;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r104, this) != r101) goto L25;
        return r101;
    L14:
        r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L19:
        AnonymousClass2 r105 = new AnonymousClass2(this.this$0, null);
        this.L$0 = r103;
        this.label = 2;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r105, this) != r101) goto L22;
        return r101;
    L15:
        ResultKt.throwOnFailure(r100);
        FlowCollector r106 = (FlowCollector) this.L$0;
        AnonymousClass1 r107 = new AnonymousClass1(this.this$0, r106, null);
        this.L$0 = r106;
        this.label = 1;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r107, this) != r101) goto L18;
        return r101;
    L18:
        r103 = r106;
        goto L19
    }
}
