package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/v;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$initSliceEventChainActions$1", f = "PdpRootComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpRootComponent$initSliceEventChainActions$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.v, Continuation<? super Unit>, Object> {
    final /* synthetic */ j73.d $dependency;
    final /* synthetic */ com.bytedance.android.ecom.arch.slice.action.v $provider;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpRootComponent this$0;

    public PdpRootComponent$initSliceEventChainActions$1(PdpRootComponent r1, com.bytedance.android.ecom.arch.slice.action.v r2, j73.d r3, Continuation r4) {
        this.this$0 = r1;
        this.$provider = r2;
        this.$dependency = r3;
        super(3, r4);
    }

    public final Continuation<Unit> create(CoroutineScope r4, vg3.v r5, Continuation<? super Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "continuation");
        PdpRootComponent$initSliceEventChainActions$1 r7 = new PdpRootComponent$initSliceEventChainActions$1(this.this$0, this.$provider, this.$dependency, r6);
        r7.L$0 = r5;
        return r7;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.v) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        vg3.v r6 = (vg3.v) this.L$0;
        r6.i1(this.$provider, this.$dependency);
        t96.a r7 = r6.t0();
        if (r7 == null) goto L8;
        PdpRootComponent r0 = this.this$0;
        PdpRootComponent$initSliceEventChainActions$1$1$1 r2 = new PdpRootComponent$initSliceEventChainActions$1$1$1(r7, null);
        int r8 = PdpRootComponent.y;
        r0.Z1(d0.class, r2);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
