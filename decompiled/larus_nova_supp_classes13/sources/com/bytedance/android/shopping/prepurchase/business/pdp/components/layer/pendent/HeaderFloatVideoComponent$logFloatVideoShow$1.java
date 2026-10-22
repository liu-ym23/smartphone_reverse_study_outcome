package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$logFloatVideoShow$1", f = "HeaderFloatVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HeaderFloatVideoComponent$logFloatVideoShow$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HeaderFloatVideoComponent this$0;

    public HeaderFloatVideoComponent$logFloatVideoShow$1(HeaderFloatVideoComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, w r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        HeaderFloatVideoComponent$logFloatVideoShow$1 r5 = new HeaderFloatVideoComponent$logFloatVideoShow$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r9);
        ProductDetailEventService.b r10 = ((w) this.L$0).m();
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r1 = this.this$0.k;
        if (r1 == null) goto L9;
        Map<String, Object> r2 = r1.d();
        if (r2 == null) goto L9;
        r0.putAll(r2);
    L9:
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r10.d(r0), "main_video_window_show", false, null, null, 14);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
