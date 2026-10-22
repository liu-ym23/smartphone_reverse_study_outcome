package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomNavigationComponentV1$componentDepend$1$refresh$1", f = "BottomNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BottomNavigationComponentV1$componentDepend$1$refresh$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.x, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $refreshType;
    private /* synthetic */ Object L$0;
    int label;

    public BottomNavigationComponentV1$componentDepend$1$refresh$1(String r1, Continuation r2) {
        this.$refreshType = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        BottomNavigationComponentV1$componentDepend$1$refresh$1 r5 = new BottomNavigationComponentV1$componentDepend$1$refresh$1(this.$refreshType, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        vg3.x r6 = (vg3.x) this.L$0;
        String r0 = this.$refreshType;
        if (r0 != null) goto L7;
        r0 = "old_bottom_nev";
    L7:
        vg3.x.a.a(r6, false, r0, null, 28);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
