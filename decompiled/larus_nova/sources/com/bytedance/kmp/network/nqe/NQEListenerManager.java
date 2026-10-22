package com.bytedance.kmp.network.nqe;

import com.bytedance.kmp.network.util.NLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes19.dex */
public final class NQEListenerManager implements com.bytedance.kmp.network.nqe.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.kmp.network.c f252536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.kmp.network.nqe.a> f252537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f252538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f252539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f252540e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.network.nqe.NQEListenerManager$onPacketLossComputed$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
    @DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager$onPacketLossComputed$2", f = "NQEListenerManager.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $downstreamLossRate;
        final /* synthetic */ double $downstreamLossRateVariance;
        final /* synthetic */ int $protocol;
        final /* synthetic */ double $upstreamLossRate;
        final /* synthetic */ double $upstreamLossRateVariance;
        int label;
        final /* synthetic */ NQEListenerManager this$0;

        public AnonymousClass2(NQEListenerManager r100, int r101, double r102, double r103, double r104, double r105, Continuation<? super AnonymousClass2> r110) {
            this.this$0 = r100;
            this.$protocol = r101;
            this.$upstreamLossRate = r102;
            this.$upstreamLossRateVariance = r103;
            this.$downstreamLossRate = r104;
            this.$downstreamLossRateVariance = r105;
            super(2, r110);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new AnonymousClass2(this.this$0, this.$protocol, this.$upstreamLossRate, this.$upstreamLossRateVariance, this.$downstreamLossRate, this.$downstreamLossRateVariance, r111);
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
            NQEListenerManager r111 = this.this$0;
            final int r102 = this.$protocol;
            final double r103 = this.$upstreamLossRate;
            final double r104 = this.$upstreamLossRateVariance;
            final double r105 = this.$downstreamLossRate;
            final double r112 = this.$downstreamLossRateVariance;
            Function1<com.bytedance.kmp.network.nqe.a, Unit> r106 = new AnonymousClass1(r102, r103, r104, r105, r112);
            this.label = 1;
            if (NQEListenerManager.b(r111, r106, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.network.nqe.NQEListenerManager$onRTTOrThroughputEstimatesComputed$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
    @DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager$onRTTOrThroughputEstimatesComputed$2", f = "NQEListenerManager.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    public static final class C106292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $downstreamThroughputKbps;
        final /* synthetic */ int $httpRttMs;
        final /* synthetic */ int $transportRttMs;
        int label;
        final /* synthetic */ NQEListenerManager this$0;

        public C106292(NQEListenerManager r100, int r101, int r102, int r103, Continuation<? super C106292> r104) {
            this.this$0 = r100;
            this.$httpRttMs = r101;
            this.$transportRttMs = r102;
            this.$downstreamThroughputKbps = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C106292(this.this$0, this.$httpRttMs, this.$transportRttMs, this.$downstreamThroughputKbps, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C106292) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            NQEListenerManager r103 = this.this$0;
            final int r104 = this.$httpRttMs;
            final int r105 = this.$transportRttMs;
            final int r106 = this.$downstreamThroughputKbps;
            Function1<com.bytedance.kmp.network.nqe.a, Unit> r107 = new AnonymousClass1(r104, r105, r106);
            this.label = 1;
            if (NQEListenerManager.b(r103, r107, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public NQEListenerManager() {
        this.f252537b = new ArrayList();
        this.f252538c = kotlinx.coroutines.sync.b.a();
        this.f252539d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        StateFlowImpl r100 = j1.a(new b(null, null, null, 15));
        this.f252540e = r100;
        e.b(r100);
    }

    @Override // com.bytedance.kmp.network.nqe.a
    public final void a(EffectiveConnectionType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        StateFlowImpl r101 = this.f252540e;
    L3:
        Object r102 = r101.getValue();
        if (r101.compareAndSet(r102, b.a((b) r102, r100, null, null, null, 14)) == false) goto L3;
        BuildersKt.launch$default(this.f252539d, null, null, new NQEListenerManager$onEffectiveConnectionTypeChanged$2(this, r100, null), 3, null);
    }

    public final Object c(com.bytedance.kmp.network.c r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof NQEListenerManager$initialize$1) == false) goto L7;
        NQEListenerManager$initialize$1 r102 = (NQEListenerManager$initialize$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        z0 r107 = (z0) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        r107.setValue(r104);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        this.f252536a = r100;
        r100.Z2(this);
        StateFlowImpl r108 = this.f252540e;
        r102.L$0 = r108;
        r102.label = 1;
        b r109 = r100.O2();
        if (r109 != r105) goto L17;
        return r105;
    L17:
        r104 = r109;
        r107 = r108;
    L7:
        r102 = new NQEListenerManager$initialize$1(this, r101);
        goto L8
    }

    public static final Object b(NQEListenerManager r100, Function1 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof NQEListenerManager$dispatchToListeners$1) == false) goto L7;
        NQEListenerManager$dispatchToListeners$1 r103 = (NQEListenerManager$dispatchToListeners$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r103.L$1;
        Function1 r109 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L39:
        List r110 = CollectionsKt.toList(r100.f252537b);     // Catch: Throwable -> L36
        r108.unlock(null);
        Iterator r111 = r110.iterator();
    L21:
        if (r111.hasNext() == false) goto L35;
        r109.invoke((com.bytedance.kmp.network.nqe.a) r111.next());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        NLog.Level r112 = NLog.f252570a;
        NLog.Level r113 = NLog.Level.ERROR;
        if (r113.compareTo(NLog.f252570a) < 0) goto L21;
        String r114 = "Error in NQEListener callback: " + e.getMessage();
        if (r114 == null) goto L32;
        String r115 = r114.toString();
        if (r115 == null) goto L32;
    L33:
        System.out.println("[" + StringsKt.first(r113.name()) + "][kmp-ttnet] " + r115);
        System.out.println("[" + StringsKt.first(r113.name()) + "][kmp-ttnet] Exception: " + e);
    L32:
        r115 = "null";
        goto L33
    L35:
        return Unit.INSTANCE;
    L36:
        th = move-exception;
        r108.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MutexImpl r116 = r100.f252538c;
        r103.L$0 = r101;
        r103.L$1 = r116;
        r103.label = 1;
        if (r116.a(null, r103) == r106) goto L49;
        r109 = r101;
        r108 = r116;
        goto L39
    L49:
        return r106;
    L7:
        r103 = new NQEListenerManager$dispatchToListeners$1(r100, r102);
        goto L8
    }

    @Override // com.bytedance.kmp.network.nqe.a
    public final void onRTTOrThroughputEstimatesComputed(int r110, int r111, int r112) {
        StateFlowImpl r100 = this.f252540e;
    L3:
        Object r101 = r100.getValue();
        if (r100.compareAndSet(r101, b.a((b) r101, null, new d(r110, r111, r112), null, null, 13)) == false) goto L3;
        BuildersKt.launch$default(this.f252539d, null, null, new C106292(this, r110, r111, r112, null), 3, null);
    }

    @Override // com.bytedance.kmp.network.nqe.a
    public final void onPacketLossComputed(int r110, double r111, double r210, double r211, double r212) {
        c r112 = new c(r110, r111, r210, r211, r212);
        StateFlowImpl r100 = this.f252540e;
    L3:
        Object r101 = r100.getValue();
        b r102 = (b) r101;
        if (r110 != 0) goto L6;
        r102 = b.a(r102, null, null, r112, null, 11);
    L11:
        if (r100.compareAndSet(r101, r102) == false) goto L3;
        BuildersKt.launch$default(this.f252539d, null, null, new AnonymousClass2(this, r110, r111, r210, r211, r212, null), 3, null);
        return;
    L6:
        if (r110 != 1) goto L11;
        r102 = b.a(r102, null, null, null, r112, 7);
        goto L11
    }
}
