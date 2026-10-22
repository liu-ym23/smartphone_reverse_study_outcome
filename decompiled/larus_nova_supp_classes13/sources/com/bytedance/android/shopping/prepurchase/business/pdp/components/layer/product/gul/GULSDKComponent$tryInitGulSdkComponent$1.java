package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.api.mall.feed.d;
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
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent$tryInitGulSdkComponent$1", f = "GULSDKComponent.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class GULSDKComponent$tryInitGulSdkComponent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GULSDKComponent this$0;

    public GULSDKComponent$tryInitGulSdkComponent$1(GULSDKComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new GULSDKComponent$tryInitGulSdkComponent$1(this.this$0, r3);
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
    L14:
        d r5 = (d) r4;
        if (r5 != null) goto L17;
        r5 = GULSDKComponent.h2(this.this$0);
    L17:
        GULSDKComponent r2 = this.this$0;
        if (r5 == null) goto L20;
        int r3 = GULSDKComponent.t;
        r2.j2(r5);
        Unit r6 = Unit.INSTANCE;
    L21:
        r2.n = r5;
        return Unit.INSTANCE;
    L20:
        r5 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Deferred<? extends d> r7 = this.this$0.o;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("componentLoadJob");
    L11:
        this.label = 1;
        r4 = r7.await(this);
        if (r4 != r0) goto L14;
        return r0;
    }
}
