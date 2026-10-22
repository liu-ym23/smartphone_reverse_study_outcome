package com.bytedance.android.shopping.skubuy.module;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0018\b\u0000\u0010\u0005*\u00020\u0000*\u00020\u0001*\u00020\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0007*\u00020\u0006*\u00020\bH\u008a@¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lv43/b;", "Lv43/a;", "Lv43/s;", "Lv43/o;", "Lv43/n;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.skubuy.module.SkuBuyCoreFlowModule$onFakeRetry$1", f = "SkuBuyCoreFlowModule.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
final class SkuBuyCoreFlowModule$onFakeRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x43.a $lastErrorViewModel;
    int label;
    final /* synthetic */ SkuBuyCoreFlowModule this$0;

    public SkuBuyCoreFlowModule$onFakeRetry$1(SkuBuyCoreFlowModule r1, x43.a r2, Continuation r3) {
        this.this$0 = r1;
        this.$lastErrorViewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new SkuBuyCoreFlowModule$onFakeRetry$1(this.this$0, this.$lastErrorViewModel, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ((s33.b) this.this$0).a.a.a().c(new y43.a(false, false, false, false, 30));
        w33.f r11 = ((s33.b) this.this$0).a.a.g();
        x43.a r2 = this.$lastErrorViewModel;
        if (r2 == null) goto L14;
        x43.a r3 = new x43.a(true, r2.b, r2.c, r2.d, r2.e, r2.f, r2.g);
    L15:
        r11.c(r3);
        return Unit.INSTANCE;
    L14:
        r3 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
