package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\"\u0018\b\u0000\u0010\u0005*\u00020\u0000*\u00020\u0001*\u00020\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0007*\u00020\u0006*\u00020\bH\u008a@¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lv43/b;", "Lv43/a;", "Lv43/s;", "Lv43/o;", "Lv43/n;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "Ln33/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.skubuy.module.SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1", f = "SkuBuyCoreFlowModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n33.a>, Object> {
    int label;
    final /* synthetic */ SkuBuyCoreFlowModule$flowQueryFetchSucceed$2 this$0;

    public SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1(SkuBuyCoreFlowModule$flowQueryFetchSucceed$2 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new SkuBuyCoreFlowModule$flowQueryFetchSucceed$2$copiedResponse$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        n33.a r4 = this.this$0.$response.b;
        int r0 = t0.a;     // Catch: Exception -> L7
        Gson r1 = t0.a.a;     // Catch: Exception -> L7
        return r1.fromJson(r1.toJson(r4), n33.a.class);
    L7:
        return null;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
