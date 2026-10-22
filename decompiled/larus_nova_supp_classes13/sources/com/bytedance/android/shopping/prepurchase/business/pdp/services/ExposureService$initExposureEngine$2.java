package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import vg3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/u;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.ExposureService$initExposureEngine$2", f = "ExposureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExposureService$initExposureEngine$2 extends SuspendLambda implements Function3<CoroutineScope, u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $otherFragmentShownCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public ExposureService$initExposureEngine$2(b r1, Ref.IntRef r2, Continuation r3) {
        this.this$0 = r1;
        this.$otherFragmentShownCount = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, u r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        ExposureService$initExposureEngine$2 r6 = new ExposureService$initExposureEngine$2(this.this$0, this.$otherFragmentShownCount, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (u) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ((u) this.L$0).d0(new AnonymousClass1(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
