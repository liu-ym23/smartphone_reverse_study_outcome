package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$realLogAndCloseAnchorV4$1", f = "PdpRootComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpRootComponent$realLogAndCloseAnchorV4$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.w, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PdpRootComponent$realLogAndCloseAnchorV4$1(Continuation r2) {
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.w r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpRootComponent$realLogAndCloseAnchorV4$1 r5 = new PdpRootComponent$realLogAndCloseAnchorV4$1(r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(((vg3.w) this.L$0).m().d(MapsKt.mapOf(TuplesKt.to("close_method", "click"))), "close_product_detail", false, null, null, 14);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
