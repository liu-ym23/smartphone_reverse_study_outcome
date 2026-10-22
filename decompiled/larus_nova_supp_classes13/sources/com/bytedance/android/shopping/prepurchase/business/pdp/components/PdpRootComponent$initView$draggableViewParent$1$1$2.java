package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$initView$draggableViewParent$1$1$2", f = "PdpRootComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpRootComponent$initView$draggableViewParent$1$1$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.y, Continuation<? super Unit>, Object> {
    final /* synthetic */ TopRoundFrameLayout $it;
    private /* synthetic */ Object L$0;
    int label;

    public PdpRootComponent$initView$draggableViewParent$1$1$2(TopRoundFrameLayout r1, Continuation r2) {
        this.$it = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.y r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpRootComponent$initView$draggableViewParent$1$1$2 r5 = new PdpRootComponent$initView$draggableViewParent$1$1$2(this.$it, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.y) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r4 = ((vg3.y) this.L$0).V();
        if (r4 == null) goto L12;
        TopRoundFrameLayout r0 = this.$it;
        if ((r0 instanceof UserInteractFrameLayout) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        r0.setDrawListener(new com.bytedance.android.shopping.anchorv4.perf.monitor.g(r4));
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
