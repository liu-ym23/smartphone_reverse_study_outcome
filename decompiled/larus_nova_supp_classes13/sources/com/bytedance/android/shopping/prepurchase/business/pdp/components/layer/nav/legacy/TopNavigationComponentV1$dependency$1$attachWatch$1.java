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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/m;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1$dependency$1$attachWatch$1", f = "TopNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV1$dependency$1$attachWatch$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.m, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $identifier;
    final /* synthetic */ int $watchMode;
    final /* synthetic */ com.bytedance.android.shopping.anchorv4.log.d $watcher;
    private /* synthetic */ Object L$0;
    int label;

    public TopNavigationComponentV1$dependency$1$attachWatch$1(com.bytedance.android.shopping.anchorv4.log.d r1, Object r2, int r3, Continuation r4) {
        this.$watcher = r1;
        this.$identifier = r2;
        this.$watchMode = r3;
        super(3, r4);
    }

    public final Continuation<Unit> create(CoroutineScope r4, vg3.m r5, Continuation<? super Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "continuation");
        TopNavigationComponentV1$dependency$1$attachWatch$1 r7 = new TopNavigationComponentV1$dependency$1$attachWatch$1(this.$watcher, this.$identifier, this.$watchMode, r6);
        r7.L$0 = r5;
        return r7;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.m) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        ((vg3.m) this.L$0).y(this.$watcher, this.$identifier, this.$watchMode);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
