package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityTime;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "networkAbility", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$listenAndResetServerTime$1", f = "PdpDynamicFeatureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpDynamicFeatureService$listenAndResetServerTime$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDynamicFeatureService this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpDynamicFeatureService$listenAndResetServerTime$1 a;
        public final /* synthetic */ x b;

        public a(PdpDynamicFeatureService$listenAndResetServerTime$1 r1, x r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            CommonMeta r6 = (CommonMeta) r5;
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r0 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) this.b.q0().a();
            if (r0 != null) goto L5;
        L19:
            String r7 = this.b.getData().d();
            if (com.bytedance.android.shopping.extensions.k.c(r7) == false) goto L23;
            o r1 = this.a.this$0.b2();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r7, "logId");
            SlcContext r2 = r1.a;
            ((SlcRenderContext) r2).i = r7;
            ((SlcRenderContext) r2).h = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("log_id", r7)});
            return;
        L23:
            return;
        L5:
            if ((r0 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == false) goto L19;
            if ((r0 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.a) == true) goto L19;
            if (r6 == null) goto L15;
            ActivityVO r8 = r6.getActivityInfo();
            if (r8 == null) goto L15;
            ActivityTime r9 = r8.getActivityTime();
            if (r9 == null) goto L15;
            long r3 = r9.getServerTime();
        L17:
            if (r3 <= 0) goto L19;
            this.a.this$0.b2().a.r(r3);
        L15:
            r3 = 0;
            goto L17
        }
    }

    public PdpDynamicFeatureService$listenAndResetServerTime$1(PdpDynamicFeatureService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "networkAbility");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpDynamicFeatureService$listenAndResetServerTime$1 r5 = new PdpDynamicFeatureService$listenAndResetServerTime$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        x r5 = (x) this.L$0;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.getData().a(), this.this$0, new a(this, r5));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
