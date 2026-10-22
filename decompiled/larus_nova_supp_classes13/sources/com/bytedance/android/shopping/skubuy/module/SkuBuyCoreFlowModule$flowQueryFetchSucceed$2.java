package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0018\b\u0000\u0010\u0005*\u00020\u0000*\u00020\u0001*\u00020\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0007*\u00020\u0006*\u00020\bH\u008a@¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lv43/b;", "Lv43/a;", "Lv43/s;", "Lv43/o;", "Lv43/n;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.skubuy.module.SkuBuyCoreFlowModule$flowQueryFetchSucceed$2", f = "SkuBuyCoreFlowModule.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
public final class SkuBuyCoreFlowModule$flowQueryFetchSucceed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n33.f $response;
    int label;
    final /* synthetic */ SkuBuyCoreFlowModule this$0;

    public SkuBuyCoreFlowModule$flowQueryFetchSucceed$2(SkuBuyCoreFlowModule r1, n33.f r2, Continuation r3) {
        this.this$0 = r1;
        this.$response = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new SkuBuyCoreFlowModule$flowQueryFetchSucceed$2(this.this$0, this.$response, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        n33.a r6 = (n33.a) r5;
        if (r6 == null) goto L15;
        Lazy r2 = SkuBuyResponseCacheHelper.a;
        SkuBuyResponseCacheHelper.d(this.this$0.c, r6, true);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1 r3 = new SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1(this, null);
        this.label = 1;
        r5 = BuildersKt.withContext(r7, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
