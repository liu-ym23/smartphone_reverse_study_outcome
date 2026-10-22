package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
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
import org.json.JSONObject;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "prefAbility", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$registerPdpShowEvent$1", f = "PdpDynamicFeatureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpDynamicFeatureService$registerPdpShowEvent$1 extends SuspendLambda implements Function3<CoroutineScope, y, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDynamicFeatureService this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ PdpDynamicFeatureService$registerPdpShowEvent$1 c;

        @Override // java.lang.Runnable
        public final void run() {
            PdpDynamicFeatureService r0 = this.c.this$0;
            int r1 = PdpDynamicFeatureService.v;
            String r2 = r0.O1().f().a.b;
            if (Intrinsics.areEqual(r0.s, r2) == true) goto L14;
            r0.s = r2;
            LynxAbilityImpl r3 = r0.a2();
            JSONObject r4 = new JSONObject();
            AnchorV4Param r5 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).a;
            if (r5 == null) goto L11;
            V4NativeParams r6 = r5.getNativeParams();
            if (r6 == null) goto L11;
            String r7 = r6.getPdpEventTransparentId();
            if (r7 == null) goto L11;
        L12:
            r4.put("pdp_event_transparent_id", r7);
            Unit r8 = Unit.INSTANCE;
            r3.B("ecom.pdp.show", r4);
            return;
        L11:
            r7 = "";
            goto L12
        }

        public a(PdpDynamicFeatureService$registerPdpShowEvent$1 r1) {
            this.c = r1;
            super("send_pdp_show_event");
        }
    }

    public PdpDynamicFeatureService$registerPdpShowEvent$1(PdpDynamicFeatureService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, y r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "prefAbility");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpDynamicFeatureService$registerPdpShowEvent$1 r5 = new PdpDynamicFeatureService$registerPdpShowEvent$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (y) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ((y) this.L$0).e1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
