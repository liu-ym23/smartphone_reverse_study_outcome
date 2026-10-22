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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/u;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.LifeCycleNotificationService$onAttach$4$2", f = "LifeCycleNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LifeCycleNotificationService$onAttach$4$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.u, Continuation<? super Unit>, Object> {
    final /* synthetic */ LastPageVideoZoomer $zoomer;
    private /* synthetic */ Object L$0;
    int label;

    public LifeCycleNotificationService$onAttach$4$2(LastPageVideoZoomer r1, Continuation r2) {
        this.$zoomer = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.u r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        LifeCycleNotificationService$onAttach$4$2 r5 = new LifeCycleNotificationService$onAttach$4$2(this.$zoomer, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.u) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        vg3.u r4 = (vg3.u) this.L$0;
        final LastPageVideoZoomer r0 = this.$zoomer;
        r0.getClass();
        r4.l1(new LastPageVideoZoomer$getCloseListener$1(r0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
