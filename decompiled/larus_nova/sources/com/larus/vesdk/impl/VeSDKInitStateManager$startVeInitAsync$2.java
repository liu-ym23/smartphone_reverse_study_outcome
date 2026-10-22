package com.larus.vesdk.impl;

import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2", f = "VeSDKInitStateManager.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
final class VeSDKInitStateManager$startVeInitAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $initBlock;
    final /* synthetic */ long $timeoutMs;
    long J$0;
    int label;

    /* JADX INFO: renamed from: com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2$1", f = "VeSDKInitStateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $initBlock;
        int label;

        public AnonymousClass1(Function0<Unit> r100, Continuation<? super AnonymousClass1> r101) {
            this.$initBlock = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$initBlock, r101);
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
            this.$initBlock.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public VeSDKInitStateManager$startVeInitAsync$2(long r100, Function0<Unit> r101, Continuation<? super VeSDKInitStateManager$startVeInitAsync$2> r102) {
        this.$timeoutMs = r100;
        this.$initBlock = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VeSDKInitStateManager$startVeInitAsync$2(this.$timeoutMs, this.$initBlock, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VeSDKInitStateManager$startVeInitAsync$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        long r102 = this.J$0;
        ResultKt.throwOnFailure(r110);     // Catch: Exception -> L8 TimeoutCancellationException -> L26
    L17:
        long r111 = System.currentTimeMillis() - r102;     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.f375500a.getClass();     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.a();     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        FLogger.f375446a.i("VeSDKInitStateManager", "startVeInitAsync: initialization completed successfully, duration=" + r111 + "ms");     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.b(r111, true, null, "async");     // Catch: Exception -> L8 TimeoutCancellationException -> L26
    L25:
        return Unit.INSTANCE;
    L8:
        e = e;
        long r112 = r102;
    L21:
        long r103 = System.currentTimeMillis() - r112;
        FLogger r104 = FLogger.f375446a;
        r104.e("VeSDKInitStateManager", "startVeInitAsync: initialization failed, duration=" + r103 + "ms, error=" + e);
        VeSDKInitStateManager.f375500a.getClass();
        VeSDKInitStateManager.f375502c.set(VeSDKInitStateManager.InitState.TIMEOUT);
        VeSDKInitStateManager.f375503d.countDown();
        r104.e("VeSDKInitStateManager", "markTimeout: state changed to TIMEOUT");
        VeSDKInitStateManager.b(r103, false, e.getMessage(), "async");
    L23:
        long r113 = System.currentTimeMillis() - r102;
        FLogger r114 = FLogger.f375446a;
        r114.e("VeSDKInitStateManager", "startVeInitAsync: initialization timeout after " + r113 + "ms, timeout=" + this.$timeoutMs + "ms");
        VeSDKInitStateManager.f375500a.getClass();
        VeSDKInitStateManager.f375502c.set(VeSDKInitStateManager.InitState.TIMEOUT);
        VeSDKInitStateManager.f375503d.countDown();
        r114.e("VeSDKInitStateManager", "markTimeout: state changed to TIMEOUT");
        VeSDKInitStateManager.b(r113, false, "timeout", "async");
        goto L25
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r110);
        r112 = System.currentTimeMillis();
        long r115 = this.$timeoutMs;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        AnonymousClass1 r116 = new AnonymousClass1(this.$initBlock, null);     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        this.J$0 = r112;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        this.label = 1;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        if (TimeoutKt.b(r115, r116, this) != r100) goto L16;
        return r100;
    L16:
        r102 = r112;
        goto L17
    L22:
        r102 = r112;
    L20:
        e = e;
        goto L21
    }
}
