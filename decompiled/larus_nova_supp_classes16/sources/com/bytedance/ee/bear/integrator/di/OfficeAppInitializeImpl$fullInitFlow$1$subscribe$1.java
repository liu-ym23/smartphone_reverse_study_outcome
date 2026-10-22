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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1(FlowableEmitter<Object> r1, Continuation<? super OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1> r2) {
        this.$emitter = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1(this.$emitter, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7 TimeoutCancellationException -> L9
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
        ResultKt.throwOnFailure(r5);
        AnonymousClass1 r6 = new AnonymousClass1(null);     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 TimeoutCancellationException -> L9
        if (TimeoutKt.b(10000, r6, this) != r0) goto L18;
        return r0;
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
