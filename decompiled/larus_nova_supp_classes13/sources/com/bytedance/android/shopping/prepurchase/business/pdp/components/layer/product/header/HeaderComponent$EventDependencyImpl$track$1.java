package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
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
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent$EventDependencyImpl$track$1", f = "HeaderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HeaderComponent$EventDependencyImpl$track$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    private /* synthetic */ Object L$0;
    int label;

    public HeaderComponent$EventDependencyImpl$track$1(String r1, Continuation r2) {
        this.$eventName = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, w r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        HeaderComponent$EventDependencyImpl$track$1 r5 = new HeaderComponent$EventDependencyImpl$track$1(this.$eventName, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        m.a.a(((w) this.L$0).m(), this.$eventName, false, null, null, 14);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
