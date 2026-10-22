package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$onAppear$1", f = "PdpDynamicFeatureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdpDynamicFeatureService$onAppear$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $enterBackGroundTime;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDynamicFeatureService this$0;

    public PdpDynamicFeatureService$onAppear$1(PdpDynamicFeatureService r1, long r2, Continuation r4) {
        this.this$0 = r1;
        this.$enterBackGroundTime = r2;
        super(3, r4);
    }

    public final Continuation<Unit> create(CoroutineScope r4, w r5, Continuation<? super Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "continuation");
        PdpDynamicFeatureService$onAppear$1 r7 = new PdpDynamicFeatureService$onAppear$1(this.this$0, this.$enterBackGroundTime, r6);
        r7.L$0 = r5;
        return r7;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r8);
        w r9 = (w) this.L$0;
        CommonMeta r0 = this.this$0.O1().d().getData().a().a();
        ProductDetailEventService.b r10 = r9.m();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("background_time", Boxing.boxInt((int) (this.$enterBackGroundTime / ((long) 1000))));
        if (r0 == null) goto L7;
        String r2 = r0.getNormalSkuId();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r1[1] = TuplesKt.to("pdp_selected_sku_id", r2);
        m.a.a(r10.d(MapsKt.mapOf(r1)), "leave_pdp_duration", true, null, null, 12);
        return Unit.INSTANCE;
    L7:
        r2 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
