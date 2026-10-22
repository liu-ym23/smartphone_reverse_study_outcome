package com.larus.xbridge.custom;

import android.os.SystemClock;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.BizUtilAuthorizationMethod$handle$1", f = "BizUtilAuthorizationMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BizUtilAuthorizationMethod$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ cx7.d $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ s0 this$0;

    public BizUtilAuthorizationMethod$handle$1(s0 r100, IvyBridgeMethod.a r101, cx7.d r102, Continuation<? super BizUtilAuthorizationMethod$handle$1> r103) {
        this.this$0 = r100;
        this.$callback = r101;
        this.$params = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BizUtilAuthorizationMethod$handle$1 r102 = new BizUtilAuthorizationMethod$handle$1(this.this$0, this.$callback, this.$params, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BizUtilAuthorizationMethod$handle$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        long r100 = SystemClock.elapsedRealtime();
        FLogger.f375446a.i("BizUtilAuthorization", "handle async started, method=" + this.this$0.f379788b);
        s0 r112 = this.this$0;
        cx7.d r101 = this.$params;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r113 = Result.m9449constructorimpl(r112.f(r101));     // Catch: Throwable -> L7
    L9:
        s0 r103 = this.this$0;
        Throwable r104 = Result.m9452exceptionOrNullimpl(r113);
        if (r104 == null) goto L13;
        FLogger.f375446a.e("BizUtilAuthorization", "handle failed, method=" + r103.f379788b + ", duration=" + (SystemClock.elapsedRealtime() - r100) + "ms", r104);
    L13:
        if (Result.m9452exceptionOrNullimpl(r113) == null) goto L16;
        r113 = MapsKt.emptyMap();
    L16:
        Map r114 = (Map) r113;
        FLogger.f375446a.i("BizUtilAuthorization", "handle success, method=" + this.this$0.f379788b + ", resultSize=" + r114.size() + ", duration=" + (SystemClock.elapsedRealtime() - r100) + "ms");
        bx7.c.d(this.this$0, this.$callback, MapsKt.toMutableMap(r114));
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
