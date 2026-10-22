package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
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
import vg3.m;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.OldGulService$tryLoadGul$1", f = "OldGulService.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class OldGulService$tryLoadGul$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OldGulService this$0;

    public OldGulService$tryLoadGul$1(OldGulService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        OldGulService$tryLoadGul$1 r5 = new OldGulService$tryLoadGul$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L14:
        ((m) r4).H0();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ((x) this.L$0).F0();
        OldGulService r5 = this.this$0;
        this.label = 1;
        int r2 = OldGulService.i;
        j r6 = r5.e;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L11:
        r4 = r6.e(m.class, this);
        if (r4 != r0) goto L14;
        return r0;
    }
}
