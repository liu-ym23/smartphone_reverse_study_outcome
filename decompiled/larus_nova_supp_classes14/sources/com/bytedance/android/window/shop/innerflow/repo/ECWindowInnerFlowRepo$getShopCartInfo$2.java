package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowCartInfoDTO;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvp3/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowRepo$getShopCartInfo$2", f = "ECWindowInnerFlowRepo.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class ECWindowInnerFlowRepo$getShopCartInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super vp3.a>, Object> {
    int label;
    final /* synthetic */ ECWindowInnerFlowRepo this$0;

    public ECWindowInnerFlowRepo$getShopCartInfo$2(ECWindowInnerFlowRepo r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ECWindowInnerFlowRepo$getShopCartInfo$2(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ECShopInnerFlowCartInfoDTO r5 = (ECShopInnerFlowCartInfoDTO) r4;
        if (r5 == null) goto L21;
        up3.a r6 = r5.getShopCartInfoDTO();
        if (r6 == null) goto L23;
        String r2 = r6.b();
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        return new vp3.a(r2, k.r(r6.a(), 0));
    L23:
        return null;
    L21:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ECWindowInnerFlowRemoteDataSource r7 = this.this$0.d;
        this.label = 1;
        r4 = r7.b(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
