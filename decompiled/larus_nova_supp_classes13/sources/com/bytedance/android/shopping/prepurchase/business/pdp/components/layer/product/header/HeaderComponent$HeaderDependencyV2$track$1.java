package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
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
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent$HeaderDependencyV2$track$1", f = "HeaderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HeaderComponent$HeaderDependencyV2$track$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ boolean $logLuban;
    final /* synthetic */ Map $param;
    private /* synthetic */ Object L$0;
    int label;

    public HeaderComponent$HeaderDependencyV2$track$1(Map r1, String r2, boolean r3, Continuation r4) {
        this.$param = r1;
        this.$eventName = r2;
        this.$logLuban = r3;
        super(3, r4);
    }

    public final Continuation<Unit> create(CoroutineScope r4, w r5, Continuation<? super Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "continuation");
        HeaderComponent$HeaderDependencyV2$track$1 r7 = new HeaderComponent$HeaderDependencyV2$track$1(this.$param, this.$eventName, this.$logLuban, r6);
        r7.L$0 = r5;
        return r7;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r9);
        w r10 = (w) this.L$0;
        boolean r0 = m.a.a(r10.m().d(this.$param), this.$eventName, false, null, null, 14);
        if (this.$logLuban == false) goto L10;
        if (r0 != true) goto L10;
        w.a.a(r10, this.$eventName, null, 6);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
