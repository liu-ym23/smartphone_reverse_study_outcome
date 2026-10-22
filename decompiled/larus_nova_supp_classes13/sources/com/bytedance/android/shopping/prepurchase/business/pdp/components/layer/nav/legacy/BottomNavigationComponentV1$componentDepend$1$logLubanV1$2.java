package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import java.util.Map;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomNavigationComponentV1$componentDepend$1$logLubanV1$2", f = "BottomNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BottomNavigationComponentV1$componentDepend$1$logLubanV1$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.w, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $label;
    final /* synthetic */ Map $map;
    private /* synthetic */ Object L$0;
    int label;

    public BottomNavigationComponentV1$componentDepend$1$logLubanV1$2(String r1, Map r2, Continuation r3) {
        this.$label = r1;
        this.$map = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, vg3.w r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        BottomNavigationComponentV1$componentDepend$1$logLubanV1$2 r6 = new BottomNavigationComponentV1$componentDepend$1$logLubanV1$2(this.$label, this.$map, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        vg3.w.a.a((vg3.w) this.L$0, this.$label, this.$map, 4);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
