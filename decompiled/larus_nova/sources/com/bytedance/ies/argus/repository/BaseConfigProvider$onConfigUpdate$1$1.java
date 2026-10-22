package com.bytedance.ies.argus.repository;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1", f = "ArgusConfigManager.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
public final class BaseConfigProvider$onConfigUpdate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, Unit> $callback;
    final /* synthetic */ i1<T> $flow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements FlowCollector<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f246101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f246102b;

        public a(Function1 r100, CoroutineScope r101) {
            this.f246101a = r100;
            this.f246102b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            Function1 r102 = this.f246101a;     // Catch: Exception -> L6
            if (r102 == null) goto L9;
            r102.invoke(r100);     // Catch: Exception -> L6
        L9:
            return Unit.INSTANCE;
        L6:
            e = move-exception;
            int r103 = com.bytedance.ies.argus.base.d.f245942a;
            com.bytedance.ies.argus.base.d.b("ArgusConfigManager", this.f246102b.getClass().getSimpleName() + " collector invoke error: " + e.getMessage(), null, 12);
            goto L9
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseConfigProvider$onConfigUpdate$1$1(i1<? extends T> r100, Function1<? super T, Unit> r101, Continuation<? super BaseConfigProvider$onConfigUpdate$1$1> r102) {
        this.$flow = r100;
        this.$callback = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BaseConfigProvider$onConfigUpdate$1$1 r102 = new BaseConfigProvider$onConfigUpdate$1$1(this.$flow, this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaseConfigProvider$onConfigUpdate$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1 for r5v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r5.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r6);
    L11:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L6:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L8:
        kotlin.ResultKt.throwOnFailure(r6);
        java.lang.Object r6 = r5.L$0;
        kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
        kotlinx.coroutines.flow.i1<T> r1 = r5.$flow;
        kotlin.jvm.functions.Function1<T, kotlin.Unit> r3 = r5.$callback;
        com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1.a r4 = new com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1.a(r3, r6);
        r5.label = 1;
        com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1.a r4 = r4;
        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
        java.lang.Object r6 = r1.collect(r4, r5);
        if (r6 != r0) goto L11;
        return r0;
    }
}
