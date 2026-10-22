package com.bytedance.ee.bear.integrator.di;

import io.reactivex.FlowableEmitter;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.integrator.di.OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1", f = "OfficeAppInitializeImpl.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowableEmitter<Object> $emitter;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.integrator.di.OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1$1", f = "OfficeAppInitializeImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1(FlowableEmitter<Object> r100, Continuation<? super OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1> r101) {
        this.$emitter = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1(this.$emitter, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L12;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7 TimeoutCancellationException -> L9
    L18:
        if (this.$emitter.isCancelled() == true) goto L28;
        tt5.a.h("OfficeAppInitializeImpl", "fullInitFlow, sdkInitJob finished.");     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        this.$emitter.onNext("anything non null");     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        this.$emitter.onComplete();     // Catch: Exception -> L7 TimeoutCancellationException -> L9
    L28:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r100);
        AnonymousClass1 r103 = new AnonymousClass1(null);     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        if (TimeoutKt.b(10000, r103, this) != r101) goto L18;
        return r101;
    L9:
        e = move-exception;
        tt5.a.i("OfficeAppInitializeImpl", "fullInitFlow, sdkInitJob timeout: ", e);
        if (this.$emitter.isCancelled() == true) goto L28;
        this.$emitter.onError(new TimeoutException("Wait docInit timeout !"));
    L7:
        e = move-exception;
        tt5.a.i("OfficeAppInitializeImpl", "fullInitFlow, sdkInitJob error: ", e);
        if (this.$emitter.isCancelled() == true) goto L28;
        this.$emitter.onError(e);
        goto L28
    }
}
